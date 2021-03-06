package io.vertx.lang.scala

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.core.Vertx
import org.scalatest.Assertions
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}
import io.vertx.lang.scala.conv._

class VertxExecutionContextTest extends AsyncFlatSpec with Matchers with Assertions {

  "Using Promise to complete a Vertx-Future" should "work with a VertxExecutionContext" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    vertx.deployVerticle(nameForVerticle[SuccessVerticle]).asScala()
      .map(res => res should not be empty)
  }

  "Switching back to the event loop execution context" should "work even when another context is used in between" in {
    val idInEventLoopPromise = Promise[Long]
    val idInGlobalPromise = Promise[Long]
    val idBackInEventLoopPromise = Promise[Long]
    val vertx = Vertx.vertx
    val ctx = vertx.getOrCreateContext()
    implicit val exec = VertxExecutionContext(vertx, ctx)
    vertx.deployVerticle(nameForVerticle[SuccessVerticle]).asScala()
      .map(res => {
        idInEventLoopPromise.success(Thread.currentThread().getId)
              Future {
                idInGlobalPromise.success(Thread.currentThread().getId)
              Thread.sleep(1000)
              "computed"
            }(ExecutionContext.global).onComplete{
                case Success(s) => idBackInEventLoopPromise.success(Thread.currentThread().getId)
                case Failure(t) => idBackInEventLoopPromise.failure(t)
              }(exec)
      })

    val aggFut = for{
      idInEventLoop <- idInEventLoopPromise.future
      idInGlobal <- idInGlobalPromise.future
      idBackInEvent <- idBackInEventLoopPromise.future
    } yield (idInEventLoop, idInGlobal, idBackInEvent)

    aggFut.map(s => s._1 should equal(s._3) shouldNot equal(s._2))
  }

  "A deployment" should "fail if the deployed verticle fails" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    vertx.deployVerticle(nameForVerticle[FailVerticle]).asScala()
      .transformWith {
        case Failure(t) => t.getMessage should equal("wuha")
        case Success(_) => fail("Deployment shouldn't succeed!")
      }
  }

}

class SuccessVerticle extends ScalaVerticle {

  override def startFuture(): Future[_] = {
    val p1 = Promise[Void]()
    val p2 = Promise[Void]()
    vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionHandler(ar => {
      if (ar.failed()) {
        p1.failure(ar.cause())
      } else {
        p1.success(null)
      }
    })
    vertx.eventBus().consumer[String]("asd2").handler(a => println(a)).completionHandler(ar => {
      if (ar.failed()) {
        p2.failure(ar.cause())
      } else {
        p2.success(null)
      }
    })
    Future.sequence(Seq(
      p1.future,
      p2.future
    ))
  }
}

class FailVerticle extends ScalaVerticle {

  override def startFuture(): Future[_] = {
    val p1 = Promise[Void]()
    vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionHandler(ar => {
      if (ar.failed()) {
        p1.failure(ar.cause())
      } else {
        p1.success(null)
      }
    })
    Future.sequence(Seq(
      p1.future,
      Future.failed(new java.lang.Exception("wuha")))
    )
  }
}

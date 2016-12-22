/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.codegen.testmodel

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import scala.collection.JavaConverters._
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.{SuperInterface1 => JSuperInterface1}
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.codegen.testmodel.{SuperInterface2 => JSuperInterface2}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */
class TestInterface(private val _asJava: Object) 
    extends SuperInterface1(_asJava) 
    with SuperInterface2 {

  private var cached_0:RefedInterface1 = _
  private var cached_1:Int = _
  private var cached_2:scala.collection.mutable.Buffer[RefedInterface1] = _

//cached methods
  def methodWithCachedReturn(foo: String):RefedInterface1 = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JTestInterface].methodWithCachedReturn(foo)
      cached_0 = RefedInterface1(tmp)
    }
    cached_0
  }

  def methodWithCachedReturnPrimitive(arg: Int):Int = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JTestInterface].methodWithCachedReturnPrimitive(arg)
      cached_1 = tmp
    }
    cached_1
  }

  def methodWithCachedListReturn():scala.collection.mutable.Buffer[RefedInterface1] = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JTestInterface].methodWithCachedListReturn()
      cached_2 = tmp.asScala.map(x => RefedInterface1(x))
    }
    cached_2
  }

//fluent methods
  def fluentMethod(str: String):TestInterface = {
    asJava.asInstanceOf[JTestInterface].fluentMethod(str)
    this
  }

//default methods
//basic methods
  override def otherSuperMethodWithBasicParams(b: Byte,s: Short,i: Int,l: Long,f: Float,d: Double,bool: Boolean,ch: Char,str: String):Unit = {
    asJava.asInstanceOf[JTestInterface].otherSuperMethodWithBasicParams(b,s,i,l,f,d,bool,ch,str)
  }

  def methodWithBasicParams(b: Byte,s: Short,i: Int,l: Long,f: Float,d: Double,bool: Boolean,ch: Char,str: String):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithBasicParams(b,s,i,l,f,d,bool,ch,str)
  }

  def methodWithBasicBoxedParams(b: Byte,s: Short,i: Int,l: Long,f: Float,d: Double,bool: Boolean,ch: Char):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithBasicBoxedParams(b,s,i,l,f,d,bool,ch)
  }

  def methodWithHandlerBasicTypes(byteHandler: Handler[Byte],shortHandler: Handler[Short],intHandler: Handler[Int],longHandler: Handler[Long],floatHandler: Handler[Float],doubleHandler: Handler[Double],booleanHandler: Handler[Boolean],charHandler: Handler[Char],stringHandler: Handler[String]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerBasicTypes({x: java.lang.Byte => byteHandler.handle(x)},{x: java.lang.Short => shortHandler.handle(x)},{x: java.lang.Integer => intHandler.handle(x)},{x: java.lang.Long => longHandler.handle(x)},{x: java.lang.Float => floatHandler.handle(x)},{x: java.lang.Double => doubleHandler.handle(x)},{x: java.lang.Boolean => booleanHandler.handle(x)},{x: java.lang.Character => charHandler.handle(x)},{x: java.lang.String => stringHandler.handle(x)})
  }

  def methodWithHandlerStringReturn(expected: String):Handler[String] = {
    {x: String => asJava.asInstanceOf[JTestInterface].methodWithHandlerStringReturn(expected).handle(x)}
  }

  def methodWithHandlerGenericReturn[T](handler: Handler[T]):Handler[T] = {
    {x: T => asJava.asInstanceOf[JTestInterface].methodWithHandlerGenericReturn[T]({x: T => handler.handle(x)}).handle(x)}
  }

  def methodWithHandlerVertxGenReturn(expected: String):Handler[RefedInterface1] = {
    {x: RefedInterface1 => asJava.asInstanceOf[JTestInterface].methodWithHandlerVertxGenReturn(expected).handle(x.asJava.asInstanceOf[JRefedInterface1])}
  }

  def methodWithHandlerAsyncResultByte(sendFailure: Boolean,handler: Handler[AsyncResult[Byte]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultByte(sendFailure,{x: AsyncResult[java.lang.Byte] => handler.handle(AsyncResultWrapper[java.lang.Byte,Byte](x, a => a))})
  }

  def methodWithHandlerAsyncResultShort(sendFailure: Boolean,handler: Handler[AsyncResult[Short]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultShort(sendFailure,{x: AsyncResult[java.lang.Short] => handler.handle(AsyncResultWrapper[java.lang.Short,Short](x, a => a))})
  }

  def methodWithHandlerAsyncResultInteger(sendFailure: Boolean,handler: Handler[AsyncResult[Int]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultInteger(sendFailure,{x: AsyncResult[java.lang.Integer] => handler.handle(AsyncResultWrapper[java.lang.Integer,Int](x, a => a))})
  }

  def methodWithHandlerAsyncResultLong(sendFailure: Boolean,handler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultLong(sendFailure,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a))})
  }

  def methodWithHandlerAsyncResultFloat(sendFailure: Boolean,handler: Handler[AsyncResult[Float]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultFloat(sendFailure,{x: AsyncResult[java.lang.Float] => handler.handle(AsyncResultWrapper[java.lang.Float,Float](x, a => a))})
  }

  def methodWithHandlerAsyncResultDouble(sendFailure: Boolean,handler: Handler[AsyncResult[Double]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDouble(sendFailure,{x: AsyncResult[java.lang.Double] => handler.handle(AsyncResultWrapper[java.lang.Double,Double](x, a => a))})
  }

  def methodWithHandlerAsyncResultBoolean(sendFailure: Boolean,handler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultBoolean(sendFailure,{x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a))})
  }

  def methodWithHandlerAsyncResultCharacter(sendFailure: Boolean,handler: Handler[AsyncResult[Char]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultCharacter(sendFailure,{x: AsyncResult[java.lang.Character] => handler.handle(AsyncResultWrapper[java.lang.Character,Char](x, a => a))})
  }

  def methodWithHandlerAsyncResultString(sendFailure: Boolean,handler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultString(sendFailure,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
  }

  def methodWithHandlerAsyncResultDataObject(sendFailure: Boolean,handler: Handler[AsyncResult[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDataObject(sendFailure,{x: AsyncResult[JTestDataObject] => handler.handle(AsyncResultWrapper[JTestDataObject,TestDataObject](x, a => TestDataObject(a)))})
  }

  def methodWithHandlerAsyncResultStringReturn(expected: String,fail: Boolean):Handler[AsyncResult[String]] = {
    {x: AsyncResult[String] => asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultStringReturn(expected,fail).handle(AsyncResultWrapper[String,java.lang.String](x, a => a))}
  }

  def methodWithHandlerAsyncResultGenericReturn[T](handler: Handler[AsyncResult[T]]):Handler[AsyncResult[T]] = {
    {x: AsyncResult[T] => asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultGenericReturn[T]({x: AsyncResult[T] => handler.handle(AsyncResultWrapper[T,T](x, a => a))}).handle(AsyncResultWrapper[T,T](x, a => a))}
  }

  def methodWithHandlerAsyncResultVertxGenReturn(expected: String,fail: Boolean):Handler[AsyncResult[RefedInterface1]] = {
    {x: AsyncResult[RefedInterface1] => asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultVertxGenReturn(expected,fail).handle(AsyncResultWrapper[RefedInterface1,JRefedInterface1](x, a => a.asJava.asInstanceOf[JRefedInterface1]))}
  }

  def methodWithUserTypes(refed: RefedInterface1):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithUserTypes(refed.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithObjectParam(str: String,obj: AnyRef):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithObjectParam(str,obj)
  }

  def methodWithDataObjectParam(dataObject: TestDataObject):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithDataObjectParam(dataObject.asJava)
  }

  def methodWithHandlerUserTypes(handler: Handler[RefedInterface1]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerUserTypes({x: JRefedInterface1 => handler.handle(RefedInterface1(x))})
  }

  def methodWithHandlerAsyncResultUserTypes(handler: Handler[AsyncResult[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultUserTypes({x: AsyncResult[JRefedInterface1] => handler.handle(AsyncResultWrapper[JRefedInterface1,RefedInterface1](x, a => RefedInterface1(a)))})
  }

  def methodWithConcreteHandlerUserTypeSubtype(handler: ConcreteHandlerUserType):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithConcreteHandlerUserTypeSubtype(handler.asJava.asInstanceOf[JConcreteHandlerUserType])
  }

  def methodWithAbstractHandlerUserTypeSubtype(handler: AbstractHandlerUserType):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithAbstractHandlerUserTypeSubtype(handler.asJava.asInstanceOf[JAbstractHandlerUserType])
  }

  def methodWithConcreteHandlerUserTypeSubtypeExtension(handler: ConcreteHandlerUserTypeExtension):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithConcreteHandlerUserTypeSubtypeExtension(handler.asJava.asInstanceOf[JConcreteHandlerUserTypeExtension])
  }

  def methodWithHandlerVoid(handler: Handler[Unit]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerVoid({x: Void => handler.handle(x)})
  }

  def methodWithHandlerAsyncResultVoid(sendFailure: Boolean,handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultVoid(sendFailure,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def methodWithHandlerThrowable(handler: Handler[Throwable]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerThrowable({x: Throwable => handler.handle(x)})
  }

  def methodWithHandlerDataObject(handler: Handler[TestDataObject]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerDataObject({x: JTestDataObject => handler.handle(TestDataObject(x))})
  }

  def methodWithHandlerGenericUserType[U](value: U,handler: Handler[GenericRefedInterface[U]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerGenericUserType[U](value,{x: JGenericRefedInterface[U] => handler.handle(GenericRefedInterface[U](x))})
  }

  def methodWithHandlerAsyncResultGenericUserType[U](value: U,handler: Handler[AsyncResult[GenericRefedInterface[U]]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultGenericUserType[U](value,{x: AsyncResult[JGenericRefedInterface[U]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[U],GenericRefedInterface[U]](x, a => GenericRefedInterface[U](a)))})
  }

  def methodWithByteReturn():Byte = {
    asJava.asInstanceOf[JTestInterface].methodWithByteReturn()
  }

  def methodWithShortReturn():Short = {
    asJava.asInstanceOf[JTestInterface].methodWithShortReturn()
  }

  def methodWithIntReturn():Int = {
    asJava.asInstanceOf[JTestInterface].methodWithIntReturn()
  }

  def methodWithLongReturn():Long = {
    asJava.asInstanceOf[JTestInterface].methodWithLongReturn()
  }

  def methodWithFloatReturn():Float = {
    asJava.asInstanceOf[JTestInterface].methodWithFloatReturn()
  }

  def methodWithDoubleReturn():Double = {
    asJava.asInstanceOf[JTestInterface].methodWithDoubleReturn()
  }

  def methodWithBooleanReturn():Boolean = {
    asJava.asInstanceOf[JTestInterface].methodWithBooleanReturn()
  }

  def methodWithCharReturn():Char = {
    asJava.asInstanceOf[JTestInterface].methodWithCharReturn()
  }

  def methodWithStringReturn():String = {
    asJava.asInstanceOf[JTestInterface].methodWithStringReturn()
  }

  def methodWithVertxGenReturn():RefedInterface1 = {
    RefedInterface1(asJava.asInstanceOf[JTestInterface].methodWithVertxGenReturn())
  }

  def methodWithVertxGenNullReturn():RefedInterface1 = {
    RefedInterface1(asJava.asInstanceOf[JTestInterface].methodWithVertxGenNullReturn())
  }

  def methodWithAbstractVertxGenReturn():RefedInterface2 = {
    RefedInterface2(asJava.asInstanceOf[JTestInterface].methodWithAbstractVertxGenReturn())
  }

  def methodWithDataObjectReturn():TestDataObject = {
    TestDataObject(asJava.asInstanceOf[JTestInterface].methodWithDataObjectReturn())
  }

  def methodWithDataObjectNullReturn():TestDataObject = {
    TestDataObject(asJava.asInstanceOf[JTestInterface].methodWithDataObjectNullReturn())
  }

  def methodWithGenericUserTypeReturn[U](value: U):GenericRefedInterface[U] = {
    GenericRefedInterface[U](asJava.asInstanceOf[JTestInterface].methodWithGenericUserTypeReturn[U](value))
  }

  def overloadedMethod(str: String,handler: Handler[String]):String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str,{x: java.lang.String => handler.handle(x)})
  }

  def overloadedMethod(str: String,refed: RefedInterface1):String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str,refed.asJava.asInstanceOf[JRefedInterface1])
  }

  def overloadedMethod(str: String,refed: RefedInterface1,handler: Handler[String]):String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str,refed.asJava.asInstanceOf[JRefedInterface1],{x: java.lang.String => handler.handle(x)})
  }

  def overloadedMethod(str: String,refed: RefedInterface1,period: Long,handler: Handler[String]):String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str,refed.asJava.asInstanceOf[JRefedInterface1],period,{x: java.lang.String => handler.handle(x)})
  }

  def methodWithGenericReturn[U](`type`: String):U = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericReturn[U](`type`)
  }

  def methodWithGenericParam[U](`type`: String,u: U):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericParam[U](`type`,u)
  }

  def methodWithGenericHandler[U](`type`: String,handler: Handler[U]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericHandler[U](`type`,{x: U => handler.handle(x)})
  }

  def methodWithGenericHandlerAsyncResult[U](`type`: String,asyncResultHandler: Handler[AsyncResult[U]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericHandlerAsyncResult[U](`type`,{x: AsyncResult[U] => asyncResultHandler.handle(AsyncResultWrapper[U,U](x, a => a))})
  }

  def methodWithJsonObjectReturn():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonObjectReturn()
  }

  def methodWithNullJsonObjectReturn():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonObjectReturn()
  }

  def methodWithComplexJsonObjectReturn():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithComplexJsonObjectReturn()
  }

  def methodWithJsonArrayReturn():io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonArrayReturn()
  }

  def methodWithNullJsonArrayReturn():io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonArrayReturn()
  }

  def methodWithComplexJsonArrayReturn():io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithComplexJsonArrayReturn()
  }

  def methodWithJsonParams(jsonObject: io.vertx.core.json.JsonObject,jsonArray: io.vertx.core.json.JsonArray):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonParams(jsonObject,jsonArray)
  }

  def methodWithNullJsonParams(jsonObject: io.vertx.core.json.JsonObject,jsonArray: io.vertx.core.json.JsonArray):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonParams(jsonObject,jsonArray)
  }

  def methodWithHandlerJson(jsonObjectHandler: Handler[io.vertx.core.json.JsonObject],jsonArrayHandler: Handler[io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerJson({x: JsonObject => jsonObjectHandler.handle(x)},{x: JsonArray => jsonArrayHandler.handle(x)})
  }

  def methodWithHandlerComplexJson(jsonObjectHandler: Handler[io.vertx.core.json.JsonObject],jsonArrayHandler: Handler[io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerComplexJson({x: JsonObject => jsonObjectHandler.handle(x)},{x: JsonArray => jsonArrayHandler.handle(x)})
  }

  def methodWithHandlerAsyncResultJsonObject(handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonObject({x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
  }

  def methodWithHandlerAsyncResultNullJsonObject(handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonObject({x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
  }

  def methodWithHandlerAsyncResultComplexJsonObject(handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonObject({x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
  }

  def methodWithHandlerAsyncResultJsonArray(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonArray({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
  }

  def methodWithHandlerAsyncResultNullJsonArray(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonArray({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
  }

  def methodWithHandlerAsyncResultComplexJsonArray(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonArray({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
  }

  def methodWithEnumParam(strVal: String,weirdo: io.vertx.codegen.testmodel.TestEnum):String = {
    asJava.asInstanceOf[JTestInterface].methodWithEnumParam(strVal,weirdo)
  }

  def methodWithEnumReturn(strVal: String):io.vertx.codegen.testmodel.TestEnum = {
    asJava.asInstanceOf[JTestInterface].methodWithEnumReturn(strVal)
  }

  def methodWithGenEnumParam(strVal: String,weirdo: io.vertx.codegen.testmodel.TestGenEnum):String = {
    asJava.asInstanceOf[JTestInterface].methodWithGenEnumParam(strVal,weirdo)
  }

  def methodWithGenEnumReturn(strVal: String):io.vertx.codegen.testmodel.TestGenEnum = {
    asJava.asInstanceOf[JTestInterface].methodWithGenEnumReturn(strVal)
  }

  def methodWithThrowableReturn(strVal: String):Throwable = {
    asJava.asInstanceOf[JTestInterface].methodWithThrowableReturn(strVal)
  }

  def methodWithThrowableParam(t: Throwable):String = {
    asJava.asInstanceOf[JTestInterface].methodWithThrowableParam(t)
  }

  def superMethodOverloadedBySubclass(s: String):Int = {
    asJava.asInstanceOf[JTestInterface].superMethodOverloadedBySubclass(s)
  }

}

  object TestInterface{
    def apply(asJava: JTestInterface) = new TestInterface(asJava)  
  //static methods
    def staticFactoryMethod(foo: String):RefedInterface1 = {
      RefedInterface1(JTestInterface.staticFactoryMethod(foo))
    }

  }

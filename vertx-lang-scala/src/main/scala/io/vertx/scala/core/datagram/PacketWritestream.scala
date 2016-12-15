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

package io.vertx.scala.core.datagram

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.datagram.{PacketWritestream => JPacketWritestream}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream

/**
  * A [[io.vertx.scala.core.streams.WriteStream]] for sending packets to a [[io.vertx.scala.core.net.SocketAddress]].
  * The stream  is called when the write fails.
  */
class PacketWritestream(private val _asJava: Object) 
    extends WriteStream[Buffer] {

  def asJava: Object = _asJava

  /**
    * Ends the stream.
    * 
    * Once the stream has ended, it cannot be used any more.
    */
  def end(): Unit = {
    asJava.asInstanceOf[JPacketWritestream].end()
  }

  /**
    * Same as [[io.vertx.scala.core.streams.WriteStream#end]] but writes some data to the stream before ending.
    */
  def end(t: Buffer): Unit = {
    asJava.asInstanceOf[JPacketWritestream].end(t.asJava.asInstanceOf[JBuffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.datagram.PacketWritestream#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    asJava.asInstanceOf[JPacketWritestream].writeQueueFull()
  }

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def write(data: Buffer): PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: io.vertx.core.Handler[Unit]): PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].drainHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

}

object PacketWritestream {

  def apply(_asJava: Object): PacketWritestream =
    new PacketWritestream(_asJava)

}

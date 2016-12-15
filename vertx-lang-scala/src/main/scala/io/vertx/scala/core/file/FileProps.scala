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

package io.vertx.scala.core.file

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.file.{FileProps => JFileProps}

/**
  * Represents properties of a file on the file system.
  * 
  */
class FileProps(private val _asJava: Object) {

  def asJava: Object = _asJava

  /**
    * The date the file was created
    */
  def creationTime(): Long = {
    asJava.asInstanceOf[JFileProps].creationTime()
  }

  /**
    * The date the file was last accessed
    */
  def lastAccessTime(): Long = {
    asJava.asInstanceOf[JFileProps].lastAccessTime()
  }

  /**
    * The date the file was last modified
    */
  def lastModifiedTime(): Long = {
    asJava.asInstanceOf[JFileProps].lastModifiedTime()
  }

  /**
    * Is the file a directory?
    */
  def isDirectory(): Boolean = {
    asJava.asInstanceOf[JFileProps].isDirectory()
  }

  /**
    * Is the file some other type? (I.e. not a directory, regular file or symbolic link)
    */
  def isOther(): Boolean = {
    asJava.asInstanceOf[JFileProps].isOther()
  }

  /**
    * Is the file a regular file?
    */
  def isRegularFile(): Boolean = {
    asJava.asInstanceOf[JFileProps].isRegularFile()
  }

  /**
    * Is the file a symbolic link?
    */
  def isSymbolicLink(): Boolean = {
    asJava.asInstanceOf[JFileProps].isSymbolicLink()
  }

  /**
    * The size of the file, in bytes
    */
  def size(): Long = {
    asJava.asInstanceOf[JFileProps].size()
  }

}

object FileProps {

  def apply(_asJava: Object): FileProps =
    new FileProps(_asJava)

}

package io.github.todokr.joint

import Generator._

trait Generator {
  def generate(settings: Settings, jsonExpr: JsonExpr): Unit
}

object Generator {
  case class Settings()
  case class Member[T](name: String, scalaType: Class[T])
  case class JsonExpr(members: Seq[Member[_]])
}

class DefaultGenerator extends Generator {
  override def generate(settings: Settings, jsonExpr: JsonExpr): Unit = ???
}
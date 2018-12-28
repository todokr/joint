package io.github.todokr.joint

import scala.io.Source

import JointParser._

trait JointParser {
  def parse(resourceName: String): Joint
}

class DefaultJointParser extends JointParser {
  private val responseDelimiter = """//\s+response:""".r
  override def parse(resourceName: String): Joint = {
    val source = Source.fromResource(s"joint/$resourceName").getLines().filter(_.nonEmpty).toVector
    val (metaDataValue, rest) = source.splitAt(1)
    val (request, response) = rest.span(l => responseDelimiter.findFirstIn(l).isEmpty)
    Joint(MetaData(metaDataValue.head), RequestJson(request), ResponseJson(response))
  }
}


object JointParser {
  case class Joint(metaData: MetaData, requestJson: RequestJson, responseJson: ResponseJson)
  case class MetaData(endpoint: String)
  case class RequestJson(lines: Seq[String])
  case class ResponseJson(lines: Seq[String])
}

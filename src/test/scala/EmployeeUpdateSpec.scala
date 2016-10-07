
/**
  * Created by IBM_ADMIN on 9/29/2016.
  */
import EmployeeCouchService._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.util.ByteString
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.model._
import shapeless.PolyDefns.~>

class EmployeeUpdateSpec extends WordSpec with Matchers with ScalatestRouteTest {
  "Employee API" should {
    "Posting to /employee/1 should update the employee" in {

      val jsonRequest = ByteString(
        s"""
          {
           |
           |"name": "Tony Ananad",
           |"band": "7A",
           |"doj" : "2015-12-01",
           |"location":"Pune",
           |"skills": [
           |    {
           |        "skill":"Spring Boot",
           |        "experience":5
           |    },
           |    {
           |        "skill":"Cloudant",
           |        "experience":6
           |    },
           |    {
           |        "skill":"Scala",
           |        "experience":0
           |    },
           |    {
           |        "skill":"Data Science",
           |        "experience":0
           |    }
           |],
           |"kind":"Employee"
           |}
        """.stripMargin)


      Put("/251a1731a841c07c3b0e7bfc31b6e52f",HttpEntity(MediaTypes.`application/json`, jsonRequest)) ~> updateEntityRoute ~> check {
        //responseAs[Employee].name shouldEqual("Seema Anand")
        status.isSuccess() shouldEqual true

      }
    }
    }


}



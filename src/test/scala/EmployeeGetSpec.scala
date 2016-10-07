import EmployeeCouchService._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class EmployeeGetSpec extends WordSpec with Matchers with ScalatestRouteTest {
  "Employee API" should {
    "Get /{id} should fetch an employee" in {

          Get("/251a1731a841c07c3b0e7bfc31b6e52f") ~> getByIdRoute ~> check {
            status.isSuccess() shouldEqual true
        }
   }

  }}

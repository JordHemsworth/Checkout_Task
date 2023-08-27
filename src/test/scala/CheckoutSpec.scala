import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CheckoutSpec extends AnyFlatSpec with Matchers {

  "Checkout" should "calculate total cost correctly for a list of items" in {
    val items = List("Apple", "Apple", "Orange", "Apple")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 2.05
  }

  it should "calculate total cost as 0 for an empty list" in {
    val items = List.empty[String]
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 0.0
  }

  it should "calculate total cost as 0 for a list with only non-matching items" in {
    val items = List("Banana", "Grape")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 0.0
  }

  it should "calculate total cost correctly for a list with only apples" in {
    val items = List("Apple", "Apple", "Apple", "Apple")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 2.4
  }

  it should "calculate total cost correctly for a list with only oranges" in {
    val items = List("Orange", "Orange")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 0.5
  }
}
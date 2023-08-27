import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CheckoutSpec extends AnyFlatSpec with Matchers {

  "Checkout" should "calculate total cost correctly for a list of items" in {
    val items = List("Apple", "Apple", "Apple", "Orange", "Orange", "Orange" )
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 1.7 // Price of 2 apples, 2 oranges
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

  it should "calculate total cost correctly for a list with only apples with offer" in {
    val items = List("Apple", "Apple", "Apple", "Apple")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 1.2 //Price of 2
  }

  it should "calculate total cost correctly for a list with only oranges without the offer" in {
    val items = List("Orange", "Orange")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 0.5
  }

  it should "calculate total cost correctly for a list with only oranges with the offer" in {
    val items = List("Orange", "Orange", "Orange")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 0.5 //Price of 2
  }

  it should "calculate total cost correctly for a list with more than three oranges with the offer" in {
    val items = List("Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
    val totalCost = Checkout.calculateTotalCost(items)
    totalCost shouldEqual 1.0 //Price of 4
  }
}
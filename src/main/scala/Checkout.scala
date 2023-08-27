object Checkout {
  val applePrice = 0.60
  val orangePrice = 0.25

  def calculateTotalCost(items: List[String]): BigDecimal = {
    val appleCount = items.count(_ == "Apple")
    val orangeCount = items.count(_ == "Orange")

    val appleDiscountedCount = appleCount / 2
    val appleTotal = appleCount - appleDiscountedCount

    val orangeTotal = ((orangeCount / 3) * 2) + (orangeCount % 3)

    val totalCost = appleTotal * applePrice + orangeTotal * orangePrice
    totalCost
  }

  def main(args: Array[String]): Unit = {
    val scannedItems = List("Apple", "Apple", "Orange", "Apple", "Orange","Orange")
    val totalCost = calculateTotalCost(scannedItems)
    println(f"Total cost: £$totalCost%.2f")
  }

}
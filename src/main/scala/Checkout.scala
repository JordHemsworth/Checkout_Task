object Checkout {
  val applePrice = 0.60
  val orangePrice = 0.25

  def calculateTotalCost(items: List[String]): BigDecimal = {
    val appleCount = items.count(_ == "Apple")
    val orangeCount = items.count(_ == "Orange")
    val totalCost = appleCount * applePrice + orangeCount * orangePrice
    totalCost
  }

  def main(args: Array[String]): Unit = {
    val scannedItems = List("Apple", "Apple", "Orange", "Apple")
    val totalCost = calculateTotalCost(scannedItems)
    println(f"Total cost: £$totalCost%.2f")
  }
}
package prg1.lx05.ex01_phones

object nexus6 {
  val name = "Nexus 6 32GB SIMフリー"
  val popularity = 66
  val nReviews = 0
  val nComments = 224
  val since = "2014/11/13"
  val carrier = "ワイモバイル"
  val simSize = "nanoSIM"
  val osType = "Android"
  val available = "?"
  val displaySize = 5.96
  val memoryGB = 64
  val tethering = "Supported"
}

object iphone6 {
  val name = "iPhone 6 64GB SIMフリー"
  val popularity = 49
  val nReviews = 4.13
  val nComments = 451
  val since = "2014/9/10"
  val carrier = "SIMフリー"
  val simSize = "nanoSIM"
  val osType = "iOS"
  val available = "?"
  val displaySize = 4.7
  val memoryGB = 64
  val tethering = "Hopefully"
}

object t1Simple {
  def main(arguments: Array[String]): Unit = {
    println(nexus6.name)
    println(iphone6.name)
  }
}

class SmartPhone(
  _name:String,
  _popularity: Int,
  _nReviews: Double,
  _nComments: Int,
  _since: String,
  _carrier: String,
  _simSize: String,
  _osType: String) {
  def name = _name
  def popularity = _popularity
}

@main def run1_naive = {
  val nexus6 = new SmartPhone("Nexus 6 32GB SIMフリー", 66, 0, 224, "2014/11/13", "ワイモバイル", "nanoSIM", "Android")

  val iphone6 = new SmartPhone("iPhone 6 64GB SIMフリー", 49, 4.13, 451, "2014/9/10", "SIMフリー", "nanoSIM", "iOS")

  for (phone <- List(nexus6, iphone6)) {
    println(phone.name) 
  }
}

trait NamedObject {
  val name: String
}

@main def run2_extends_trait = {
  object nexus6 extends NamedObject {
    val name = "Nexus 6 32GB SIMフリー"
    val popularity = 66
    val nReviews = 0
    val nComments = 224
    val since = "2014/11/13"
    val carrier = "ワイモバイル"
    val simSize = "nanoSIM"
    val osType = "Android"
    val available = "?"
    val displaySize = 5.96
    val memoryGB = 64
    val tethering = true
  }

  object iphone6 extends NamedObject {
    val name = "iPhone 6 64GB SIMフリー"
    val popularity = 49
    val nReviews = 4.13
    val nComments = 451
    val since = "2014/9/10"
    val carrier = "SIMフリー"
    val simSize = "nanoSIM"
    val osType = "iOS"
    val available = "?"
    val displaySize = 4.7
    val memoryGB = 64
    val tethering = "Hopefully"
  }

  for (phone <- List(nexus6, iphone6)) {
    println(phone.name) 
  }
}

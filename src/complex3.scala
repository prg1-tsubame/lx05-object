package prg1.lx05.ex02_complex3

import scala.math._

// 複素数のクラスの実装例3 - クラス宣言で val 引数を用いた作例
class Complex(val re: Double, val im: Double) {

  // クラスの引数(re, im)を利用して定義した例
  def plus(c: Complex): Complex = {
    new Complex(re + c.re, im + c.im)
  }

  // re, im関数を利用して定義した例
  def minus(c: Complex): Complex = {
    new Complex(re - c.re, im - c.im)
  }

  def neg: Complex = { new Complex(-re, -im) }

  def abs = { sqrt(re*re + im*im) }

  override def toString(): String = {
    if (im >= 0) {
      f"($re%.01f+$im%.01fi)"
    } else {
      f"($re%.01f${im}%.01fi)"
    }
  }

  def +(c: Complex): Complex = { plus(c) }

  def +(x: Double): Complex  = { new Complex(re + x, im) }

  def -(c: Complex): Complex = { minus(c) }

  def -(x: Double): Complex  = { new Complex(re - x, im) }

  override def equals(obj: Any): Boolean = obj match {
    case c: Complex => re == c.re && im == c.im
    case x: Double => re == x && im == 0
    case _ => false
  }

  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    result = prime * result + re.hashCode()
    result = prime * result + im.hashCode()
    result
  }

  def unary_- = { neg }

  def *(c: Complex): Complex = {
    new Complex(re * (c.re) - im * (c.im), re * (c.im) + im * (c.re))
  }

  def *(x: Double): Complex = { new Complex(re * x , im * x) }
}

@main def run = {
  def fromPolar(r: Double, theta: Double): Complex = {
    new Complex(r * cos(theta), r * sin(theta))
  }
}

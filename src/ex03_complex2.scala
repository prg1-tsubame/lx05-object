package prg1.lx05.ex03_complex2

import scala.math._

// 複素数のクラスの実装例2
class Complex(_re: Double, _im: Double) {
  def re = _re
  def im = _im

  // クラスの引数(_re, _im)を利用して定義した例
  def plus(c: Complex): Complex = {
    new Complex(_re + c.re, _im + c.im)
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

object Complex {
  def fromPolar(r: Double, theta: Double): Complex = {
    new Complex(r * cos(theta), r * sin(theta))
  }
}

@main def run = {
  val c1 = new Complex(2, 1)
  val c2 = new Complex(1, -2)
  println(s"$c1 + $c2 = ${c1 + c2}")
  println(s"$c1 - $c2 = ${c1 - c2}")
  println(s"$c1 * $c2 = ${c1 * c2}")
  println(s"|$c1| = ${c1.abs}")
  println(s"-$c1 = ${-c1}")
  println(s"fromPolar(1, Pi) = ${Complex.fromPolar(1, Pi)}")
  println(s"$c1 == $c1 = ${c1 == c1}")
}

package prg1.lx05.graphics

import java.awt.Dimension
import java.awt.image.BufferedImage
import javax.swing.{ImageIcon, JFrame, JLabel, WindowConstants}

abstract class AbstractGraphicsApp extends App {
  val W = 1024
  val H = 1024

  def draw(image: BufferedImage): Unit

  val image = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB)
  draw(image)

  val frame = new JFrame("Graphics Example")
  frame.getContentPane().add(new JLabel(new ImageIcon(image)))
  frame.setPreferredSize(new Dimension(W + 50, H + 50))
  frame.pack()
  frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE)
  frame.setVisible(true)
}

object ex05aRainbow extends AbstractGraphicsApp {
  def draw(image: BufferedImage): Unit = {
    for (x <- 0 until W)
      for (y <- 0 until H)
        image.setRGB(x, y, (x << 16) + (y << 8) + 128)
  }
}

import prg1.lx05.ex02b_complex2.Complex

object ex05bMandelbrot extends AbstractGraphicsApp {
  def draw(image: BufferedImage): Unit = {
    val T = 256
    val COL = 200
    for (x <- 0 until W)
      for (y <- 0 until H) {
        val c = new Complex(2.2 * x / W - 1.7, 2.2 * y / H - 1.1)
        var z = new Complex(0, 0);
        var color = 0
        var i = 0
        while (i < T) {
          z = z * z + c
          if (z.abs > 2) {
            i = T - i
            if (i % 2 == 0) color = (i << 16) + (COL << 8) + COL
            else color = (COL << 16) + (COL << 8) + i
            i = Int.MaxValue  // break out of the while loop
          } else { i = i + 1 }
        }
        image.setRGB(x, y, color)
      }
  }
}
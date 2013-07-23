package core

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

object Image {
  val width = 200
  val height = 200
  val invWidth = 1.0f / this.width.toFloat
  val invHeight = 1.0f / this.height.toFloat
  val ratio = this.height.toFloat / this.width.toFloat
  val img: BufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
  val pixels = Array.fill[Color](width, height)(new Color(0.0f, 0.0f, 0.0f))

  def set(x: Integer, y: Integer, color: Color) = pixels(y)(x) = color

  def save(filename: String) {
    for (y <- 0 until height) {
      for (x <- 0 until width) {
        img.setRGB(y, x, pixels(y)(x).toInt)
      }
    }

    ImageIO.write(img, "png", new File(filename))
  }

}
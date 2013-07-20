package core

class Color(var r: Float, var g: Float, var b: Float) {
  def *=(c: Color) {
    this.r *= c.r
    this.g *= c.g
    this.b *= c.b
  }

  def +=(c: Color) {
    this.r += c.r
    this.g += c.g
    this.b += c.b
  }

  def toInt(): Integer = {
    return (clamp(this.r) << 16) + (clamp(this.g) << 8) + clamp(this.b)
  }

  def clamp(i: Float): Integer = (i * 255.0).toInt

  override def toString() = this.r + " " + this.g + " " + this.b
}
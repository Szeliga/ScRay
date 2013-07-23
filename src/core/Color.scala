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
    //    this.gammaCorrection
    return (clamp(this.r) << 16) + (clamp(this.g) << 8) + clamp(this.b)
  }

  def gammaCorrection() {
    val gamma: Float = 1.0f / 2.2f
    this.r = Math.pow(this.r.toDouble, gamma).toFloat
    this.g = Math.pow(this.g.toDouble, gamma).toFloat
    this.b = Math.pow(this.b.toDouble, gamma).toFloat
  }

  def clamp(i: Float): Integer = (i * 255.0).toInt

  override def toString() = this.r + " " + this.g + " " + this.b
}
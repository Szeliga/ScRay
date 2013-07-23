package math

class Vec3(var x: Float, var y: Float, var z: Float) {

  def +(v: Vec3): Vec3 = return new Vec3(this.x + v.x, this.y + v.y, this.z + v.z)

  def -(v: Vec3): Vec3 = return new Vec3(this.x - v.x, this.y - v.y, this.z - v.z)

  def +=(v: Vec3) {
    x += v.x
    y += v.y
    z += v.z
  }

  def *(v: Vec3): Float = x * v.x + y * v.y + z * v.z

  def *(s: Float): Vec3 = new Vec3(this.x * s, this.y * s, this.z * s)

  def *=(s: Float) {
    x *= s
    y *= s
    z *= s
  }

  def x(v: Vec3): Vec3 = {
    new Vec3(
      y * v.z - z * v.y,
      z * v.x - x * v.z,
      x * v.y - y * v.x)
  }

  def length: Float = Math.sqrt((this * this).toDouble).toFloat

  def normalize = this *= (1.0f / this.length)


  override def toString(): String = x + " " + y + " " + z

}
package shapes

import core.Ray
import math.Vec3

class Sphere(val center: Vec3, val r: Float) extends Shape {

  def intersect(ray: Ray): Boolean = {
    val v: Vec3 = this.center - ray.o

    val b: Float = v * ray.dir
    //    println(b)
    val det: Float = b * b - (v * v) + (this.r * this.r)
    //    println(det)
    if (det < 0) return false

    val discSqrt = Math.sqrt(det)
    val t2 = b + discSqrt

    if (t2 < 0) return false

    val t1 = b - discSqrt

    if (t1 > 0)
      ray.t = t1.toFloat
    else
      ray.t = t2.toFloat

    return true
  }

  def normal(ip: Vec3): Vec3 = {
    return (ip - this.center) * (1.0f / this.r)
  }
}
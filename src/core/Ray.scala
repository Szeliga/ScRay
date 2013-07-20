package core

import math.Vec3
import scala.Float

class Ray(var o: Vec3, var dir: Vec3) {
  var t: Float = Float.PositiveInfinity
}
package shapes

import core.Ray
import math.Vec3

abstract class Shape {
  def intersect(ray: Ray): Boolean

  def normal(ip: Vec3): Vec3
}
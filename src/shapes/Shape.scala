package shapes

import core.Ray

abstract class Shape {
  def intersect(ray: Ray): Boolean
}
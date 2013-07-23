package tracers

import core.Camera
import core.Color
import math.Vec3
import shapes.Shape
import shapes.Sphere
import core.Image
import scala.collection.mutable.ListBuffer

object RayTracer {
  var shapes = ListBuffer.empty[Shape]

  def render(width: Integer, height: Integer) {
    val camera = Camera(new Vec3(.0f, 10.0f, 30.0f), new Vec3(.0f, .0f, .0f), 90.0f)

    shapes += new Sphere(new Vec3(.0f, .0f, .0f), 10.0f)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        val ray = camera.spawnRay(x, y)
        for (shape <- shapes) {
          if (shape.intersect(ray)) {
            val ip: Vec3 = ray.o + ray.dir * ray.t
            val normal: Vec3 = shape.normal(ip)
            Image.set(x, y, new Color(Math.abs(normal.x), Math.abs(normal.y), Math.abs(normal.z)))
          }
        }
      }
    }
    Image.save("test2.png")
  }
}
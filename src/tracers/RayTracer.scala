package tracers

import core.Camera
import core.Ray
import core.Color
import math.Vec3
import shapes.Shape
import shapes.Sphere
import core.Image
import scala.collection.mutable.ListBuffer

object RayTracer extends AbstractTracer {
  var shapes = ListBuffer.empty[Shape]
  
  def render(width: Integer, height: Integer) {
    val camera = new Camera(new Vec3(0.0f, .0f, 30.0f))
    shapes += new Sphere(new Vec3(.0f, .0f, .0f), 20.0f)
    
    for(y <- 0 until height) {
      for(x <- 0 until width) {
        var ray = camera.spawnRay(x, y)
        for(shape <- shapes) {
          if(shape.intersect(ray)) {
            Image.set(x, y, new Color(1.0f, 0.0f, 0.0f))
          }
        }
      }
    }
    Image.save("test2.png")
  }
}
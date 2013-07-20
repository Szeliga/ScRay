package core

import math.Vec3

class Camera(var eye: Vec3) {
  def spawnRay(x: Integer, y: Integer): Ray = {
    val hWidth = Image.width / 2
    val hHeight = Image.height / 2
    val point = new Vec3(-hWidth.toFloat + x.toFloat, hHeight.toFloat - y.toFloat, 0.0f)
    val dir = point - this.eye
    dir.normalize
    new Ray(this.eye, dir)
  }
}
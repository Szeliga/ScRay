package core

import math.Vec3

object Camera {
  def apply(eye: Vec3, lookAt: Vec3, fov: Float): Camera = {
    // Calculate u, v, w

    val cam = new Camera(eye, lookAt, fov)
    cam.w = cam.lookAt - cam.eye
    cam.w.normalize
    cam.u = cam.w x cam.up
    cam.v = cam.u x cam.w
    cam.v *= -1.0f
    cam.planeWidth = Math.tan((fov / 2.0f) * Math.PI / 360.0f).toFloat
    cam.planeHeight = cam.planeWidth * Image.ratio
    cam.corner = cam.eye + cam.w - (cam.v * cam.planeWidth) - (cam.u * cam.planeWidth)
    cam.toRight = cam.v * (2.0f * cam.planeWidth)
    cam.toBottom = cam.u * (2.0f * cam.planeHeight)
    cam
  }
}

class Camera(val eye: Vec3, val lookAt: Vec3, val fov: Float) {
  var u: Vec3 = null
  var v: Vec3 = null
  var w: Vec3 = null
  var planeWidth: Float = 0.0f
  var planeHeight: Float = 0.0f
  var corner: Vec3 = null
  var toRight: Vec3 = null
  var toBottom: Vec3 = null
  var up: Vec3 = new Vec3(.0f, 1.0f, .0f)

  def spawnRay(x: Integer, y: Integer): Ray = {
    val point = this.corner + this.toRight * (x.toFloat * Image.invWidth) + this.toBottom * (y.toFloat * Image.invHeight)
    val dir = point - this.eye
    dir.normalize
    new Ray(this.eye, dir)
  }
}
import stddraw
import math

# Documentacion de los modulos
# https://introcs.cs.princeton.edu/python/code/

g = -9.8

class Ball:

    def __init__(self, x, y, vel, angle):
        self._x = x
        self._y = y
        self._vel = vel
        self._angle = math.radians(angle)

    def __str__(self):
        return f"({self._x},{self._y}), vel={self._vel}, angle={self._angle}"

    def updatePosition(self, time):
        self._x = self._vel*math.cos(self._angle)*time
        self._y = self._vel*math.sin(self._angle)*time + g*t**2/2

    def paint(self):
        stddraw.setPenColor(stddraw.RED)
        stddraw.setPenRadius(0.02)
        stddraw.point(self._x, self._y)

    def isAboveGround(self):
        return self._y>=0


if __name__=="__main__":
    ball = Ball(0,0,30,60)
    print(str(ball))

    stddraw.setXscale(0,100)
    stddraw.setYscale(0,100)
    stddraw.clear()

    deltaT = 0.01
    t = 0.0
    while t<10 and ball.isAboveGround():
        stddraw.clear()
        ball.updatePosition(t)
        ball.paint()
        # print(str(ball))
        stddraw.show(deltaT*1000)
        t += deltaT

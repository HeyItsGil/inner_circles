import processing.core.*
import kotlin.math.PI

class CircleWithPattern(private val sketch: PApplet) {
    private val radius: Int by lazy { sketch.width/2 }
    private val innerCircleRadius by lazy { radius/4f }
    var angle = 2 * PI

    init {

    }

    fun display(colourRange: Float, alphaRange: Float){
        sketch.pushMatrix()
        sketch.translate(sketch.width/2f, sketch.height/2f)
        sketch.stroke(0)
        sketch.ellipse(0f,0f, radius.toFloat(), radius.toFloat())
//        innerCirclesOne()
//        innerCirclesTwo()
        innerCirclesThree(colourRange, alphaRange)
        angle+= 0.01
//        Why does incrementing the angle result in the circles rotating at different speeds???
        sketch.popMatrix()
    }

    fun drawCircle(x: Float, y: Float){
        sketch.ellipse(x, y, innerCircleRadius, innerCircleRadius)
    }

    fun drawCircle(x: Float, y: Float, radiusFactor: Float){
        sketch.ellipse(x, y, innerCircleRadius*radiusFactor, innerCircleRadius*radiusFactor)
    }

    fun innerCirclesOne(){
        sketch.rotate(angle.toFloat())
        sketch.ellipse(0f, -innerCircleRadius, innerCircleRadius*2f, innerCircleRadius*2f)
        sketch.ellipse(0f, innerCircleRadius*1.5f, innerCircleRadius, innerCircleRadius)
    }

    fun innerCirclesTwo(){
        sketch.rotate(angle.toFloat())
        sketch.ellipse(0f, -innerCircleRadius, innerCircleRadius, innerCircleRadius)
        sketch.ellipse(innerCircleRadius, innerCircleRadius/2f, innerCircleRadius, innerCircleRadius)
        sketch.ellipse(-innerCircleRadius, innerCircleRadius/2f, innerCircleRadius, innerCircleRadius)
//        sketch.ellipse(0f, -radius/6f-radius/12f, radius/5f, radius/5f)
//        sketch.ellipse(-radius/6f, radius/6f, radius/5f, radius/5f)
//        sketch.ellipse(radius/6f, radius/6f, radius/5f, radius/5f)
    }

    fun innerCirclesThree(colourRange: Float, alphaRange: Float){
        sketch.fill(colourRange, 85.9f, 100f, 175f)
        sketch.noStroke()
        sketch.rotate(angle.toFloat())
        drawCircle(0f, -innerCircleRadius*.75f, 1.5f)
        drawCircle(0f, innerCircleRadius*.75f, 1.5f)
        drawCircle(-innerCircleRadius*.75f, 0f, 1.5f)
        drawCircle(innerCircleRadius*0.75f, 0f, 1.5f)
    }
}

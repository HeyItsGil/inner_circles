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
//        innerCirclesThree(colourRange, alphaRange)
        innerCirclesFour()
        angle+= 0.01
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

    fun innerCirclesFour(){
        sketch.fill(45f, 85.9f, 100f, 175f)
        sketch.noStroke()
        val radFactor = 1.5f
        sketch.rotate(angle.toFloat())
        drawCircle(0f, -innerCircleRadius*.75f, radFactor)
        drawCircle(0f, innerCircleRadius*.75f, radFactor)
        drawCircle(-innerCircleRadius*.75f, 0f, radFactor)
        drawCircle(innerCircleRadius*0.75f, 0f, radFactor)

        drawCircle(innerCircleRadius*0.75f, -innerCircleRadius*.75f, radFactor)
        drawCircle(innerCircleRadius*0.75f, innerCircleRadius*.75f, radFactor)
        drawCircle(-innerCircleRadius*0.75f, -innerCircleRadius*.75f, radFactor)
        drawCircle(-innerCircleRadius*0.75f, innerCircleRadius*.75f, radFactor)

    }
}

import processing.core.PApplet

class Main : PApplet() {
    private val circle: CircleWithPattern by lazy {
        CircleWithPattern(this)
    }

    init {
       this.runSketch()
    }

    override fun settings() {
        size(640, 480)
//        fullScreen()
//        pixelDensity(2)
    }

    override fun setup() {
        colorMode(HSB, 360f)

    }

    override fun draw() {
        colorMode(HSB, 360f, 100f, 100f)
        background(0f, 0f, 100f)
        fill(0f, 0f, 100f)
        val colourRange = map(mouseX.toFloat(), 0f, width.toFloat(), 0f, 360f)
        val alphaRange = map(mouseY.toFloat(), 0f, height.toFloat(), 0f, 255f)
        circle.display(colourRange.toFloat(), alphaRange.toFloat())

//        noLoop()
    }

}

fun main(args: Array<String>) {
    Main()
}
package com.orlinskas.customviewtask.customView

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator


class OldCustomProgressBar @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    private var animator: ValueAnimator? = null
    private lateinit var paint: Paint
    private lateinit var path: Path
    private var degreesArray = arrayOf(0F, 45F, 90F, 135F, 180F, 225F, 270F, 315F, 360F)
    private var degrees = 90F
    private var color = Color.RED
    private var strokeWidth = 10F
    private var intermediate = false

    init {
        init(attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(attrs: AttributeSet?) {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.STROKE
        path = Path()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator = ValueAnimator.ofInt(0, degreesArray.size - 1).apply {
            addUpdateListener {
                val animDegrees = it.animatedValue
                degrees = degreesArray[animDegrees as Int]
                invalidate()
            }
            duration = 500L
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        paint.color = color
        paint.strokeWidth = strokeWidth
        if (intermediate) {
            animator?.start()
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //координаты левой скобки
        val pointA: Point
        val pointB: Point
        val pointA1: Point
        val pointB1: Point

        //координаты правой скобки
        val pointC: Point
        val pointC1: Point
        val pointD: Point
        val pointD1: Point

        //координаты центральной линии
        val pointF1: Point
        val pointF2: Point

        if (canvas != null) {
            pointA = Point((width / 10) * 2, (height / 10) * 3)
            pointA1 = Point((width / 10) * 4, (height / 10) * 2)
            pointB = Point((width / 10) * 2, (height / 10) * 7)
            pointB1 = Point((width / 10) * 4, (height / 10) * 8)

            pointC = Point((width / 10) * 8, (height / 10) * 3)
            pointC1 = Point((width / 10) * 6, (height / 10) * 2)
            pointD = Point((width / 10) * 8, (height / 10) * 7)
            pointD1 = Point((width / 10) * 6, (height / 10) * 8)

            pointF1 = Point((width / 10) * 5, (height / 10) * 3)
            pointF2 = Point((width / 10) * 5, (height / 10) * 7)

            // левая скобка
            path.reset()
            path.moveTo(pointA1)
            path.lineTo(pointA)
            path.lineTo(pointB)
            path.lineTo(pointB1)
            canvas.drawPath(path, paint)

            // правая скобка
            path.reset()
            path.moveTo(pointC1)
            path.lineTo(pointC)
            path.lineTo(pointD)
            path.lineTo(pointD1)
            canvas.drawPath(path, paint)

            // центральная линия
            path.reset()
            path.moveTo(pointF1)
            path.lineTo(pointF2)

            //анимация центральной линии
            val matrix = Matrix()
            val rectF = RectF()
            path.computeBounds(rectF, true)
            matrix.postRotate(degrees, rectF.centerX(), rectF.centerY())
            path.transform(matrix)
            canvas.drawPath(path, paint)
        }
    }

    override fun onDetachedFromWindow() {
        animator?.cancel()
        super.onDetachedFromWindow()
    }

    public fun start() {
        animator?.let {
            if(it.isRunning){
                stop()
            }
            else {
                it.start()
            }
        }
    }

    public fun stop() {
        animator?.cancel()
        degrees = 90F
        invalidate()
    }

    public fun setColor(resID: Int) {
        this.color = resID
    }

    public fun setStrokeWidth(width: Float) {
        strokeWidth = width
    }

    public fun intermediate(intermediate: Boolean) {
        this.intermediate = intermediate
    }

    private fun Path.lineTo(point: Point) {
        this.lineTo(point.x.toFloat(), point.y.toFloat())
    }

    private fun Path.moveTo(point: Point) {
        this.moveTo(point.x.toFloat(), point.y.toFloat())
    }

    private fun Canvas?.drawPoint(point: Point, paint: Paint) {
        this?.drawPoint(point.x.toFloat(), point.y.toFloat(), paint)
    }

    private fun Canvas?.drawLine(pointA: Point, pointB: Point, paint: Paint) {
        this?.drawLine(pointA.x.toFloat(), pointA.y.toFloat(), pointB.x.toFloat(), pointB.y.toFloat(), paint)
    }
}



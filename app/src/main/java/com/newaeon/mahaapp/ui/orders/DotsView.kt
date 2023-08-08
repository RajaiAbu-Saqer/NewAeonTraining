package com.newaeon.mahaapp.ui.orders

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.newaeon.mahaapp.R


class DotsView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val dotRadius = 8f
    private val dotSpacing = 20f
    private val dotPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.purple_200)
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f

        val maxDots = 12
        for (i in 0 until maxDots) {
            val angle = Math.toRadians((360.0 / maxDots) * i)
            val x = centerX + (dotSpacing * Math.cos(angle)).toFloat()
            val y = centerY + (dotSpacing * Math.sin(angle)).toFloat()

            canvas.drawCircle(x, y, dotRadius, dotPaint)
        }
    }
}
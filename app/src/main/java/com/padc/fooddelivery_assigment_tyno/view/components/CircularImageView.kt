package com.padc.fooddelivery_assigment_tyno.view.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.content.withStyledAttributes
import com.padc.fooddelivery_assigment_tyno.R

class CircularImageView @JvmOverloads constructor(
    context : Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0
) : AppCompatImageView(context,attrs,defStyleAttr){
    private var cornerRadius = 0f
    private var cornerX = 0f
    private var cornerY = 0f

    private val path = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var borderColor = Color.WHITE
    var fillColor = Color.WHITE
    var borderWidth = 5f

    init {
        context.withStyledAttributes(attrs, R.styleable.CircularImageView) {
            cornerRadius = getDimension(R.styleable.CircularImageView_cornerRadius,0f)
            cornerX = getDimension(R.styleable.CircularImageView_cornerX,0f)
            cornerY = getDimension(R.styleable.CircularImageView_cornerY,0f)
            fillColor = getColor(R.styleable.CircularImageView_fillColor,0)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        val radius = cornerRadius/2f
        path.addCircle(cornerX,cornerY,cornerRadius,Path.Direction.CCW)
        paint.color = borderColor
        paint.color  = fillColor
        paint.style = Paint.Style.FILL
        paint.strokeWidth = borderWidth

        canvas?.drawCircle(cornerX, cornerY , cornerRadius- borderWidth/3f,paint)
        canvas?.clipPath(path)
        super.onDraw(canvas)
    }

}

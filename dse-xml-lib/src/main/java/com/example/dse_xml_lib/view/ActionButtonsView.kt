package com.example.dse_xml_lib.view

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageButton
import android.widget.LinearLayout
import com.example.dse_xml_lib.R

class ActionButtonsView(context: Context) : LinearLayout(context) {

    val favoriteButton: ImageButton
    val shareButton: ImageButton

    init {
        orientation = HORIZONTAL
        gravity = Gravity.END

        favoriteButton = ImageButton(context).apply {
            // Ícone de coração (favorito)
            setImageResource(R.drawable.ic_favorite_off)
            background = null
            contentDescription = "Favoritar notícia"
            setPadding(dpToPx(12), dpToPx(12), dpToPx(12), dpToPx(12))
        }

        shareButton = ImageButton(context).apply {
            // Ícone de compartilhar
            setImageResource(R.drawable.ic_share)
            background = null
            contentDescription = "Compartilhar notícia"
            setPadding(dpToPx(12), dpToPx(12), dpToPx(12), dpToPx(12))
        }

        addView(favoriteButton)
        addView(shareButton)
    }

    private fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}

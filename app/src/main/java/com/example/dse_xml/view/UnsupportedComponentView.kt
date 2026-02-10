package com.example.dse_xml.view

import android.content.Context
import android.graphics.Color

class UnsupportedComponentView(context: Context) : androidx.appcompat.widget.AppCompatTextView(context) {

    init {
        text = "Componente não suportado"
        setTextColor(Color.RED)
    }
}

package com.example.dse_xml_lib.view

import android.content.Context
import android.graphics.Color
import androidx.appcompat.widget.AppCompatTextView

class UnsupportedComponentView(context: Context) : AppCompatTextView(context) {

    init {
        text = "Componente não suportado"
        setTextColor(Color.RED)
    }
}

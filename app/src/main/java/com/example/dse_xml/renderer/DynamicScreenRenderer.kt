package com.example.dse_xml.renderer

import android.content.Context
import android.view.ViewGroup
import com.example.dse_xml.factory.ComponentFactory
import com.example.dse_xml.model.ScreenResponse

class DynamicScreenRenderer {

    fun render(
        context: Context,
        container: ViewGroup,
        screen: ScreenResponse
    ) {
        container.removeAllViews()

        screen.components.forEach { component ->
            val view = ComponentFactory.create(context, component)
            container.addView(view)
        }
    }
}


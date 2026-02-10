package com.example.dse_xml_lib.renderer

import android.content.Context
import android.view.ViewGroup
import com.example.dse_xml_lib.factory.ComponentFactory
import com.example.dse_xml_lib.model.ScreenResponse

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


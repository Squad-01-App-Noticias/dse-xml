package com.example.dse_xml_lib.view

import android.content.Context
import android.graphics.Color
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UnsupportedComponentViewTest {

    private val context: Context =
        ApplicationProvider.getApplicationContext()

    @Test
    fun shouldHaveDefaultText() {

        val view = UnsupportedComponentView(context)

        assertEquals("Componente não suportado", view.text)
    }

    @Test
    fun shouldHaveRedTextColor() {

        val view = UnsupportedComponentView(context)

        assertEquals(Color.RED, view.currentTextColor)
    }
}

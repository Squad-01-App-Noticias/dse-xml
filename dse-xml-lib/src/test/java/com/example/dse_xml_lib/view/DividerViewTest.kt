package com.example.dse_xml_lib.view

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DividerViewTest {

    private val context: Context =
        ApplicationProvider.getApplicationContext()

    @Test
    fun shouldCreateDividerView() {

        val view = DividerView(context)

        assertNotNull(view)
    }
}

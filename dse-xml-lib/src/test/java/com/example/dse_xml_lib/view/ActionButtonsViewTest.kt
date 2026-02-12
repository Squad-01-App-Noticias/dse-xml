package com.example.dse_xml_lib.view

import android.content.Context
import android.widget.ImageButton
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ActionButtonsViewTest {

    private val context: Context =
        ApplicationProvider.getApplicationContext()

    @Test
    fun shouldCreateTwoButtons() {

        val view = ActionButtonsView(context)

        assertEquals(2, view.childCount)
        assertTrue(view.getChildAt(0) is ImageButton)
        assertTrue(view.getChildAt(1) is ImageButton)
    }

    @Test
    fun favoriteButtonShouldHaveContentDescription() {

        val view = ActionButtonsView(context)

        assertEquals(
            "Favoritar notícia",
            view.favoriteButton.contentDescription
        )
    }

    @Test
    fun shareButtonShouldHaveContentDescription() {

        val view = ActionButtonsView(context)

        assertEquals(
            "Compartilhar notícia",
            view.shareButton.contentDescription
        )
    }
}

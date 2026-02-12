package com.example.dse_xml_lib.factory

import android.R
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.dse_xml_lib.model.ComponentResponse
import com.example.dse_xml_lib.view.ActionButtonsView
import com.example.dse_xml_lib.view.DividerView
import com.example.dse_xml_lib.view.UnsupportedComponentView

object ComponentFactory {

    fun create(
        context: Context,
        component: ComponentResponse
    ): View {
        return when (component.component) {
            "TEXT" -> createText(context, component.props)
            "IMAGE" -> createImage(context, component.props)
            "DIVIDER" -> createDivider(context, component.props)
            "ACTION_BUTTONS" -> createActionButtons(context, component.props)
            else -> UnsupportedComponentView(context)
        }
    }

    private fun createText(
        context: Context,
        props: Map<String, String>
    ): View {
        return TextView(context).apply {
            val marginTop = props["margin_top"]?.toIntOrNull() ?: 0
            val marginBottom = props["margin_bottom"]?.toIntOrNull() ?: 0
            val marginLeft = props["margin_left"]?.toIntOrNull() ?: 0
            val marginRight = props["margin_right"]?.toIntOrNull() ?: 0

            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    dpToPx(context, marginLeft),
                    dpToPx(context, marginTop),
                    dpToPx(context, marginRight),
                    dpToPx(context, marginBottom)
                )
            }

            text = props["description"] ?: ""
            contentDescription = props["accessibility_text"] ?: ""

            isFocusable = true
            isFocusableInTouchMode = false
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES

            gravity = when (props["gravity"]) {
                "START" -> Gravity.START
                "CENTER" -> Gravity.CENTER
                "END" -> Gravity.END
                else -> Gravity.START
            }

            val textColor = props["text_color"]?.let { parseColor(it) } ?: Color.BLACK
            setTextColor(textColor)

            val textSize = props["text_size"]?.toFloatOrNull() ?: 16f
            setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)

            typeface = when (props["text_style"]) {
                "BOLD" -> Typeface.DEFAULT_BOLD
                "ITALIC" -> Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
                "BOLD_ITALIC" -> Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC)
                else -> Typeface.DEFAULT
            }

            val lineSpacing = props["line_spacing"]?.toFloatOrNull() ?: 1.0f
            setLineSpacing(0f, lineSpacing)
        }
    }

    private fun createImage(
        context: Context,
        props: Map<String, String>
    ): View {
        return ImageView(context).apply {
            val marginTop = props["margin_top"]?.toIntOrNull() ?: 0
            val marginBottom = props["margin_bottom"]?.toIntOrNull() ?: 0
            val marginLeft = props["margin_left"]?.toIntOrNull() ?: 0
            val marginRight = props["margin_right"]?.toIntOrNull() ?: 0
            val height = props["height"]?.toIntOrNull() ?: 400

            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dpToPx(context, height)
            ).apply {
                setMargins(
                    dpToPx(context, marginLeft),
                    dpToPx(context, marginTop),
                    dpToPx(context, marginRight),
                    dpToPx(context, marginBottom)
                )
            }

            contentDescription = props["accessibility_text"] ?: ""

            isFocusable = true
            isFocusableInTouchMode = false
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES

            adjustViewBounds = true

            scaleType = when (props["scale_type"]) {
                "CENTER_CROP" -> ImageView.ScaleType.CENTER_CROP
                "FIT_CENTER" -> ImageView.ScaleType.FIT_CENTER
                "CENTER_INSIDE" -> ImageView.ScaleType.CENTER_INSIDE
                else -> ImageView.ScaleType.CENTER_CROP
            }

            val imageUrl = props["url"] ?: ""
            if (imageUrl.isNotEmpty()) {
                this.load(imageUrl) {
                    crossfade(true)
                    placeholder(R.drawable.ic_menu_gallery)
                    error(R.drawable.ic_menu_report_image)
                }
            }
        }
    }

    private fun createDivider(
        context: Context,
        props: Map<String, String>
    ): View {
        return DividerView(context).apply {
            val marginTop = props["margin_top"]?.toIntOrNull() ?: 0
            val marginBottom = props["margin_bottom"]?.toIntOrNull() ?: 0
            val marginLeft = props["margin_left"]?.toIntOrNull() ?: 0
            val marginRight = props["margin_right"]?.toIntOrNull() ?: 0
            val height = props["height"]?.toIntOrNull() ?: 1

            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dpToPx(context, height)
            ).apply {
                setMargins(
                    dpToPx(context, marginLeft),
                    dpToPx(context, marginTop),
                    dpToPx(context, marginRight),
                    dpToPx(context, marginBottom)
                )
            }

            val color = props["color"]?.let { parseColor(it) } ?: Color.LTGRAY
            setBackgroundColor(color)

            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
    }

    private fun createActionButtons(
        context: Context,
        props: Map<String, String>
    ): View {
        return ActionButtonsView(context).apply {
            val marginTop = props["margin_top"]?.toIntOrNull() ?: 0
            val marginBottom = props["margin_bottom"]?.toIntOrNull() ?: 0
            val marginLeft = props["margin_left"]?.toIntOrNull() ?: 0
            val marginRight = props["margin_right"]?.toIntOrNull() ?: 0

            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    dpToPx(context, marginLeft),
                    dpToPx(context, marginTop),
                    dpToPx(context, marginRight),
                    dpToPx(context, marginBottom)
                )
            }
        }
    }

    private fun dpToPx(context: Context, dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }

    private fun parseColor(colorString: String): Int {
        return try {
            Color.parseColor(colorString)
        } catch (e: Exception) {
            Color.BLACK
        }
    }
}

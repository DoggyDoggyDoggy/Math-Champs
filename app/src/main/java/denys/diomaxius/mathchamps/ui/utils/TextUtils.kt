package denys.diomaxius.mathchamps.ui.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

fun buildColorfulText(text: String): AnnotatedString {
    val colors = listOf(
        Color(0xFF4285F4),
        Color(0xFF0F9D58),
        Color(0xFFF4B400),
        Color(0xFFDB4437)
    )

    return buildAnnotatedString {
        text.forEachIndexed { index, char ->
            val color = colors[index % colors.size]
            withStyle(style = SpanStyle(color = color)) {
                append(char)
            }
        }
    }
}
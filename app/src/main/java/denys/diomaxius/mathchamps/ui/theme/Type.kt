package denys.diomaxius.mathchamps.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import denys.diomaxius.mathchamps.R

val Roboto = FontFamily(
    Font(R.font.roboto_semi_bold, FontWeight.SemiBold)
)

val Oswald = FontFamily(
    Font(R.font.oswald_semi_bold, FontWeight.SemiBold)
)

val Typography = Typography(

    labelLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = 36.sp,
        shadow = Shadow(
            color = Color.Black,
            offset = Offset(4f, 4f),
            blurRadius = 8f
        )
    ),

    displayLarge = TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.SemiBold,
        fontSize = 42.sp
    ),

    displaySmall = TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp
    )

)
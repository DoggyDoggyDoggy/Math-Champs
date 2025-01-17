package denys.diomaxius.mathchamps.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import denys.diomaxius.mathchamps.data.model.Difficulty
import denys.diomaxius.mathchamps.ui.utils.buildColorfulText

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Difficulty.entries.forEach { difficulty ->
            Box(
                modifier = Modifier
                    .padding(25.dp)
                    .width(250.dp)
                    .height(75.dp)
                    .background(Color(0xFFE2DFE9))
                    .border(
                        color = (Color(0xFFA995D6)),
                        width = 1.dp,
                        shape = RectangleShape
                    )
                    .clickable {
                        navController.navigate("game/${difficulty.name}")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = buildColorfulText(difficulty.title),
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}
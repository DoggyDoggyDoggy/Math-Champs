package denys.diomaxius.mathchamps.ui.game

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay


@Composable
fun Game(
    viewModel: GameViewModel = hiltViewModel()
) {
    val equation = viewModel.equation.observeAsState()
    val equationAnswers = viewModel.equationAnswers.observeAsState()

    val boxColor = remember { mutableStateOf(Color.White) }
    val animatedColor by animateColorAsState(targetValue = boxColor.value)

    LaunchedEffect(boxColor.value) {
        delay(125)
        boxColor.value = Color.White
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(animatedColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${equation.value?.a} ${equation.value?.operator} ${equation.value?.b}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            equationAnswers.value?.answers?.forEach { answer ->
                Card(
                    modifier = Modifier
                        .height(75.dp)
                        .weight(1f)
                        .padding(5.dp)
                        .clickable {
                            boxColor.value =
                                if (viewModel.check(answer)) Color(0xFF00FF0D) else Color(0xFFFF0000)
                        }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = answer.toString(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                }
            }
        }
    }
}
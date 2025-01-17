package denys.diomaxius.mathchamps.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import denys.diomaxius.mathchamps.data.model.Difficulty

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("game/${Difficulty.Kindergarten.name}") }) {
            Text("Kindergarten")
        }
        Button(onClick = { navController.navigate("game/${Difficulty.FirstGrade.name}") }) {
            Text("First Grade")
        }
        Button(onClick = { navController.navigate("game/${Difficulty.SecondGrade.name}") }) {
            Text("Second Grade")
        }
        Button(onClick = { navController.navigate("game/${Difficulty.ThirdGrade.name}") }) {
            Text("Third Grade")
        }
    }
}

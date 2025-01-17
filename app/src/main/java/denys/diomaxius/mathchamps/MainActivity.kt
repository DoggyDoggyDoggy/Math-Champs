package denys.diomaxius.mathchamps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import denys.diomaxius.mathchamps.navigation.Navigation
import denys.diomaxius.mathchamps.ui.game.Game
import denys.diomaxius.mathchamps.ui.theme.MathChampsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathChampsTheme {
                Navigation()
            }
        }
    }
}
package denys.diomaxius.mathchamps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import denys.diomaxius.mathchamps.ui.game.Game
import denys.diomaxius.mathchamps.ui.theme.MathChampsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathChampsTheme {
                Game()
            }
        }
    }
}
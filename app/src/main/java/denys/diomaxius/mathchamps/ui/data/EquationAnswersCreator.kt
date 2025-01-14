package denys.diomaxius.mathchamps.ui.data

import android.util.Log
import denys.diomaxius.mathchamps.ui.data.model.Equation
import denys.diomaxius.mathchamps.ui.data.model.EquationAnswers
import kotlin.random.Random

class EquationAnswersCreator() {
    fun generateAnswers(equation: Equation): EquationAnswers {
        val equationAnswers = EquationAnswers().apply {
            answers[0] = equation.result
            checkEquationOperator(equation, this)
            answers.shuffle()
        }
        return equationAnswers
    }

    private fun checkEquationOperator(equation: Equation, equationAnswers: EquationAnswers) {
        when (equation.operator) {
            '+' -> sumEquation(equation, equationAnswers)

            else -> {}
        }
    }

    private fun sumEquation(equation: Equation, equationAnswers: EquationAnswers) {
        val decreaseResult = (4 downTo 2).find { equation.result - it > 0 } ?: 2

        equationAnswers.answers[1] = equation.result + Random.nextInt(1, 4)
        equationAnswers.answers[2] = equation.result - Random.nextInt(1, decreaseResult)
        equationAnswers.answers[3] = Random.nextInt(1, 21)
    }
}
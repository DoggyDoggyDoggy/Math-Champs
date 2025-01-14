package denys.diomaxius.mathchamps.ui.data

import denys.diomaxius.mathchamps.ui.data.model.Equation
import denys.diomaxius.mathchamps.ui.data.model.EquationAnswers

class EquationAnswersCreator() {
    private val equationAnswers = EquationAnswers()

    fun generateAnswers(equation: Equation) : EquationAnswers {
        equationAnswers.answers[0] = equation.result
        equationAnswers.answers[1] = 1
        equationAnswers.answers[2] = 2
        equationAnswers.answers[3] = 3
        return equationAnswers
    }
}
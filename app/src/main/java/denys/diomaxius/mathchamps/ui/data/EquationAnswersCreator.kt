package denys.diomaxius.mathchamps.ui.data

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
            '-' -> extractEquation(equation, equationAnswers)
            '*' -> multiplyEquation(equation, equationAnswers)
            '/' -> divideEquation(equation, equationAnswers)

            else -> {}
        }
    }
    private fun divideEquation(equation: Equation, equationAnswers: EquationAnswers) {
        equationAnswers.answers[1] = when {
            equation.result > 1 -> equation.result - 1
            else -> equation.result + 2
        }
        equationAnswers.answers[2] = when {
            equation.result < 100 -> equation.result + 1
            else -> equation.result - 2
        }
        equationAnswers.answers[3] = Random.nextInt(1, 50)
    }

    private fun multiplyEquation(equation: Equation, equationAnswers: EquationAnswers) {

        if (equation.a != 10 || equation.b != 10) {
            equationAnswers.answers[1] = when {
                equation.a != 10 && equation.b != 10 -> {
                    if (Random.nextInt(0, 2) == 0)
                        equation.result + equation.a
                    else
                        equation.result + equation.b
                }

                equation.a != 10 -> equation.result + equation.a
                else -> equation.result + equation.b
            }
        } else {
            equationAnswers.answers[1] = if (Random.nextInt(0, 2) == 0)
                equation.result - equation.a
            else
                equation.result - equation.b
        }

        equationAnswers.answers[2] = when {
            equation.a != 1 && equation.b != 1 -> {
                if (equation.a == equation.b) {
                    equation.a + equation.b
                } else {
                    if (Random.nextInt(0, 2) == 0)
                        equation.result - equation.a
                    else
                        equation.result - equation.b
                }
            }
            else -> 1
        }

        equationAnswers.answers[3] = Random.nextInt(1, 100)
    }

    private fun extractEquation(equation: Equation, equationAnswers: EquationAnswers) {
        val decreaseResult = (4 downTo 2).find { equation.result - it > 0 } ?: 0

        equationAnswers.answers[1] = equation.result + Random.nextInt(1, 4)

        if (decreaseResult != 0) {
            equationAnswers.answers[2] = equation.result - Random.nextInt(1, decreaseResult)
        } else {
            equationAnswers.answers[2] = equationAnswers.answers[1] + 1
        }

        equationAnswers.answers[3] = Random.nextInt(1, 21)
    }

    private fun sumEquation(equation: Equation, equationAnswers: EquationAnswers) {
        val decreaseResult = (4 downTo 2).find { equation.result - it > 0 } ?: 2

        equationAnswers.answers[1] = equation.result + Random.nextInt(1, 4)
        equationAnswers.answers[2] = equation.result - Random.nextInt(1, decreaseResult)
        equationAnswers.answers[3] = Random.nextInt(1, 21)
    }
}
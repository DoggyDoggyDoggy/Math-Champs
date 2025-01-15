package denys.diomaxius.mathchamps.ui.data

import denys.diomaxius.mathchamps.ui.data.model.Equation
import denys.diomaxius.mathchamps.ui.data.utils.equationSolver
import kotlin.random.Random

class EquationCreator {
    fun generateEquation(): Equation {
        val operator = randomOperator()
        val a = randomNumberA(operator)
        val b = randomNumberB(operator, a)

        val result = equationSolver(operator, a, b)
        return Equation(a, b, operator, result)
    }

    private fun randomOperator(): Char {
        //val operators = listOf('+', '-', '/', '*')
        val operators = listOf('+', '-')
        return operators.random()
    }

    private fun randomNumberA(operator: Char): Int {
        return  when (operator) {
            '+' -> Random.nextInt(1, 11)
            '-' -> Random.nextInt(2, 21)
            else -> 0
        }
    }
    private fun randomNumberB(operator: Char, a: Int): Int {
        return when (operator) {
            '+' -> Random.nextInt(1, 11)
            '-' -> Random.nextInt(1, a)
            else -> 0
        }
    }
}
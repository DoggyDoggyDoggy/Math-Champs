package denys.diomaxius.mathchamps.ui.data

import denys.diomaxius.mathchamps.ui.data.model.Equation
import denys.diomaxius.mathchamps.ui.data.utils.equationSolver
import kotlin.random.Random

class EquationCreator {
    fun generateEquation(): Equation {
        val a = randomNumber()
        val b = randomNumber()
        val operator = randomOperator()
        val result = equationSolver(operator, a, b)
        return Equation(a, b, operator, result)
    }

    private fun randomOperator(): Char {
        val operators = listOf('+', '-', '/', '*')
        return operators.random()
    }

    private fun randomNumber(): Int {
        return Random.nextInt(1, 11)
    }
}
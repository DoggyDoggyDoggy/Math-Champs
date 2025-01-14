package denys.diomaxius.mathchamps.ui.data

import kotlin.random.Random

class EquationCreator {
    fun equation(): Equation {
        val a = randomNumber()
        val b = randomNumber()
        val operator = randomOperator()
        val result = solveEquation(operator, a, b)
        return Equation(a, b, operator, result)
    }

    private fun randomOperator(): Char {
        val operators = listOf('+', '-', '/', '*')
        return operators.random()
    }

    private fun randomNumber(): Int {
        return Random.nextInt(1, 11)
    }

    private fun solveEquation(operator: Char, a: Int, b: Int): Int {
        return when (operator) {
            '+' -> a + b
            '-' -> a - b
            '/' -> a / b
            '*' -> a * b
            else -> 0
        }
    }
}
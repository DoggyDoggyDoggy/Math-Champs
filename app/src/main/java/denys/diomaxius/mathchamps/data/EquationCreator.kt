package denys.diomaxius.mathchamps.data

import denys.diomaxius.mathchamps.data.model.Difficulty
import denys.diomaxius.mathchamps.data.model.Equation
import denys.diomaxius.mathchamps.data.utils.equationSolver
import denys.diomaxius.mathchamps.data.utils.findAllDivisors
import kotlin.random.Random

class EquationCreator(private val difficulty: Difficulty) {
    fun generateEquation(): Equation {
        val operator = randomOperator()
        val a = randomNumberA(operator)
        val b = randomNumberB(operator, a)

        val result = equationSolver(operator, a, b)
        return Equation(a, b, operator, result)
    }

    private fun randomOperator(): Char {
        val operators = listOf('+', '-', '/', '*')
        return operators.random()
    }

    private fun randomNumberA(operator: Char): Int {
        return  when (operator) {
            '+' -> Random.nextInt(1, 11)
            '-' -> Random.nextInt(2, 21)
            '*' -> Random.nextInt(1, 11)
            '/' -> Random.nextInt(1, 101)
            else -> 0
        }
    }
    private fun randomNumberB(operator: Char, a: Int): Int {
        return when (operator) {
            '+' -> Random.nextInt(1, 11)
            '-' -> Random.nextInt(1, a)
            '*' -> Random.nextInt(1, 11)
            '/' -> findAllDivisors(a).random()
            else -> 0
        }
    }
}
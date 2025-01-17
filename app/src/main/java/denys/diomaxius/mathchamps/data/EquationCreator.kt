package denys.diomaxius.mathchamps.data

import android.util.Log
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
        return if (difficulty == Difficulty.ThirdGrade) {
            listOf('+', '-', '/', '*').random()
        } else {
            listOf('+', '-').random()
        }

    }

    private fun randomNumberA(operator: Char): Int {
        val aRangeSumming = when(difficulty) {
            Difficulty.Kindergarten -> 6
            Difficulty.FirstGrade -> 11
            Difficulty.SecondGrade -> 26
            Difficulty.ThirdGrade -> 51
        }

        val aRangeExtract = when(difficulty) {
            Difficulty.Kindergarten -> 11
            Difficulty.FirstGrade -> 21
            Difficulty.SecondGrade -> 51
            Difficulty.ThirdGrade -> 101
        }

        return  when (operator) {
            '+' -> Random.nextInt(1, aRangeSumming)
            '-' -> Random.nextInt(2, aRangeExtract)
            '*' -> Random.nextInt(1, 11)
            '/' -> Random.nextInt(1, 101)
            else -> 0
        }
    }
    private fun randomNumberB(operator: Char, a: Int): Int {
        val bRangeSumming = when(difficulty) {
            Difficulty.Kindergarten -> 6
            Difficulty.FirstGrade -> 11
            Difficulty.SecondGrade -> 26
            Difficulty.ThirdGrade -> 51
        }

        return when (operator) {
            '+' -> Random.nextInt(1, bRangeSumming)
            '-' -> Random.nextInt(1, a)
            '*' -> Random.nextInt(1, 11)
            '/' -> findAllDivisors(a).random()
            else -> 0
        }
    }
}
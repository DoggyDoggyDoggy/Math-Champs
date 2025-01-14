package denys.diomaxius.mathchamps.ui.data.utils

fun equationSolver(operator: Char, a: Int, b: Int): Int {
    return when (operator) {
        '+' -> a + b
        '-' -> a - b
        '/' -> a / b
        '*' -> a * b
        else -> 0
    }
}
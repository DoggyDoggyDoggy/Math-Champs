package denys.diomaxius.mathchamps.data.utils

import kotlin.math.sqrt

fun findAllDivisors(N: Int): List<Int> {
    val divisors = mutableListOf<Int>()
    val sqrtN = sqrt(N.toDouble()).toInt()

    for (D in 1..sqrtN) {
        if (N % D == 0) {
            divisors.add(D)
            if (D != N / D) {
                divisors.add(N / D)
            }
        }
    }

    if (divisors.size > 2) {
        divisors.remove(1)
        divisors.remove(N)
    }

    return divisors.sorted()
}
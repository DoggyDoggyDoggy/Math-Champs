package denys.diomaxius.mathchamps.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import denys.diomaxius.mathchamps.ui.data.EquationAnswersCreator
import denys.diomaxius.mathchamps.ui.data.model.Equation
import denys.diomaxius.mathchamps.ui.data.model.EquationAnswers
import denys.diomaxius.mathchamps.ui.data.EquationCreator

class GameViewModel : ViewModel() {
    private val equationCreator = EquationCreator()
    private val equationAnswersCreator = EquationAnswersCreator()

    private val _equation = MutableLiveData<Equation>()
    val equation: LiveData<Equation> = _equation

    private val _equationAnswers = MutableLiveData<EquationAnswers>()
    val equationAnswers: LiveData<EquationAnswers> = _equationAnswers

    init {
        generateEquation()
    }

    fun generateEquation() {
        _equation.value = equationCreator.generateEquation()
        _equationAnswers.value = equationAnswersCreator.generateAnswers(_equation.value!!)
    }

    fun check(userAnswer: Int) {
        if (userAnswer == _equation.value?.result) {
            generateEquation()
        }
    }
}
package denys.diomaxius.mathchamps.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.mathchamps.data.model.Difficulty
import denys.diomaxius.mathchamps.data.EquationAnswersCreator
import denys.diomaxius.mathchamps.data.model.Equation
import denys.diomaxius.mathchamps.data.model.EquationAnswers
import denys.diomaxius.mathchamps.data.EquationCreator
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val difficulty: Difficulty = Difficulty.valueOf(
        savedStateHandle["difficulty"] ?: Difficulty.Kindergarten.name
    )

    private val equationCreator = EquationCreator(difficulty)
    private val equationAnswersCreator = EquationAnswersCreator(difficulty)

    private val _equation = MutableLiveData<Equation>()
    val equation: LiveData<Equation> = _equation

    private val _equationAnswers = MutableLiveData<EquationAnswers>()
    val equationAnswers: LiveData<EquationAnswers> = _equationAnswers

    init {
        generateEquation()
    }

    private fun generateEquation() {
        _equation.value = equationCreator.generateEquation()
        _equationAnswers.value = equationAnswersCreator.generateAnswers(_equation.value!!)
    }

    fun check(userAnswer: Int) {
        if (userAnswer == _equation.value?.result) {
            generateEquation()
        }
    }
}
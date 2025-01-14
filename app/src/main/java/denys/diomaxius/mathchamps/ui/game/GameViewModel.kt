package denys.diomaxius.mathchamps.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import denys.diomaxius.mathchamps.ui.data.Equation
import denys.diomaxius.mathchamps.ui.data.EquationCreator

class GameViewModel : ViewModel() {
    private val equationCreator = EquationCreator()

    private val _equation = MutableLiveData<Equation>()
    val equation: LiveData<Equation> = _equation

    fun generateEquation() {
        _equation.value = equationCreator.equation()
    }
}
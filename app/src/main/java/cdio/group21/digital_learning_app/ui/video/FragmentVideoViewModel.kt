package cdio.group21.digital_learning_app.ui.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cdio.group21.digital_learning_app.repository.repository

class FragmentVideoViewModel : ViewModel() {

    private val _amount = MutableLiveData<Int>().apply {
        value = 0
    }

    fun getAmount(): LiveData<Int> {
        return _amount
    }

    fun setAmount(number: Int){
        _amount.value?.let { a ->
            if (a < 10) {
                _amount.value = a + 1
            }
        }
    }

    suspend fun deleteCourse(courseID: Int){
        val repo = repository()
        repo.deleteCourse(courseID)
    }
}
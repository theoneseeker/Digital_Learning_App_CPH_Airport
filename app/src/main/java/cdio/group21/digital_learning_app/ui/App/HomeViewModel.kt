package cdio.group21.digital_learning_app.ui.App

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cdio.group21.digital_learning_app.repository.repository
import cdio.group21.digital_learning_app.ui.data.user

class HomeViewModel : ViewModel() {

    private val _lTitle = MutableLiveData<List<String>>()
    private val _lCompletionRate = MutableLiveData<List<String>>()

    fun getTitle(): LiveData<List<String>> {
        return _lTitle
    }

    fun getCompletionRate(): LiveData<List<String>>{
        return _lCompletionRate
    }

    fun updateUserData(){
        val repository = repository()
        val luser = repository.getUser { updateList(it) }
    }

    private fun updateList(ux: user){
        _lTitle.postValue(ux.courses_not_complete)
    }
}
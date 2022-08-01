package cdio.group21.digital_learning_app.ui.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cdio.group21.digital_learning_app.repository.repository

class FragmentUsernameViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()

    fun getUsername(): LiveData<String>{
        return _username
    }

    fun setUsername(username: String){
        _username.value = username
    }

    fun getPassword(): LiveData<String>{
        return _password
    }

    fun setPassword(password: String){
        _password.value = password
    }

    fun updateData(){
        val repo = repository()
        repo.getUser { _username.postValue(it.email) }
    }

    fun courseData(){
        val repo = repository()
        repo.getCourse { _username.postValue(it.title) }
    }

    suspend fun deleteCourse(){
        val repo = repository()
        repo.deleteCourse(0)
    }
}
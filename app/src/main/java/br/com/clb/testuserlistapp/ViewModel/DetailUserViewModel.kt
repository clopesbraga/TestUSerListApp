package br.com.clb.testuserlistapp

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class DetailUserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private var originalCpf: String = ""
    private val _state: MutableStateFlow<DetailUserState> = MutableStateFlow(DetailUserState())
    val state = _state

    fun initializeUserDetails(name: String?, age: String?, cpf: String?, city: String?) {
        originalCpf = cpf ?: ""
        _state.update { currentState ->
            currentState.copy(
                name = name ?: "",
                age = age ?: "",
                cpf = originalCpf,
                city = city ?: "",
                status = currentState.status
            )
        }
    }

    fun onNameChange(name: String) {
        _state.update { currentState ->
            currentState.copy(name = name)
        }
    }

    fun onAgeChange(age: String) {
        _state.update { currentState ->
            currentState.copy(age = age)
        }
    }

    fun onCityChange(city: String) {
        _state.update { currentState ->
            currentState.copy(city = city)
        }
    }

    fun onStatusChange(status: Boolean) {
        _state.update { currentState ->
            currentState.copy(status = status)
        }
    }

    fun onPhotoUriChange(uri: Uri?) {
        _state.update { it.copy(photoUri = uri.toString()) }
    }


    fun UpdateUser() {
        viewModelScope.launch {
            val user = UserModel(
                name = state.value.name,
                age = state.value.age,
                cpf = state.value.cpf,
                city = state.value.city,
                photo = state.value.photoUri,
                status = state.value.status
            )
            repository.update(user)
        }
    }

}
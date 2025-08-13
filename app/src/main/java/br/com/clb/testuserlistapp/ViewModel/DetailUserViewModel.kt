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

    private val _state: MutableStateFlow<DetailUserState> = MutableStateFlow(DetailUserState())
    val state = _state

    init {
        _state.update { currentState ->
            currentState.copy(
                name = _state.value.name,
                age =  _state.value.age,
                cpf =  _state.value.cpf,
                city = _state.value.city,
                status = true
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

    fun onCPFChange(cpf: String) {
        _state.update { currentState ->
            currentState.copy(cpf = cpf)
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
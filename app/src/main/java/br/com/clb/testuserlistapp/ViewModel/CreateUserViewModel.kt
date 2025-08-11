package br.com.clb.testuserlistapp

import android.app.Application
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CreateUserViewModel(
    private val application: Application,
    private val repository: UserRepository
) : ViewModel() {

    private val _state: MutableStateFlow<CreateUserState> = MutableStateFlow(CreateUserState())
    val state = _state

    init {
        _state.update { currentState ->
            currentState.copy(
                name = "Cleiton",
                birthDate = "21/07/82",
                cpf = 123456789,
                city = "São Paulo",
                photoUri = "",
                status = true
            )
        }
    }

    fun onNameChange(name: String) {
        _state.update { currentState ->
            currentState.copy(name = name)
        }
    }

    fun onBirthDateChange(birthDate: String) {
        _state.update { currentState ->
            currentState.copy(birthDate = birthDate)
        }
    }

    fun onCPFChange(cpf: String) {
        _state.update { currentState ->
            currentState.copy(cpf = cpf.toInt())
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


    fun registerUser() {
        viewModelScope.launch {
            val user = UserModel(
                name = state.value.name,
                birthDate = state.value.birthDate,
                cpf = state.value.cpf,
                city = state.value.city,
                photo = state.value.photoUri,
                status = state.value.status
            )
            repository.insert(user)
        }
    }

}
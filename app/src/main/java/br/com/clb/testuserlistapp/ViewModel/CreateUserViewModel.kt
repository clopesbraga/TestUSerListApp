package br.com.clb.testuserlistapp

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CreateUserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _state: MutableStateFlow<CreateUserState> = MutableStateFlow(CreateUserState())
    val state = _state

    init {
        _state.update { currentState ->
            currentState.copy(
                name = "",
                age = "",
                cpf = "",
                city = "",
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

    fun onPhotoUriChange(uri: Uri?) {
        _state.update { it.copy(photoUri = uri.toString()) }
    }

    fun registerUser() {
        viewModelScope.launch {
            val user = UserModel(
                name = state.value.name,
                age = state.value.age,
                cpf = state.value.cpf,
                city = state.value.city,
                photo = state.value.photoUri,
                status = state.value.status
            )
            try {
                repository.insert(user)

            } catch (e: Exception) {
                Log.e("CreateUserViewModel", "Erro ao inserir usuário", e.fillInStackTrace())
            }
        }
    }
}
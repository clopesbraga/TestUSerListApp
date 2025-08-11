package br.com.clb.testuserlistapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ListUserViewModel(
    private val application: Application,
    private val repository: UserRepository
) : ViewModel() {

    private val _state: MutableStateFlow<ListUserState> = MutableStateFlow(ListUserState())
    val state = _state.asStateFlow()

    init {

        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch{
            _state.update {it.copy(isloading = true)}
            repository.getAllUsers().collect{users ->
                _state.update { currentState ->
                    currentState.copy(
                        users = users,
                        isloading = false,
                        isSuccess = true
                    )
                }

            }
        }
    }


    fun onUserStatusChange(userCpf: Int, newStatus: Boolean) {
       viewModelScope.launch {

           val userToUpdate = _state.value.users.find { it.cpf == userCpf}
           if (userToUpdate != null) {
               val updatedUser = userToUpdate.copy(status = newStatus)
               try {

                   repository.update(updatedUser)

               }catch (e: Exception){

               }
           }
       }
    }

}


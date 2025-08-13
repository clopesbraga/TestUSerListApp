package br.com.clb.testuserlistapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ListDesativeUserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _state: MutableStateFlow<ListDesativeUserState> = MutableStateFlow(ListDesativeUserState())
    val state = _state.asStateFlow()

    init {

        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch{
            _state.update {it.copy(isloading = true)}
            repository.getAllDesative().collect{users ->
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


    fun onUserStatusChange(userCpf: String, newStatus: Boolean) {
       viewModelScope.launch {

           val userToUpdate = _state.value.users.find { it.cpf == userCpf}
           if (userToUpdate != null) {
               val updatedUser = userToUpdate.copy(status = newStatus)
               try {

                   repository.update(updatedUser)

               }catch (e: Exception){

                   Log.e("ListUserViewModel", "Erro ao atualizar o status do usuário",e.fillInStackTrace())

               }
           }
       }
    }

}


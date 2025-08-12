package br.com.clb.testuserlistapp


data class ListDesativeUserState(

    val users: List<UserModel> = emptyList(),
    val status: Boolean = false,
    val isloading: Boolean = false,
    val isSuccess: Boolean = false,

)

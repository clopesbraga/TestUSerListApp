package br.com.clb.testuserlistapp


data class CreateUserState(

    val name: String = "",
    val birthDate: String = "",
    val cpf: Int = 0,
    val city: String = "",
    val photoUri: String = "",
    val status: Boolean = false


)
package br.com.clb.testuserlistapp


data class CreateUserState(
    val name: String = "",
    val age: String = "",
    val cpf: String = "",
    val city: String = "",
    val photoUri: String = "",
    val status: Boolean = false


)
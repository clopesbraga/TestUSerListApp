package br.com.clb.testuserlistapp


data class DetailUserState(
    val name: String = "",
    val age: String = "",
    val cpf: String="",
    val city: String = "",
    val photoUri: String = "",
    val status: Boolean = true
)
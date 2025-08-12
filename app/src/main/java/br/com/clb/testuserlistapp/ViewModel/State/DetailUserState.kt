package br.com.clb.testuserlistapp


data class DetailUserState(

    val name: String = "",
    val birthDate: String = "",
    val cpf: Int = 0,
    val city: String = "",
    val photoUri: String = "",
    val status: Boolean = false
)
package br.sp.senai.jandira.jengt_provest.model

import androidx.compose.runtime.MutableState

data class Aluno(
    val id: Int= 0,
    val name: String= "",
    val email: String= "",
    val senha: String= "",
    val curso: Int = 2,
    val gender: String= "",
    val status: Int= 1
)

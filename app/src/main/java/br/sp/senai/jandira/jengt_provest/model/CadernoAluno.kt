package br.sp.senai.jandira.jengt_provest.model

data class CadernoAluno(

    val id: Int = 0,
    val titulo: String = "",
    val texto: String = "",
    val aluno_id: Int
)

data class CadernoAlunoResponse(

    val anotacoes: List<CadernoAluno>,
    val qt: Int,
    val status_code: Int
)
package br.sp.senai.jandira.jengt_provest.model

data class Curso (
    val id: Int = 0,
    val nome: String = ""
)

data class CursoResponse(
    val curso: List<Curso>
)

data class Disciplina(
    val id: Int = 0,
    val nome: String = ""
)

data class DisciplinaResponse(
    val disciplinas: List<Disciplina>
)
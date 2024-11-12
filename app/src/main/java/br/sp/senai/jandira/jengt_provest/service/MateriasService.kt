package br.sp.senai.jandira.jengt_provest.service

import br.sp.senai.jandira.jengt_provest.model.CadernoAlunoResponse
import br.sp.senai.jandira.jengt_provest.model.CursoResponse
import retrofit2.Call
import retrofit2.http.GET

interface MateriasService {

    @GET("cursos")
    fun getAllCursos(): Call<CursoResponse>

}
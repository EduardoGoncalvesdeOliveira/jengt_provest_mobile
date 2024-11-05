package br.sp.senai.jandira.jengt_provest.service

import br.sp.senai.jandira.jengt_provest.model.Aluno
import br.sp.senai.jandira.jengt_provest.model.Redacao
import com.google.android.gms.dtdi.analytics.Results
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface RedacaoService {

    @Headers("Content-Type: application/json")
    @POST("redacao")
    fun postRedacao(@Body redacao: Redacao): Call<Redacao>

}

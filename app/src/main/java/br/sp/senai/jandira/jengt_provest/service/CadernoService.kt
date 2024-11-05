package br.sp.senai.jandira.jengt_provest.service

import br.sp.senai.jandira.jengt_provest.model.Aluno
import br.sp.senai.jandira.jengt_provest.model.CadernoAlunoResponse
import com.google.android.gms.dtdi.analytics.Results
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface CadernoService {

//        @GET("caderno/{id}")
//        fun getCadernoById(@Path("id") id: Int): Call<Aluno>

    @GET("caderno")
    fun getAllCadernos(): Call<CadernoAlunoResponse>

//        @Headers("Content-Type: application/json")
//        @POST("caderno")
//        fun postCaderno(@Body aluno: Aluno): Call<Aluno>

}
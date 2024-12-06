package br.senai.sp.jandira.rickandmortyapi.service

import br.sp.senai.jandira.jengt_provest.service.CadernoService
import br.sp.senai.jandira.jengt_provest.service.MateriasService
import br.sp.senai.jandira.jengt_provest.service.RedacaoService
import br.sp.senai.jandira.jengt_provest.service.TemaRedacaoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "https://provest-ehefgcbyg0g2d6gy.brazilsouth-01.azurewebsites.net/v1/jengt_provest/"

    private val BASE_URL_RENDER = "https://jengt-provest-backend.onrender.com/v1/jengt_provest/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    private val retrofitFactory_RENDER = Retrofit
        .Builder()
        .baseUrl(BASE_URL_RENDER)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getAlunoService(): AlunoService {
        return retrofitFactory.create(AlunoService::class.java)
    }

    fun getTemaRedacaoService(): TemaRedacaoService {
        return retrofitFactory_RENDER.create(TemaRedacaoService::class.java)
    }

    fun getRedacaoService(): RedacaoService {
        return retrofitFactory.create(RedacaoService::class.java)
    }

    fun getCadernoAlunoService(): CadernoService {
        return retrofitFactory.create(CadernoService::class.java)
    }

    fun getCursosService(): MateriasService {
        return retrofitFactory.create(MateriasService::class.java)
    }



    // FALTA IMPLEMENTAR ALGUNS AINDA
}
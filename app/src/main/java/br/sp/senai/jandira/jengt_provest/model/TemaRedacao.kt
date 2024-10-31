package br.sp.senai.jandira.jengt_provest.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
import kotlinx.coroutines.launch

data class TemaRedacao(
    val id: Int = 0,
    val nome: String,
    val descricao: String
)

data class TemaRedacaoResponse(
    val tema: List<TemaRedacao>
)
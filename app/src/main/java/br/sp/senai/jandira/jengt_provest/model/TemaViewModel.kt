package br.sp.senai.jandira.jengt_provest.model
//
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
//import kotlinx.coroutines.launch
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class TemaViewModel : ViewModel() {
//
//    // Armazena a lista de temas
//    private val _temas = mutableStateOf<List<TemaRedacao>>(emptyList())
//    val temas = _temas
//
//    init {
//        fetchTemas()
//    }
//
//    private fun fetchTemas() {
//        viewModelScope.launch {
//            val service = RetrofitFactory().getTemaRedacaoService()
//            val call = service.getAllTemas()
//
//            call.enqueue(object : Callback<List<TemaRedacao>> {
//                override fun onResponse(
//                    call: Call<List<TemaRedacao>>,
//                    response: Response<List<TemaRedacao>>
//                ) {
//                    if (response.isSuccessful) {
//                        _temas.value = response.body() ?: emptyList()
//                    }
//                }
//
//                override fun onFailure(call: Call<List<TemaRedacao>>, t: Throwable) {
//                    // Tratar erro
//                    _temas.value = emptyList() // Define uma lista vazia em caso de erro
//                }
//            })
//        }
//    }
//}

package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
import br.sp.senai.jandira.jengt_provest.model.Aluno
import br.sp.senai.jandira.jengt_provest.model.Results
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun home(controlNavigation: NavHostController) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun homePreview() {
    JENGTProVestTheme {
        home(controlNavigation = rememberNavController())
    }
}
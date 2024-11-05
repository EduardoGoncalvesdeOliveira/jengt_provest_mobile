package br.sp.senai.jandira.jengt_provest.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.sp.senai.jandira.jengt_provest.R

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
import br.sp.senai.jandira.jengt_provest.model.TemaRedacao
import br.sp.senai.jandira.jengt_provest.model.TemaRedacaoResponse
import br.sp.senai.jandira.jengt_provest.service.TemaRedacaoService
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun escolhaTemaRedacao(navigationController: NavHostController) {

    var temas by remember { mutableStateOf(listOf<TemaRedacao>()) }
    val retrofitFactory = RetrofitFactory()
    var TemaRedacaoService = retrofitFactory.getTemaRedacaoService()

    Log.e("teste do tema aaaaa", "credoo ${temas}")

    LaunchedEffect(Unit) {

        TemaRedacaoService.getAllTemas().enqueue(object : Callback<TemaRedacaoResponse> {
            override fun onResponse(
                p0: Call<TemaRedacaoResponse>,
                response: Response<TemaRedacaoResponse>
            ) {
                if (response.isSuccessful) {
                    temas = response.body()?.tema ?: emptyList()
                }
            }

            override fun onFailure(p0: Call<TemaRedacaoResponse>, p1: Throwable) {
                Log.e("erro fudeu", "erro porra caralho ${p1}")
            }
        })

    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)),
                containerColor = Color(0xffC6E6A3),
                contentColor = Color(0xff201F4B),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.notebook_icon),
                        contentDescription = "Anotações",
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(34.dp)
                            .clickable { navigationController.navigate("CadernoDoAluno") },
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.home_icon),
                        contentDescription = "Home",
                        modifier = Modifier
                            .padding(bottom = 0.dp)
                            .size(40.dp)
                            .clickable { navigationController.navigate("Home") },
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = "Mensagens",
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(34.dp)
                            .clickable { navigationController.navigate("Chats") },
                    )
                }
            }
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column(
                    modifier = Modifier
                        .background(Color(0xffffffff1))
                        .fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(0xff201F4B),
                                shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
                            )
                            .height(182.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Redações".toUpperCase(),
                                color = Color(0xffDEFEA0),
                                fontSize = 32.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Escolha seu tema:",
                            color = Color(0xff201F4B),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Normal
                        )
                        LazyColumn(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                        ) {
                            items(temas) { tema ->


                                Card(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxWidth()
                                        .clickable {
                                            navigationController.navigate("Redacao/${tema.nome}")
                                        },
                                    elevation = CardDefaults.elevatedCardElevation(4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xff201F4B)  // Define a cor de fundo do Card
                                    )
                                ) {
                                    Column(modifier = Modifier.padding(14.dp)) {

                                        Text(
                                            text = "'${tema.nome}'",
                                            color = Color(0xffFFFFFF),
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily.SansSerif,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Spacer(modifier = Modifier.height(4.dp))

                                        Text(
                                            text = tema.descricao,
                                            color = Color(0xffFFFFFF),
                                            fontSize = 12.sp,
                                            fontFamily = FontFamily.SansSerif,
                                            fontStyle = FontStyle.Italic,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun escolhaTemaRedacaoPreview() {
    JENGTProVestTheme {
        escolhaTemaRedacao(navigationController = rememberNavController())
    }
}

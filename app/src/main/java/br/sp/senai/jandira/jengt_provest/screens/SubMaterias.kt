package br.sp.senai.jandira.jengt_provest.screens

import android.preference.PreferenceActivity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
import br.sp.senai.jandira.jengt_provest.R
import br.sp.senai.jandira.jengt_provest.model.Curso
import br.sp.senai.jandira.jengt_provest.model.CursoResponse
import br.sp.senai.jandira.jengt_provest.model.DisciplinaResponse
import br.sp.senai.jandira.jengt_provest.service.MateriasService
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun subMaterias(navigationController: NavHostController, materiaNome: String) {

    var disciplinas by remember { mutableStateOf(listOf<Curso>()) }
    val retrofitFactory = RetrofitFactory()
    var MateriasService = retrofitFactory.getCursosService()
    var materiaNome by remember { mutableStateOf(materiaNome) }

    LaunchedEffect(Unit) {

        MateriasService.getAllDisciplinas().enqueue(object : Callback<DisciplinaResponse> {
            override fun onResponse(
                p0: Call<DisciplinaResponse>,
                response: Response<DisciplinaResponse>
            ) {
                if (response.isSuccessful) {
                    disciplinas = (response.body()?.disciplinas ?: emptyList()) as List<Curso>
                }
            }

            override fun onFailure(p0: Call<DisciplinaResponse>, p1: Throwable) {
                Log.e("erro fudeu", "erro porra caralho ${p1}")            }
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
                        .fillMaxSize()
                        .background(Color(0xFFFFFFF1))
                )
                {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(0x991D6BC7),
                                shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
                            )
                            .height(110.dp)

                    ) {

                        Row(
                            modifier = Modifier.padding(top = 35.dp, start = 16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = "botão de seta",
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable {
                                    },
                                tint = Color(0xFF201F4B)
                            )
                        }

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = materiaNome,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )

                        }

                    }

                    Spacer(modifier = Modifier.height(60.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .width(370.dp)
                                .height(55.dp),
                            shape = RoundedCornerShape(100.dp),
                            colors = ButtonDefaults.buttonColors(Color(0x991D6BC7))
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Professores Disponiveis",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Light,
                                    fontStyle = FontStyle.Normal,
                                    color = Color.Black
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    LazyColumn(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxSize()
                    ) {
                        items(disciplinas) { disciplinas ->

                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .clickable { },
                                elevation = CardDefaults.elevatedCardElevation(4.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xff201F4B)  // Define a cor de fundo do Card
                                )
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {

                                    Text(
                                        text = "'${disciplinas.id}'",
                                        color = Color(0xffFFFFFF),
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = "'${disciplinas.nome}'",
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

//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 30.dp)
//                    ) {
//                        val temas = listOf(
//                            "Geografia - Geopolítica",
//                            "Geografia - Climas",
//                            "Geografia - Solos",
//                            "Geografia - Domínios",
//                            "Geografia - Domínios"
//                        )
//
//                        temas.forEachIndexed { index, tema ->
//                            ListItem(title = tema)
//
//                            if (index < temas.size - 1) {
//                                Divider(
//                                    color = Color(0xFF201F4B),
//                                    thickness = 1.dp,
//                                    modifier = Modifier.padding(vertical = 8.dp)
//                                )
//                            }
//                        }
//                    }

                }
            }
        }
    )
}

@Composable
fun ListItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
            .padding(vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = title,
            color = Color(0xff201F4B),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal

        )

        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "botão de seta",
            modifier = Modifier
                .size(28.dp)
                .clickable {
                }
                .graphicsLayer(rotationZ = 180f),
            tint = Color(0xFF201F4B)
        )

    }
}


@Preview(showBackground = true)
@Composable
fun subMateriasPreview() {
    JENGTProVestTheme {
//        subMaterias(navigationController = rememberNavController())
    }
}
package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.CollectionsBookmark
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.sp.senai.jandira.jengt_provest.R
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listaCalendario(controlNavigation: NavHostController) {


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
                            .clickable { controlNavigation.navigate("CadernoDoAluno") },
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.home_icon),
                        contentDescription = "Home",
                        modifier = Modifier
                            .padding(bottom = 0.dp)
                            .size(40.dp)
                            .clickable { controlNavigation.navigate("Home") },
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = "Mensagens",
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(34.dp)
                            .clickable { controlNavigation.navigate("Chats") },
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
                            .height(75.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 24.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Dezembro, 10",
                                color = Color(0xffBCB3DF),
                                fontSize = 18.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier
                                .width(180.dp))
                            Text(
                                text = "2024",
                                color = Color(0xffC6E6A3),
                                fontSize = 18.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 22.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(vertical = 22.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Card(
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth()
                                    .clickable { controlNavigation.navigate("EscolhaTemaRedacao") }
                                    .border(
                                        width = 2.dp, // Espessura da borda
                                        color = Color(0xffC6E6A3),
                                        shape = RoundedCornerShape(8.dp)
                                    ),

                                colors = CardDefaults.cardColors(Color(0xffC6E6A3))
                            ) {

                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(start = 20.dp)
                                        .clickable { controlNavigation.navigate("EscolhaTemaRedacao") },
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Text(
                                        text = "Escolha seu tema",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Light,
                                        fontStyle = FontStyle.Normal,
                                        color = Color(0xff201F4B)
                                    )

                                    Spacer(modifier = Modifier
                                        .width(115.dp))

                                    Icon(
                                        imageVector = Icons.Default.ArrowBackIosNew,
                                        contentDescription = "botão de seta",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .clickable {
                                            }
                                            .graphicsLayer(rotationZ = 180f),
                                        tint = Color(0xFF201F4B)
                                    )
                                }
                            }
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Card(
                                modifier = Modifier
                                    .fillMaxSize(),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xffF7F7F7) // Define a cor desejada aqui
                                )

                            ) {

                                Column(modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp),
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    horizontalAlignment = Alignment.CenterHorizontally) {

                                    Text(
                                        text = "O que fazer na sua redação?",
                                        color = Color(0xff201F4B),
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Text(
                                        text = "Tenha sua redação avaliada segundo os critérios de correção do Enem (Exame Nacional do Ensino Médio), o maior exame vestibular do Brasil. A nota da redação, variando entre 0 (zero) e 1000 (mil) pontos, é atribuída com base em 5 competências (200 pontos por competência):",
                                        color = Color(0xff201F4B),
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight.Light,
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = "C1" + " Domínio da escrita formal da língua portuguesa.\n" +
                                                "C2 Compreender o tema e não fugir do que é proposto.\n" +
                                                "C3 Selecionar, relacionar, organizar e interpretar informações, fatos, opiniões e argumentos em defesa de um ponto de vista.\n" +
                                                "C4 Conhecimento dos mecanismos linguísticos necessários para a construção da argumentação.\n" +
                                                "C5 Proposta de intervenção e respeito aos direitos humanos.",
                                        color = Color(0xff201F4B),
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight.Light
                                    )
                                }
                            }
                        }
                    }
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun listaCalendarioPreview() {
    JENGTProVestTheme {
        listaCalendario(controlNavigation = rememberNavController())
    }
}
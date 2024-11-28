package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun instrucoesRedacao(controlNavigation: NavHostController) {


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
                            .height(150.dp)
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
                                    .border(
                                        width = 2.dp, // Espessura da borda
                                        color = Color(0xffD4A4E2),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                colors = CardDefaults.cardColors(Color.Transparent)
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

                                    Icon(
                                        painter = painterResource(id = R.drawable.notebook_icon),
                                        contentDescription = "Anotações",
                                        modifier = Modifier
                                            .padding(top = 2.dp)
                                            .size(34.dp)
                                            .clickable { controlNavigation.navigate("CadernoDoAluno") },
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
                                    .fillMaxSize()
                                    .border(
                                        BorderStroke(
                                            2.dp,
                                            Color(0xffD4A4E2)
                                        ), // Define a espessura e cor da borda
                                        shape = RoundedCornerShape(8.dp) // Garante que a borda tenha o mesmo formato do card
                                    ),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Transparent // Define a cor desejada aqui
                                )

                            ) {

                                var title by remember { mutableStateOf("") }

                                TextField(
                                    value = title,
                                    onValueChange = { title = it },  // Atualiza o estado do texto
                                    label = {
                                        Text(
                                            modifier = Modifier
                                                .padding(bottom = 24.dp),
                                            text = "Título do Caderno",
                                            color = Color(0xff201F4B),
                                            fontSize = 20.sp,
                                            fontFamily = FontFamily.SansSerif,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold
                                        )
                                    },
                                    placeholder = {
                                        Text(
                                            "Insira o título:"
                                        )
                                    },  // Placeholder quando o campo está vazio
                                    modifier = Modifier
                                        .fillMaxWidth(),  // O TextField ocupa toda a largura disponível
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color.Transparent,  // Fundo transparente
                                        focusedIndicatorColor = Color.Transparent,  // Borda ao focar
                                        unfocusedIndicatorColor = Color.Transparent  // Borda quando não focado
                                    ),
                                    textStyle = androidx.compose.ui.text.TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    ),

                                    shape = RoundedCornerShape(
                                        topEnd = 8.dp, // Não arredonda o canto inferior direito
                                        topStart = 8.dp  // Arredonda bastante o canto inferior esquerdo
                                    ),

                                    )

                                var text by remember { mutableStateOf("") }

                                TextField(
                                    value = text,
                                    onValueChange = { text = it },
                                    label = { Text(
                                        text = "Escolha seu tema",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Light,
                                        fontStyle = FontStyle.Normal,
                                        color = Color(0xff201F4B)) },
                                    placeholder = { },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 20.dp)
                                        .height(1000.dp),  // Aumenta a altura do TextField
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    ),
                                    shape = RoundedCornerShape(
                                        bottomEnd = 8.dp, // Não arredonda o canto inferior direito
                                        bottomStart = 8.dp  // Arredonda bastante o canto inferior esquerdo
                                    )
                                )
                            }
                        }
                    }
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun instrucoesRedacaoPreview() {
    JENGTProVestTheme {
        instrucoesRedacao(controlNavigation = rememberNavController())
    }
}
package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cadernoDoAluno(controlNavigation: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
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
                        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
                    )
                    .height(75.dp)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Caderno do Aluno".toUpperCase(),
                        color = Color(0xffDEFEA0),
                        fontSize = 28.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W300
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

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .size(width = 142.dp, height = 100.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffC6E6A3))
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Salvar",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                color = Color(0xff201F4B)
                            )

                            Icon(
                                imageVector = Icons.Default.Save,
                                contentDescription = "Atividades",
                                tint = Color(0xff201F4B),
                                modifier = Modifier
                                    .size(26.dp)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(160.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .size(width = 70.dp, height = 100.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xffE4E2ED))
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    imageVector = Icons.Default.CollectionsBookmark,
                                    contentDescription = "Atividades",
                                    tint = Color(0xff201F4B),
                                    modifier = Modifier
                                        .size(26.dp)
                                )
                            }
                        }

                        Button(
                            onClick = { },
                            modifier = Modifier
                                .size(width = 70.dp, height = 100.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xffE4E2ED))
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Atividades",
                                    tint = Color(0xff201F4B),
                                    modifier = Modifier
                                        .size(26.dp)
                                )
                            }
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
                            label = { Text("Se texto aqui") },
                            placeholder = {  },
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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun cadernoDoAlunoPreview() {
    JENGTProVestTheme {
        cadernoDoAluno(controlNavigation = rememberNavController())
    }
}
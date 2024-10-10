package br.sp.senai.jandira.jengt_provest.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
fun redacao(controlNavigation: NavHostController) {
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
                        shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)
                    )
                    .height(125.dp)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Vamos escrever!",
                        color = Color(0xffDEFEA0),
                        fontSize = 26.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Light
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(horizontal = 18.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Tema escolhido:",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffffffff)  // Define a cor de fundo do Card
                    ),
                    border = BorderStroke(width = 4.dp, Color(0xffD4A4E2))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 14.dp, vertical = 4.dp),
                            text = "Desafios para o enfrentamento da invisibilidade do trabalho de cuidado realizado pela mulher no Brasil.",
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(top = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                var title by remember { mutableStateOf("") }

                TextField(
                    value = title,
                    onValueChange = { title = it },  // Atualiza o estado do texto
                    label = {},
                    placeholder = { Text("Título:") },  // Placeholder quando o campo está vazio
                    modifier = Modifier.fillMaxWidth(),  // O TextField ocupa toda a largura disponível
                            colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xfff7f6f6),  // Fundo transparente
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
                    onValueChange = {text = it},
                    label = {},
                    placeholder = { Text("Escreva seu texto aqui") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1000.dp),  // Aumenta a altura do TextField
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xfff7f6f6),
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun redacaoPreview() {
    JENGTProVestTheme {
        redacao(controlNavigation = rememberNavController())
    }
}
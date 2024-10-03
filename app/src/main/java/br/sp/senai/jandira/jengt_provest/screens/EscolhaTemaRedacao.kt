package br.sp.senai.jandira.jengt_provest.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Iso
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
import br.sp.senai.jandira.jengt_provest.R
import br.sp.senai.jandira.jengt_provest.model.Aluno
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun escolhaTemaRedacao(navigationController: NavHostController) {
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
                        shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
                    )
                    .height(182.dp)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
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
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(14.dp)
                ) {

                    val options = listOf(
                        "impacto das mudanças climáticas na vida das populações urbanas e rurais.",
                        "Desafios para a valorização do trabalho e a geração de emprego no Brasil",
                        "Os impactos das redes sociais nas relações interpessoais e na saúde mental.",
                        "A educação integral para o desenvolvimento de habilidades socioemocionais e cognitivas",
                        "A importância da preservação ambiental para a qualidade de vida das presentes e futuras gerações",
                        "Manipulação do comportamento do usuário pelo controle de dados na internet",
                        "Desafios para a formação educacional de surdos no Brasil.",
                        "Caminhos para combater a intolerância religiosa no Brasil."
                    )

                    // Variável para armazenar a opção selecionada
                    var selectedOption by remember { mutableStateOf("") }

                    // Controla se o menu está expandido ou não
                    var expanded by remember { mutableStateOf(false) }

                    // ExposedDropdownMenuBox cria um campo de texto que pode abrir um menu suspenso
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {

                        var isBlocked by remember { mutableStateOf(false) }

                        TextField(
                            value = selectedOption,
                            enabled = isBlocked,
                            onValueChange = { selectedOption = it },  // Atualiza o estado do texto
                            label = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .menuAnchor(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Escolha um tema")

                                    Icon(
                                        modifier = Modifier
                                            .size(width = 30.dp, height = 25.dp),
                                        imageVector = Icons.Filled.KeyboardArrowDown,
                                        contentDescription = "teste",
                                        tint = Color(0xffD4A4E2)
                                    )

                                }
                            },
                            placeholder = { Text("Título:") },  // Placeholder quando o campo está vazio
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffD4A4E2), // Cor da borda
                                    shape = RoundedCornerShape(8.dp) // Formato arredondado da borda
                                ),  // O TextField ocupa toda a largura disponível
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color(0xffffffff),  // Fundo transparente
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

                        // Menu dropdown com as opções
                        DropdownMenu(
                            modifier = Modifier
                                .background(Color.White)
                                .width(386.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffD4A4E2), // Cor da borda
                                    shape = RoundedCornerShape(8.dp)
                                ), // Formato arredondado da borda,
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {

                            options.forEach { option ->
                                DropdownMenuItem(modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 2.dp)
                                    .background(Color(0xff201F4B))
                                    .border(
                                        width = 2.dp, // Largura da borda
                                        color = Color(0xff201F4B), // Cor da borda
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                    text = {
                                        Text(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(Color(0xff201F4B))
                                                .border(
                                                    width = 0.dp, // Largura da borda
                                                    color = Color(0xff201F4B), // Cor da borda
                                                    shape = RoundedCornerShape(0.dp)
                                                ), color = Color.White, text = option
                                        )
                                    },
                                    onClick = {
                                        selectedOption = option
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }

                    Card (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 40.dp),
                        shape = RoundedCornerShape(10.dp), // Define o arredondamento das bordas do Card
                        colors = CardDefaults.cardColors(containerColor = Color(0xfff7f7f7)) // Define a cor de fundo do Card
                    ){

                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 20.dp, horizontal = 22.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly){

                            Text(
                                text = "O que fazer na sua redação?",
                                fontSize = 22.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                modifier = Modifier
                                    .padding(vertical = 10.dp),
                                text = "Tenha sua redação avaliada segundo os critérios de correção do Enem (Exame Nacional do Ensino Médio), o maior exame vestibular do Brasil. A nota da redação, variando entre 0 (zero) e 1000 (mil) pontos, é atribuída com base em 5 competências (200 pontos por competência):",
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal

                            )

                            Text(
                                modifier = Modifier
                                    .padding(vertical = 10.dp),
                                text = "C1 Domínio da escrita formal da língua portuguesa.\n" +
                                        "C2 Compreender o tema e não fugir do que é proposto.\n" +
                                        "C3 Selecionar, relacionar, organizar e interpretar informações, fatos, opiniões e argumentos em defesa de um ponto de vista.\n" +
                                        "C4 Conhecimento dos mecanismos linguísticos necessários para a construção da argumentação.\n" +
                                        "C5 Proposta de intervenção e respeito aos direitos humanos.",
                                textAlign = TextAlign.Start,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal
                            )

                            Text(modifier = Modifier
                                .fillMaxWidth(),
                                text = "Boa Redação!",
                                textAlign = TextAlign.End,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal
                            )

                        }
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun escolhaTemaRedacaoPreview() {
    JENGTProVestTheme {
        escolhaTemaRedacao(navigationController = rememberNavController())
    }
}
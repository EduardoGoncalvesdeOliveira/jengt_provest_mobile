package br.sp.senai.jandira.jengt_provest.screens
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.KeyboardArrowDown
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.ExposedDropdownMenuBox
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.State
//import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
//import br.sp.senai.jandira.jengt_provest.model.TemaRedacao
//import br.sp.senai.jandira.jengt_provest.model.TemaViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun escolhaTemaRedacao(navigationController: NavHostController, temaViewModel: TemaViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
//    // Obtém a lista de temas do ViewModel
//    val temas = temaViewModel.temas.value
//
//    Surface(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(
//            modifier = Modifier
//                .background(Color(0xffffffff1))
//                .fillMaxSize()
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(
//                        color = Color(0xff201F4B),
//                        shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
//                    )
//                    .height(182.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//
//                    Text(
//                        text = "Redações".toUpperCase(),
//                        color = Color(0xffDEFEA0),
//                        fontSize = 32.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontStyle = FontStyle.Normal,
//                        fontWeight = FontWeight.Normal
//                    )
//                }
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//
//                ) {
//
//                    // Variável para armazenar a opção selecionada
//                    var selectedOption by remember { mutableStateOf("") }
//
//                    // Controla se o menu está expandido ou não
//                    var expanded by remember { mutableStateOf(false) }
//
//                    ExposedDropdownMenuBox(
//                        expanded = expanded,
//                        onExpandedChange = { expanded = !expanded }
//                    ) {
//
//                        TextField(
//                            value = selectedOption,
//                            onValueChange = { selectedOption = it },  // Atualiza o estado do texto
//                            label = {
//                                Row(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .menuAnchor(),
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Text("Escolha um tema")
//
//                                    Icon(
//                                        modifier = Modifier.size(30.dp),
//                                        imageVector = Icons.Filled.KeyboardArrowDown,
//                                        contentDescription = null
//                                    )
//                                }
//                            },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .border(
//                                    width = 2.dp,
//                                    color = Color(0xffD4A4E2),
//                                    shape = RoundedCornerShape(8.dp)
//                                )
//                        )
//
//                        // Dropdown com temas dinâmicos obtidos da API
//                        DropdownMenu(
//                            expanded = expanded,
//                            onDismissRequest = { expanded = false }
//                        ) {
//                            temas.forEach { tema ->
//                                DropdownMenuItem(
//                                    text = { Text(tema.nome) },
//                                    onClick = {
//                                        selectedOption = tema.nome
//                                        expanded = false
//                                    }
//                                )
//                            }
//                        }
//                    }
//
//                    // O restante do seu layout continua aqui
//                    Button(
//                        onClick = { navigationController.navigate("Redacao") },
//                        modifier = Modifier
//                            .size(width = 260.dp, height = 72.dp)
//                            .padding(top = 12.dp, bottom = 20.dp),
//                        colors = ButtonDefaults.buttonColors(Color(0xffDEFEA0))
//                    ) {
//                        Text(
//                            text = "Vamos escrever!",
//                            fontSize = 16.sp,
//                            color = Color(0xff201F4B)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun escolhaTemaRedacaoPreview() {
//    JENGTProVestTheme {
//        escolhaTemaRedacao(navigationController = rememberNavController())
//    }
//}
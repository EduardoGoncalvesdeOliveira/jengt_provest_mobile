package br.sp.senai.jandira.jengt_provest.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.sp.senai.jandira.jengt_provest.R
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun home(navigationController: NavHostController) {

    var showSearchField by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd MMM", Locale("pt", "BR"))
    val formattedDate = currentDate.format(formatter)
    val scrollState = rememberScrollState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val drawerContent = @Composable {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Text("Bem-vindo, Celso!", fontSize = 24.sp, color = Color.Black)

            DrawerMenuItem(icon = Icons.Default.Task, text = "Tarefas")
            DrawerMenuItem(icon = Icons.Default.Chat, text = "Chats")
            DrawerMenuItem(icon = Icons.Default.Settings, text = "Configurações")
            DrawerMenuItem(icon = Icons.Default.Search, text = "Calendário")
            DrawerMenuItem(icon = Icons.Default.Videocam, text = "Vídeo-Aulas")
            DrawerMenuItem(icon = Icons.Default.Book, text = "Matérias")
            DrawerMenuItem(icon = Icons.Default.CollectionsBookmark, text = "Redações")
            DrawerMenuItem(icon = Icons.Default.Person, text = "Perfil")
        }
    }

    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = drawerContent
    ) {
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
                    Surface(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(color = Color(0xFFFFFFF1))
                    ) {
                        Column(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(horizontal = 16.dp, vertical = 0.dp)
                                .verticalScroll(scrollState)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.menu),
                                    contentDescription = "Menu de navegação",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable {

                                        }
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    if (showSearchField) {
                                        OutlinedTextField(
                                            shape = RoundedCornerShape(20.dp),
                                            colors = OutlinedTextFieldDefaults.colors(
                                                unfocusedBorderColor = Color(0xffBCB3DF),
                                                focusedLabelColor = Color(0xffBCB3DF),
                                                focusedBorderColor = Color(0xffBCB3DF)
                                            ),
                                            value = searchText,
                                            onValueChange = { searchText = it },
                                            placeholder = {
                                                Text("Pesquise...")
                                            },
                                            modifier = Modifier
                                                .width(250.dp)
                                                .padding(end = 16.dp)
                                                .height(20.dp)
                                        )
                                    } else {

                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "Pesquisar",
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clickable {
                                                    showSearchField = true
                                                },
                                            tint = Color(0xFFB39DDB)
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(16.dp))


                                    Icon(
                                        imageVector = Icons.Default.Notifications,
                                        contentDescription = "Notificações",
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clickable {
                                            },
                                        tint = Color(0xFFB39DDB)
                                    )
                                }
                            }


                            Text(
                                text = "DashBoard",
                                color = Color(0xffD4A4E2),
                                fontSize = 35.sp,
                                fontWeight = FontWeight.Medium
                            )

                            Spacer(modifier = Modifier.height(10.dp))


                            LazyRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            ) {
                                item {
                                    Card(
                                        modifier = Modifier
                                            .size(250.dp, height = 255.dp)
                                            .padding(horizontal = 9.dp),
                                        colors = CardDefaults.cardColors(Color(0x00FFFFFF)),
                                        border = BorderStroke(4.dp, Color(0xff201F4B)),
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxSize()
                                        ) {

                                            Image(
                                                painter = painterResource(id = R.drawable.more),
                                                contentDescription = "pontinhos",
                                                modifier = Modifier
                                                    .align(Alignment.TopEnd)
                                                    .size(30.dp),
                                            )

                                            Column(
                                                modifier = Modifier.padding(
                                                    top = 100.dp,
                                                    start = 16.dp
                                                ),
                                                horizontalAlignment = Alignment.Start
                                            ) {

                                                Icon(
                                                    imageVector = Icons.Default.CollectionsBookmark,
                                                    contentDescription = "Atividades",
                                                    tint = Color(0xff201F4B),
                                                    modifier = Modifier.size(65.dp)
                                                )

                                                Spacer(modifier = Modifier.height(8.dp))

                                                Text(
                                                    text = "Atividades",
                                                    color = Color(0xff201F4B),
                                                    fontSize = 30.sp,
                                                    fontWeight = FontWeight.Light
                                                )

                                                Spacer(modifier = Modifier.height(4.dp))

                                                Box(
                                                    modifier = Modifier
                                                        .width(100.dp)
                                                        .height(4.dp)
                                                        .background(Color(0xFF8373C2))
                                                )
                                            }
                                        }
                                    }
                                }

                                item {
                                    Card(
                                        modifier = Modifier
                                            .size(250.dp, height = 255.dp)
                                            .padding(horizontal = 9.dp),
                                        colors = CardDefaults.cardColors(Color(0x00FFFFFF)),
                                        border = BorderStroke(4.dp, Color(0xff201F4B)),
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clickable { navigationController.navigate("EscolhaTemaRedacao") },
                                        ) {

                                            Image(
                                                painter = painterResource(id = R.drawable.more),
                                                contentDescription = "pontinhos",
                                                modifier = Modifier
                                                    .align(Alignment.TopEnd)
                                                    .size(30.dp),
                                            )

                                            Column(
                                                modifier = Modifier.padding(
                                                    top = 100.dp,
                                                    start = 16.dp
                                                ),
                                                horizontalAlignment = Alignment.Start
                                            ) {

                                                Icon(
                                                    imageVector = Icons.Default.Bookmark,
                                                    contentDescription = "Redações",
                                                    tint = Color(0xff201F4B),
                                                    modifier = Modifier.size(65.dp)
                                                )

                                                Spacer(modifier = Modifier.height(8.dp))

                                                Text(
                                                    text = "Redações",
                                                    color = Color(0xff201F4B),
                                                    fontSize = 30.sp,
                                                    fontWeight = FontWeight.Light
                                                )

                                                Spacer(modifier = Modifier.height(4.dp))

                                                Box(
                                                    modifier = Modifier
                                                        .width(100.dp)
                                                        .height(4.dp)
                                                        .background(Color(0xFFBCB3DF))
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(30.dp))

                            Text(
                                text = "Calendário",
                                color = Color(0xff201F4B),
                                fontSize = 35.sp,
                                fontWeight = FontWeight.Light
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Card(
                                modifier = Modifier
                                    .size(400.dp, height = 100.dp)
                                    .padding(horizontal = 9.dp),
                                colors = CardDefaults.cardColors(Color(0x00FFFFFF)),
                                border = BorderStroke(4.dp, Color(0xff201F4B))
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp)
                                ) {

                                    Card(
                                        modifier = Modifier.size(80.dp, 70.dp),
                                        colors = CardDefaults.cardColors(Color(0x00FFFFFF)),
                                        border = BorderStroke(4.dp, Color(0xffD4A4E2)),
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(start = 24.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = formattedDate,
                                                fontSize = 22.sp,
                                                color = Color(0xff201F4B)
                                            )
                                        }
                                    }

                                    Row(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "História e Geografia",
                                            color = Color(0xff201F4B),
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Light
                                        )

                                        Icon(
                                            imageVector = Icons.Default.ArrowBackIosNew,
                                            contentDescription = "botão de seta",
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clickable {
                                                }
                                                .graphicsLayer(rotationZ = 180f),
                                            tint = Color(0xFF201F4B)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Anotações",
                                color = Color(0xff201F4B),
                                fontSize = 35.sp,
                                fontWeight = FontWeight.Light
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Box(
                                modifier = Modifier
                                    .size(400.dp, 190.dp)
                                    .padding(16.dp)
                                    .border(
                                        BorderStroke(4.dp, Color(0xff201F4B)),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        painter = painterResource(id = R.drawable.activity),
                                        contentDescription = "Ícone de Anotação",
                                        tint = Color(0xff201F4B),
                                        modifier = Modifier
                                            .size(90.dp)
                                    )


                                    Column(
                                        verticalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .padding(start = 12.dp)
                                    ) {

                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(60.dp)
                                                .background(
                                                    Color(0xFFECECEC),
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                                .clickable {
                                                }
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .padding(horizontal = 16.dp),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "História", color = Color(0xff201F4B))
                                                Icon(
                                                    imageVector = Icons.Default.ArrowBackIosNew,
                                                    contentDescription = "botao de seta",
                                                    modifier = Modifier
                                                        .size(30.dp)
                                                        .clickable {
                                                        }
                                                        .graphicsLayer(rotationZ = 180f),
                                                    tint = Color(0xFF201F4B)
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(60.dp)
                                                .background(
                                                    Color(0xFFECECEC),
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                                .clickable {
                                                }
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .padding(horizontal = 16.dp),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Quimíca", color = Color(0xff201F4B))
                                                Icon(
                                                    imageVector = Icons.Default.ArrowBackIosNew,
                                                    contentDescription = "botao de seta",
                                                    modifier = Modifier
                                                        .size(30.dp)
                                                        .clickable {
                                                        }
                                                        .graphicsLayer(rotationZ = 180f),
                                                    tint = Color(0xFF201F4B)
                                                )
                                            }
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
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ModalDrawer(
    drawerState: DrawerState,
    gesturesEnabled: Boolean,
    drawerContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Box {
        Row {
            if (drawerState.isOpen) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(250.dp)
                ) {
                    drawerContent()
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = if (drawerState.isOpen) 0.dp else 0.dp)
            ) {
                content()
            }
        }
    }
}

@Composable
fun DrawerMenuItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Start
        )
    }
}


@Preview(showBackground = true)
@Composable
fun homePreview() {
    JENGTProVestTheme {
        home(navigationController = rememberNavController())
    }
}
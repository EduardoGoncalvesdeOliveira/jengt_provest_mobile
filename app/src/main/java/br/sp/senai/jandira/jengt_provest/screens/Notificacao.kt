package br.sp.senai.jandira.jengt_provest.screens

//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBackIosNew
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Divider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import br.sp.senai.jandira.jengt_provest.R
//import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
//
//@Composable
//fun notificacao(navigationController: NavHostController, title: String, description: String) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp)
//    ) {
//        Text(
//            text = title,
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFFC6E6A3),
//        )
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        Text(
//            text = description,
//            fontSize = 14.sp,
//            color = Color(0xFFBCB3DF),
//        )
//    }
//}
//
//@Composable
//fun Notificatio() {
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)),
//                containerColor = Color(0xFFC6E6A3),
//                contentColor = Color(0xFF201F4B),
//            ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceAround
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.notebook_icon),
//                        contentDescription = "Anotações",
//                        modifier = Modifier
//                            .size(24.dp)
//                            .clickable {
//
//                            }
//                    )
//
//                    Icon(
//                        painter = painterResource(id = R.drawable.home_icon),
//                        contentDescription = "Home",
//                        modifier = Modifier
//                            .size(24.dp)
//                            .clickable {
//
//                            }
//                    )
//
//                    Icon(
//                        painter = painterResource(id = R.drawable.chat_icon),
//                        contentDescription = "Mensagens",
//                        modifier = Modifier
//                            .size(24.dp)
//                            .clickable {
//
//                            }
//                    )
//                }
//            }
//        },
//        content = { innerPadding ->
//            Box(modifier = Modifier.padding(innerPadding)
//                .fillMaxSize()
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color(0xFF1D2951))
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(
//                                color = Color(0xFFfffff1),
//                                shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
//                            )
//                            .height(75.dp)
//                    ) {
//                        Row(
//                            modifier = Modifier.padding(top = 26.dp, start = 16.dp)
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.ArrowBackIosNew,
//                                contentDescription = "botão de seta",
//                                modifier = Modifier
//                                    .size(32.dp)
//                                    .clickable {
//                                    },
//                                tint = Color(0xFF201F4B)
//                            )
//                        }
//                        Row(
//                            modifier = Modifier
//                                .padding(top = 25.dp, start = 16.dp)
//                                .fillMaxWidth(),
//                            horizontalArrangement = Arrangement.Center,
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//
//                            Text(
//                                text = "Notificações",
//                                fontSize = 30.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = Color.Black,
//                                textAlign = TextAlign.Center,
//                                modifier = Modifier.padding(end = 32.dp)
//                            )
//                        }
//                    }
//
//                    Spacer(modifier = Modifier.height(20.dp))
//
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 20.dp)
//                    ) {
//                        val notifications = listOf(
//                            "ai que n sei oq n sei oq la blanblablablablabla",
//                            "ai que n sei oq n sei oq la blanblablablablabla",
//                            "ai que n sei oq n sei oq la blanblablablablabla",
//                            "ai que n sei oq n sei oq la blanblablablablabla",
//                            "ai que n sei oq n sei oq la blanblablablablabla"
//                        )
//
//                        notifications.forEachIndexed { index, notification ->
//                            notificacao(title = "Atenção", description = notification)
//
//                            if (index < notifications.size - 1) {
//                                Divider(
//                                    color = Color(0xFFBFC1DB),
//                                    thickness = 1.dp,
//                                    modifier = Modifier.padding(vertical = 8.dp)
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun notificacaoPreview() {
//    JENGTProVestTheme {
//        Notificatio()
//    }
//}
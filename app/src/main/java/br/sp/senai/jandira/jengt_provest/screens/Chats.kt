package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import br.sp.senai.jandira.jengt_provest.R
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun chats(controlNavigation: NavHostController) {

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
                                shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
                            )
                            .height(100.dp)
                    )
                    {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Chats".toUpperCase(),
                                color = Color(0xffDEFEA0),
                                fontSize = 32.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable { controlNavigation.navigate("ChatComUsuario") },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(54.dp)
                                    .clip(RoundedCornerShape(50.dp)),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFD9D9D9)
                                )
                            ) {


                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(12.dp)
                                ) {

                                    Image(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        painter = painterResource(
                                            id = R.drawable.cat
                                        ),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                            ) {

                                Text(
                                    modifier = Modifier,
                                    text = "Prof Julia Fonseca",
                                    fontSize = 15.sp,
                                    color = Color(0xff201F4B),
                                    fontFamily = FontFamily.SansSerif,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Light
                                )

                                Text(
                                    modifier = Modifier,
                                    text = "mensagens...",
                                    fontSize = 13.sp,
                                    color = Color(0xff201F4B),
                                    fontFamily = FontFamily.SansSerif,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Thin
                                )

                            }
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp, bottom = 32.dp)
                                .height(0.8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xff201F4B))
                        ) {}


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                            .clickable { controlNavigation.navigate("ChatComUsuario") },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(54.dp)
                                    .clip(RoundedCornerShape(50.dp)),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFD9D9D9)
                                )
                            ) {


                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(12.dp)
                                ) {

                                    Image(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        painter = painterResource(
                                            id = R.drawable.cat
                                        ),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                            ) {

                                Text(
                                    modifier = Modifier,
                                    text = "Prof Tamires Fernandes",
                                    fontSize = 15.sp,
                                    color = Color(0xff201F4B),
                                    fontFamily = FontFamily.SansSerif,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Light
                                )

                                Text(
                                    modifier = Modifier,
                                    text = "mensagens...",
                                    fontSize = 13.sp,
                                    color = Color(0xff201F4B),
                                    fontFamily = FontFamily.SansSerif,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Thin
                                )

                            }
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp, bottom = 32.dp)
                                .height(0.8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xff201F4B))
                        ) {}


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable { controlNavigation.navigate("ChatComUsuario") },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(54.dp)
                                    .clip(RoundedCornerShape(50.dp)),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFD9D9D9)
                                )
                            ) {


                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(12.dp)
                                ) {

                                    Image(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        painter = painterResource(
                                            id = R.drawable.cat
                                        ),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                            ) {

                                Text(
                                    modifier = Modifier,
                                    text = "Prof Gabriela Cavalcanti",
                                    fontSize = 15.sp,
                                    color = Color(0xff201F4B),
                                    fontFamily = FontFamily.SansSerif,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Light
                                )

                                Text(
                                    modifier = Modifier,
                                    text = "mensagens...",
                                    fontSize = 13.sp,
                                    color = Color(0xff201F4B),
                                    fontFamily = FontFamily.SansSerif,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Thin
                                )

                            }
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp, bottom = 32.dp)
                                .height(0.8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xff201F4B))
                        ) {}

                    }
                }
            }
        })
}



@Preview(showBackground = true)
@Composable
fun chatsPreview() {
    JENGTProVestTheme {
        chats(controlNavigation = rememberNavController())
    }
}
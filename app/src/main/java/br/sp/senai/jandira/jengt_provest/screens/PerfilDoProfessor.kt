package br.senai.jandira.sp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.sp.senai.jandira.jengt_provest.R
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme

@Composable
fun teacherProfile(navigationController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFF1))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFFFFF1))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xff201F4B),
                        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
                    )
                    .height(90.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
            ) {
                Card(
                    modifier = Modifier
                        .size(150.dp),
                    shape = RoundedCornerShape(100.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(28.dp)
                    ) {

                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            painter = painterResource(
                                id = R.drawable.foxprofile
                            ),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = "Insira um nome ou uma foto de perfil (opcional)",
                        fontSize = 13.sp,
                        color = Color(0xff201F4B),
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Light
                    )
                }
            }

            Column(
                modifier = Modifier
                    .size(400.dp)
                    .padding(end = 30.dp),
                verticalArrangement = Arrangement.SpaceAround

            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xff201F4B),
                        focusedLabelColor = Color(0xff201F4B),
                        focusedBorderColor = Color(0xff201F4B)
                    ),
                    label = {
                        Text(
                            text = "Nome",
                            color = Color(0xff201F4B),
                            fontStyle = FontStyle.Italic
                        )
                    }
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xff201F4B),
                        focusedLabelColor = Color(0xff201F4B),
                        focusedBorderColor = Color(0xff201F4B)
                    ),
                    label = {
                        Text(
                            text = "Materia que atua",
                            color = Color(0xff201F4B),
                            fontStyle = FontStyle.Italic
                        )
                    }
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xff201F4B),
                        focusedLabelColor = Color(0xff201F4B),
                        focusedBorderColor = Color(0xff201F4B)
                    ),
                    label = {
                        Text(
                            text = "Horarios disponiveis ",
                            color = Color(0xff201F4B),
                            fontStyle = FontStyle.Italic
                        )
                    }
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xff201F4B),
                        focusedLabelColor = Color(0xff201F4B),
                        focusedBorderColor = Color(0xff201F4B)
                    ),
                    label = {
                        Text(
                            text = "Dias disponiveis",
                            color = Color(0xff201F4B),
                            fontStyle = FontStyle.Italic
                        )
                    }
                )


            }


        }

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 700.dp)
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(
//                        color = Color(0xff201F4B),
//                        shape = RoundedCornerShape(topEnd = 14.dp, topStart = 14.dp)
//                    )
//                    .height(90.dp)
//            )
//        }


    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun teacherProfilePreview() {
    JENGTProVestTheme {
        teacherProfile(navigationController = NavHostController(context = LocalContext.current))
    }
}
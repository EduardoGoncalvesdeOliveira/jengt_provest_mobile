package br.sp.senai.jandira.jengt_provest.screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme

@Composable
fun videoAula(controlNavigation: NavHostController) {
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
                        color = Color(0xffD9D9D9),
                    )
                    .height(240.dp)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Back",
                            tint = Color(0xff201F4B),
                            modifier = Modifier
                                .size(20.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.Pause,
                            contentDescription = "Pause",
                            tint = Color(0xff201F4B),
                            modifier = Modifier
                                .size(26.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.ArrowForwardIos,
                            contentDescription = "Next",
                            tint = Color(0xff201F4B),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }

                Icon(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(40.dp),
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "BackPage",
                    tint = Color(0xff201F4B)
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()) {

                    Text(
                        text = "UniCamp - GEOGRAFIA - Geopolítica - VídeoAula 1",
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W400,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xff201F4B)
                    )

                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp))

                Column (modifier = Modifier
                    .height(175.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                    ){

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(62.dp),
                        shape = RoundedCornerShape(100.dp),
                        colors = ButtonDefaults.buttonColors(Color(0x991D6BC7))
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Entrar em contato com um professor",
                                fontSize = 16.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Normal,
                                color = Color(0xff201F4B)
                            )
                        }

                    }

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(62.dp),
                        shape = RoundedCornerShape(100.dp),
                        colors = ButtonDefaults.buttonColors(Color(0x991D6BC7))
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Questões e Respostas",
                                fontSize = 16.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Normal,
                                color = Color(0xff201F4B)
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
fun videoAulaPreview() {
    JENGTProVestTheme {
        videoAula(controlNavigation = rememberNavController())
    }
}
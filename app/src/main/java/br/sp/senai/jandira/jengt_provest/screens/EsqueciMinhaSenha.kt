package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
fun forgotPassword(navigationController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (modifier = Modifier
            .fillMaxSize()) {
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
                        text = "ProVest",
                        color = Color(0xffDEFEA0),
                        fontSize = 62.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Thin
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Recuperação de senha",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Normal
                )
            }

            Column (
                modifier = Modifier.fillMaxSize(),
            ){
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 48.dp, end = 48.dp),
                    verticalArrangement = Arrangement.SpaceEvenly

                ) {
                    Column (modifier = Modifier,
                        horizontalAlignment = Alignment.Start){

                        Text(
                            modifier = Modifier
                                .padding(start = 12.dp, bottom = 6.dp),
                            text = "Email",
                            color = Color(0xff000000),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Normal
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            value = "",
                            onValueChange = {},
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color(0xffBCB3DF),
                                focusedLabelColor = Color(0xffBCB3DF),
                                focusedBorderColor = Color(0xffBCB3DF)
                            ),
                        )
                    }

                    Column (modifier = Modifier,
                        horizontalAlignment = Alignment.Start){

                        Text(
                            modifier = Modifier
                                .padding(start = 12.dp, bottom = 6.dp),
                            text = "Confirme o email",
                            color = Color(0xff000000),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Normal
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            value = "",
                            onValueChange = {},
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color(0xffBCB3DF),
                                focusedLabelColor = Color(0xffBCB3DF),
                                focusedBorderColor = Color(0xffBCB3DF)
                            ),
                        )
                    }

                    Column (modifier = Modifier,
                        horizontalAlignment = Alignment.Start){

                        Text(
                            modifier = Modifier
                                .padding(start = 12.dp, bottom = 6.dp),
                            text = "Nova senha",
                            color = Color(0xff000000),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Normal
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            value = "",
                            onValueChange = {},
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color(0xffBCB3DF),
                                focusedLabelColor = Color(0xffBCB3DF),
                                focusedBorderColor = Color(0xffBCB3DF)
                            ),
                        )
                    }

                    Column (modifier = Modifier,
                        horizontalAlignment = Alignment.Start){

                        Text(
                            modifier = Modifier
                                .padding(start = 12.dp, bottom = 6.dp),
                            text = "Confirme a senha",
                            color = Color(0xff000000),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Normal
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            value = "",
                            onValueChange = {},
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color(0xffBCB3DF),
                                focusedLabelColor = Color(0xffBCB3DF),
                                focusedBorderColor = Color(0xffBCB3DF)
                            ),
                        )
                    }

                    Spacer(modifier = Modifier.height(100.dp))

                    Row (
                        modifier = Modifier
                    ){
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "botao de voltar",
                            tint = Color(0xFF000000)
                        )
                    }

                }


            }


        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun forgotPasswordPreview() {
    JENGTProVestTheme {
        forgotPassword(navigationController = rememberNavController())
    }
}
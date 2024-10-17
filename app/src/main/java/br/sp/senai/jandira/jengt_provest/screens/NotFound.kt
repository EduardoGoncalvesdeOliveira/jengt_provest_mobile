package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
fun notFound(controlNavigation: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xff201F4B))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                    Image(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .height(125.dp)
                            .width(125.dp),
                        painter = painterResource(
                            id = R.drawable.notfoundprovest
                        ),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                            .height(120.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(vertical = 10.dp),
                            text = "Ops!",
                            color = Color(0xffDEFEA0),
                            fontSize = 26.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Normal
                        )

                        Text(
                            modifier = Modifier
                                .padding(vertical = 10.dp),
                            text = "Parece que ocorreu um erro",
                            color = Color(0xffDEFEA0),
                            fontSize = 26.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Normal
                        )
                    }


                Column (modifier = Modifier
                    .padding(10.dp)
                    .height(200.dp),
                    verticalArrangement = Arrangement.SpaceEvenly){

                    Text(
                        modifier = Modifier,
                        text = "Ocorreu um problema ao tentar realizar a ação solicitada. ",
                        color = Color(0xffDEFEA0),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Light
                    )

                    Text(
                        modifier = Modifier,
                        text = "Por favor, verifique sua conexão e tente novamente mais tarde.",
                        color = Color(0xffDEFEA0),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Light
                    )

                    Text(
                        modifier = Modifier,
                        text = "Se o problema persistir, entre em contato com o suporte técnico para obter assistência.",
                        color = Color(0xffDEFEA0),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Light
                    )

                }

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(width = 260.dp, height = 52.dp)
                        .padding(top = 12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xffDEFEA0)),
                    border = BorderStroke(1.dp, Color(0xffBCB3DF))
                ) {
                    Text(
                        text = "Tentar Novamente".toUpperCase(),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xff201F4B)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun notFoundPreview() {
    JENGTProVestTheme {
        notFound(controlNavigation = rememberNavController())
    }
}
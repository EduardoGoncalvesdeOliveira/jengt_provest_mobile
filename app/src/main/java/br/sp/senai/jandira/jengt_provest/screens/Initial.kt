package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.sp.senai.jandira.jengt_provest.R

@Composable
fun Initial(navigationController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffFFFFF1)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                shape = RoundedCornerShape(bottomStart = 45.dp, bottomEnd = 45.dp),
                colors = CardDefaults.cardColors(Color(0xff201F4B))
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp),
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

                    Spacer(modifier = Modifier.height(10.dp))

                    Image(
                        painter = painterResource(id = R.drawable.female),
                        contentDescription = "mulher pensando",
                        modifier = Modifier
                            .size(250.dp)
                    )
                }

            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {


                Text(
                    textAlign = TextAlign.Center,
                    text = "OLÁ, ESTAMOS MUITO FELIZES POR TE VER POR AQUI!",
                    fontSize = 24.sp
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = { navigationController.navigate("SignUpStudent") },
                        modifier = Modifier
                            .size(height = 70.dp, width = 250.dp)
                            .padding(vertical = 12.dp),
                        colors = ButtonDefaults.buttonColors(Color(0x00DEFEA0)),
                        border = BorderStroke(1.dp, Color(0xffBCB3DF))
                    ) {
                        Text(
                            text = "Sou Aluno",
                            fontSize = 14.sp,
                            color = Color(0xFF000000)
                        )
                    }

                    Button(
                        onClick = { navigationController.navigate("SignUpTeacher") },
                        modifier = Modifier
                            .size(height = 70.dp, width = 250.dp)
                            .padding(vertical = 12.dp),
                        colors = ButtonDefaults.buttonColors(Color(0x00DEFEA0)),
                        border = BorderStroke(1.dp, Color(0xffBCB3DF))
                    ) {
                        Text(
                            text = "Sou Professor",
                            fontSize = 14.sp,
                            color = Color(0xFF000000)
                        )
                    }

                }


            }



        }

    }

}
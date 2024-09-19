package br.senai.jandira.sp.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LinkedCamera
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun studentProfile(navigationController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFF1))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xff201F4B),
                        shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
                    )
                    .height(300.dp)

            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .size(150.dp),
                        shape = RoundedCornerShape(100.dp)
                    ) {
                        Icon(
                            modifier = Modifier.fillMaxSize(),
                            imageVector = Icons.Default.AccountCircle,
                            tint = Color(0xff201F4B),
                            contentDescription = "Icone de uma pessoa"
                        )

                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 190.dp, start = 90.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    FloatingActionButton(
                        modifier = Modifier.size(40.dp),
                        shape = RoundedCornerShape(50.dp),
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.LinkedCamera,
                            contentDescription = "adcionar foto"
                        )

                    }

                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Nycolle lima".toUpperCase(),
                        fontSize = 30.sp,
                        color = Color(0xffDEFEA0)
                    )

                }


            }

            Column(
                modifier = Modifier
                    .size(400.dp)
                    .padding(start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.SpaceAround

            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xff8373C2),
                        focusedLabelColor = Color(0xff8373C2),
                        focusedBorderColor = Color(0xff8373C2)
                    ),
                    label = {
                        Text(
                            text = "Nome",
                            color = Color(0xff8373C2)
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
                        unfocusedBorderColor = Color(0xff8373C2),
                        focusedLabelColor = Color(0xff8373C2),
                        focusedBorderColor = Color(0xff8373C2)
                    ),
                    label = {
                        Text(
                            text = "Telefone",
                            color = Color(0xff8373C2)
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
                        unfocusedBorderColor = Color(0xff8373C2),
                        focusedLabelColor = Color(0xff8373C2),
                        focusedBorderColor = Color(0xff8373C2)
                    ),
                    label = {
                        Text(
                            text = "Email",
                            color = Color(0xff8373C2)
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
                        unfocusedBorderColor = Color(0xff8373C2),
                        focusedLabelColor = Color(0xff8373C2),
                        focusedBorderColor = Color(0xff8373C2)
                    ),
                    label = {
                        Text(
                            text = "Mudar senha",
                            color = Color(0xff8373C2)
                        )
                    }
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(width = 260.dp, height = 52.dp)
                        .padding(top = 12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xffBCB3DF)),
                    border = BorderStroke(1.dp, Color(0xffBCB3DF))
                ) {
                    Text(
                        text = "salvar".toUpperCase(),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xFF000000)
                    )
                }

            }



            Row (

            ){
                Icon(
                    modifier = Modifier
                        .width(60.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "botao de voltar",
                    tint = Color(0xFF000000),

                    )
            }


        }

    }

}





@Preview(showSystemUi = true, showBackground = true)
@Composable
fun studentProfilePreview() {
    JENGTProVestTheme {
        studentProfile(navigationController = rememberNavController())
    }
}
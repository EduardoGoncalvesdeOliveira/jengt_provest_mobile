package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
fun registeredSuccessfully(navigationController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xff201F4B)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                modifier = Modifier.size(180.dp),
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Confirmação de cadastro",
                tint = Color(0xff8CE5C3))

            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "CADASTRADO COM SUCESSO!",
                color = Color(0xffDEFEA0),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(200.dp))

            Column(){
                Button(
                    onClick = { navigationController.navigate("StudentProfile") },
                    modifier = Modifier
                        .size(width = 260.dp, height = 52.dp)
                        .padding(top = 12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xffBCB3DF)),
                    border = BorderStroke(1.dp, Color(0xffBCB3DF))
                ) {
                    Text(
                        text = "ACESSAR MEU PERFIL".toUpperCase(),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xFF000000)
                    )
                }

                Button(
                    onClick = { navigationController.navigate("Home") },
                    modifier = Modifier
                        .size(width = 260.dp, height = 52.dp)
                        .padding(top = 12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xffBCB3DF)),
                    border = BorderStroke(1.dp, Color(0xffBCB3DF))
                ) {
                    Text(
                        text = "HOME".toUpperCase(),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xFF000000)
                    )
                }
            }
        }



    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun registeredSuccessfullyPreview() {
    JENGTProVestTheme {
        registeredSuccessfully(navigationController = rememberNavController())
    }
}
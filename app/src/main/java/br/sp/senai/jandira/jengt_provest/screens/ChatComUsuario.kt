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
fun chatComUsuario(controlNavigation: NavHostController) {

    Scaffold(

        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)),
                contentColor = Color(0xffC6E6A3),
                containerColor = Color(0xff201F4B),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.send),
                        contentDescription = "Enviar",
                        modifier = Modifier
                            .size(34.dp)
                            .clickable {  },
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
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Eduardo G. de Oliveira",
                                color = Color(0xffDEFEA0),
                                fontSize = 24.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Light
                            )

                            Card(
                                modifier = Modifier
                                    .size(54.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Transparent

                                ),
                                border = BorderStroke(2.dp, Color(0xffBCB3DF))
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
                                            id = R.drawable.foxprofile
                                        ),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop
                                    )
                                }

                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {


                        Spacer(modifier = Modifier.height(16.dp))




                    }
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun chatComUsuarioPreview() {
    JENGTProVestTheme {
        chatComUsuario(controlNavigation = rememberNavController())
    }
}
package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun loginTeachers(controlNavigation: NavHostController) {
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Bem Vindo Professor!".toUpperCase(),
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Login",
                    fontSize = 44.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,

                    )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(top = 12.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                var emailState = remember {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    maxLines = 1,
                    shape = RoundedCornerShape(50.dp),
                    label = {
                        Text(
                            text = "Email",
                            fontSize = 16.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "testeLogin",
                            tint = Color(0xffBCB3DF)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xffBCB3DF),
                        focusedLabelColor = Color(0xffBCB3DF),
                        focusedBorderColor = Color(0xffBCB3DF)
                    ),
                )

                var passwordState = remember {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    maxLines = 1,
                    shape = RoundedCornerShape(50.dp),
                    label = {
                        Text(
                            text = "Password",
                            fontSize = 16.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "testeLogin",
                            tint = Color(0xffBCB3DF)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xffBCB3DF),
                        focusedLabelColor = Color(0xffBCB3DF),
                        focusedBorderColor = Color(0xffBCB3DF)
                    ),
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    var mensagemErro = remember {
                        mutableStateOf("")
                    }

                    Text(text = mensagemErro.value, color = Color.Red)

                    Button(
                        onClick = {
                            if (emailState.value == "qwe" && passwordState.value == "123") {
                                mensagemErro.value = ""
                                controlNavigation.navigate("RegisteredSuccessfully")
                            } else {
                                mensagemErro.value = "Usuário ou Senha incorreta"
                            }

                        },
                        modifier = Modifier
                            .size(width = 260.dp, height = 52.dp)
                            .padding(top = 12.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffBCB3DF)),
                        border = BorderStroke(1.dp, Color(0xffBCB3DF))
                    ) {
                        Text(
                            text = "Login".toUpperCase(),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = Color(0xFF000000)
                        )
                    }

                    Text(modifier = Modifier
                        .padding(top = 8.dp)
                        .clickable { controlNavigation.navigate("RegisteredSuccessfully") },
                        text = "Esqueceu a senha?",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Italic,
                        color = Color.Gray
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        var overState = remember {
                            mutableStateOf(false)
                        }

                        Checkbox(
                            checked = overState.value,
                            onCheckedChange = {
                                overState.value = it
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xffBCB3DF),
                                uncheckedColor = Color(0xffBCB3DF)
                            )
                        )

                        Text(
                            text = "Lembrar de mim",
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic,
                            color = Color.Gray
                        )


                    }

                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(Color(0xff0A8365))
                    )

                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Não possui cadastro?", fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black
                        )
                        Text(modifier = Modifier
                            .clickable { controlNavigation.navigate("SignUpTeacher") },
                            text = "Criar conta", fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xff0A8365)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginTeachersPreview() {
    JENGTProVestTheme {
        loginTeachers(controlNavigation = rememberNavController())
    }
}
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun questao(navigationController: NavHostController) {
    var optionA by remember { mutableStateOf(false) }
    var optionB by remember { mutableStateOf(false) }
    var optionC by remember { mutableStateOf(false) }
    var optionD by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFF1))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xffCC7070),
                        shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp)
                    )
                    .height(40.dp)
                    .width(300.dp),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(
                    text = "Matemática",
                    color = Color(0xffffffff),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .size(370.dp, height = 275.dp)
                        .padding(horizontal = 9.dp),
                    colors = CardDefaults.cardColors(Color(0xFFE2E2E2)),
                ) {

                    Text(
                        modifier = Modifier.padding(18.dp),
                        text = "Na Matemática, os conjuntos representam a reunião de diversos objetos e as operações realizadas com os conjuntos são: união, intersecção e diferença.Aproveite as 10 questões a seguir para testar seus conhecimentos. Utilize as resoluções comentadas para tirar as suas dúvidas.",
                        color = Color(0xff201F4B),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.padding(20.dp),
                text = "Questão 1",
                color = Color(0xff201F4B),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier
                    .padding(20.dp),
                text = "Considere os conjuntos\n" +
                        "A = {1, 4, 7}\n" +
                        "B = {1, 3, 4, 5, 7, 8}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "É correto afirmar que:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = optionA,
                        onCheckedChange = { optionA = it }
                    )
                    Text(text = "a) A ∪ B", fontSize = 18.sp)
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = optionB,
                        onCheckedChange = { optionB = it }
                    )
                    Text(text = "b) A ∩ B", fontSize = 18.sp)
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = optionC,
                        onCheckedChange = { optionC = it }
                    )
                    Text(text = "c) B ∪ A", fontSize = 18.sp)
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = optionD,
                        onCheckedChange = { optionD = it }
                    )
                    Text(text = "d) B ∩ A", fontSize = 18.sp)
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun questaoPreview() {
    JENGTProVestTheme {
        questao(navigationController = rememberNavController())
    }
}
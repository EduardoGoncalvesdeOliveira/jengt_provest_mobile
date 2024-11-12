package br.sp.senai.jandira.jengt_provest.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
import br.sp.senai.jandira.jengt_provest.R
import br.sp.senai.jandira.jengt_provest.model.CadernoAluno
import br.sp.senai.jandira.jengt_provest.model.CadernoAlunoResponse
import br.sp.senai.jandira.jengt_provest.model.Curso
import br.sp.senai.jandira.jengt_provest.model.CursoResponse
import br.sp.senai.jandira.jengt_provest.service.MateriasService
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun materias(navigationController: NavHostController) {

    var cursos by remember { mutableStateOf(listOf<Curso>()) }
    val retrofitFactory = RetrofitFactory()
    var MateriasService = retrofitFactory.getCursosService()

    LaunchedEffect(Unit) {

        MateriasService.getAllCursos().enqueue(object : Callback<CursoResponse> {
            override fun onResponse(
                p0: Call<CursoResponse>,
                response: Response<CursoResponse>
            ) {
                if (response.isSuccessful) {
                    cursos = response.body()?.curso ?: emptyList()
                }
            }

            override fun onFailure(p0: Call<CursoResponse>, p1: Throwable) {
                Log.e("erro fudeu", "erro porra caralho ${p1}")
            }
        })
    }

        Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)),
                containerColor = Color(0xffC6E6A3),
                contentColor = Color(0xff201F4B),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.notebook_icon),
                        contentDescription = "Anotações",
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(34.dp)
                            .clickable { navigationController.navigate("CadernoDoAluno") },
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.home_icon),
                        contentDescription = "Home",
                        modifier = Modifier
                            .padding(bottom = 0.dp)
                            .size(40.dp)
                            .clickable { navigationController.navigate("Home") },

                        )

                    Icon(
                        painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = "Mensagens",
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(34.dp)
                            .clickable { navigationController.navigate("Chats") },

                        )
                }
            }
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFFFF1))
                        .padding(16.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(2.dp, Color(0xFFD4A4E2), RoundedCornerShape(16.dp))
                            .padding(start = 40.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "20", fontSize = 32.sp, color = Color(0xFF5446B6))
                                Text(text = "out", fontSize = 18.sp, color = Color(0xFF5446B6))
                            }
                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = "UniCamp - 1ª fase",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn (modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                    ){
                        items(cursos) { curso ->

                            SubjectButton("${curso.nome}", Color(0xFFD98C8C))
                            SubjectButton("${curso.nome}", Color(0xFFE1ACB2))
                            SubjectButton("${curso.nome}", Color(0xFFF8D3A2))
                            SubjectButton("${curso.nome}", Color(0xFFF2E29A))
                            SubjectButton("${curso.nome}", Color(0xFFAED8A5))
                            SubjectButton("${curso.nome}", Color(0xFFB4DAD5))
                            SubjectButton("${curso.nome}", Color(0xFFA9BFE6))
                            SubjectButton("${curso.nome}", Color(0xFFB2A5D8))

                        }

                    }
                }
            }
        }
    )
}

@Composable
fun SubjectButton(subjectName: String, backgroundColor: Color) {
    Button(
        onClick = {  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(32.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = subjectName,
                color = Color(0xff201F4B),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color(0xFF2B264B),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun materiasPreview() {
    JENGTProVestTheme {
        materias(navigationController = rememberNavController())
    }
}
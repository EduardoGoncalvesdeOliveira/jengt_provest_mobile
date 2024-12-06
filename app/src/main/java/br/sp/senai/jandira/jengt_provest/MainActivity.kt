package br.sp.senai.jandira.jengt_provest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.jandira.sp.screens.teacherProfile
import br.sp.senai.jandira.jengt_provest.screens.Initial
import br.sp.senai.jandira.jengt_provest.screens.cadernoDoAluno
import br.sp.senai.jandira.jengt_provest.screens.chatComUsuario
import br.sp.senai.jandira.jengt_provest.screens.chats
import br.sp.senai.jandira.jengt_provest.screens.escolhaTemaRedacao
//import br.sp.senai.jandira.jengt_provest.screens.escolhaTemaRedacao
import br.sp.senai.jandira.jengt_provest.screens.forgotPassword
import br.sp.senai.jandira.jengt_provest.screens.home
import br.sp.senai.jandira.jengt_provest.screens.instrucoesRedacao
import br.sp.senai.jandira.jengt_provest.screens.listaCadernos
import br.sp.senai.jandira.jengt_provest.screens.loginStudents
import br.sp.senai.jandira.jengt_provest.screens.loginTeachers
import br.sp.senai.jandira.jengt_provest.screens.materias
import br.sp.senai.jandira.jengt_provest.screens.notFound
import br.sp.senai.jandira.jengt_provest.screens.redacao
import br.sp.senai.jandira.jengt_provest.screens.redacaoEnviada
import br.sp.senai.jandira.jengt_provest.screens.registeredSuccessfully
import br.sp.senai.jandira.jengt_provest.screens.signUpStudent
import br.sp.senai.jandira.jengt_provest.screens.signUpTeacher
import br.sp.senai.jandira.jengt_provest.screens.subMaterias
import br.sp.senai.jandira.jengt_provest.screens.videoAula
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JENGTProVestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val controlNavigation = rememberNavController()
                    NavHost(navController = controlNavigation, startDestination = "Initial") {

                        composable(route = "Initial") { Initial(controlNavigation) }

                        composable(route = "SignUpTeacher") { signUpTeacher(controlNavigation) }
                        composable(route = "LoginTeacher") { loginTeachers(controlNavigation) }

                        composable(route = "SignUpStudent") { signUpStudent(controlNavigation) }
                        composable(route = "LoginStudent") { loginStudents(controlNavigation) }

                        composable(route = "ForgotPassword") { forgotPassword(controlNavigation) }


                        composable(route = "RegisteredSuccessfully") {
                            registeredSuccessfully(
                                controlNavigation
                            )
                        }


                        composable(route = "TeacherProfile") { teacherProfile(controlNavigation) }
                        composable(route = "StudentProfile") { teacherProfile(controlNavigation) }

                        composable(route = "Home") { home(controlNavigation) }

                        composable(route = "Redacao/{tituloTema}") { backStackEntry ->
                            val tituloTema = backStackEntry.arguments?.getString("tituloTema") ?: ""
                            redacao(controlNavigation, tituloTema = tituloTema)
                        }

                        composable(route = "CadernoDoAluno") { cadernoDoAluno(controlNavigation) }

                        composable(route = "VideoAula") { videoAula(controlNavigation) }

                        composable(route = "EscolhaTemaRedacao") {
                            escolhaTemaRedacao(
                                controlNavigation
                            )
                        }

                        composable(route = "Calendar") { calendar(controlNavigation) }

                        composable(route = "NotFound") { notFound(controlNavigation) }

                        composable(route = "RedacaoEnviada") { redacaoEnviada(controlNavigation) }

                        composable(route = "Chats") { chats(controlNavigation) }

                        composable(route = "ChatComUsuario") { chatComUsuario(controlNavigation) }

                        composable(route = "ListaDeCadernos") { listaCadernos(controlNavigation) }

                        composable(route = "Materias") { materias(controlNavigation) }

                        composable(route = "SubMaterias/{materiaNome}") { backStackEntry ->
                            val materiaNome = backStackEntry.arguments?.getString("materiaNome") ?: ""
                            subMaterias(controlNavigation, materiaNome = materiaNome)
                        }

                        composable(route = "instrucoesRedacao") { instrucoesRedacao(controlNavigation) }

                    }
                }
            }
        }
    }
}
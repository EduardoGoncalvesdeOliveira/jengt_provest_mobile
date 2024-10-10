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
//import br.sp.senai.jandira.jengt_provest.screens.escolhaTemaRedacao
import br.sp.senai.jandira.jengt_provest.screens.forgotPassword
import br.sp.senai.jandira.jengt_provest.screens.home
import br.sp.senai.jandira.jengt_provest.screens.loginStudents
import br.sp.senai.jandira.jengt_provest.screens.loginTeachers
import br.sp.senai.jandira.jengt_provest.screens.redacao
import br.sp.senai.jandira.jengt_provest.screens.registeredSuccessfully
import br.sp.senai.jandira.jengt_provest.screens.signUpStudent
import br.sp.senai.jandira.jengt_provest.screens.signUpTeacher
import br.sp.senai.jandira.jengt_provest.screens.videoAula
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme

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
                    NavHost(navController = controlNavigation, startDestination = "CadernoDoAluno") {

                        composable(route = "Initial") { Initial(controlNavigation) }

                        composable(route = "SignUpTeacher") { signUpTeacher(controlNavigation) }
                        composable(route = "LoginTeacher") { loginTeachers(controlNavigation) }

                        composable(route = "SignUpStudent") { signUpStudent(controlNavigation) }
                        composable(route = "LoginStudent") { loginStudents(controlNavigation) }

                        composable(route = "ForgotPassword") { forgotPassword(controlNavigation) }


                        composable(route = "RegisteredSuccessfully") { registeredSuccessfully(controlNavigation) }


                        composable(route = "TeacherProfile") { teacherProfile(controlNavigation) }
                        composable(route = "StudentProfile") { teacherProfile(controlNavigation) }

                        composable(route = "Home") { home(controlNavigation) }

                        composable(route = "Redacao") { redacao(controlNavigation) }

                        composable(route = "CadernoDoAluno") { cadernoDoAluno(controlNavigation) }

                        composable(route = "VideoAula") { videoAula(controlNavigation) }

//                        composable(route = "EscolhaTemaRedacao") { escolhaTemaRedacao(controlNavigation) }

                    }
                }
            }
        }
    }
}
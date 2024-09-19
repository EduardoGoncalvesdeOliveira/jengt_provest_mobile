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
import br.sp.senai.jandira.jengt_provest.screens.forgotPassword
import br.sp.senai.jandira.jengt_provest.screens.home
import br.sp.senai.jandira.jengt_provest.screens.loginStudents
import br.sp.senai.jandira.jengt_provest.screens.loginTeachers
import br.sp.senai.jandira.jengt_provest.screens.registeredSuccessfully
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
                    NavHost(navController = controlNavigation, startDestination = "greetings") {

                        composable(route = "Initial") { Initial(controlNavigation) }

                        composable(route = "SignUpTeacher") { loginTeachers(controlNavigation) }
                        composable(route = "LoginTeacher") { loginTeachers(controlNavigation) }

                        composable(route = "SignUpStudent") { loginStudents(controlNavigation) }
                        composable(route = "LoginStudent") { loginStudents(controlNavigation) }

                        composable(route = "ForgotPassword") { forgotPassword(controlNavigation) }


                        composable(route = "registeredSuccessfully") { registeredSuccessfully(controlNavigation) }


                        composable(route = "teacherProfile") { teacherProfile(controlNavigation) }
                        composable(route = "studentProfile") { teacherProfile(controlNavigation) }

                        composable(route = "Home") { home(controlNavigation) }

                    }
                }
            }
        }
    }
}
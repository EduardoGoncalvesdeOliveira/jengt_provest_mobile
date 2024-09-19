package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme

@Composable
fun home(controlNavigation: NavHostController) { }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun homePreview() {
    JENGTProVestTheme {
        home(controlNavigation = rememberNavController())
    }
}
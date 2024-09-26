package br.sp.senai.jandira.jengt_provest.screens

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rickandmortyapi.service.RetrofitFactory
import br.sp.senai.jandira.jengt_provest.model.Aluno
import br.sp.senai.jandira.jengt_provest.model.Results
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home(controlNavigation: NavHostController) {

    val options = listOf("Opção 1", "Opção 2", "Opção 3")

    // Variável para armazenar a opção selecionada
    var selectedOption by remember { mutableStateOf("") }

    // Controla se o menu está expandido ou não
    var expanded by remember { mutableStateOf(false) }

    // ExposedDropdownMenuBox cria um campo de texto que pode abrir um menu suspenso
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedOption,
            onValueChange = { selectedOption = it },
            label = { Text("Selecione uma opção") },
            readOnly = true,  // Impede a edição manual
            modifier = Modifier.menuAnchor(),
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color.Black,
                disabledTextColor = Color.Transparent
            )
        )

        // Menu dropdown com as opções
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun homePreview() {
    JENGTProVestTheme {
        home(controlNavigation = rememberNavController())
    }
}
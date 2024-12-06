import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.sp.senai.jandira.jengt_provest.ui.theme.JENGTProVestTheme
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            calendar(navigationController = rememberNavController())
        }
    }
}

@Composable
fun calendar(navigationController: NavHostController) {
    var selectedDate by remember { mutableStateOf(LocalDate.of(2024, 12, 10)) }
    var offsetY by remember { mutableStateOf(0f) } // Variable to store drag offset
    val dragThreshold = 150f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        TopBar(

            date = selectedDate,
            offsetY = offsetY,
            onDrag = { delta ->
                offsetY = (offsetY + delta).coerceIn(0f, dragThreshold) // Constrain dragging within bounds
            },
            onDragEnd = {
                // Hide or show calendar depending on the drag position
                if (offsetY > dragThreshold) {
                    selectedDate = LocalDate.of(2024, 8, 1) // Switch to calendar view
                }
                offsetY = 0f // Reset drag
            }
        )

        if (offsetY == 0f) {
            ExamList() // Show exam list
        } else {
            CalendarView(
                selectedDate = selectedDate,
                onDateSelected = { selectedDate = it }
            )
        }
    }
}

@Composable
fun TopBar(date: LocalDate, offsetY: Float, onDrag: (Float) -> Unit, onDragEnd: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                color = Color(0xFF433B5B)
            )
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    onDrag(dragAmount.y)
                }
            }
            .offset(y = offsetY.dp) // Move the top bar with drag
            .height(100.dp)
            .background(
                color = Color(0xff201F4B),
                shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 26.dp, vertical = 26.dp)
                .background(
                color = Color(0xff201F4B),
                shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
            )
        ) {
            Text(
                text = "${date.month.getDisplayName(TextStyle.FULL, Locale.getDefault())}, ${date.dayOfMonth}",
                color = Color(0xfffffff1),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = date.year.toString(),
                color = Color(0xFF9BD5AF),
                fontSize = 20.sp
            )
        }

//        Spacer(modifier = Modifier .width(1f))

        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = "Open Calendar",
            tint = Color.White,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }

    // Detect when drag is finished
    LaunchedEffect(offsetY) {
        if (offsetY == 0f) {
            onDragEnd()
        }
    }
}

@Composable
fun ExamList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xfffffff1))
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Provas",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff201F4B),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        listOf(
            "20 out" to "UniCamp - 1ª fase",
            "3 nov" to "ENEM - dia 1",
            "10 nov" to "ENEM - dia 2",
            "15 nov" to "Unesp - 1ª fase",
            "17 nov" to "Fuvest - 1ª fase"
        ).forEach { (date, name) ->
            item {
                Card(
                    modifier = Modifier
                        .height(75.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 9.dp),
                    colors = CardDefaults.cardColors(Color(0x00FFFFFF)),
                    border = BorderStroke(1.dp, Color(0xff201F4B))
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(Color(0xfffffff1))
                        ) {
                            Text(
                                text = date,
                                modifier = Modifier.align(Alignment.Center),
                                color = Color(0xff201F4B),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = name, fontSize = 16.sp, color = Color(0xff201F4B))
                    }
                }

                Spacer(modifier = Modifier .height(10.dp))
            }
        }
    }
}

@Composable
fun CalendarView(selectedDate: LocalDate, onDateSelected: (LocalDate) -> Unit) {
    // Definir a data estática como 10 de dezembro de 2024
    val currentDate = LocalDate.of(2024, 12, 10)  // Data fixa

    // Usar o selectedDate, mas garantir que ele é o mês e o ano do calendário atual
    val currentMonth = selectedDate.month
    val currentYear = selectedDate.year

    // Obter o primeiro dia do mês e o número de dias do mês
    val firstDayOfMonth = selectedDate.withDayOfMonth(1)
    val firstDayOfWeek = firstDayOfMonth.dayOfWeek.ordinal // Obter a posição do primeiro dia da semana (0=Domingo, 6=Sábado)
    val daysInMonth = selectedDate.lengthOfMonth()

    // Gerar as datas para o grid do calendário
    val dates = Array(6) { Array(7) { null as LocalDate? } } // 6 linhas, 7 colunas (dias da semana)
    var currentDay = 1
    for (week in 0 until 6) {
        for (dayOfWeek in 0 until 7) {
            if (week == 0 && dayOfWeek < firstDayOfWeek || currentDay > daysInMonth) {
                // Deixar espaços vazios antes do primeiro dia do mês e após o último dia
                continue
            }
            dates[week][dayOfWeek] = LocalDate.of(currentYear, currentMonth, currentDay)
            currentDay++
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff201F4B))
            .padding(16.dp)
    ) {
        // Cabeçalho de Mês e Ano
        Text(
            text = "${currentMonth.getDisplayName(TextStyle.FULL, Locale.getDefault())} $currentYear",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Cabeçalhos dos Dias da Semana (Dom, Seg, Ter, ...)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val weekdays = listOf("M", "T", "W", "T", "F", "S", "S")
            weekdays.forEach { day ->
                Text(
                    text = day,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Dias do Calendário
        for (week in 0 until 6) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (dayOfWeek in 0 until 7) {
                    val date = dates[week][dayOfWeek]
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                when {
                                    date != null && date == selectedDate -> Color(0xFF9BD5AF)  // Selecionar o dia
                                    date != null && date == currentDate -> Color(0x759BD5AF) // Marcar o dia atual
                                    else -> Color(0xFF433B5B)
                                },
                                shape = RoundedCornerShape(50.dp)
                            )
                            .clickable { date?.let { onDateSelected(it) } },
                        contentAlignment = Alignment.Center
                    ) {
                        date?.let {
                            Text(
                                text = it.dayOfMonth.toString(),
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun calendarPreview() {
    JENGTProVestTheme {
        calendar(navigationController = rememberNavController())
    }
}
package com.example.miretohidratacion

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.MutableIntSet
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miretohidratacion.ui.theme.MiRetohidratacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiRetohidratacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaHidratacionV4(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaHidratacionV4(modifier: Modifier) {
    val fondo = Color(0xFF000000)
    val color1 = Color(0xFFFFC107)
    val color2 = Color(0xFFEE0000)
    val color3 = Color(0xFFFFEB3B)

    val contexto = LocalContext.current

    var vasos by remember { mutableIntStateOf(0) }
    val meta = 8

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(fondo)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text ="Mi reto de Hidratación",
            fontSize = 17.sp,
            color = color1
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Cada baso cuenta!!!!!",
            fontSize = 17.sp,
            color = color2
        )
        Spacer(modifier= Modifier.height(38.dp))
        Text(
            text = "TU DESAFIO SEMANAL",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = color3
        )
        Spacer(modifier= Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("META Diaria", fontSize = 12.sp, color=color2)
                Text(
                    text = "$meta vasos",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = color2
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Duración", fontSize = 12.sp, color=color2)
                Text(
                    text = "7 DIAS",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = color2
                )
            }
        }
        Spacer(modifier= Modifier.height(42.dp))
        Text(
            text = "PLAN PARA HOY",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = color1
        )
        Spacer(modifier= Modifier.height(42.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Mañana", fontSize = 16.sp, color = color3)
            Text("3 vasos", fontSize = 16.sp, color = color3)
        }
        Spacer(modifier= Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Tarde", fontSize = 16.sp, color = color3)
            Text("3 vasos", fontSize = 16.sp, color = color1)
        }
        Spacer(modifier= Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Noche", fontSize = 16.sp, color = color3)
            Text("2 vasos", fontSize = 16.sp, color = color1)
        }
        Spacer(modifier= Modifier.height(24.dp))
        Text(
            text ="VASOS REGISTRADOS: $vasos ➡️ $meta",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = color1,
            textAlign = TextAlign.Center
        )
        Spacer(modifier= Modifier.height(24.dp))
        Text(
            text = if(vasos == meta) "META ALCANZADA" else "Sigue avanzando",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = color1,
            textAlign = TextAlign.Center
        )
        Spacer(modifier= Modifier.height(24.dp))
        Button(
            onClick = { if(vasos > 0) vasos-- },
            enabled = vasos > 0,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = color1)
        ) {
            Text("DESHACER ULTIMO VASO", fontSize = 14.sp)
        }
        Spacer(modifier= Modifier.height(24.dp))

        Button(
            onClick = {
                makeText(
                    contexto,
                    "Consejo: distribuye los vasos durante el día",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = color1)
        ) {
            Text("VER CONSEJO DEL DIA")
        }
        Spacer(modifier= Modifier.height(24.dp))
        Button(
            onClick = {
                makeText(
                    contexto,
                    "Tu meta es de 8 vasos diarios durante 7 dias",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = color1)
        ) {
            Text("RECORDAR MI META")
        }
        Spacer(modifier= Modifier.height(24.dp))
        Text(
            text = "Hoy comienza un habito saludable",
            fontSize = 15.sp,
            color = color2,
            textAlign = TextAlign.Center
        )
    }

}
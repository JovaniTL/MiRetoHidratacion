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
                    PantallaHidratacionV5(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun PantallaHidratacionV5(modifier: Modifier) {

    val fondo = Color(0xFF0F172A)
    val color1 = Color(0xFF38BDF8)
    val color2 = Color(0xFF7DD3FC)
    val color3 = Color(0xFF1E293B)
    val colorBoton = Color(0xFF06B6D4)
    val contexto = LocalContext.current
    var vasos by remember { mutableIntStateOf(0) }
    var meta by remember { mutableIntStateOf(8) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(fondo)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Mi reto de Hidratación",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = color1,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Cada vaso cuenta",
            fontSize = 17.sp,
            color = color2
        )

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color3,
                    RoundedCornerShape(16.dp)
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "CONFIGURA TU META",
                fontSize = 14.sp,
                color = color1,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = {if (meta > 0) meta--},
                    enabled = meta > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorBoton
                    )
                ) {
                    Text("-", color = Color.White)
                }

                Spacer(modifier = Modifier.width(30.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "$meta VASOS",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "Meta diaria",
                        fontSize = 12.sp,
                        color = color2
                    )
                }

                Spacer(modifier = Modifier.width(30.dp))

                Button(
                    onClick = {meta++},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorBoton
                    )
                ) {
                    Text("+", color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "TU DESAFÍO SEMANAL",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = color1
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "Meta diaria",
                    color = color2
                )

                Text(
                    "${meta} vasos",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "Duración",
                    color = color2
                )

                Text(
                    "7 días",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "VASOS REGISTRADOS: $vasos ➜ $meta",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = color1
        )

        Spacer(modifier = Modifier.height(12.dp))

        LinearProgressIndicator(
            progress = { vasos.toFloat() / meta.toFloat() },
            modifier = Modifier.fillMaxWidth().height(20.dp),

            color = color1,
            trackColor = Color(0xFF475569)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { if (vasos < meta) vasos++ },
            enabled = vasos < meta,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorBoton
            )
        ) {
            Text(
                "REGISTRAR UN VASO",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { if (vasos > 0) vasos-- },
            enabled = vasos > 0,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorBoton
            )
        ) {
            Text(
                "DESHACER ÚLTIMO VASO",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = if (vasos == meta)
                "🎉 ¡Meta alcanzada!"
            else
                "Sigue avanzando, vaso a vaso",
            color = color2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier= Modifier.height(24.dp))
        Button(
            onClick = {
                makeText(
                    contexto,
                    "Tu meta es de ${meta} vasos diarios durante 7 dias",
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
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
                    PantallaHidratacionV2(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaHidratacionV2(modifier: Modifier) {
    val fondo = Color(0xFFFFC107)
    val color1 = Color(0xFF008DFF)
    val color2 = Color(0xFF00EE0B)
    val color3 = Color(0xFF03A9F4)
    Column(
        modifier = modifier.fillMaxSize().systemBarsPadding().padding(24.dp),
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
        Spacer(modifier= Modifier.height(24.dp))
        Text(
            text = "Mi Meta diaria",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = color3
        )
        Text(
            text = "8 vasos",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = color2
        )
        Spacer(modifier= Modifier.height(24.dp))
        Text(
            text = "Hoy comienza un habito saludable",
            fontSize = 16.sp,
            color = color3,
            textAlign = TextAlign.Center
        )
    }
}

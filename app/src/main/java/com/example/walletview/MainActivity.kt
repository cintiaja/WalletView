package com.example.walletview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.walletview.ui.theme.GastosMes.WalletViewScreen
import com.example.walletview.ui.theme.WalletViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletViewTheme {
                Scaffold(modifier = Modifier.fillMaxWidth(),
                    containerColor = Color(0xFFFCFCFC)) {
                        innerPadding ->     WalletViewScreen(Modifier.padding(innerPadding))}
                // Scaffold le da espacio para que no se tape con la barra de arriba
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Aquí mostramos nuestra pantalla con las gráficas
                    WalletViewScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WalletViewTheme {
        Scaffold(modifier = Modifier.fillMaxWidth(),
            containerColor = Color(0xFFFCFCFC)) {
                innerPadding ->     WalletViewScreen(Modifier.padding(innerPadding))}
        WalletViewScreen()
    }
}
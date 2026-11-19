package com.example.walletview.ui.theme.GastosMes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate


@Composable
fun Graficaredonda(gastos: List<Gasto>){
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        factory = {context ->
            PieChart(context)
        },
        update = { chart ->
            // Convertimos cada gasto en una "rebanada"
            val entradas = gastos.map { PieEntry(it.monto, it.categoria) }

            val dataSet = PieDataSet(entradas, "GASTOS AL MES").apply {
                colors = ColorTemplate.MATERIAL_COLORS.toList() // Colores de las rebanadas
                valueTextSize = 14f
            }

            chart.data = PieData(dataSet)
            chart.description.isEnabled = false
            chart.animateY(1000)
            chart.invalidate()
        }
    )

}

@Composable
fun GraficaBarra(gastos: List<Gasto>){
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        factory = {context-> BarChart(context)},
        update = { chart ->
            val entradas = gastos.mapIndexed { i, g -> BarEntry(i.toFloat(), g.monto) }

           // Spacer(modifier = Modifier.height(30.dp))

            val dataSet = BarDataSet(entradas, "Gastos por categoría").apply {
                colors = ColorTemplate.MATERIAL_COLORS.toList()
            }
            chart.data = BarData(dataSet)
            // Ponemos los nombres de las categorías abajo de cada barra
            chart.xAxis.valueFormatter = IndexAxisValueFormatter(gastos.map { it.categoria })
            chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
            chart.description.isEnabled = false
            chart.animateY(1000)
            chart.invalidate()

        }
    )
}

@Composable
fun WalletViewScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp)
        .background(Color.White)) {
        Spacer(modifier = Modifier.height(40.dp))//espacio
        Text("WalletView", style = MaterialTheme.typography.headlineMedium,
            color = Color.Black)//color de texto
        Graficaredonda(gastos)
        GraficaBarra(gastos)

    }
}



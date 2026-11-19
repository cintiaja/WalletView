package com.example.walletview.ui.theme.GastosMes

import kotlin.collections.listOf
data class Gasto (val categoria: String, val monto: Float)

val gastos = listOf(
    Gasto("comida", 2500f ),
    Gasto("Transporte", 1200f),
    Gasto("Renta", 5000f),
    Gasto("necesarios(agua, gas, etc)", 2000f)
)





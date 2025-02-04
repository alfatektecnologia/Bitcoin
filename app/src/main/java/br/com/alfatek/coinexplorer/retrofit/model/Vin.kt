package br.com.alfatek.coinexplorer.retrofit.model

data class Vin(
    val coinbase: String,
    val sequence: Long,
    val txinwitness: List<String>
)
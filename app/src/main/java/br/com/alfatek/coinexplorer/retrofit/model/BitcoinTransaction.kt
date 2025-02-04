package br.com.alfatek.coinexplorer.retrofit.model

data class BitcoinTransaction(
    val hash: String,
    val locktime: Int,
    val size: Int,
    val txid: String,
    val version: Int,
    val vin: List<Vin>,
    val vout: List<Vout>,
    val vsize: Int,
    val weight: Int
)
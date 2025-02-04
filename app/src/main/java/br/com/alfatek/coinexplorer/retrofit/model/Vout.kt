package br.com.alfatek.coinexplorer.retrofit.model

data class Vout(
    val n: Int,
    val scriptPubKey: ScriptPubKey,
    val value: String
)
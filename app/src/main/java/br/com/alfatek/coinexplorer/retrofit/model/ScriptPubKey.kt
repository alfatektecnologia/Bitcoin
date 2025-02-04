package br.com.alfatek.coinexplorer.retrofit.model

data class ScriptPubKey(
    val address: String,
    val asm: String,
    val desc: String,
    val hex: String,
    val type: String
)
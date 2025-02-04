package br.com.alfatek.coinexplorer.retrofit.model

data class BitcoinTransaction(
    val bits: String,
    val chainwork: String,
    val confirmations: Int,
    val difficulty: String,
    val hash: String,
    val height: Int,
    val mediantime: Int,
    val merkleroot: String,
    val nTx: Int,
    val nextblockhash: String,
    val nonce: Int,
    val previousblockhash: String,
    val size: Int,
    val strippedsize: Int,
    val time: Int,
    val tx: List<String>,
    val version: Int,
    val versionHex: String,
    val weight: Int
)
package br.com.alfatek.coinexplorer.retrofit.model

import br.com.alfatek.coinexplorer.retrofit.ApiService

data class BlockchainInfo(
    val bestblockhash: String,
    val blocks: Int,
    val chain: String,
    val chainwork: String,
    val difficulty: Double,
    val headers: Int,
    val initialblockdownload: Boolean,
    val mediantime: Int,
    val pruned: Boolean,
    val size_on_disk: Int,
    val time: Int,
    val verificationprogress: Int,
    val warnings: List<Any>
)
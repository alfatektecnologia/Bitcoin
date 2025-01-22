package br.com.alfatek.coinexplorer.presentation.state

import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo

data class BlockInfoState(
    val isLoading: Boolean = false,
    val data: BlockchainInfo? = null,
    var error: String = ""
) {
}
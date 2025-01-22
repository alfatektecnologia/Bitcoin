package br.com.alfatek.coinexplorer.retrofit

import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo

interface Repository{

    suspend fun getBlockInfo(): BlockchainInfo
}

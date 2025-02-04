package br.com.alfatek.coinexplorer.retrofit

import br.com.alfatek.coinexplorer.retrofit.model.BitcoinBalance
import br.com.alfatek.coinexplorer.retrofit.model.BitcoinTransaction
import br.com.alfatek.coinexplorer.retrofit.model.Block
import br.com.alfatek.coinexplorer.retrofit.model.BlockHash
import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo

interface Repository{

    suspend fun getBlockInfo(): BlockchainInfo

    suspend fun getBalance(address: String): BitcoinBalance

    suspend fun getTransaction(hash: String): BitcoinTransaction

    suspend fun getBlockHash(block: String): BlockHash

    suspend fun getBlock(block: String): Block
}

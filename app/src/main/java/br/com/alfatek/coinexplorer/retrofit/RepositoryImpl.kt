package br.com.alfatek.coinexplorer.retrofit

import br.com.alfatek.coinexplorer.retrofit.model.BitcoinBalance
import br.com.alfatek.coinexplorer.retrofit.model.BitcoinTransaction
import br.com.alfatek.coinexplorer.retrofit.model.Block
import br.com.alfatek.coinexplorer.retrofit.model.BlockHash
import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val apiService: ApiService): Repository {

    override suspend fun getBlockInfo(): BlockchainInfo {

            return withContext(Dispatchers.IO){
                val response = apiService.getBitcoinInfo()
                return@withContext response.body() ?: throw Exception("Error")
            }

    }

    override suspend fun getBalance(address: String): BitcoinBalance {
        return withContext(Dispatchers.IO){
            val response = apiService.getBalance(address)
            return@withContext response.body() ?: throw Exception("Error")
        }
    }

    override suspend fun getTransaction(hash: String): BitcoinTransaction {
        return withContext(Dispatchers.IO){
            val response = apiService.getTransaction(hash)
            return@withContext response.body() ?: throw Exception("Error")
        }
    }

    override suspend fun getBlockHash(block: String): BlockHash {
        return withContext(Dispatchers.IO){
            val response = apiService.getBlockHash(block)
            return@withContext response.body() ?: throw Exception("Error")
        }
    }

    override suspend fun getBlock(block: String): Block {
        return withContext(Dispatchers.IO){
            val response = apiService.getBlock(block)
            return@withContext response.body() ?: throw Exception("Error")
        }
    }

}
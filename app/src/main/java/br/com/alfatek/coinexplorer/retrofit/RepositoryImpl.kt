package br.com.alfatek.coinexplorer.retrofit

import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val apiService: ApiService): Repository {
    override suspend fun getBlockInfo(): BlockchainInfo {
        return apiService.getBitcoinInfo()
    }
}
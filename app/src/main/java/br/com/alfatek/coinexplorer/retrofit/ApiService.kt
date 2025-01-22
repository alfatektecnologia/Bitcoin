package br.com.alfatek.coinexplorer.retrofit

import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiService {

    @GET("getblockchaininfo")
    suspend fun getBitcoinInfo(): BlockchainInfo

    companion object{
        const val BASE_URL = "https://shisatoshi.758206.xyz:5000/"
    }
}


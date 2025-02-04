package br.com.alfatek.coinexplorer.retrofit

import br.com.alfatek.coinexplorer.retrofit.model.BitcoinBalance
import br.com.alfatek.coinexplorer.retrofit.model.BitcoinTransaction
import br.com.alfatek.coinexplorer.retrofit.model.Block
import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ApiService {

    @GET("getblockchaininfo")
    suspend fun getBitcoinInfo(): Response<BlockchainInfo>

    @GET("getbalance")
    suspend fun getBalance(@Query("address") address: String): Response<BitcoinBalance>

    @GET("gettransaction")
    suspend fun getTransaction(@Query("txid") hash: String): Response<BitcoinTransaction>

    @GET("getblockhash")
    suspend fun getBlock(@Query("height") block: String): Response<Block>

    companion object{
        const val BASE_URL = "https://shisatoshi.758206.xyz:5000/"
    }
}


package br.com.alfatek.coinexplorer.di

import android.util.Log
import br.com.alfatek.coinexplorer.retrofit.ApiService
import br.com.alfatek.coinexplorer.retrofit.ApiService.Companion.BASE_URL
import br.com.alfatek.coinexplorer.retrofit.Repository
import br.com.alfatek.coinexplorer.retrofit.RepositoryImpl
import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providerRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit) : ApiService {
        return  retrofit.create(ApiService::class.java)
//        }catch (e:Exception){
//            Log.d("RETROFIT ERROR","Erro acessando servidor remoto", null)
//            BlockchainInfo(
//                chain = "regtest",
//                blocks = 184,
//                headers = 184,
//                bestblockhash = "4d631d728e7f95c8934517935bfbc6cbb5c4f3eb6c0f588b9b1484abc3e82ff3",
//                difficulty = 4.656542373906925e-10,
//                time = 1736803578,
//                mediantime = 1736799078,
//                verificationprogress = 1,
//                initialblockdownload = false,
//                chainwork = "0000000000000000000000000000000000000000000000000000000000000172",
//                size_on_disk = 55166,
//                pruned = false,
//                warnings = emptyList(),
//            )
//        }
    }

    @Provides
    @Singleton
    fun providerRepositoryImpl(apiService: ApiService) : Repository {
        return RepositoryImpl(apiService)
    }

}
package br.com.alfatek.coinexplorer.di

import br.com.alfatek.coinexplorer.retrofit.ApiService
import br.com.alfatek.coinexplorer.retrofit.ApiService.Companion.BASE_URL
import br.com.alfatek.coinexplorer.retrofit.Repository
import br.com.alfatek.coinexplorer.retrofit.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .retryOnConnectionFailure(true)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit{
        val okHttpClient: OkHttpClient = provideOkHttpClient()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return  retrofit.create(ApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService) : Repository {
        return RepositoryImpl(apiService)
    }

}
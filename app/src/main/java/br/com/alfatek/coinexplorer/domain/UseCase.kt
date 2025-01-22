package br.com.alfatek.coinexplorer.domain

import br.com.alfatek.coinexplorer.retrofit.RepositoryImpl
import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import perfetto.protos.UiState
import javax.inject.Inject

class UseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {

    operator fun invoke(): Flow<UiState<BlockchainInfo>> = flow{
        emit(UiState.Loading())
        try {
            emit(UiState.Success(data = repositoryImpl.getBlockInfo()))
        } catch (e: Exception){
            emit(UiState.Error(message= e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)
}
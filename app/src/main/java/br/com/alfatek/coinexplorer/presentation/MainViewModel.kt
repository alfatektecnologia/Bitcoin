package br.com.alfatek.coinexplorer.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alfatek.coinexplorer.domain.UseCase
import br.com.alfatek.coinexplorer.retrofit.Repository
import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val repository: Repository): ViewModel() {

    private val _info = MutableLiveData<BlockchainInfo>()
    val info:LiveData<BlockchainInfo> get() = _info

   init {
        viewModelScope.launch {
            _info.postValue(repository.getBlockInfo())
        }
    }

}
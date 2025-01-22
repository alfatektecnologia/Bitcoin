package br.com.alfatek.coinexplorer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BlockchainInfoScreen(viewModel: MainViewModel = hiltViewModel()) {
    val blockchainInfo by viewModel.info.observeAsState()

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Text(text = "Blockchain Info")
        blockchainInfo?.let {
            Text(text = "Chain: ${it.chain}")
            Text(text = "Blocks: ${it.blocks}")
            // Add more fields as necessary
        }
    }
}

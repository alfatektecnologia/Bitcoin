package br.com.alfatek.coinexplorer

import android.app.Application
import android.app.PendingIntent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alfatek.coinexplorer.presentation.MainViewModel
import br.com.alfatek.coinexplorer.ui.theme.CoinExplorerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CoinExplorerTheme {
                val blockchainInfo by viewModel.info.observeAsState()

//                LaunchedEffect(Unit) {
//                    viewModel.fetchBlockchainInfo()
//                }

                blockchainInfo?.let { info ->
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Chain: ${info.chain}")
                        Text(text = "Blocks: ${info.blocks}")
                        Text(text = "Headers: ${info.headers}")
                        // Display other fields as needed
                    }
                }
            }
        }
    }
}


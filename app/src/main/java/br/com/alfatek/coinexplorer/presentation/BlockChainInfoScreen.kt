package br.com.alfatek.coinexplorer.presentation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BlockchainInfoScreen(viewModel: MainViewModel = hiltViewModel()) {
    val blockchainInfo by viewModel.info.observeAsState()
    val blockHash by viewModel.block.observeAsState()
    val transaction by viewModel.transaction.observeAsState()
    val balance by viewModel.balance.observeAsState()

    var texto= remember{ mutableStateOf("N/A") }
    var search = remember{ mutableStateOf("N/A") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
           //.verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        )
    {

        TextField(
            value = texto.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onValueChange = { texto.value = it },
            label = { Text(checkTexto(texto.value))
                    },
            trailingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(enabled = true, onClick = { search.value = checkTexto(texto.value) })
                       // .enabled(texto?.isNotEmpty() ?: false)
                        ) })
        when (search.value) {
            "Block" -> {

                viewModel.getBlock(texto.value)
                BlockInfoCard(blockHash)
            }
            "Transaction" -> {

                viewModel.getTransaction(texto.value)
                BitcoinTransactionCard(transaction)
            }
            "Wallet" -> {
                viewModel.getBalance(texto.value)
              BitcoinBalanceCard(balance)
            }
            else -> {
                BlockChainInfoCard(blockchainInfo)
            }
        }



    }

}


fun checkTexto(text: String): String {
    lateinit var operation: String
    if (text.length > 44) {
        operation = "Transaction"
    } else if (text.all { it.isDigit() }) {
        operation = "Block"
    } else if (text.length > 30 && text.length == 44) {
        operation = "Wallet"
    } else {
        operation = "N/A"
    }

    return operation
}


fun isValidBitcoinAddress(address: String): Boolean {
    val legacyPattern = "^(bcrt1|[13])[a-km-zA-HJ-NP-Z1-9]{25,34}\$".toRegex()
    val bech32Pattern = "^(bc1)[a-zA-HJ-NP-Z0-9]{25,39}$".toRegex()

    return legacyPattern.matches(address) || bech32Pattern.matches(address)
}

package br.com.alfatek.coinexplorer.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.alfatek.coinexplorer.common.Util.checkTexto

@Composable
fun BlockchainInfoScreen(viewModel: MainViewModel = hiltViewModel()) {
    val blockchainInfo by viewModel.info.observeAsState()
    val blockHash by viewModel.blockHash.observeAsState()
    val transaction by viewModel.transaction.observeAsState()
    val balance by viewModel.balance.observeAsState()
    val block by viewModel.block.observeAsState()
    val blockState = remember { mutableStateOf(true) }
    val transactionState = remember { mutableStateOf(false) }
    val walletState = remember { mutableStateOf(false) }
    val searchType = remember { mutableStateOf("Block") }
    var isBlockHash = false
    var isBlock = false
    var isTransaction = false
    var isWallet  = false
    val texto = remember { mutableStateOf("N/A") }
    val search = remember { mutableStateOf("Info") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        )
    {

        Card(modifier = Modifier.padding(8.dp)) {

            Column(Modifier.selectableGroup()) {

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = blockState.value,
                                    onClick = {
                                        blockState.value = !blockState.value
                                        transactionState.value = false
                                        walletState.value = false
                                        searchType.value = "Block"
                                        texto.value = "N/A"
                                    }
                                )
                                Text(
                                    text = "Block",
                                    style = MaterialTheme.typography.bodyLarge,
                                    //modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = transactionState.value,
                                onClick = {
                                    transactionState.value = !transactionState.value
                                    blockState.value = false
                                    walletState.value = false
                                    searchType.value = "Transaction"
                                    texto.value = "N/A"
                                }
                            )
                            Text(
                                text = "Transaction",
                                style = MaterialTheme.typography.bodyLarge,
                                //modifier = Modifier.padding(start = 8.dp)
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = walletState.value,
                                onClick = {
                                    walletState.value = !walletState.value
                                    blockState.value = false
                                    transactionState.value = false
                                    searchType.value = "Wallet"
                                    texto.value = "N/A"
                                } // null recommended for accessibility with screenreaders
                            )
                            Text(
                                text = "Wallet",
                                style = MaterialTheme.typography.bodyLarge,
                               // modifier = Modifier.padding(start = 8.dp)
                            )
                        }


                    }
                Spacer(Modifier.height(16.dp))
                TextField(
                    value = texto.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 2.dp, color = Color.Gray)
                        
                        .padding(16.dp),
                    onValueChange = { texto.value = it },

                    label = {
                        //Text(checkTexto(texto.value))
                    },
                    shape = OutlinedTextFieldDefaults.shape,
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable(
                                    enabled = true,
                                    onClick = { search.value = callRepo(searchType.value,texto,viewModel)})
                            // .enabled(texto?.isNotEmpty() ?: false)
                        )
                    }
                )
                Spacer(Modifier.height(16.dp))

            }

        }

        if (blockHash != null && search.value == "BlockHash") {
            BlockHashInfoCard(blockHash)
        }
        if (block != null && search.value == "Block") {
            BlockInfoCard(block)
        }
        if (transaction != null && search.value == "Transaction") {
            BitcoinTransactionCard(transaction)
        }
        if (balance != null && search.value == "Balance") {
            BitcoinBalanceCard(balance)
        }
        if (blockchainInfo != null && search.value == "Info") {
            BlockChainInfoCard(blockchainInfo)
        }




    }

}


fun callRepo(text: String, texto: MutableState<String>, viewModel: MainViewModel): String {
    when (text) {
        "Block" -> {
            if (texto.value.all { it.isDigit() }) {
                viewModel.getBlockHash(texto.value)
                return "BlockHash"
            } else {
                viewModel.getBlock(texto.value)
               return "Block"
            }

        }

        "Transaction" -> {
            viewModel.getTransaction(texto.value)
            return "Transaction"
        }

        "Wallet" -> {
            viewModel.getBalance(texto.value)
           return "Balance"
        }

        else -> {
           return "Info"
        }
    }
}





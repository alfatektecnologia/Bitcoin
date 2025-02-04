package br.com.alfatek.coinexplorer.presentation

import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
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
    val blockState = remember { mutableStateOf(false) }
    val transactionState = remember { mutableStateOf(false) }
    val walletState = remember { mutableStateOf(false) }
    val searchType = remember { mutableStateOf("N/A") }

    val texto = remember { mutableStateOf("N/A") }
    val search = remember { mutableStateOf("N/A") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        )
    {

        Card(modifier = Modifier.padding(8.dp)) {
//            val radioOptions = listOf("Block", "Transaction", "Wallet")
//            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

            Column(Modifier.selectableGroup()) {
                //radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            // .selectable(
                             //   selected = (text == selectedOption),
                            //    onClick = { onOptionSelected(text) },
                            //    role = Role.RadioButton
                           // )
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                            RadioButton(
                                selected = blockState.value,
                                onClick = {
                                    blockState.value = !blockState.value
                                    transactionState.value = false
                                    walletState.value = false
                                    searchType.value = "Block"
                                }
                            )
                            Text(
                                text = "Block",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        RadioButton(
                            selected = transactionState.value,
                            onClick = {
                                transactionState.value = !transactionState.value
                                blockState.value = false
                                walletState.value = false
                                searchType.value = "Transaction"
                            }
                        )
                        Text(
                            text = "Transaction",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        RadioButton(
                            selected = walletState.value,
                            onClick = {
                                walletState.value = !walletState.value
                                blockState.value = false
                                transactionState.value = false
                                searchType.value = "Wallet"
                            } // null recommended for accessibility with screenreaders
                        )
                        Text(
                            text = "Wallet",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 8.dp)
                        )

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
                        Text(checkTexto(texto.value))
                    },
                    shape = OutlinedTextFieldDefaults.shape,
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable(
                                    enabled = true,
                                    onClick = { search.value = searchType.value })
                            // .enabled(texto?.isNotEmpty() ?: false)
                        )
                    }
                )

            }

        }




        when (search.value) {
            "Block" -> {
                if (texto.value.all { it.isDigit() }) {
                    viewModel.getBlockHash(texto.value)
                    BlockHashInfoCard(blockHash)
                } else {
                    viewModel.getBlock(texto.value)
                    BlockInfoCard(block)
                }

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





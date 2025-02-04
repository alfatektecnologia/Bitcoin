package br.com.alfatek.coinexplorer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alfatek.coinexplorer.retrofit.model.BitcoinTransaction

@Composable
fun BitcoinTransactionCard(transaction: BitcoinTransaction?) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = transaction?.hash ?: "N/A",
                onValueChange = {},
                label = { Text("Hash") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.locktime?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Locktime") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.size?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Size") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.txid ?: "N/A",
                onValueChange = {},
                label = { Text("Txid") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.version?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Version") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.vin?.joinToString(", ") { it.coinbase } ?: "N/A",
                onValueChange = {},
                label = { Text("Vin Coinbase") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.vout?.joinToString(", ") { it.value } ?: "N/A",
                onValueChange = {},
                label = { Text("Vout Value") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.vsize?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Vsize") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.weight?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Weight") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
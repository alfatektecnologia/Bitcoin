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
                value = transaction?.bits ?: "N/A",
                onValueChange = {},
                label = { Text("Bits") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.chainwork ?: "N/A",
                onValueChange = {},
                label = { Text("Chainwork") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.confirmations?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Confirmations") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.difficulty ?: "N/A",
                onValueChange = {},
                label = { Text("Difficulty") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.hash ?: "N/A",
                onValueChange = {},
                label = { Text("Hash") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.height?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Height") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.mediantime?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Median Time") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.merkleroot ?: "N/A",
                onValueChange = {},
                label = { Text("Merkle Root") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.nTx?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Number of Transactions") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.nextblockhash ?: "N/A",
                onValueChange = {},
                label = { Text("Next Block Hash") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.nonce?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Nonce") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.previousblockhash ?: "N/A",
                onValueChange = {},
                label = { Text("Previous Block Hash") },
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
                value = transaction?.strippedsize?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Stripped Size") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.time?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Time") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = transaction?.tx?.joinToString(", ") ?: "N/A",
                onValueChange = {},
                label = { Text("Transactions") },
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
                value = transaction?.versionHex ?: "N/A",
                onValueChange = {},
                label = { Text("Version Hex") },
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
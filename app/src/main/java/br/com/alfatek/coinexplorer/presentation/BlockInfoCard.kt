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
import br.com.alfatek.coinexplorer.retrofit.model.Block
@Composable
fun BlockInfoCard(blockInfo: Block?) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = blockInfo?.bits ?: "N/A",
                onValueChange = {},
                label = { Text("Bits") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.chainwork ?: "N/A",
                onValueChange = {},
                label = { Text("Chainwork") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.confirmations?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Confirmations") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.difficulty ?: "N/A",
                onValueChange = {},
                label = { Text("Difficulty") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.hash ?: "N/A",
                onValueChange = {},
                label = { Text("Hash") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.height?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Height") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.mediantime?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Mediantime") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.merkleroot ?: "N/A",
                onValueChange = {},
                label = { Text("Merkleroot") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.nTx?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Number of Transactions") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.nonce?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Nonce") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.previousblockhash ?: "N/A",
                onValueChange = {},
                label = { Text("Previous Block Hash") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.size?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Size") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.strippedsize?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Stripped Size") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.time?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Time") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.tx?.joinToString(", ") ?: "N/A",
                onValueChange = {},
                label = { Text("Transactions") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.version?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Version") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.versionHex ?: "N/A",
                onValueChange = {},
                label = { Text("Version Hex") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = blockInfo?.weight?.toString() ?: "N/A",
                onValueChange = {},
                label = { Text("Weight") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
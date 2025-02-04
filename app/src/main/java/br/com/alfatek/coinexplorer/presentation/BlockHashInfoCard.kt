package br.com.alfatek.coinexplorer.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.alfatek.coinexplorer.retrofit.model.BlockHash

@Composable
fun BlockHashInfoCard(blockHash: BlockHash?) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Block Hash:",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            blockHash?.blockhash?.let {
                TextField(
                    readOnly = true,
                    value = it,
                    onValueChange = {},
                    label = { Text("Block Hash") }
                )
            }
        }
    }
}
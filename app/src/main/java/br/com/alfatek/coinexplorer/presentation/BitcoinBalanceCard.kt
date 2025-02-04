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
import br.com.alfatek.coinexplorer.retrofit.model.BitcoinBalance

@Composable
fun BitcoinBalanceCard(balance: BitcoinBalance?) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = balance?.address ?: "N/A",
                onValueChange = {},
                label = { Text("Address") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = balance?.balance ?: "N/A",
                onValueChange = {},
                label = { Text("Balance") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
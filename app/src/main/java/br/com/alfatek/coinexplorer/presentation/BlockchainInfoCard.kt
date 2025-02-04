package br.com.alfatek.coinexplorer.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import br.com.alfatek.coinexplorer.retrofit.model.BlockchainInfo


@Composable
fun BlockChainInfoCard(blockChainInfo: BlockchainInfo?) {
    Text("Blockchain Info", fontSize = TextUnit(value = 24.0f,type= Sp))
    Card(
        modifier = Modifier.padding(8.dp).background(color = Color.Gray)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                //.verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            ) {
            //Text("Best Block Hash: ")
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .selectable(selected = false, enabled = true, onClick = {  })
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray)
                ,
                value = blockChainInfo?.bestblockhash ?: "N/A",
                onValueChange = {  },
                label = { Text("Best Block Hash") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray)
                ,
                value = blockChainInfo?.blocks.toString() ?: "0",
                onValueChange = {  },
                label = { Text("Blocks") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray),
                value = blockChainInfo?.chain ?: "N/A",
                onValueChange = {  },
                label = { Text("Chain") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray),
                value = blockChainInfo?.difficulty.toString() ?: "0.0",
                onValueChange = {  },
                label = { Text("Difficulty") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray),
                value = blockChainInfo?.headers.toString() ?: "0",
                onValueChange = {  },
                label = { Text("Headers") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray),
                value = blockChainInfo?.mediantime.toString() ?: "0",
                onValueChange = {  },
                label = { Text("Median Time") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray),
                value = blockChainInfo?.size_on_disk.toString() ?: "0",
                onValueChange = {  },
                label = { Text("Size on Disk: ") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color= Color.Red)
                    .border(width = 2.dp, color = Color.LightGray),
                value = blockChainInfo?.verificationprogress.toString() ?: "0.0",
                onValueChange = {  },
                label = { Text("Verification Progress: ") },
                readOnly = true,
                shape = OutlinedTextFieldDefaults.shape
            )

        }
    }
}
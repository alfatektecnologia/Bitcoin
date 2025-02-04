package br.com.alfatek.coinexplorer.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import br.com.alfatek.coinexplorer.R
import br.com.alfatek.coinexplorer.ui.theme.CoinExplorerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

   // val scrollState = rememberScrollState(50)
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val navItemList = listOf(
        NavItem(label = "Explorer", route = "home", icon = R.drawable.search_24),
        NavItem(label = "Wallet", route = "wallet", icon = R.drawable.wallet_24),
        NavItem(label = "Register", route = "register", icon = R.drawable.registration_24),
    )
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),

        topBar = { CenterAlignedTopAppBar(
            title = {Text(text = "CoinExplorer", textAlign = TextAlign.Center)}) },
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex==index,
                        onClick = {selectedIndex=index},
                        label = {Text(text = navItem.label)},
                        icon = { Icon(painter = painterResource(id = navItem.icon), contentDescription = "icon") }
                    )
                }
            }
        }
        ){innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
        ) {

            CoinExplorerTheme {
                BlockchainInfoScreen()
            }
        }
    }
}


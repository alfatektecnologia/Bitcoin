package br.com.alfatek.coinexplorer.common

object Util {

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
}
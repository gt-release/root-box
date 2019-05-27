package jp.co.takawagu.rootBox.model

import java.math.BigDecimal

data class Menu(
        val code: String,
        val name: String,
        val price: BigDecimal,
        val kcal: Int,
        val category: String) {
    val taxInPrice: BigDecimal = price + Tax.tax(price)
}
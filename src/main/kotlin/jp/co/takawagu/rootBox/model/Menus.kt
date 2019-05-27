package jp.co.takawagu.rootBox.model

import java.math.BigDecimal

class Menus {

    val list: MutableList<Menu> = mutableListOf()

    fun totalPrice() = list.map { it.price }.fold(BigDecimal.ZERO, BigDecimal::add)

    fun totalTaxInPrice() = list.map { it.taxInPrice }.fold(BigDecimal.ZERO, BigDecimal::add)

    fun totalKcal() = list.map { it.kcal }.sum()

    fun add(menu: Menu) = list.add(menu)

    fun serialize() = list.map { it.code }.joinToString(separator = ",")

}
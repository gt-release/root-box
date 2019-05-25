package jp.co.takawagu.rootBox.model

import java.math.BigDecimal

class Menus {
    private val menus: MutableList<Menu> = mutableListOf()

    fun getList(): List<Menu> {
        return menus
    }

    fun totalPrice() = menus.map { it.price }.fold(BigDecimal.ZERO, BigDecimal::add)

    fun totalKcal() = menus.map { it.kcal }.sum()

    fun add(menu: Menu) = menus.add(menu)

}
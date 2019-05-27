package jp.co.takawagu.rootBox.service

import jp.co.takawagu.rootBox.mapper.MenuMapper
import jp.co.takawagu.rootBox.model.Menus
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class MenuService(
        private val menuMapper: MenuMapper
) {

    fun pickUpRandomAll(price: BigDecimal): Menus {
        val menus = Menus()
        var tempPrice = price
        val allMenus = menuMapper.selectAll()
        while (true) {
            val menu = allMenus.filter { it.taxInPrice < tempPrice }.shuffled().firstOrNull()
                    ?: return menus
            menus.add(menu)
            tempPrice -= menu.taxInPrice
        }
    }

    fun deserialize(serial: String): Menus {
        val menus = Menus()
        serial.split(",").map { menuMapper.select(it) }.forEach { menus.add(it) }
        return menus
    }
}
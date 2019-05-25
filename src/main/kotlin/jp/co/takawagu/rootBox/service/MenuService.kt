package jp.co.takawagu.rootBox.service

import jp.co.takawagu.rootBox.mapper.MenuMapper
import jp.co.takawagu.rootBox.model.Menu
import jp.co.takawagu.rootBox.model.Menus
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class MenuService(
        private val menuMapper: MenuMapper
) {
    fun pickUpRandom(price: BigDecimal): Menu? {
        val menuList = menuMapper.selectDownPriceMenu(price)
        return menuList.shuffled().firstOrNull()
    }

    fun pickUpRandomAll(price: BigDecimal): Menus {
        val menus = Menus()

        var tempPrice = price
        while (true) {
            val menu = pickUpRandom(tempPrice) ?: return menus
            menus.add(menu)
            tempPrice -= menu.price
        }
    }
}
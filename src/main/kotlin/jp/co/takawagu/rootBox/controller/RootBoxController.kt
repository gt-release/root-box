package jp.co.takawagu.rootBox.controller

import jp.co.takawagu.rootBox.service.MenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class RootBoxController(
        val menuService: MenuService
) {

    @RequestMapping("result")
    fun result(
            @RequestParam(value = "price", required = false, defaultValue = "1000") price: String,
            model: Model): String {
        val priceDecimal = price.toBigDecimal()
        model.addAttribute("menus", menuService.pickUpRandomAll(priceDecimal))
        return "result"
    }
}
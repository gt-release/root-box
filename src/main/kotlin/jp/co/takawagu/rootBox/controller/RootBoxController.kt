package jp.co.takawagu.rootBox.controller

import jp.co.takawagu.rootBox.model.Menus
import jp.co.takawagu.rootBox.service.MenuService
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Controller
class RootBoxController(
        private val menuService: MenuService,
        private val redisTemplate: StringRedisTemplate
) {
    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("uuid", UUID.randomUUID().toString())
        return "index"
    }

    @RequestMapping("result")
    fun result(
            @RequestParam(value = "price", required = true) price: String,
            @RequestParam(value = "uuid", required = true) uuid: String,
            model: Model): String {
        val menus: Menus
        val serial = redisTemplate.opsForValue().get(uuid)
        if (serial == null) {
            menus = menuService.pickUpRandomAll(price.toBigDecimal())
            redisTemplate.opsForValue().set(uuid, menus.serialize())
        } else {
            menus = menuService.deserialize(serial)
        }
        model.addAttribute("menus", menus)
        model.addAttribute("uuid", UUID.randomUUID().toString())
        return "result"
    }
}
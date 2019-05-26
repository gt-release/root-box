package jp.co.takawagu.rootBox.model

import java.math.BigDecimal
import java.math.RoundingMode

object Tax {
    private val TAX_RATE = BigDecimal.valueOf(8)
    val tax = { it: BigDecimal ->
        (it * TAX_RATE).scaleByPowerOfTen(-2).setScale(0, RoundingMode.DOWN)
    }
}

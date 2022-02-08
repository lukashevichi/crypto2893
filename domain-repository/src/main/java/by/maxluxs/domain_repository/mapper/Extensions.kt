package by.maxluxs.domain_repository.mapper

import java.math.RoundingMode
import java.text.DecimalFormat

internal fun Double.roundToString(): String {
    val df = DecimalFormat("#.####")
    df.roundingMode = RoundingMode.CEILING
    return df.format(this)
}
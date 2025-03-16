package jp.shirataki.sharedelementtransition

import androidx.annotation.DrawableRes

data class Mountain(
    val name: String,
    val area: String,
    val description: String,
    @DrawableRes val imageRes: Int,
)

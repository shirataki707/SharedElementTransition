package jp.shirataki.sharedelementtransition.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Mountain(
    val id: Int,
    val name: String,
    val area: String,
    val description: String,
    @DrawableRes val imageRes: Int,
    @DrawableRes val iconRes: Int,
) : Parcelable

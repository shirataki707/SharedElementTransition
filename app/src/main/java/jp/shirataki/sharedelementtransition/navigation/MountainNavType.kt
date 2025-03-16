package jp.shirataki.sharedelementtransition.navigation

import android.net.Uri
import android.os.Bundle
import androidx.core.os.BundleCompat
import androidx.navigation.NavType
import jp.shirataki.sharedelementtransition.data.Mountain
import kotlinx.serialization.json.Json

object MountainNavType : NavType<Mountain>(
    isNullableAllowed = false
) {
    override fun put(bundle: Bundle, key: String, value: Mountain) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): Mountain {
        return requireNotNull(BundleCompat.getParcelable(bundle, key, Mountain::class.java))
    }

    override fun serializeAsValue(value: Mountain): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun parseValue(value: String): Mountain {
        return Json.decodeFromString(value)
    }
}

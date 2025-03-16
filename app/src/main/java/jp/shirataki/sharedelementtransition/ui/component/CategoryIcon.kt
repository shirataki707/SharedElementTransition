package jp.shirataki.sharedelementtransition.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import jp.shirataki.sharedelementtransition.ui.sharedElement.easySharedElement

@Composable
fun CategoryIcon(
    sharedTransitionKey: String,
    @DrawableRes iconRes: Int,
    categoryIconSize: Dp,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .easySharedElement(key = sharedTransitionKey)
            .size(categoryIconSize)
            .background(Color.DarkGray)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = "mountain",
            tint = Color.White,
            modifier = Modifier
                .size(categoryIconSize * 0.6f)
                .align(Alignment.BottomStart)
                .padding(8.dp),
        )
    }
}

package jp.shirataki.sharedelementtransition.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import jp.shirataki.sharedelementtransition.ui.sharedElement.easySharedElement

@Composable
fun ImageWithCategoryIcon(
    sharedTransitionImageKey: String,
    sharedTransitionCategoryKey: String,
    @DrawableRes imageRes: Int,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    imageHeight: Dp = 200.dp,
    categoryIconSize: Dp = 64.dp,
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .easySharedElement(key = sharedTransitionImageKey)
                .fillMaxWidth()
                .height(imageHeight)
        )
    }

    CategoryIcon(
        sharedTransitionKey = sharedTransitionCategoryKey,
        iconRes = iconRes,
        categoryIconSize = categoryIconSize,
        modifier = Modifier.offset(x = 16.dp, y = (-32).dp)
    )
}

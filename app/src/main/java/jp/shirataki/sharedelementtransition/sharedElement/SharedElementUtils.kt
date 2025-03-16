package jp.shirataki.sharedelementtransition.sharedElement

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Modifier.easySharedElement(key: Any): Modifier {
    with(LocalSharedTransitionScope.current) {
        return this@easySharedElement.sharedElement(
            state = rememberSharedContentState(key = key),
            animatedVisibilityScope = LocalAnimatedVisibilityScope.current
        )
    }
}

package jp.shirataki.sharedelementtransition.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import jp.shirataki.sharedelementtransition.data.Mountain
import jp.shirataki.sharedelementtransition.ui.screen.MountainDetailRoute
import jp.shirataki.sharedelementtransition.ui.screen.MountainDetailScreen
import jp.shirataki.sharedelementtransition.ui.screen.MountainRoute
import jp.shirataki.sharedelementtransition.ui.screen.MountainScreen
import jp.shirataki.sharedelementtransition.ui.screen.navigateToMountainDetail
import jp.shirataki.sharedelementtransition.ui.sharedElement.AnimatedVisibilityScopeProvider
import jp.shirataki.sharedelementtransition.ui.sharedElement.SharedTransitionScopeProvider
import kotlin.reflect.typeOf

private const val animationDurationMilliSeconds = 500

@Composable
fun SharedElementTransitionNavHost() {
    SharedTransitionScopeProvider {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = MountainRoute,
        ) {
            composable<MountainRoute> {
                AnimatedVisibilityScopeProvider(animatedVisibilityScope = this) {
                    MountainScreen(
                        onMountainClick = { mountain ->
                            navController.navigateToMountainDetail(mountain = mountain)
                        },
                    )
                }
            }

            composable<MountainDetailRoute>(
                typeMap = mapOf(
                    typeOf<Mountain>() to MountainNavType,
                ),
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(durationMillis = animationDurationMilliSeconds)
                    ) + fadeIn(animationSpec = tween(durationMillis = animationDurationMilliSeconds))
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = tween(durationMillis = animationDurationMilliSeconds)
                    ) + fadeOut(animationSpec = tween(durationMillis = animationDurationMilliSeconds))
                }
            ) { backStackEntry ->
                AnimatedVisibilityScopeProvider(animatedVisibilityScope = this) {
                    val mountain = backStackEntry.toRoute<MountainDetailRoute>().mountain
                    MountainDetailScreen(
                        mountain = mountain,
                        onBackPressed = {
                            navController.popBackStack()
                        },
                    )
                }
            }
        }
    }
}

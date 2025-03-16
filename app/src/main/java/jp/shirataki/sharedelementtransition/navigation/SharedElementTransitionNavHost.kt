package jp.shirataki.sharedelementtransition.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import jp.shirataki.sharedelementtransition.data.Mountain
import jp.shirataki.sharedelementtransition.screen.MountainDetailRoute
import jp.shirataki.sharedelementtransition.screen.MountainDetailScreen
import jp.shirataki.sharedelementtransition.screen.MountainRoute
import jp.shirataki.sharedelementtransition.screen.MountainScreen
import jp.shirataki.sharedelementtransition.screen.navigateToMountainDetail
import jp.shirataki.sharedelementtransition.sharedElement.AnimatedVisibilityScopeProvider
import jp.shirataki.sharedelementtransition.sharedElement.SharedTransitionScopeProvider
import kotlin.reflect.typeOf

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
                )
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

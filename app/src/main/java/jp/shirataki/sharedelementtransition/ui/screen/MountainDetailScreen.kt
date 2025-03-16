package jp.shirataki.sharedelementtransition.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import jp.shirataki.sharedelementtransition.data.Mountain
import jp.shirataki.sharedelementtransition.ui.component.ImageWithCategoryIcon
import kotlinx.serialization.Serializable

@Serializable
data class MountainDetailRoute(
    val mountain: Mountain,
)

fun NavController.navigateToMountainDetail(mountain: Mountain, navOptions: NavOptions? = null) {
    navigate(route = MountainDetailRoute(mountain = mountain), navOptions = navOptions)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MountainDetailScreen(
    mountain: Mountain,
    onBackPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed,
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = mountain.name,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(start = 16.dp, bottom = 32.dp)
            )

            ImageWithCategoryIcon(
                sharedTransitionImageKey = "image-${mountain.id}",
                sharedTransitionCategoryKey = "category-${mountain.id}",
                imageRes = mountain.imageRes,
                iconRes = mountain.iconRes,
                imageHeight = 250.dp,
                categoryIconSize = 80.dp,
                modifier = Modifier.padding(end = 32.dp)
            )

            Text(
                text = mountain.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

        }
    }
}


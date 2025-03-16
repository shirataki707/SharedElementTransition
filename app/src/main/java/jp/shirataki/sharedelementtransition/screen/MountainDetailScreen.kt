package jp.shirataki.sharedelementtransition.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import jp.shirataki.sharedelementtransition.data.Mountain
import jp.shirataki.sharedelementtransition.data.MountainDemoDataProvider
import jp.shirataki.sharedelementtransition.sharedElement.easySharedElement
import kotlinx.serialization.Serializable

@Serializable
data class MountainDetailRoute(
    val mountain: Mountain,
)

fun NavController.navigateToMountainDetail(mountain: Mountain, navOptions: NavOptions? = null) {
    navigate(route = MountainDetailRoute(mountain = mountain), navOptions = navOptions)
}

@Composable
fun MountainDetailScreen(
    mountain: Mountain = MountainDemoDataProvider.provideData().first(),
    onBackPressed: () -> Unit,
) {
    Column {
        Image(
            painter = painterResource(id = mountain.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .easySharedElement(key = "image-${mountain.id}")
                .fillMaxWidth()
                .height(240.dp),
        )
        Icon(
            painter = painterResource(id = mountain.iconRes),
            contentDescription = null,
            modifier = Modifier
                .easySharedElement(key = "icon-${mountain.id}")
                .padding(16.dp)
                .clickable { onBackPressed() },
        )
        Text(
            text = mountain.description
        )
    }
}


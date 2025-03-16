package jp.shirataki.sharedelementtransition.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.shirataki.sharedelementtransition.data.Mountain
import jp.shirataki.sharedelementtransition.data.MountainDemoDataProvider
import jp.shirataki.sharedelementtransition.ui.component.ImageWithCategoryIcon
import kotlinx.serialization.Serializable

@Serializable
data object MountainRoute

@Composable
fun MountainScreen(
    onMountainClick: (Mountain) -> Unit,
) {
    val mountains = MountainDemoDataProvider.provideData()

    Surface {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(mountains) { mountain ->
                MountainItem(
                    mountain = mountain,
                    onMountainClick = onMountainClick,
                )
            }
        }
    }
}

@Composable
private fun MountainItem(
    mountain: Mountain,
    onMountainClick: (Mountain) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(end = 32.dp)
            .clickable(onClick = { onMountainClick(mountain) })
    ) {
        ImageWithCategoryIcon(
            sharedTransitionImageKey = "image-${mountain.id}",
            sharedTransitionCategoryKey = "category-${mountain.id}",
            imageRes = mountain.imageRes,
            iconRes = mountain.iconRes,
        )

        Text(
            text = mountain.name,
            modifier = Modifier
                .offset(y = (-24).dp)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.titleLarge,
        )

        Text(
            text = mountain.area,
            modifier = Modifier
                .offset(y = (-16).dp)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

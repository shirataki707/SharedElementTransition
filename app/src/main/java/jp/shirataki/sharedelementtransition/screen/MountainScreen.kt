package jp.shirataki.sharedelementtransition.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import jp.shirataki.sharedelementtransition.data.Mountain
import jp.shirataki.sharedelementtransition.data.MountainDemoDataProvider
import jp.shirataki.sharedelementtransition.sharedElement.easySharedElement
import kotlinx.serialization.Serializable

@Serializable
data object MountainRoute

@Composable
fun MountainScreen(
    onMountainClick: (Mountain) -> Unit,
) {
    val mountains = MountainDemoDataProvider.provideData()

    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(mountains) { mountain ->
            MountainCard(
                mountain = mountain,
                onMountainClick = onMountainClick,
            )
        }
    }
}

@Composable
private fun MountainCard(
    mountain: Mountain,
    onMountainClick: (Mountain) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(end = 32.dp)
            .clickable(onClick = { onMountainClick(mountain) })
    ) {

        MountainImageWithIcon(mountain = mountain)

        Text(
            text = mountain.name,
            modifier = Modifier
                .offset(y = (-24).dp)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.labelLarge,
        )
        Text(
            text = mountain.area,
            modifier = Modifier
                .offset(y = (-16).dp)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Composable
private fun MountainIcon(
    mountain: Mountain,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .easySharedElement(key = "icon-${mountain.id}")
            .size(64.dp)
            .background(Color.DarkGray)
    ) {
        Icon(
            painter = painterResource(id = mountain.iconRes),
            contentDescription = "mountain",
            tint = Color.White,
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.BottomStart)
                .padding(8.dp),
        )
    }
}

@Composable
private fun MountainImageWithIcon(mountain: Mountain) {
    Column {
        Image(
            painter = painterResource(mountain.imageRes),
            contentDescription = mountain.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .easySharedElement(key = "image-${mountain.id}")
                .fillMaxWidth()
                .height(200.dp)
        )
    }

    MountainIcon(
        mountain = mountain,
        modifier = Modifier.offset(x = 16.dp, y = (-32).dp)
    )
}

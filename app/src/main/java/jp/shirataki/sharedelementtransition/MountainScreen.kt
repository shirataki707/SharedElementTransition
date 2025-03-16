package jp.shirataki.sharedelementtransition

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MountainScreen() {
    val mountains = MountainDemoDataProvider.provideData()

    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(mountains) { mountain ->
            MountainCard(mountain)
        }
    }
}

@Composable
private fun MountainCard(mountain: Mountain) {
    Column(
        modifier = Modifier
            .padding(end = 32.dp)
            .clickable(onClick = { /* TODO */ })
    ) {

        MountainImageWithIcon(mountain)

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
private fun MountainIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(64.dp)
            .background(Color.DarkGray)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_landscape),
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
                .fillMaxWidth()
                .height(200.dp)
        )

        MountainIcon(modifier = Modifier.offset(x = 16.dp, y = (-32).dp))
    }
}

@Preview
@Composable
private fun MountainCardPreview() {
    MountainCard(
        Mountain(
            name = "八ヶ岳(赤岳)",
            area = "山梨",
            description = "八ヶ岳連峰の主峰である赤岳は標高2,899mを誇り、登山者に人気の山。美しい稜線と絶景が楽しめ、初心者から上級者まで楽しめるコースが豊富。",
            imageRes = R.drawable.mountain_akadake
        )
    )
}

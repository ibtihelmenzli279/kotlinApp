package com.example.tp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tp2.data.Info
import com.example.tp2.modele.Card
import com.example.tp2.ui.theme.TP2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP2Theme {
                AllCards(Info.infoCard)
            }
        }
    }
}@Composable
fun Card(c: Card) {
    val configuration = LocalConfiguration.current
    val deviceWidth = configuration.screenWidthDp.dp
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(8.dp),

        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(c.photo),
                    contentDescription = "Card photo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16F / 9F)
                )
                Text(
                    text = c.desription,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}


@Composable
fun AllCards(cards: List<Card>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(cards) { card ->
            Card(card)
        }
    }
}

package com.example.quotes.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotes.R
import com.example.quotes.modal.data


@Composable
fun QuotesListItem(quotes: data, onClick: (quotes: data) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(quotes) }
    )

    {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
//                imageVector = Icons.Filled.Favorite,
                painter = painterResource(id = R.drawable.quote),
                contentDescription = "Quotes",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .padding(7.dp)
                    .rotate(180F)

            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quotes.quotes,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Box(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxSize(.4f)
                        .background(Color(0xFFEEEEEE))
                )


                Text(
                    text = quotes.author,
                    fontWeight = FontWeight(300),
                    modifier = Modifier.padding(top = 4.dp)
                )


            }
        }
    }
}





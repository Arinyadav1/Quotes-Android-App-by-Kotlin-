package com.example.quotes.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.DataManager
import com.example.quotes.R
import com.example.quotes.modal.data

@Composable
fun QuotesDetails(quotes : data) {
    BackHandler {
        DataManager.switchPage(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xffffffff),
                        Color(0xffe3e3e3)
                    )
                )
            )

    ){
        Column {
            Card(
                modifier = Modifier.padding(32.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                colors = CardDefaults.cardColors(Color.White)

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(15.dp)

                ) {
                    Image(
                        painter = painterResource(R.drawable.quote),
                        contentDescription = "quote image",
                        modifier = Modifier.size(40.dp)
                            .rotate(180F)
                    )

                    Text(
                        text = quotes.quotes,
                        fontWeight = FontWeight(500),
                        fontSize = 30.sp,
                        modifier = Modifier.padding(bottom = 4.dp, top = 7.dp)
                    )
                    Box(
                        modifier = Modifier
                            .height(4.dp)
                            .fillMaxSize(.6f)
                            .background(Color(0xFFEEEEEE))
                    )

                    Text(
                        text = quotes.author,
                        fontWeight = FontWeight(300),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            Text(
                text = "By Arin Yadav",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f)
                    .padding(bottom = 10.dp)



            )
        }
    }
}
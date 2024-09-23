package com.example.quotes.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotes.modal.data

@Composable
fun QuotesListItemScreen(data : Array<data>, onClick : (quotes : data) -> Unit){
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.fillMaxWidth(1f)
                .padding(top = 40.dp, bottom = 3.dp)

        )
        Text(
            text = "By Arin Yadav",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1f)
                .padding(bottom = 10.dp)


        )
        quotesList(data = data, onClick)


    }
}

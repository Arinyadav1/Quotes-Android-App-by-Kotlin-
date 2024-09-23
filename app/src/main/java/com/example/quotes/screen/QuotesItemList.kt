package com.example.quotes.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.example.quotes.modal.data

@Composable
fun quotesList(data : Array<data>, onClick : (quotes : data) -> Unit){
    val listState = rememberLazyListState()

    LazyColumn(content = {
        items(data){
            QuotesListItem(quotes = it, onClick)
        }
    }, state = listState)
}
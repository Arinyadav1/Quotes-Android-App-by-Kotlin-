package com.example.quotes

import android.content.Context
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.modal.data
import com.google.gson.Gson
import java.io.InputStream
import java.nio.charset.Charset

object DataManager {
    var data = emptyArray<data>()
    var currentQuote : data? = null
    var curretPage = mutableStateOf(pages.Listing)

    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context : Context){
        val inputStream = context.assets.open("data.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<data>::class.java)
        isDataLoaded.value = true
    }
    fun switchPage(quotes : data?){
        if(curretPage.value == pages.Listing){
            currentQuote = quotes
            curretPage.value = pages.Details
        } else{
            curretPage.value = pages.Listing
        }
    }
}




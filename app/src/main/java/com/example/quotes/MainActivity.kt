package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotes.screen.QuotesDetails
import com.example.quotes.screen.QuotesListItem
import com.example.quotes.screen.QuotesListItemScreen
import com.example.quotes.screen.quotesList
import com.example.quotes.ui.theme.QuotesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch{
//            delay()
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
//            window.statusBarColor = getColor(R.color.black)
            App()
        }
    }
}

@Composable
fun App(){
    if(DataManager.isDataLoaded.value){
        if(DataManager.curretPage.value == pages.Listing) {
            QuotesListItemScreen(data = DataManager.data) {
                DataManager.switchPage(it)
            }
        }else{
            DataManager.currentQuote?.let { QuotesDetails(it) }
        }
    }

}

enum class pages(){
    Listing,
    Details
}
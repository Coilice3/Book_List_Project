package com.example.booklistproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.MenuCompat
import com.example.booklistproject.MainActivity.BookCategory.bookList
import com.example.booklistproject.ui.theme.BookListProjectTheme
import com.example.booklistproject.ui.theme.ColorTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookListProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
    object BookCategory{
        val bookList = listOf(
            Book("Anya x family", 12.79, R.drawable.anyaxfamily, R.string.cartoon.toString()),
            Book("Arcane", 12.79, R.drawable.arcane, R.string.cartoon.toString()),
            Book("Beauty and the beast", 6.99, R.drawable.bntb, R.string.cartoon.toString()),
            Book("Castlevania", 12.79, R.drawable.castlevania, R.string.cartoon.toString()),
            Book("Elementals", 12.79, R.drawable.elementals, R.string.cartoon.toString()),
            Book("Home alone", 12.79, R.drawable.home_alone, R.string.comedy.toString()),
            Book("Invincible", 12.79, R.drawable.invincible, R.string.cartoon.toString()),
            Book("Itaewon class", 12.79, R.drawable.itaewon_class, R.string.romance.toString()),
            Book("Johnny English", 12.79, R.drawable.johnny_english, R.string.comedy.toString()),
            Book("King of fighter", 12.79, R.drawable.kof, R.string.action.toString()),
            Book("Life is strange", 12.79, R.drawable.lis, R.string.romance.toString()),
            Book("Love, Rosie", 12.79, R.drawable.love_rosie, R.string.romance.toString()),
            Book("Mulan", 12.79, R.drawable.mulan, R.string.cartoon.toString()),
            Book("Prince of Egypt", 12.79, R.drawable.prince_of_egypt, R.string.cartoon.toString()),
            Book("Spider Man", 12.79, R.drawable.spiderman, R.string.cartoon.toString()),
            Book("Street fighter", 12.79, R.drawable.sf, R.string.action.toString()),
            Book("Titanic", 12.79, R.drawable.titanic, R.string.romance.toString()),
            Book("Twilight", 12.79, R.drawable.twilight, R.string.romance.toString()),
            Book("Van Helsing", 12.79, R.drawable.van_helsing, R.string.horror.toString()),
            Book("Sweet home", 12.79, R.drawable.sweet_home, R.string.horror.toString()),
            Book("WALL E", 12.79, R.drawable.wall_e, R.string.romance.toString()),
            Book("Trine 4", 12.79, R.drawable.trine4, R.string.comedy.toString()),
        )
    }
    private val bookState: MutableStateFlow<BookList> =
        MutableStateFlow(BookList(bookList))


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen(){
        val context = LocalContext.current
        val book by bookState.collectAsState()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(
                            Modifier.clickable { backToMain(context) }
                                .background(ColorTheme.lightYellow)
                        ) {
                            Text(text = "Book Menu", style = MaterialTheme.typography.labelSmall)
                        }
                    },
                    actions = { Icon(imageVector = Icons.Default.Menu,
                        contentDescription = "",)
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        ColorTheme.lightYellow
                    )
                )
            }
        ) {it ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .background(ColorTheme.lightBlack)
            )
            {
                BookGrid(book, ::startBookActivity)
            }
        }

    }


    fun startBookActivity(book: Book){
        val intent = Intent(this, BookActivity::class.java).apply {
            putExtra(BookActivity.KEY_NAME, book.name)
            putExtra(BookActivity.KEY_PRICE, book.price)
            putExtra(BookActivity.KEY_IMAGE, book.image)
            putExtra(BookActivity.KEY_CATEGORY, book.category)
        }
        startActivity(intent)
    }


}


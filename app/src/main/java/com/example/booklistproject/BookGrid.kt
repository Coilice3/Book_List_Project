package com.example.booklistproject

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booklistproject.ui.theme.ColorTheme


@Composable
fun BookGrid(bookList: BookList, startActivity: (Book) -> Unit){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(
                items = bookList.bookList,
                itemContent = { book: Book ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.background(color = ColorTheme.lightBlack)
                        ) {
                            Image(painter = painterResource(id = book.image),
                                contentDescription = stringResource(id = R.string.book_content_description, book.name),
                                modifier = Modifier
                                    .size(150.dp)
                                    .clickable {
                                        Log.d("BookGrid", "Image clicked for book: ${book.name}")
                                        startActivity(book)
                                    }
                            )
                            Text(text = book.name, style = MaterialTheme.typography.titleLarge)
                            Text(text = "$ ${book.price}", style = MaterialTheme.typography.bodyLarge)
                        }

                }
            )
        }
    )
}


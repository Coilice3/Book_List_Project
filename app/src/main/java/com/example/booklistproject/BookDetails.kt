package com.example.booklistproject

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booklistproject.ui.theme.ColorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetails(book: Book){
    val context = LocalContext.current
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
    ){
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
                .background(ColorTheme.lightBlack),
        ) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = ColorTheme.header,
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(10.dp)
                    .background(ColorTheme.lightYellow)
                    .clickable {
                        backToMain(context)
                    }
            )
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = book.image),
                    contentDescription = stringResource(R.string.book_content_description, book.name),
                    modifier = Modifier.size(350.dp)
                )
                Text(text = book.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 34.sp)
                Text(text = "$ ${book.price}", color = Color.White, fontSize = 16.sp)
            }

        }
    }
}

fun backToMain(context: Context){
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}
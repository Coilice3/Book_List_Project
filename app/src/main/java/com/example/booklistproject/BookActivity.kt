package com.example.booklistproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class BookActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra(KEY_NAME)
        val price = intent.getDoubleExtra(KEY_PRICE, 0.0)
        val image = intent.getIntExtra(KEY_IMAGE, 0)
        val category = intent.getStringExtra(KEY_CATEGORY)

        val book =
            Book(name.toString(), price, image, category.toString())//todo replace with the passed values from intent
        setContent { BookDetails(book) }
    }
    

    companion object{
        const val KEY_NAME = "name"
        const val KEY_PRICE = "price"
        const val KEY_IMAGE = "image"
        const val KEY_CATEGORY = "category"
    }
}
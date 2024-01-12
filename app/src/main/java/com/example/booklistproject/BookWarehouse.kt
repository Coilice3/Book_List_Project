package com.example.booklistproject

import androidx.annotation.DrawableRes
import com.google.android.gms.tflite.acceleration.Model

data class Book(
    val name: String,
    val price: Double,
    @DrawableRes val image: Int,
    val category: String
)




data class BookList(val bookList: List<Book>)
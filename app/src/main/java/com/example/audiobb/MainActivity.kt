package com.example.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a BookList
        val books = buildBooks()

        println(books)
    }

    fun buildBooks() : BookList {
        var books = BookList()
        var bookResource = resources.getStringArray(R.array.bookInfo)
        for (i in 0..bookResource.size step 2) {
            // grab all the resources from the list and build a bookList from it
            books.add(Book(bookResource[i], bookResource[i+1]))
        }

        return books
    }
}
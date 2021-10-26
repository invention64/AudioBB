package com.example.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.internal.ContextUtils.getActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a BookList
        val books = buildBooks()
        val bookList = ViewModelProvider(this).get(BookListViewModel::class.java)
        bookList.setBookList(books)


        println(books)
    }

    fun buildBooks() : BookList {
        var books = BookList()
        var bookResource = resources.getStringArray(R.array.bookInfo)
        for (i in 1..bookResource.size step 2) {
            // grab all the resources from the list and build a bookList from it
            books.add(Book(bookResource[i-1], bookResource[i]))
        }

        return books
    }
}
package com.example.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.internal.ContextUtils.getActivity

class MainActivity : AppCompatActivity() {
    val nullBook = Book("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a BookList
        val books = buildBooks()
        val bookList = ViewModelProvider(this).get(BookListViewModel::class.java)
        val bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        // data initialization
        if (savedInstanceState == null) {
            bookList.setBookList(books)
            bookViewModel.setBook(nullBook)
        }
        // Check if a dedicated displayFragment exists
        val hasDisplay = findViewById<FragmentContainerView>(R.id.displayContainer) != null

        // I only really have to do this part manually, since my other layouts manually manage this
        if (!hasDisplay) {
            if (savedInstanceState == null) {
                // manually add the fragment
                supportFragmentManager.beginTransaction().replace(
                    R.id.listContainer,
                    BookListFragment.newInstance()).addToBackStack(null)
                    .commit()
            } else if (bookViewModel.getBook().value != nullBook) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.displayContainer,
                    BookDetailsFragment.newInstance()).addToBackStack(null)
                    .commit()
            }
        }


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
package com.example.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (_books : BookList, _ocl: View.OnClickListener) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private val books = _books
    private val ocl = _ocl


    class ViewHolder(_view: View) : RecyclerView.ViewHolder(_view) {
        val authorText = _view.findViewById<TextView>(R.id.bookAuthorTextView)
        val titleText = _view.findViewById<TextView>(R.id.bookTitleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_book, parent, false)
        view.setOnClickListener(ocl)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.imageView.setImageResource(items[position].resourceId)
        holder.authorText.text = books[position].author
        holder.titleText.text = books[position].title
    }

    override fun getItemCount(): Int {
        return books.size
    }
}
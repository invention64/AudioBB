package com.example.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_BOOKLIST = "booklist"


/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_BOOKLIST)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_book_list, container, false)
        val recyclerView = layout.findViewById<RecyclerView>(R.id.bookList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val bookViewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)
        val bookListViewModel = ViewModelProvider(requireActivity()).get(BookListViewModel::class.java)
        // dumb way to do this, maybe laggy
        // TODO: Get rid of this dumb hack
        val bookList = bookListViewModel.getBookList().value
        val onClickListener = View.OnClickListener {
            val bookPos = recyclerView.getChildAdapterPosition(it)
            // TODO: Error check this, seems like it could break
            bookViewModel.setBook(bookList?.get(bookPos)!!)
        }

        recyclerView.adapter = BookAdapter(bookList!!, onClickListener)

        return layout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    // put(Booklist) I don't know if I have to do this since I'm using ViewModels to store the booklist
                }
            }
    }
}
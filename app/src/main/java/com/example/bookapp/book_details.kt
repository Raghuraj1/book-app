package com.example.bookapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class BookDetailFragment : Fragment() {

    private lateinit var detailImage: ImageView
    private lateinit var detailTitle: TextView
    private lateinit var detailAuthor: TextView
    private lateinit var detailDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_details, container, false)

        detailImage = view.findViewById(R.id.detailImage)
        detailTitle = view.findViewById(R.id.detailTitle)
        detailAuthor = view.findViewById(R.id.detailAuthor)
        detailDescription = view.findViewById(R.id.detailDescription)

        return view
    }

    fun updateBookDetails(book: Book) {
        if (::detailTitle.isInitialized) {
            detailImage.setImageResource(book.titleImage)
            detailTitle.text = book.title
            detailAuthor.text = book.author
            detailDescription.text = book.description
        }
    }
}
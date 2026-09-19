package com.example.bookapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class BookAdapter(
    private val bookList: ArrayList<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = bookList[position]
        holder.cover.setImageResource(currentItem.titleImage)
        holder.author.text = currentItem.author
        holder.title.text = currentItem.title
        holder.itemView.setOnClickListener {
            onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cover: ShapeableImageView = itemView.findViewById(R.id.bookCover)
        var title: TextView = itemView.findViewById(R.id.bookTitle)
        var author: TextView = itemView.findViewById(R.id.bookAuthor)
    }
}

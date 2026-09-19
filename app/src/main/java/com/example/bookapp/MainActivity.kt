package com.example.bookapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Book>
    private lateinit var imageId: Array<Int>
    private lateinit var title: Array<String>
    private lateinit var author: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageId = arrayOf(
            R.drawable.b1,
            R.drawable.b2,
            R.drawable.b3,
            R.drawable.b4,
            R.drawable.b5,
        )

        title = arrayOf(
            "The Hobbit",
            "Harry Potter",
            "Life of Pi",
            "The Little Prince",
            "The Wizard of Oz"
        )

        author = arrayOf(
            "J.R.R. Tolkien",
            "J.K. Rowling",
            "Yann Martel",
            "Antoine de Saint-Exupéry",
            "L. Frank Baum"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val book = Book(imageId[i], title[i], author[i])
            newArrayList.add(book)
        }
        newRecyclerView.adapter = BookAdapter(newArrayList)
    }
}

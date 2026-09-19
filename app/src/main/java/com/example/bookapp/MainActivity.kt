package com.example.bookapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newArrayList: ArrayList<Book>
    private lateinit var imageId: Array<Int>
    private lateinit var title: Array<String>
    private lateinit var author: Array<String>
    private lateinit var description: Array<String>

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

        description = arrayOf(
            "A fantasy novel by English author J. R. R. Tolkien following home-loving Bilbo Baggins.",
            "A fantasy play by Jack Thorne based on an original story by J.K. Rowling.",
            "A Canadian fantasy adventure novel by Yann Martel about a boy stranded on a lifeboat.",
            "A poetic tale by French aristocrat Antoine de Saint-Exupéry involving a young prince.",
            "An American children's novel written by L. Frank Baum and illustrated by W. W. Denslow."
        )


        newArrayList = arrayListOf()
        getUserData(savedInstanceState)
    }

    private fun getUserData(savedInstanceState: Bundle?) {
        for (i in imageId.indices) {
            val book = Book(imageId[i], title[i], author[i],description[i])
            newArrayList.add(book)
        }
        if (savedInstanceState == null) {
            val detailFragment = BookDetailFragment()
            val listFragment = BookListFragment(newArrayList) { selectedBook ->
                detailFragment.updateBookDetails(selectedBook)
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.listFragmentContainer, listFragment)
                .replace(R.id.detailFragmentContainer, detailFragment)
                .commit()

            detailFragment.view?.let {
                if (newArrayList.isNotEmpty()) detailFragment.updateBookDetails(newArrayList[0])
            }
        }
    }
}

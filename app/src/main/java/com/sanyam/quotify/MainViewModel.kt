package com.sanyam.quotify

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(private val context: Context) : ViewModel() {
    private var quoteList : Array<Quote> = emptyArray()
    private var index : Int = 0

    init {
        quoteList = loadQuotesFromAssets()
    }

    fun loadQuotesFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() : Quote {
        return if (++index <= quoteList.size-1) {
            quoteList[++index]
        } else {
            index = quoteList.size-1
            quoteList[index]
        }
    }

    fun previousQuote() : Quote {
        return if (--index >= 0) {
            quoteList[--index]
        } else {
            index = 0
            quoteList[index]
        }
    }

}
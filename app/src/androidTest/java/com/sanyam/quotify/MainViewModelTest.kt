package com.sanyam.quotify

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadQuotesFromAssets() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val quote = MainViewModel(context)
        quote.loadQuotesFromAssets()
        assertEquals(9, quote.loadQuotesFromAssets().size)
    }
}
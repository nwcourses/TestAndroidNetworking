package com.example.test0001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch the coroutine using our LifecycleScope - as last week
        lifecycleScope.launch {
            var httpResponse = ""

            // Switch to the IO context to perform the HTTP request
            withContext(Dispatchers.IO) {
                // Send a GET request to https://kotlinlang.org
                Log.d("test0001log", "Making request")
                httpResponse = URL("https://kotlinlang.org").readText()
                Log.d("test0001log", httpResponse)
            }

            // Add the response to a text view
            //findViewById<TextView>(R.id.tv1).text = httpResponse
        }
    }
}
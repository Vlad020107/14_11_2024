package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        var languages = resources.getStringArray(R.array.languages)
        val adapter = ArrayAdapter(
            this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
            languages
        )
        binding.Spinner.adapter = adapter
        binding.Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var url = "https://www.wikipedia.org/wiki${languages[p2]}"
                binding.WV.loadUrl(url)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.WV.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url:String?
            ): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }
    }
}
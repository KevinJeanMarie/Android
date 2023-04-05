package com.example.android

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

        findViewById<TextView>(R.id.barcode).applyBoldText("Code-barres", "UYGUGU")

        fun toast(){
            val text = "Hello toast!"
            val duration = Toast.LENGTH_LONG

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

        toast()
    }

    fun TextView.applyBoldText(prefix: String, value: String) {
        val text = "$prefix : $value"
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(":") + 1, 0)
        setText(text)

    }
}
class Product : AppCompatActivity(){
    val name: String,
    val brand: String,
    val barcode: String,
    val nutriscore: String,
    val imageUrl: String,
    val quantity: String,
    val countries: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>
}



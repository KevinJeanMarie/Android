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

        findViewById<TextView>(R.id.barcode).applyBoldText("Code-barres", product.barcode)

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
class Product(
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
) {
   override fun toString(): String {
        return "Product(" +
               "name='$name'," +
               " brand='$brand'," +
               " barcode='$barcode," +
               " nutriscore='$nutriscore," +
               " imageUrl='$imageUrl," +
               " quantity= '$quantity," +
               " countries= '$countries," +
               "ingredients= '$ingredients," +
               "allergens= '$allergens," +
               "additives= '$additives" +
               ")"
    }
}
fun main() {
    val product = Product(
        name = "Petits pois et carottes",
        brand = "Cassegrain",
        barcode = "3083680085304",
        nutriscore = "E",
        quantity = "400 g (280 g net égoutté)",
        countries = listOf("France", "Japon", "Suisse"),
        imageUrl = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
        ingredients = listOf("Petit pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel","arôme naturel"),
        allergens = listOf("aucune"),
        additives = listOf("aucun")
    )
    println(product.toString())
}


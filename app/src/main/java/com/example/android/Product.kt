package com.example.android

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
        return "com.example.android.Product(" +
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
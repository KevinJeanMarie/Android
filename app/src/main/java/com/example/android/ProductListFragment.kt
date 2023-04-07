package com.example.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.Extensions.applyBoldText

class ProductListFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.productlist, container, false)
    }
/*
    val product = Product(
        name = "Petits pois et carottes",
        brand = "Cassegrain",
        barcode = "3083680085304",
        nutriscore = "E",
        quantity = "400 g (280 g net égoutté)",
        countries = listOf("France", "Japon", "Suisse"),
        imageUrl = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
        ingredients = listOf(
            "Petit pois 66%",
            "eau",
            "garniture 2,8% (salade, oignon grelot)",
            "sucre",
            "sel",
            "arôme naturel"
        ),
        allergens = listOf("aucune"),
        additives = listOf("aucun")
    )
*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view as RecyclerView

        val list = List(100) {
            "Position ${it + 1}"
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapter(list, object : OnProductClickListener {
            override fun onProductClicked(position: String) {
                /* view.findViewById<TextView>(R.id.barcode).applyBoldText("Code-barres", product.barcode) */
            }
        })
    }
}

class ListAdapter(private val listOfPositions: List<String>,
                  private val listener: OnProductClickListener,
) : RecyclerView.Adapter<PositionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        return PositionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_item, parent, false),
            listener,
        )
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        holder.updateCell(listOfPositions[position])
    }

    override fun getItemCount(): Int {
        return listOfPositions.size
    }

}

class PositionViewHolder(v: View, val listener: OnProductClickListener) : RecyclerView.ViewHolder(v) {

    private val text : TextView = v.findViewById(R.id.item_text)

    fun updateCell(position: String) {
        itemView.setOnClickListener {
            listener.onProductClicked(position)
        }

        text.text = position
    }

}

interface OnProductClickListener {
    fun onProductClicked(position: String)
}
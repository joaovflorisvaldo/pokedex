package com.android.pokedex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.pokedex.R
import com.android.pokedex.domain.Pokemon

class PokemonAdapter(private val items: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvName = findViewById<TextView>(R.id.tvName)
            val tvTypeOne = findViewById<TextView>(R.id.tvTypeOne)
            val tvTypeTwo = findViewById<TextView>(R.id.tvTypeTwo)

            // TODO Carregar Imagem

            tvNumber.text = "Nº ${item.formattedNumber}"
            tvName.text = item.name
            tvTypeOne.text = item.types[0].name

            if (item.types.size > 1) {
                tvTypeTwo.visibility = View.VISIBLE
                tvTypeTwo.text = item.types[1].name
            } else {
                tvTypeTwo.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }
}

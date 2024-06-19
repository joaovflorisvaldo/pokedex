package com.android.pokedex.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.pokedex.R
import com.android.pokedex.domain.Pokemon
import com.android.pokedex.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_main)

            val recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)
            val charmander = Pokemon(
                "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png",
                4,
                "Charmander",
                listOf(
                    PokemonType("Fire")
                )
            )

            val pokemons = listOf(
                charmander, charmander, charmander, charmander, charmander
            )

            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = PokemonAdapter(pokemons)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

package com.android.pokedex.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.pokedex.R
import com.android.pokedex.api.PokemonRepository
import com.android.pokedex.domain.Pokemon
import com.android.pokedex.domain.PokemonType
import kotlinx.coroutines.Runnable

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_main)
            recyclerView = findViewById(R.id.rvPokemons)
            Thread(Runnable {
                loadPokemons()
            }).start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()
        pokemonsApiResult?.results?.let {


            val pokemons: List<Pokemon?> = it.map {pokemonResult ->
                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult = PokemonRepository.getPokemons(number)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->
                            type.type
                        }
                    )
                }

            }
            val layoutManager = LinearLayoutManager(this)

            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(pokemons)
            }
        }
    }
}

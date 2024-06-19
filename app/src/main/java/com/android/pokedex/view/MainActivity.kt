package com.android.pokedex.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.pokedex.R
import com.android.pokedex.api.PokemonRepository
import com.android.pokedex.domain.Pokemon
import com.android.pokedex.viewmodel.PokemonViewModel
import com.android.pokedex.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var pokemons = MutableLiveData<List<Pokemon?>>()

    val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory()).get(PokemonViewModel::class.java)
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()
        pokemonsApiResult?.results?.let {


            pokemons.postValue(it.map {pokemonResult ->
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

            })

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            recyclerView = findViewById(R.id.rvPokemons)

            viewModel.pokemons.observe(this, Observer{
                loadRecyclerView(it)
            })

        } catch (e: Exception) {
            Log.e("POKEMON_API", "ERRO AO CRIAR $e")
        }
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}

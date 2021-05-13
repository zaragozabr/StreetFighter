package br.com.streetfighterteam.services

import br.com.streetfighterteam.models.Character
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


interface CharactersInterface {
    @GET("sf.json")
  fun listCharacters() : Call<List<Character>>
}

class CharacterConnection{
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fiapstreetfighter.web.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(CharactersInterface::class.java)
}
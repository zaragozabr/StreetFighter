package br.com.streetfighterteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.streetfighterteam.adapters.CharactersAdapter
import br.com.streetfighterteam.databinding.ActivityMainBinding
import br.com.streetfighterteam.models.Character
import br.com.streetfighterteam.services.CharacterConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

//    private val characters = listOf(
//        Character("Ryu",4,3,3,2,4,
//            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-ryu-2.jpg"),
//        Character("Ryu", 4,3,3,2,4,
//            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-ryu-2.jpg"),
//        Character("Chun-Li", 2,2,4,4,3,
//            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-chun-li-2.jpg"),
//        Character("Nash", 3,3,4,3,3,
//            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-nash-2.jpg"),
//        Character("Ken", 3,3,4,2,3,
//            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-ken-2.jpg")
//    )




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CharacterConnection().service.listCharacters().enqueue(object: Callback<List<Character>>{
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
               if(response.isSuccessful){
                   response.body()?.let {
                       configureList(it)
                   }?: run{
                       Toast.makeText(this@MainActivity,"Falha ao carregar personagens",Toast.LENGTH_LONG).show()
                   }
               }else{
                   Toast.makeText(this@MainActivity,"Falha ao carregar personagens",Toast.LENGTH_LONG).show()

               }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
               Toast.makeText(this@MainActivity,"Falha ao carregar personagens",Toast.LENGTH_LONG).show()
            }


        })
    }

private fun configureList(characters: List<Character>){
    binding.pbLoading.visibility = View.INVISIBLE
    binding.rvCharacters.visibility = View.VISIBLE
    val adapter = CharactersAdapter(characters)
    binding.rvCharacters.adapter = adapter
}

}
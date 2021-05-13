package br.com.streetfighterteam

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.streetfighterteam.databinding.ActivityCharacterBinding

import br.com.streetfighterteam.models.Character
import com.bumptech.glide.Glide

class CharacterActivity : AppCompatActivity() {

    lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityCharacterBinding.inflate(layoutInflater)

        setContentView(binding.root)

       // binding = ActivityCharacterBinding.inflate(layoutInflater)
       // setContentView(binding.root)


        val character = intent.extras?.get("character") as Character



        Glide
            .with(this)
            .load(character.photo)
            .into(binding.ivPhoto2)

        binding.tvName2.text = character.name

        binding.ivStarsPower.setImageDrawable(getStarImage(character.power))
        binding.ivStarsHealth.setImageDrawable(getStarImage(character.health))
        binding.ivStarsMobility.setImageDrawable(getStarImage(character.mobility))
        binding.ivStarsTechniques.setImageDrawable(getStarImage(character.techniques))
        binding.ivStarsRange.setImageDrawable(getStarImage(character.range))
    }

    private fun getStarImage(value: Int) : Drawable{
        return when (value){
            1 -> getDrawable(R.drawable.starts1)!!
            2 -> getDrawable(R.drawable.starts2)!!
            3 -> getDrawable(R.drawable.starts3)!!
            4 -> getDrawable(R.drawable.starts4)!!
            5 -> getDrawable(R.drawable.starts5)!!
            else -> getDrawable(R.drawable.starts1)!!
        }
    }
}
package br.com.streetfighterteam.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.streetfighterteam.CharacterActivity
import br.com.streetfighterteam.R
import br.com.streetfighterteam.models.Character
import com.bumptech.glide.Glide

class CharactersAdapter(private val characters: List<Character>): RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_character,parent,false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int = characters.size


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]

        val tvName = holder.view.findViewById<TextView>(R.id.tvName)
        val ivPhoto = holder.view.findViewById<ImageView>(R.id.ivPhoto)

        tvName.text = character.name

        Glide
            .with(ivPhoto.context)
            .load(character.photo)
            .into(ivPhoto)

        holder.view.setOnClickListener {
            val intent = Intent(holder.view.context, CharacterActivity::class.java)
            intent.putExtra("character",character)
            holder.view.context.startActivity(intent)
        }
    }


}
package com.example.anywhereapp.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.anywhereapp.databinding.TextItemBinding
import com.example.myanywhereapplication.simpsons.model.RelatedTopicSimpsons

class SimpsonsAdapter(val myContext: Context): RecyclerView.Adapter<SimpsonsAdapter.SimpsonsViewholder>() {
    private var myList = listOf<RelatedTopicSimpsons>()

    class SimpsonsViewholder(var binding: TextItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpsonsViewholder {
        val binding = TextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimpsonsViewholder(binding)
    }

    override fun onBindViewHolder(holder: SimpsonsViewholder, position: Int) {
        holder.binding.apply {
            characterName.text = myList?.get(position)?.text?.substringBefore("-") ?: ""
            characterName.setOnClickListener() {
                val intent = Intent(myContext, CharacterDetailsActivity::class.java)
                intent.putExtra("image_url", if(!myList.get(position).icon?.uRL.isNullOrEmpty()) {
                    "https://duckduckgo.com" + myList.get(position).icon?.uRL
                } else
                { null }
                )
                intent.putExtra("title_text", characterName.text)
                intent.putExtra("details_text", myList.get(position).text?.substringAfter("-")?.trim())
                startActivity(myContext,intent,null)
            }
        }
    }

    override fun getItemCount(): Int = myList.size

    fun setData(newList : List<RelatedTopicSimpsons>){
        myList = newList
        notifyDataSetChanged()
    }
}
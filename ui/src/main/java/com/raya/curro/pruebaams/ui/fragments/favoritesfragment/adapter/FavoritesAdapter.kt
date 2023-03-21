package com.raya.curro.pruebaams.ui.fragments.favoritesfragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.raya.curro.pruebaams.domain.model.Result
import com.raya.curro.pruebaams.ui.base.Diffutils
import com.raya.curro.pruebaams.ui.databinding.ItemCharacterBinding

class FavoritesAdapter(private var listener: FavoriteCharacterListListener) :
    ListAdapter<Result, FavoritesAdapter.RikHolder>(
        Diffutils()
    ) {

    interface FavoriteCharacterListListener {
        fun onCharacterClick(item: Result, img: View)
    }

    class RikHolder(
        private val binding: ItemCharacterBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result, listener: FavoriteCharacterListListener) = with(binding) {
            characterName.text = item.name
            characterImg.load(item.image)
            characterImg.transitionName = item.id.toString() + "f"
            itemView.setOnClickListener { listener.onCharacterClick(item, characterImg) }
            binding.characterImg.transitionName = item.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RikHolder {
        val inflater =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RikHolder(inflater)
    }

    override fun onBindViewHolder(holder: RikHolder, position: Int) {
        holder.bind(currentList[position], listener)
    }
}
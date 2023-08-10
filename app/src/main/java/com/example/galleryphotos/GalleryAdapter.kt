package com.example.galleryphotos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class GalleryAdapter(val listPhotos: Photos): RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    // lateinit var onItemClilck:((Photo,String)->Unit)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.imageview)
        val title = itemView.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = listPhotos.photos.photo[position].title
        val farm = listPhotos.photos.photo[position].farm
        val server = listPhotos.photos.photo[position].server
        val id = listPhotos.photos.photo[position].id
        val secret = listPhotos.photos.photo[position].secret
        val url = "https://farm" +farm.toString() + ".staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg"
        Picasso.get().load(url).into(holder.image)

        /*holder.itemView.setOnClickListener {
            onItemClilck?.invoke(listPhotos.photos.photo[position],url)
        }*/
    }

    override fun getItemCount(): Int {
        return listPhotos.photos.photo.size
    }

}
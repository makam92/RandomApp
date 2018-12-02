package com.makam.randomapp.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.makam.presentation.model.ImgurView
import com.makam.randomapp.R
import org.w3c.dom.Text

class ImgurAdapter(var dataSet: List<ImgurView>) : RecyclerView.Adapter<ImgurAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val imgurView = dataSet[p1]
        var title = p0.view.findViewById<TextView>(R.id.imgur_title)
        title.text = imgurView.title
        var image = p0.view.findViewById<ImageView>(R.id.imgur_image)
        var requestOptions =  RequestOptions()
        requestOptions.centerInside()
        Glide.with(p0.view.context).load(imgurView.images?.get(0) ?: imgurView.link).apply(requestOptions)
            .into(image)
        var likes = p0.view.findViewById<TextView>(R.id.imgur_likes)
        likes.text = "${imgurView.ups.toString()} likes"
        var comments = p0.view.findViewById<TextView>(R.id.imgur_comments)
        comments.text = "${imgurView.comments} comments"

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.card_imgur, p0, false)

        return ViewHolder(view)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
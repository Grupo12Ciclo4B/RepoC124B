package com.example.apprende4bg12.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.interfaces.OnCourseClickListener
import com.example.apprende4bg12.databinding.ItemCoursesBinding


class CoursesAdapter (var list: List<CoursesModel>): RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    var listener: OnCourseClickListener? = null

        class ViewHolder(val View: ItemCoursesBinding): RecyclerView.ViewHolder(View.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemCoursesBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.View.itemCourseTitle.text = item.title
        holder.View.itemCoursesRating.rating = item.star.toFloat()
        //holder.View.itemCourseIcon.setImageResource(item.icon.toInt())
        Glide.with(holder.View.root).load(item.icon).centerCrop().into(holder.View.itemCourseIcon)
        holder.View.root.setOnClickListener{
            listener?.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return  list.size
    }
    fun changeDataSet(newList: List<CoursesModel>){
        this.list = newList
        notifyDataSetChanged()
    }

}
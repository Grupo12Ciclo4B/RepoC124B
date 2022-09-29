package com.example.apprende4bg12.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.interfaces.OnServiceClickListener
import com.example.apprende4bg12.data.models.ServiceModel
import com.example.apprende4bg12.databinding.ItemServiceBinding

class ServiceAdapter (var list: List<ServiceModel>): RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    var listener: OnServiceClickListener? = null

        class ViewHolder(val View: ItemServiceBinding): RecyclerView.ViewHolder(View.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemServiceBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.View.itemServiceTitle.text = item.title
        holder.View.itemServiceText.text = item.description
        //  holder.View.itemServiceIcon.setImageResource(item.icon.toInt())
        Glide.with(holder.View.root).load(item.icon).centerCrop().into(holder.View.itemServiceIcon)
        holder.View.root.setOnClickListener{
            listener?.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    fun changeDataSet(newList: List<ServiceModel>){
        this.list = newList
        notifyDataSetChanged()
    }

}
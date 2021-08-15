package com.example.codehiveregistraction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Coursesadapter( var courseList:List<courses>):RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_list_item,parent,false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        var currentCourse=courseList.get(position)
        holder.tvcourcename.text=currentCourse.Coursename
        holder.tvcoursecode.text=currentCourse.Coursecode
        holder.tvdiscription.text=currentCourse.Description
        holder.tvinstactor.text=currentCourse.Instructor
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class CourseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvcourcename=itemView.findViewById<TextView>(R.id.tvcoursecode)
    var tvcoursecode=itemView.findViewById<TextView>(R.id.tvcoursename)
    var tvdiscription=itemView.findViewById<TextView>(R.id.tvdiscription)
    var tvinstactor=itemView.findViewById<TextView>(R.id.tvinstractor)
}

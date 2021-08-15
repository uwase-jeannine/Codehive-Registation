package com.example.codehiveregistraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Courseactivity : AppCompatActivity() {
    lateinit var rvCourses:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courseactivity)
        displayCourses()
    }

    fun displayCourses() {
        var courceList = listOf(
            courses("Python", "DTG4", "Data classes", "Jemus"),
            courses("Kotlin", "DTS56", "Classes", "John"),
            courses("Javascript", "TDF4", "Data classes", "Mainer"),
            courses("React", "TDV34", "Components", "Mainer"),
        )
        rvCourses = findViewById(R.id.rvCourses)
        var coursesadapter=Coursesadapter(courceList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=coursesadapter

        rvCourses.apply {
            layoutManager=LinearLayoutManager(baseContext)
            adapter=coursesadapter
        }

    }
}
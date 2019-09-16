package com.m7amdelbana.hanginkotlin.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.m7amdelbana.hanginkotlin.R
import com.m7amdelbana.hanginkotlin.network.model.Place
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnItemClicked {

    override fun onClick(position: Int) {

    }

    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var places: ArrayList<Place>

    var placeAdapter: PlaceAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        places = ArrayList()
        getPlaces()
    }

    private fun getPlaces() {
        // TODO: Implement API Request.
    }
}

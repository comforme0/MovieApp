package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.adapter.MovieAdapter
import com.example.movieapp.api.RetrofitClient
import com.example.movieapp.api.ServiceInterface
import com.example.movieapp.model.ResponseMovie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var serviceInterface: ServiceInterface

    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager

    companion object {
        const val API_KEY : String = "e8226cd6dc636523f65474c67077271b"
        const val BASE_URI : String = "https://api.themoviedb.org/3/"
        const val IMAGE_URI : String = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val TAG : String = MainActivity::class.java.simpleName
        setContentView(R.layout.activity_main)

        retrofit = RetrofitClient.getInstance()
        serviceInterface = retrofit.create(ServiceInterface::class.java)

        recyclerView = findViewById(R.id.recycler)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager

        Runnable {
            serviceInterface.getPopularMovie(API_KEY).enqueue(object :
                Callback<ResponseMovie> {
                override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                    Log.d(TAG, t.message)
                }

                override fun onResponse(
                    call: Call<ResponseMovie>,
                    response: Response<ResponseMovie>
                ) {
                    val movies = response.body()?.results
                    Toast.makeText(this@MainActivity, "Movie size = ${movies?.size}", Toast.LENGTH_SHORT).show()
//                    recyclerView.adapter = MovieAdapter(movies!!)
                }
            })
        }.run()
    }
}

package com.arifwidayana.koinretrofit.ui.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.arifwidayana.koinretrofit.R
import com.arifwidayana.koinretrofit.data.utils.Status
import com.arifwidayana.koinretrofit.ui.adapter.MoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv_movies)

        getData()
    }

    private fun getData() {
        val progressDialog = ProgressDialog(this)
        viewModel.movies.observe(this) { resources ->
            when (resources.status) {
                Status.LOADING -> {
                    progressDialog.setMessage("Loading")
                    progressDialog.show()
                }
                Status.SUCCESS -> {
                    resources.data?.results?.let {
                        val adapter = MoviesAdapter(it)
                        rv.adapter = adapter
                    }
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error: ${resources.message}", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }
        }
        viewModel.getMovies()
    }
}
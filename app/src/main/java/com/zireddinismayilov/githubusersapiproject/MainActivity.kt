package com.zireddinismayilov.githubusersapiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zireddinismayilov.githubusersapiproject.adapter.Adapter
import com.zireddinismayilov.githubusersapiproject.data.RepositoryDTO
import com.zireddinismayilov.githubusersapiproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapterData: RepositoryDTO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getData(this@MainActivity)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.result.observe(this@MainActivity, Observer {
            adapterData = it
            binding.reposRecyclerView.adapter = Adapter(adapterData)
            binding.reposRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        })
    }
}
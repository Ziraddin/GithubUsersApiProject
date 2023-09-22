package com.zireddinismayilov.githubusersapiproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zireddinismayilov.githubusersapiproject.adapter.Adapter
import com.zireddinismayilov.githubusersapiproject.data.RepositoryDTO
import com.zireddinismayilov.githubusersapiproject.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapterData: RepositoryDTO
    lateinit var date: String
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn2.setTextColor(resources.getColor(R.color.clicked))
        date = getCurrentDate(7)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getData(this@MainActivity, date = date)
        setUpObservers()
        setUpButtonsTextColors()
    }


    private fun setUpObservers() {
        viewModel.result.observe(this@MainActivity, Observer {
            adapterData = it
            adapter = Adapter(adapterData)
            binding.reposRecyclerView.adapter = adapter
            binding.reposRecyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter.notifyDataSetChanged()
        })
    }

    private fun getCurrentDate(whenn: Int): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -whenn)
        return sdf.format(calendar.time)
    }

    private fun setUpButtonsTextColors() {
        val btn1 = binding.btn1
        val btn2 = binding.btn2
        val btn3 = binding.btn3

        btn1.apply {
            setOnClickListener {
                setTextColor(resources.getColor(R.color.clicked))
                btn2.setTextColor(resources.getColor(R.color.defaultButtonText))
                btn3.setTextColor(resources.getColor(R.color.defaultButtonText))
                date = getCurrentDate(1)
                viewModel.getData(this@MainActivity, date = date)
            }
        }
        btn2.apply {
            setOnClickListener {
                setTextColor(resources.getColor(R.color.clicked))
                btn1.setTextColor(resources.getColor(R.color.defaultButtonText))
                btn3.setTextColor(resources.getColor(R.color.defaultButtonText))
                date = getCurrentDate(7)
                viewModel.getData(this@MainActivity, date = date)
            }
        }
        btn3.apply {
            setOnClickListener {
                setTextColor(resources.getColor(R.color.clicked))
                btn1.setTextColor(resources.getColor(R.color.defaultButtonText))
                btn2.setTextColor(resources.getColor(R.color.defaultButtonText))
                date = getCurrentDate(30)
                viewModel.getData(this@MainActivity, date = date)
            }
        }
    }

}
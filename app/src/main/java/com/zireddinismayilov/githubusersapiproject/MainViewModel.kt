package com.zireddinismayilov.githubusersapiproject

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zireddinismayilov.githubusersapiproject.data.RepositoryDTO
import com.zireddinismayilov.githubusersapiproject.retrofit.Instance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    var result = MutableLiveData<RepositoryDTO>()

    fun getData(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            Instance.instance.getRepos(date = "created%3A>2017-05-17", pageCount = 20).enqueue(object : Callback<RepositoryDTO> {
                override fun onResponse(call: Call<RepositoryDTO>, response: Response<RepositoryDTO>) {
                    val res = response.body() as RepositoryDTO
                    result.postValue(res)
                    Log.d("data", res.items[0].name)
                }

                override fun onFailure(call: Call<RepositoryDTO>, t: Throwable) {
                    Toast.makeText(context, "Failed to get data!", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
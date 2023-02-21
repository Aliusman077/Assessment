package com.example.assessmenttask.viewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessmenttask.retrofit.api.CatApi
import com.example.assessmenttask.retrofit.model.Cat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel :ViewModel() {
    private val TAG=javaClass.simpleName

    private val catFact: MutableLiveData<Cat?> = MutableLiveData()

    fun getCatFact() {
            val call: Call<Cat> = CatApi.retrofit.getCatFact()
            call.enqueue(object : Callback<Cat> {
                override fun onResponse(
                    call: Call<Cat>, response: Response<Cat>,
                ) {
                    Log.e(TAG, "message response " + response.message())
                    if (response.isSuccessful) {
                        catFact.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Cat>, t: Throwable) {
                    catFact.value = null
                    Log.e("TAG", "onFailure:  " + t.message)
                }

            })
    }

    fun getCatFactLiveData(): LiveData<Cat?>? {
        return catFact
    }



}
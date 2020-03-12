package com.amanguru.retrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
 val BASEURL:String="https://jsonplaceholder.typicode.com/"
    var mapdata =HashMap<String,String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      mapdata.put("userId","1")
        mapdata.put("_sort","id")
        mapdata.put("_order","desc")
        val retrofit:Retrofit=Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiRequest:ApiRequest=retrofit.create(ApiRequest::class.java)

        val call: Call<List<ModuleClass>> = apiRequest.getData(mapdata)
       call.enqueue(object :Callback<List<ModuleClass>>

       {
           override fun onFailure(call: Call<List<ModuleClass>>, t: Throwable) {

           }

           override fun onResponse(
               call: Call<List<ModuleClass>>,
               response: Response<List<ModuleClass>>
           ) {
               val data=response.body()
               if (data != null) {


                       Toast.makeText(applicationContext, data.toString(),
                           Toast.LENGTH_LONG).show()
               }
           }

       })


    }
}

package com.amanguru.retrofitapi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiRequest {

  @GET("posts")
 fun getData(@QueryMap data:Map<String,String>):Call<List<ModuleClass>>
}
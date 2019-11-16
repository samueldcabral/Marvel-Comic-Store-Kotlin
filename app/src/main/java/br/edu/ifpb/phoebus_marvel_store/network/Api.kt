package br.edu.ifpb.phoebus_marvel_store.network

import br.edu.ifpb.phoebus_marvel_store.retrofit_model.ComicsModel
import br.edu.ifpb.phoebus_marvel_store.retrofit_model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("comics")
    fun getComics(@Query("apikey") apiKey : String,
                  @Query("ts") ts : String,
                  @Query("hash") hash : String) : Call<ComicsModel>
}

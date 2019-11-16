package br.edu.ifpb.phoebus_marvel_store

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifpb.phoebus_marvel_store.config.Config
import br.edu.ifpb.phoebus_marvel_store.model.ComicBook
import br.edu.ifpb.phoebus_marvel_store.retrofit_model.ComicsModel
import br.edu.ifpb.phoebus_marvel_store.retrofit_model.Result
import br.edu.ifpb.phoebus_marvel_store.network.Api

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var listComics: ArrayList<Result> = arrayListOf()
    private var listSelected : HashMap<Int, ComicBook> = hashMapOf()
    private var listRareComics : ArrayList<Int> = arrayListOf()
    private lateinit var listView: ListView
    private lateinit var textAppbar : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        this.listView = findViewById(R.id.lvMain)
        this.textAppbar = findViewById(R.id.tvAppbar)

        fab.setOnClickListener { view ->
            val it = Intent(this, CheckoutActivity::class.java)
            it.putExtra("SELECTED", listSelected)
            it.putExtra("RARE", listRareComics)
            startActivity(it)
        }

        getComics()
        listView.adapter = ComicsAdapter(this, listComics, listSelected, listRareComics)
        listView.setOnItemClickListener(OnItemClickList())
    }

    fun getComics() {

        val BASE_URL = "http://gateway.marvel.com/v1/public/"
        val PUBLIC_KEY = Config.Keys.PUBLIC_KEY
        val PRIVATE_KEY = Config.Keys.PRIVATE_KEY

        val ts = System.currentTimeMillis().toString()
        var hash = generatorMd5(ts, PUBLIC_KEY, PRIVATE_KEY)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Api::class.java)
        val callback = service.getComics(PUBLIC_KEY, ts, hash)

        callback.enqueue(object : Callback<ComicsModel> {
            override fun onResponse(call: Call<ComicsModel>, response: Response<ComicsModel>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        var comicResponse = response.body()
                        listComics.addAll(comicResponse?.data!!.results)
                        listRareComics.addAll(getRandomRareComics(listComics.size))
//
//                        for(item in listRareComics) {
//                            Log.i("APP_MARVEL", "position is ${item}")
//                        }

                        (this@MainActivity.listView.adapter as ComicsAdapter).update()

//                        var index = 1
                        for(comic in listComics) {
//
                            Log.i("APP_MARVEL", "${comic.title} - Images: ${comic.images}")

//                            for(price in comic.prices) {
//                                Log.i("APP_MARVEL", "Prices: $${price.price} - type ${price.type}")
//                            }
//
//                            Log.i("APP_MARVEL", "-------------------------------------------------------")

//                            try{
//                                var path = "${comic.images.get(0).path}${comic.images.get(0).extension}"
//                                Log.i("APP_MARVEL", "\npath:  ${path}\n\n")
//                            } catch (e : Exception) {
//
//                            }

//                            if(index == 1 || index == 2) {
//                                try{
//                                    Log.i("APP_MARVEL", "get 0: ${result.images.get(0)} - ${result.images.get(0).path} - ${result.images.get(0).extension}")
//                                }catch (e : Throwable ) {
//                                    Log.i("APP_MARVEL", "something wrong")
//                                }
//                            }
////                            if(index == 1) {
////                                Log.i("APP_MARVEL", "get 0: ${result.images}")
//////                                Log.i("APP_MARVEL", "get 0: ${result.images.get(0)} - ${result.images.get(0).path} - ${result.images.get(0).extension}")
//////
//////                                Log.i("APP_MARVEL", "${result.images.get(0).path}${result.images.get(0).extension}")
////                                index++
//////                                Picasso.get().load("${result.images.get(0).path}${result.images.get(0).extension}").into(imageView);
////                            }
//                            index++
                        }


                    } else {
                        Log.e("APP_MARVEL", "Response error or null")
                    }
                } else {
                    Log.e("APP_MARVEL", "Response wasn't successful.\n${response.raw()}")
                }
            }

            override fun onFailure(call: Call<ComicsModel>, t: Throwable) {
                Log.e("APP_MARVEL", "On failure ${t}")
            }
        })

    }

    private fun getRandomRareComics(size: Int): MutableSet<Int> {
        var numberOfRareComics = Math.floor(size * 0.12).toInt()
        var listOfRare : MutableSet<Int> = mutableSetOf()

        for(i in 1..numberOfRareComics){
            listOfRare.add(Random.nextInt(0, size))
        }


        return listOfRare
    }

    private fun generatorMd5(ts: String, PUBLIC_KEY: String, PRIVATE_KEY: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(
                ts.toByteArray()
                        + PRIVATE_KEY.toByteArray()
                        + PUBLIC_KEY.toByteArray()
            )

            val no = BigInteger(1, messageDigest)

            var hashtext = no.toString(16)

            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            return hashtext

        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

    inner class OnItemClickList : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            var comic = listComics.get(position)
            var comicSelected : ComicBook

            try{
                comicSelected = ComicBook(comic.title, comic.prices.get(0).price)

            } catch (e : Exception) {
                comicSelected  = ComicBook(comic.title, "0.00")

                Log.i("APP_MARVEL", "Chegou no catch ${e.printStackTrace()}")
            }

            if(listSelected.get(position) != null) {
                this@MainActivity.listSelected.remove(position)
            }else {
                try{
                    this@MainActivity.listSelected.put(position, comicSelected)
                }catch (e : Exception) {

                }
            }

            var totalCostSelect : Double = 0.0

            for(entries in listSelected) {
                totalCostSelect += entries.value.price.toDouble()
            }

            if(listSelected.size > 0) {
                this@MainActivity.textAppbar.text = "Selected ${this@MainActivity.listSelected.size} comic(s). Order total $${totalCostSelect}"

            } else {
                this@MainActivity.textAppbar.text = "Touch the comic to add it to the cart"
            }

            (this@MainActivity.listView.adapter as ComicsAdapter).update()
        }
    }
}
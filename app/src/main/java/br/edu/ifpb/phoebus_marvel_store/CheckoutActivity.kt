package br.edu.ifpb.phoebus_marvel_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import br.edu.ifpb.phoebus_marvel_store.model.ComicBook
import br.edu.ifpb.phoebus_marvel_store.retrofit_model.Result
import kotlinx.android.synthetic.main.activity_main.*

class CheckoutActivity : AppCompatActivity() {
    private lateinit var textView : TextView
    private lateinit var editText : EditText
    private lateinit var listView : ListView
    private lateinit var button : Button
    private var listSelected : HashMap<Int, ComicBook> = hashMapOf()
    private var listRareComics : ArrayList<Int> = arrayListOf()
    private var listSelectPlusRareAdapter : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        setSupportActionBar(toolbar)

        this.textView = findViewById(R.id.tvCheckout)
        this.editText = findViewById(R.id.etCheckout)
        this.listView = findViewById(R.id.lvCheckout)
        this.button = findViewById(R.id.btCheckout)

        var selected : HashMap<Int, ComicBook> = intent.getSerializableExtra("SELECTED") as HashMap<Int, ComicBook>
        var rare : ArrayList<Int> = intent.getSerializableExtra("RARE") as ArrayList<Int>


        listSelected.putAll(selected)
        listRareComics.addAll(rare)

        for(comic in selected) {
            var title = ""

            if(rare.contains(comic.key)){
                title += "*RARE* "
            }

            if(comic.value.price != "0") {
                title += "${comic.value.title} - $${comic.value.price}"
            }else {
                title += "${comic.value.title} - $0.00"

            }


            listSelectPlusRareAdapter.add(title)
        }

        for(item in listSelectPlusRareAdapter ){
            Log.i("APP_MARVEL", "the final list is ${item}")

        }

//        Log.i("APP_MARVEL", "Checkout Activity -> listSelected ${listSelected}  size: ${listSelected.size}")
//        Log.i("APP_MARVEL", "Checkout Activity -> listRareComics ${listRareComics}  size: ${listRareComics.size}")

//        this.listView.adapter = CheckoutAdapter(this, listSelectPlusRareAdapter)

        this.listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listSelectPlusRareAdapter)
    }
}

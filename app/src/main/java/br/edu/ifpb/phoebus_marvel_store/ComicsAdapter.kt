package br.edu.ifpb.phoebus_marvel_store

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.edu.ifpb.phoebus_marvel_store.model.ComicBook
import br.edu.ifpb.phoebus_marvel_store.retrofit_model.Result
import com.squareup.picasso.Picasso
import java.lang.Exception

class ComicsAdapter(var context : Context,
                    var listComics : List<Result>,
                    var listSelected : HashMap<Int, ComicBook>,
                    var rare : ArrayList<Int>)  : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var layout : View

        if(convertView == null) {
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            layout = inflater.inflate(R.layout.adapter_main, null)
        } else {
            layout = convertView
        }

        if(listSelected.get(position) != null) {
            layout.setBackgroundColor(Color.rgb(236,203,204))
        }else {
            layout.setBackgroundColor(Color.WHITE)
        }

        val tvTitulo = layout.findViewById<TextView>(R.id.tvTitulo)
        val ivCapa = layout.findViewById<ImageView>(R.id.ivCapa)

        val comic = listComics.get(position)
        var price = ""
        var title = ""

        if(rare.contains(position)) {
            title = "*RARE* ${comic.title}"
        } else {
            title = comic.title
        }

        try{
            if(comic.prices.get(0).price == "0") {
                price = "FREE"
            }else {
                price = "$${comic.prices.get(0).price}"
            }
            tvTitulo.text = "${title} - ${price}"

        } catch(e : Exception) {
            tvTitulo.text = "${title} - $0.00"
        }

        try {
            var path = "${comic.images.get(0).path}.${comic.images.get(0).extension}"
//            Log.i("APP_MARVEL", "path:  ${path}")
            Picasso.get().load(path).into(ivCapa)

        } catch(e : Exception) {
//            Log.i("APP_MARVEL", "Something wrong this way comes")
        }

        return layout
    }

    override fun getItem(position: Int): Any {
        return listComics.get(position)
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getCount(): Int {
        return listComics.count()
    }

    fun update() {
        notifyDataSetChanged()
    }
}
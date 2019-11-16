package br.edu.ifpb.phoebus_marvel_store

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.edu.ifpb.phoebus_marvel_store.model.ComicBook
import br.edu.ifpb.phoebus_marvel_store.retrofit_model.Result
import java.lang.Exception

class CheckoutAdapter(var context : Context,
                      var listCheckout : ArrayList<String>)  : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var layout : View

        if(convertView == null) {
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            layout = inflater.inflate(R.layout.adapter_main, null)
        } else {
            layout = convertView
        }


//
        var textView = layout.findViewById<TextView>(R.id.tvCheckoutTitulo)

        try{
            textView.text = listCheckout.get(position)
        }catch (e : Exception) {
            textView.text = "Deu ruim pirraia"
        }


        return layout
    }

    override fun getItem(position: Int): Any {
        return listCheckout.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getCount(): Int {
        return listCheckout.size
    }
}
package com.meetic.espresso_template

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import java.util.*
import kotlinx.android.synthetic.main.list_activity.*

/**
 * Created by g.tan on 11/03/2016.
 */
class ListActivity : AppCompatActivity() {

    companion object {
        const val NUMBER_OF_ELEMENT : Int = 100;
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        val data : MutableList<String>  = ArrayList()
        var i = 0;
        while (i <= NUMBER_OF_ELEMENT) {
            data.add("element " + i);
            i++
        }
        val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        listView.adapter = adapter;
        listView.setOnItemClickListener { adapterView, view, position, id ->

            val itemName : String = adapterView.adapter.getItem(position) as String;

            var intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.BUNDLE_ITEM_NAME, itemName);
            startActivity(intent);
        }
    }
}
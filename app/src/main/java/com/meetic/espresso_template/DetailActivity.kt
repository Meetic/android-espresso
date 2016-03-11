package com.meetic.espresso_template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by g.tan on 11/03/2016.
 */
class DetailActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_ITEM_NAME : String = "BUNDLE_ITEM_NAME";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var itemName : String = intent.extras.getString(BUNDLE_ITEM_NAME);
        title = itemName;
    }
}
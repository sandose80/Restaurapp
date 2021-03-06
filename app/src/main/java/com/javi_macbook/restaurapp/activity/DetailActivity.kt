package com.javi_macbook.restaurapp.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.javi_macbook.restaurapp.R
import com.javi_macbook.restaurapp.model.Dish
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        private val EXTRA_DISH = "EXTRA_DISH"

        fun intent(context: Context, dish: Dish): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_DISH, dish)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dish = intent.getSerializableExtra(EXTRA_DISH) as? Dish

        if (dish != null){
            // Actualizamos la interfaz
            val dishImage = findViewById<ImageView>(R.id.dish_image)
            val dishName = findViewById<TextView>(R.id.dish_name)
            val dishDescription = findViewById<TextView>(R.id.dish_description)
            val dishPrice = findViewById<TextView>(R.id.dish_price)

            // Actualizo la vista(itemView) con el modelo (Dish)
            dishImage.setImageResource(dish.image)
            dishName.text = dish.name
            dishDescription.text = dish.description

            val priceString = getString(R.string.dish_price, dish.price)
            dishPrice.text = priceString

            var alergenos = dish.alergens

            for (alergen in 0 until dish.alergens.size){
                when (dish.alergens[alergen]){
                    "1" -> alergen_1.visibility = View.VISIBLE
                    "2" -> alergen_2.visibility = View.VISIBLE
                    "3" -> alergen_3.visibility = View.VISIBLE
                    "4" -> alergen_4.visibility = View.VISIBLE
                    "5" -> alergen_5.visibility = View.VISIBLE
                    "6" -> alergen_6.visibility = View.VISIBLE
                }
            }

//            val alergen_01Image = findViewById<ImageView>(R.id.alergen_1)
//            alergen_01Image.visibility = View.VISIBLE
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            // Sabemos que se ha pulsado la flecha de Back
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

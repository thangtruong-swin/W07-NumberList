package au.edu.swin.sdmd.w07_numberlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showListItems(100)
    }

    fun showListItems(items: Int) {
        val numberList = findViewById<RecyclerView>(R.id.numberList)
        val data = IntArray(items) { it }.filter { it % 3 == 0 || it % 5 == 0}
        val adapter = NumberAdapter(data) { showDetailSingleItem(it) }
        numberList.layoutManager = LinearLayoutManager(this)
        numberList.adapter = adapter
    }
    fun showDetailSingleItem(item: Int) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra("myNumber", item)
        startActivity(i)
    }
}
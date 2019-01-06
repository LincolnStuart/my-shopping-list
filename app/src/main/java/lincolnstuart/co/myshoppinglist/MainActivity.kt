package lincolnstuart.co.myshoppinglist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import lincolnstuart.co.myshoppinglist.adapter.ActiveShoppingListAdapter
import lincolnstuart.co.myshoppinglist.model.ShoppingList
import lincolnstuart.co.myshoppinglist.util.Param
import lincolnstuart.co.myshoppinglist.util.RequestCode
import lincolnstuart.co.myshoppinglist.util.ResultCode
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RequestCode.CREATE.value && resultCode == ResultCode.OK.value) {
            data?.let {
                val shoppingList = ShoppingList()
                shoppingList.title =  it.extras[Param.TITLE.value].toString()
                add(shoppingList)
            }
        }
    }

    private fun initComponents() {
        rv_shopping_lists.adapter = ActiveShoppingListAdapter(ArrayList(), this@MainActivity)
        rv_shopping_lists.layoutManager = LinearLayoutManager(applicationContext)
        fb_add_shopping_list.setOnClickListener {
            startActivityForResult(
                Intent(
                    this@MainActivity,
                    ShoppingListActivity::class.java
                ), RequestCode.CREATE.value
            )
        }
    }

    fun add(shoppingList: ShoppingList) {
        (rv_shopping_lists.adapter as ActiveShoppingListAdapter).lists.add(shoppingList)
        rv_shopping_lists.adapter.notifyDataSetChanged()
    }

}

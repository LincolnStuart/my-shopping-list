package lincolnstuart.co.myshoppinglist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import lincolnstuart.co.myshoppinglist.adapter.ActiveShoppingListAdapter
import lincolnstuart.co.myshoppinglist.model.ShoppingList
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        teste()
    }

    fun teste(){
        var lists: MutableList<ShoppingList> = ArrayList<ShoppingList>()
        var sl1 = ShoppingList()
        sl1.title = "Teste 1"
        sl1.date = Date()
        var sl2 = ShoppingList()
        sl2.title = "Teste 2"
        sl2.date = Date()
        lists.add(sl1)
        lists.add(sl2)
        rv_shopping_lists.adapter = ActiveShoppingListAdapter(lists, this@MainActivity)
        rv_shopping_lists.layoutManager = LinearLayoutManager(applicationContext)
        rv_shopping_lists.adapter
    }

}

package lincolnstuart.co.myshoppinglist.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_shopping_list.view.*
import lincolnstuart.co.myshoppinglist.R
import lincolnstuart.co.myshoppinglist.model.ShoppingList
import java.text.SimpleDateFormat
import java.util.*

class ActiveShoppingListAdapter(val lists: MutableList<ShoppingList>, private val context: Context) :
    RecyclerView.Adapter<ActiveShoppingListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_shopping_list, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = lists.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val shoppingList = lists[position]
        holder.bindView(shoppingList)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(shoppingList: ShoppingList) {
            itemView.tv_title.text = shoppingList.title
            val date = "(${shoppingList.date.format()})"
            itemView.tv_date.text = date
        }

        @SuppressLint("SimpleDateFormat")
        fun Date.format(): String{
            val formatter = SimpleDateFormat("dd/MM/yyy")
            return formatter.format(this)
        }

    }


}


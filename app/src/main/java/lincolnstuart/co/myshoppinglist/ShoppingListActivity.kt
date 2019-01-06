package lincolnstuart.co.myshoppinglist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_list.*
import lincolnstuart.co.myshoppinglist.util.Param
import lincolnstuart.co.myshoppinglist.util.ResultCode

class ShoppingListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
        initComponents()
    }

    private fun initComponents(){
        bt_submit.setOnClickListener{
            val intent = Intent()
            intent.putExtra(Param.TITLE.value, et_title.text)
            setResult(ResultCode.OK.value, intent)
            supportFinishAfterTransition()
        }
    }


    override fun onBackPressed() {
        setResult(ResultCode.CANCELLED.value)
        supportFinishAfterTransition()
    }

}

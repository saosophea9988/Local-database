package com.example.database01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun button(v:View){
        var city:String = editText.text.toString()
        var name:String = editText2.text.toString()

        var dtol = Staff(city, name)
        var helper = Myhelper(this)
        var res = helper.insertData(dtol)

        if(res==-1.toLong()){
            Toast.makeText(this,"Register fail",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Register success",Toast.LENGTH_LONG).show()
        }
    }
    fun button2(v:View)
    {
        var db = Myhelper(this)
        var list = db.readRecord()

        var str = ""
        for(i in list)
        {
            str += "city:" + i.city + "   name:"+i.sname+"\n"
        }
        textView.text = str
    }
}
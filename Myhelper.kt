package com.example.database01

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext
import android.database.sqlite.SQLiteException
var mylist = ArrayList<Staff>()
var DB_NAME = "mydb1"
var COL1 = "city"
var COL2 = "sname"
var TABLE_NAME = "staff"
class Myhelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, 1 ) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var s = "create table " +
                "$TABLE_NAME( $COL1 varchar(250)," +
                " $COL2 varchar(250));"
        p0?.execSQL(s)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun insertData(s:Staff): Long {
        var cv = ContentValues()

        cv.put(COL1,s.city)
        cv.put(COL2,s.sname)

        var db = this.writableDatabase
        var res = db.insert(TABLE_NAME,null,cv)

        return res
    }
    fun readRecord(): ArrayList<Staff>
    {
        var db = this.readableDatabase
        var c = db.rawQuery("Select * from $TABLE_NAME",null)
        if(c!= null){
            if(c.moveToFirst())
            {
                do
                {
                    var city = c.getString(c.getColumnIndex(COL1))
                    var name = c.getString(c.getColumnIndex(COL2))
                    var s = Staff(city,name)
                    mylist.add(s)
                }while (c.moveToNext())
            }
        }
        return mylist
    }
}
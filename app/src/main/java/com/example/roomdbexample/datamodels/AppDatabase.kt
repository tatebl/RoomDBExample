package com.example.roomdbexample.datamodels

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.roomdbexample.dao.CustomerData

@Database(entities = [Customer::class],version = 1,exportSchema=false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun customerDao():CustomerData     //pointer
    companion object {

        @Volatile    //anything that you right to INSTANCE will be available anywhere in app
        private var INSTANCE: AppDatabase?=null;

        fun getDatabase(context: Context):AppDatabase {    //returns database
            val tempInstance = INSTANCE
            if(tempInstance!=null) {
                return tempInstance
            }

            synchronized(this) {        //will lock the other objects to allow this function to
                                            //executes
                var instance= Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,"Brandon").build()

                INSTANCE = instance

                return instance

            }
        }
    }

}
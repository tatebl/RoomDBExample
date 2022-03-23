package com.example.roomdbexample.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdbexample.datamodels.Customer

@Dao
interface CustomerData {

    @Query("SELECT * FROM customer")
    fun fetchAllCustomer():LiveData<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomers(customer:Customer)

    @Query("DELETE FROM customer WHERE id=:id")
    suspend fun deleteCustomerById(id:Int)

}
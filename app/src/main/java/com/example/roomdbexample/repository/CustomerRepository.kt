package com.example.roomdbexample.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.roomdbexample.dao.CustomerData
import com.example.roomdbexample.datamodels.AppDatabase
import com.example.roomdbexample.datamodels.Customer

class CustomerRepository(application: Application) {

    private lateinit var customerDao:CustomerData

    init {
        var database= AppDatabase.getDatabase(application)
        customerDao = database.customerDao()
    }

    val readAllCustomers:LiveData<List<Customer>> = customerDao.fetchAllCustomer()

    suspend fun deleteCustomerById(id:Int) {        //logic written in CustomerData
        customerDao.deleteCustomerById(id)
    }

    suspend fun insertCustomer(customer: Customer) {
        customerDao.insertCustomers(customer)
    }


}
package com.sitaram.composeapp.features.database.room

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

abstract class DatabaseHelper : RoomDatabase() {

    // initialize the final variable
    private val DB_NAME: String = "UserDatabase"

    @Volatile
    private var instance: DatabaseHelper? = null

    // this methods are FIFO data
    @Synchronized
    open fun getDatabaseInstance(context: Context?): DatabaseHelper? {
        // check the instance is null object
        if (instance == null) {
            instance = databaseBuilder(context!!, DatabaseHelper::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
        return instance
    }

    // create the abstract methods
    abstract fun userDao(): Dao
}








//registerUser()?.subscribeOn(Schedulers.io())
//?.subscribe(object : CompletableObserver {
//    override fun onSubscribe(disposable: Disposable) {
//        compositeDisposable.add(disposable)
//    }
//
//    override fun onComplete() {
//    }
//
//    override fun onError(e: Throwable) {
//    }
//})
//
//private fun registerUser(): Completable? {
//    val userList = mutableListOf<UserPojo>()
//    userList.add(UserPojo("sonam100@gmail.com", "Sonam", "sonam011"))
//    userList.add(UserPojo("sonam200@gmail.com", "Sonam", "sonam022"))
//    userList.add(UserPojo("sonam300@gmail.com", "Sonam", "sonam033"))
//
//    val register = databaseHelper?.userDao()?.registerUser(userList)
//    Log.e("Completable: ", "$register")
//    return register
//}
//
//private fun allUsers() {
//    val name = databaseHelper?.userDao()?.getAllUsers("Jon Son")
//    Log.e("Username: ", "$name")
//}

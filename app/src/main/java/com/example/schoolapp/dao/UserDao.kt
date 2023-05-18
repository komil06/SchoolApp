package com.example.schoolapp.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.User



@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM user_table")
    fun getAllUsers():LiveData<List<User>>
}
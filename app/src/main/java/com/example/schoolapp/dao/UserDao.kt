package com.example.schoolapp.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.User



@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE userId = :userId")
    fun getUserById(userId: Int): User?

    @Query("SELECT * FROM user WHERE login = :login AND password = :password")
    fun login(login: String, password: String): User?

    @Insert
    fun insertUser(user: User) : Long

    @Delete
    fun deleteUser(user: User)
}
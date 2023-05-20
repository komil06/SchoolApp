package com.example.schoolapp.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.User



@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

//    @Query("SELECT * FROM users")
//    fun getAllUsers():LiveData<List<User>>

    @Delete
    fun deleteUser(user:User)

//    @Query("select * FROM users" + "where id = :id")
//    fun getUserById(id:Int):User
//
//    @Query("select * FROM users" + "where role = :role")
//    fun getUserByRole(role:String):User
}
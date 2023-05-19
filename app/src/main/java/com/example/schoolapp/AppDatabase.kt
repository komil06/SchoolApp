package com.example.schoolapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.schoolapp.dao.StudentDao
import com.example.schoolapp.dao.TeacherDao
import com.example.schoolapp.dao.UserDao
import com.example.schoolapp.entity.Teacher
import com.example.schoolapp.entity.User


@Database(entities = [User::class, ], version = 1)
abstract class AppDatabase: RoomDatabase(){
    companion object{
        var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app_data")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
    abstract fun getStudentDao(): StudentDao
    abstract fun getTeacherDao(): TeacherDao

    abstract fun getUserDao(): UserDao

}
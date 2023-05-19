package com.example.schoolapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo("user_name") var userName:String,
    var login:String,
    var password:String,
    var role:String
)

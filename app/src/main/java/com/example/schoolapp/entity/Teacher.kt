package com.example.schoolapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Teacher(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo("teacher_name") var teacherName:String,
    var login:String,
    var password:String
)

package com.example.schoolapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo("student_name") var studentName:String,
    var login:String,
    var password:String
)
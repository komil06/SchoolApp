package com.example.schoolapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo("student_name") var studentName:String,
    @ColumnInfo("student_class") var studentClass:String,
    var login:String,
    var password:String
)
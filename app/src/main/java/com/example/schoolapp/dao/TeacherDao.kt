package com.example.schoolapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.Teacher



@Dao
interface TeacherDao {
    @Query("SELECT * FROM teacher_subject")
    fun getAllTeacherSubjects(): List<Teacher>

    @Query("SELECT * FROM teacher_subject WHERE id = :id")
    fun getTeacherSubjectById(id: Int): Teacher?

    @Query("SELECT * FROM teacher_subject WHERE userId = :userId")
    fun getTeacherSubjectsByUserId(userId: Int): List<Teacher>

    @Insert
    fun insertTeacherSubject(teacherSubject: Teacher)

    @Delete
    fun deleteTeacherSubject(teacherSubject: Teacher)

    @Query("SELECT subjectId FROM teacher_subject WHERE userId = :userId")
    fun getSubjectIdByUserId(userId: Int): Int

}
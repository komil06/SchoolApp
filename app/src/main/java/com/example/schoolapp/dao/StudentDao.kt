package com.example.schoolapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.StudentSubject

@Dao
interface StudentDao {
    @Query("SELECT * FROM student_subject WHERE id = :id")
    fun getStudentSubjectById(id: Int): StudentSubject?

    @Query("SELECT * FROM student_subject WHERE userId = :userId")
    fun getStudentSubjectByUserId(userId: Int): StudentSubject?

    @Query("SELECT * FROM student_subject WHERE groupId = :groupId")
    fun getStudentsByGroupId(groupId: Int): List<StudentSubject>

    @Insert
    fun insertStudentSubject(studentSubject: StudentSubject)

    @Delete
    fun deleteStudentSubject(studentSubject: StudentSubject)
}
package com.example.schoolapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.Subject


@Dao
interface SubjectDao {
    @Query("SELECT * FROM subject")
    fun getAllSubjects(): List<Subject>

    @Query("SELECT * FROM subject WHERE subjectId = :subjectId")
    fun getSubjectById(subjectId: Int): Subject?

    @Insert
    fun insertSubject(subject: Subject)

    @Delete
    fun deleteSubject(subject: Subject)
}
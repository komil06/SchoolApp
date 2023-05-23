package com.example.schoolapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.Mark


@Dao
interface MarksDao {
    @Query("SELECT * FROM mark WHERE id = :id")
    fun getMarkById(id: Int): Mark?

    @Insert
    fun insertMark(mark: Mark)

    @Query("UPDATE mark SET mark = :mark WHERE id = :id")
    fun updateMarkValueById(id: Int, mark: Int)

    @Delete
    fun deleteMark(mark: Mark)

    @Query("SELECT * FROM mark WHERE teacherSubjectId = :teacherSubjectId " +
            "AND studentSubjectId = :studentSubjectId")
    fun getStudentMarkByTeacherSubjectId(teacherSubjectId: Int, studentSubjectId: Int): Mark?

    @Query("SELECT * FROM mark WHERE studentSubjectId = :studentSubjectId")
    fun getStudentMarkByStudentSubjectId(studentSubjectId: Int): Mark?

    @Query("SELECT * FROM mark WHERE studentSubjectId = :studentSubjectId")
    fun getMarksByStudentSubjectId(studentSubjectId: Int): List<Mark>

    @Query("SELECT * FROM mark WHERE studentSubjectId = :studentSubjectId AND subjectId = :subjectId")
    fun getMarkByStudentSubjectIdAndSubjectId(studentSubjectId: Int, subjectId: Int): Mark?

    @Query("SELECT * FROM mark WHERE teacherSubjectId = :teacherSubjectId")
    fun getMarksByTeacherSubjectId(teacherSubjectId: Int): List<Mark>
}
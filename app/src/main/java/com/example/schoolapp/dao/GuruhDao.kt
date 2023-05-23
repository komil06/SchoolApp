package com.example.schoolapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.schoolapp.entity.Group


@Dao
interface GuruhDao {
    @Query("SELECT * FROM guruh")
    fun getAllGroups(): List<Group>

    @Query("SELECT * FROM guruh WHERE groupId = :groupId")
    fun getGroupById(groupId: Int): Group?

    @Insert
    fun insertGroup(group: Group)

    @Delete
    fun deleteGroup(group: Group)
}
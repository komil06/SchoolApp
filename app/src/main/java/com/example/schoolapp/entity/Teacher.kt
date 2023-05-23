package com.example.schoolapp.entity

import androidx.room.*


@Entity(
    tableName = "teacher_subject",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = Subject::class,
            parentColumns = ["subjectId"],
            childColumns = ["subjectId"]
        ),
        ForeignKey(
            entity = Group::class,
            parentColumns = ["groupId"],
            childColumns = ["groupId"]
        )
    ],
    indices = [
        Index("userId"),
        Index("subjectId"),
        Index("groupId"),
    ]
)
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId: Int,
    val subjectId: Int,
    val groupId: Int,
)

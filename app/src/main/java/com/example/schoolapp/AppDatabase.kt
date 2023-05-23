package com.example.schoolapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.schoolapp.dao.*
import com.example.schoolapp.entity.*


@Database(
    entities = [
        User::class,
        Teacher::class,
        StudentSubject::class,
        Subject::class,
        Group::class,
        Mark::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app_data")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

    abstract fun getStudentDao(): StudentDao
    abstract fun getTeacherDao(): TeacherDao

    abstract fun getUserDao(): UserDao
    abstract class SchoolSystemDatabase : RoomDatabase() {

        abstract fun userDao(): UserDao
        abstract fun teacherSubjectDao(): TeacherDao
        abstract fun studentSubjectDao(): StudentDao
        abstract fun subjectDao(): SubjectDao
        abstract fun groupDao(): GuruhDao
        abstract fun markDao(): MarksDao


        class AddGroupIdToTeacherSubjectMigration : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE mark ADD COLUMN subjectId INTEGER NOT NULL DEFAULT 0")
            }
        }

        companion object {
            private const val DATABASE_NAME = "school_system_database"

            @Volatile
            private var INSTANCE: SchoolSystemDatabase? = null

            fun getInstance(context: Context): SchoolSystemDatabase {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        SchoolSystemDatabase::class.java,
                        DATABASE_NAME
                    )
                        .allowMainThreadQueries()
                        .addMigrations(AddGroupIdToTeacherSubjectMigration())
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}
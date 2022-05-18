package com.roomrelationships

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.roomrelationships.entities.Director
import com.roomrelationships.entities.School
import com.roomrelationships.entities.Student
import com.roomrelationships.entities.Subject
import com.roomrelationships.entities.relations.SchoolDao
import com.roomrelationships.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Subject::class,
        Director::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
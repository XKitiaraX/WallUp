package com.example.wallup.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BoulderProblem::class], version = 1, exportSchema = false)
abstract class ProblemDatabase: RoomDatabase() {

    abstract val problemDatabaseDao: ProblemDatabaseDao

    companion object{

        @Volatile
        private var INSTANCE: ProblemDatabase? = null

        fun getInstance(context: Context): ProblemDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, ProblemDatabase::class.java, "boulder_problems_database")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
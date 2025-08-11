package br.com.clb.testuserlistapp


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf((UserModel::class)), version = 1)


abstract class UserDb : RoomDatabase() {

    abstract fun UserDAO(): IUserDAO

    companion object {

        private lateinit var DBINSTANCE: UserDb
        fun getDatabase(context: Context): UserDb {
            if (!Companion::DBINSTANCE.isInitialized) {
                synchronized(UserDb::class) {
                    DBINSTANCE =
                        Room.databaseBuilder(context, UserDb::class.java, "UserDb")
                            .addMigrations(MIGRATION)
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return DBINSTANCE
        }

        private val MIGRATION: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM User")
            }
        }
    }
}
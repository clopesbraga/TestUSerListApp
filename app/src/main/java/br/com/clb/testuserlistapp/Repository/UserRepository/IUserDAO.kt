package br.com.clb.testuserlistapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface IUserDAO {

    @Insert
    fun insert(user: UserModel)

    @Update
    fun update(cpf: UserModel)

    @Delete
    fun delete(cpf: UserModel)

    @Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<UserModel>>

    @Query("SELECT * FROM User WHERE status = 1")
    fun getAllActive(): Flow<List<UserModel>>

    @Query("SELECT * FROM User WHERE status = 0")
    fun getAllDesative(): Flow<List<UserModel>>


}
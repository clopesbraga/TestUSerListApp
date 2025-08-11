package br.com.clb.testuserlistapp

import android.content.Context
import kotlinx.coroutines.flow.Flow


class UserRepository(private val context: Context) {

    private val base = UserDb.getDatabase(context).UserDAO()

    fun insert(user: UserModel) {
        base.insert(user)
    }

    suspend fun update(user: UserModel) {
        base.update(user)
    }

    suspend fun delete(user: UserModel) {
        base.delete(user)
    }

    suspend fun getAllUsers(): Flow<List<UserModel>> {
        return base.getAllUsers()
    }

    suspend fun getAllActive(): Flow<List<UserModel>> {
        return base.getAllActive()
    }

    suspend fun getAllDesative(): Flow<List<UserModel>> {
        return base.getAllDesative()
    }

}
package br.com.clb.testuserlistapp

import android.content.Context
import kotlinx.coroutines.flow.Flow


class UserRepository(private val context: Context) {

    private val base = UserDb.getDatabase(context).UserDAO()

    fun insert(user: UserModel) {
        base.insert(user)
    }

     fun update(user: UserModel) {
        base.update(user)
    }

     fun delete(user: UserModel) {
        base.delete(user)
    }

     fun getAllUsers(): Flow<List<UserModel>> {
        return base.getAllUsers()
    }

     fun getAllActive(): Flow<List<UserModel>> {
        return base.getAllActive()
    }

     fun getAllDesative(): Flow<List<UserModel>> {
        return base.getAllDesative()
    }

}
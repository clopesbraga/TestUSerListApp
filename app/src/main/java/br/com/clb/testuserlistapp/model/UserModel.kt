package br.com.clb.testuserlistapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User")
data class UserModel(

    @PrimaryKey(autoGenerate = false) val cpf: String,
    @ColumnInfo val name: String,
    @ColumnInfo val age: String,
    @ColumnInfo val city: String,
    @ColumnInfo val photo: String,
    @ColumnInfo val status: Boolean
)




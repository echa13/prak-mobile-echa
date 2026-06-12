package com.example.orangcantkikapps.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.orangcantkikapps.data.entity.NoteEntity

    @Dao
    interface NoteDao {
        @Query("SELECT * FROM notes")
        suspend fun getAll(): List<NoteEntity>

        @Insert
        suspend fun insert(note: NoteEntity)

        @Delete
        suspend fun delete(note: NoteEntity)
    }
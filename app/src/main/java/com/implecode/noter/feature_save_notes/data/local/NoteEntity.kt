package com.implecode.noter.feature_save_notes.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "notes_table"
)
data class NoteEntity(
    @PrimaryKey(
        autoGenerate = false
    )
    val timestamp: Long,
    val title: String,
    val desc: String,
    val isPinned: Boolean,
    val category: String
)

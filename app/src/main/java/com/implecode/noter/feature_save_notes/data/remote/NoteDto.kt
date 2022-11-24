package com.implecode.noter.feature_save_notes.data.remote

data class NoteDto(
    val timestamp: Long?,
    val title: String?,
    val description: String?,
    val category: String?,
    val is_pinned: Boolean?,
    val modified_at: Long?
)

package com.softylur.mynotes.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val noteTitle: String,
    val noteContent: String,
    //val timestamp: Long = System.currentTimeMillis()
) : Parcelable

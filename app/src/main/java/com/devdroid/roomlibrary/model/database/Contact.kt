package com.devdroid.roomlibrary.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact_table")
data class Contact(
    @PrimaryKey(autoGenerate = true) var id : Int=0,
    var name : String,
    var phoneNumber: String,
    var email : String,
    var image : ByteArray? = null
)

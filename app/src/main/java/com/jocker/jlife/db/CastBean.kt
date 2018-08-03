package com.jocker.jlife.db

import androidx.room.*
import com.jocker.jlife.beans.Avaters

@Entity(foreignKeys = [(ForeignKey(entity = SubjectBean::class, parentColumns = [ID],
        childColumns = [SUBJECT_ID]))],
        tableName = TABLE_NAME_CASTS)
data class CastBean constructor(
        val alt: String,
        @Embedded val avatars: Avaters,
        val name: String,
        @PrimaryKey val id: Long,
        @ColumnInfo(name = SUBJECT_ID,index = true) var subjectId: Long
) {

}

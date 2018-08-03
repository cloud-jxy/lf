package com.jocker.jlife.db

import androidx.room.*
import com.jocker.jlife.beans.Avaters
import com.jocker.jlife.beans.Rating

@Entity(tableName = TABLE_NAME_SUBJECT)
data class SubjectBean(
        @Embedded val rating: Rating,
        val genres: List<String>,
        val title: String,
        val collect_count: Long,
        val original_title: String,
        val subtype: String,
        val year: String,
        @Embedded val images: Avaters,
        val alt: String,
        @PrimaryKey @ColumnInfo(name = ID, index = true) val id: Long

) {

}
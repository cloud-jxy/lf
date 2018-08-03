package com.jocker.jlife.beans

import androidx.room.Embedded
import androidx.room.Relation
import com.jocker.jlife.db.*

/**
 * < 1. 参数设置为 var  设置为 val 会报错 >
 *
 */
class Subjects(
        @Embedded var rating: Rating? = null,
        var genres: List<String> = arrayListOf(),
        var title: String = "",
        var collect_count: Long = 0L,
        var original_title: String = "",
        var subtype: String = "",
        var year: String = "",
        @Embedded var images: Avaters? = null,
        var alt: String = "",
        var id: Long = 0L,
        @Relation(entity = CastBean::class, parentColumn = ID, entityColumn = SUBJECT_ID)
        var casts: List<CastBean> = arrayListOf(),
        @Relation(entity = DirectorBean::class, parentColumn = ID, entityColumn = SUBJECT_ID)
        var directors: List<DirectorBean> = arrayListOf()
) {

}
package com.jocker.jlife.db

import androidx.lifecycle.Transformations
import androidx.paging.DataSource
import androidx.room.*
import com.jocker.jlife.beans.Subjects
import kotlin.concurrent.timer

/**
 * 数据库的操作需要在子线程中进行
 */
@Dao
interface SubjectsDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSubjectBean(subjectBean: SubjectBean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCast(casts: List<CastBean>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDirectors(directors: List<DirectorBean>)

    /**
     * 非 entity 的抽象方法 增删改查需要设置 @Transaction
     */
    @Transaction
    fun insertSubject(subjects: List<Subjects>) {
        subjects.map {
            insertSubjectBean(SubjectBean(it.rating!!, it.genres, it.original_title, it.collect_count,
                    it.original_title, it.subtype,
                    it.year, it.images!!, it.alt, it.id))
            it.casts.map {
                castBean -> castBean.subjectId = it.id
            }
            insertCast(it.casts)
            it.directors.map {
                directorBean -> directorBean.subjectId = it.id
            }
            insertDirectors(it.directors)
        }
    }

    @Transaction
    @Query("select * from table_subjects")
    fun querySubjects(): DataSource.Factory<Int, Subjects>

}
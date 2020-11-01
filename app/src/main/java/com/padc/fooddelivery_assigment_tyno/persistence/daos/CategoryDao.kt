package com.padc.fooddelivery_assigment_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO

@Dao
interface CategoryDao {

    @Query("SELECT * FROM tbCategory")
    @ColumnInfo
    fun getAllCategoriesList(): LiveData<List<CategoryVO>>

    @Query("DELETE FROM tbCategory")
    @ColumnInfo
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @ColumnInfo
    fun insertAllCategory(categoryVO:  List<CategoryVO>)
}
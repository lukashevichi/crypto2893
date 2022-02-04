package by.maxluxs.domain_local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import by.maxluxs.domain_local.Contract.CONCURRENCY_TABLE_NAME
import by.maxluxs.domain_local.model.ConcurrencyLocal
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ConcurrencyDao {

    // Rx interface
    /**
     * CREATE
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(concurrency: ConcurrencyLocal): Completable

    /**
     * READ
     */
    @Query("SELECT * FROM $CONCURRENCY_TABLE_NAME")
    fun getAll(): Single<List<ConcurrencyLocal>>

    @Query("SELECT * FROM $CONCURRENCY_TABLE_NAME WHERE ID = :id LIMIT 1")
    fun get(id: String): Single<ConcurrencyLocal>

    /**
     * DELETE
     */
    @Delete
    fun delete(concurrency: ConcurrencyLocal): Completable

    /**
     * OBSERVE
     */
    @Query("SELECT COUNT(*) FROM $CONCURRENCY_TABLE_NAME")
    fun observeAllCount(): LiveData<Int>

    @Query("SELECT COUNT(*) FROM $CONCURRENCY_TABLE_NAME")
    fun getAllCount(): Int

}

package by.maxluxs.data.local.database.factory

import android.content.Context
import androidx.room.Room
import by.maxluxs.data.local.database.CurrencyDataBase

object CurrencyDataBaseFactory {

    private const val CURRENCY_DB_NAME = "CURRENCY.db"

    fun create(context: Context) =
        Room.databaseBuilder(context, CurrencyDataBase::class.java, CURRENCY_DB_NAME)

}
package com.example.worldskillbank.db

import android.provider.BaseColumns

object MyDbNameClass: BaseColumns
{
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_SUM = "sum"
    const val COLUMN_NAME_PASSWORD = "password"
    const val COLUMN_NAME_EMAIL = "email"
    const val COLUMN_NAME_LOGIN = "Login"
    const val COLUMN_NAME_per_day = "per_day"
    const val COLUMN_NAME_Card_number = "Card_number"

    const val DATABASE_VERSION = 2  //версия
    const val DATABASE_NAME = "Registration.db"  //Название

    const val CREAT_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME ("+
            "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_SUM TEXT, $COLUMN_NAME_PASSWORD TEXT, $COLUMN_NAME_EMAIL TEXT, $COLUMN_NAME_LOGIN TEXT, $COLUMN_NAME_per_day TEXT," +
            "$COLUMN_NAME_Card_number TEXT)"



    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}
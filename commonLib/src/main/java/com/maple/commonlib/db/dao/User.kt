package com.maple.commonlib.db.dao
import androidx.room.*
@Entity(tableName = "users")
class User {

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

    @ColumnInfo(name = "userId")
    var userId:String? = ""

    @ColumnInfo(name = "accessToken")
    var accessToken:String? = ""

    @ColumnInfo(name = "username")
    var username:String? = ""

    @ColumnInfo(name = "phone")
    var phone:String? = ""

    @ColumnInfo(name = "avatar")
    var avatar:String? = ""

}
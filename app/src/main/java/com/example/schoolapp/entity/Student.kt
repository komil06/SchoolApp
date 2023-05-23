package com.example.schoolapp.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*


@Entity(
    tableName = "student_subject",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = Group::class,
            parentColumns = ["groupId"],
            childColumns = ["groupId"]
        )
    ],
    indices = [
        Index("userId"),
        Index("groupId")
    ]
)
data class StudentSubject(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId: Int,
    val groupId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(userId)
        parcel.writeInt(groupId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentSubject> {
        override fun createFromParcel(parcel: Parcel): StudentSubject {
            return StudentSubject(parcel)
        }

        override fun newArray(size: Int): Array<StudentSubject?> {
            return arrayOfNulls(size)
        }
    }
}
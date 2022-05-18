package com.roomrelationships.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.roomrelationships.entities.School
import com.roomrelationships.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
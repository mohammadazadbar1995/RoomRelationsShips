package com.roomrelationships.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.roomrelationships.entities.Director
import com.roomrelationships.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
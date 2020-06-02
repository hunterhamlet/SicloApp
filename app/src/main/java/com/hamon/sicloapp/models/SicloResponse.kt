package com.hamon.sicloapp.models

import com.squareup.moshi.Json

data class SicloResponse(
    @field:Json(name = "calendar") val calendar: Map<String, List<SicloClass>> = mapOf<String, List<SicloClass>>(),
    @field:Json(name = "instructors") val instructors: List<Instructor> = listOf()
)

data class SicloClass(
    @field:Json(name = "textoEspecial") val textoEspecial: String = "",
    @field:Json(name = "duration") val duration: Int = 0,
    @field:Json(name = "intensity") val intensity: Int = 0,
    @field:Json(name = "fecha") val fecha: String = "",
    @field:Json(name = "tipo") val tipo: String = "",
    @field:Json(name = "class_type") val classType: Int = 0,
    @field:Json(name = "instructor") val instructor: Instructor = Instructor(),
    @field:Json(name = "hour") val hour: String = "",
    @field:Json(name = "id") val id: Int = 0
)

data class Playlist(
    @field:Json(name = "reference_id") val referenceId: String = "",
    @field:Json(name = "name") val name: String = "",
    @field:Json(name = "active") val active: Boolean = false,
    @field:Json(name = "id") val id: Int = 0
)

data class Instructor(
    @field:Json(name = "face_photo") val facePhoto: String = "",
    @field:Json(name = "full_photo") val fullPhoto: String = "",
    @field:Json(name = "playlist") val playlist: Playlist = Playlist(),
    @field:Json(name = "id") val id: Int = 0,
    @field:Json(name = "interests") val interests: Interests = Interests(),
    @field:Json(name = "nombre") val nombre: String = ""
)

data class Interests(
    @field:Json(name = "surprise") val surprise: String = "",
    @field:Json(name = "music") val music: String = "",
    @field:Json(name = "instructor") val instructor: Int = 0,
    @field:Json(name = "fitness") val fitness: String = "",
    @field:Json(name = "activities") val activities: String = "",
    @field:Json(name = "inspiration") val inspiration: String = "",
    @field:Json(name = "philosophy") val philosophy: String = ""
)
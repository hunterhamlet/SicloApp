package com.hamon.sicloapp.models

import com.squareup.moshi.Json

data class SicloResponse(
    @field:Json(name = "calendar") val calendar: Calendar = Calendar(),
    @field:Json(name = "instructors") val instructors: List<InstructorsItem> = listOf()
)

data class Dom31Item(
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

data class SB30Item(
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

data class InstructorsItem(
    @field:Json(name = "face_photo") val facePhoto: String = "",
    @field:Json(name = "full_photo") val fullPhoto: String = "",
    @field:Json(name = "playlist") val playlist: Playlist = Playlist(),
    @field:Json(name = "id") val id: Int = 0,
    @field:Json(name = "interests") val interests: Interests = Interests(),
    @field:Json(name = "nombre") val nombre: String = ""
)

data class Calendar(
    @field:Json(name = "Mié 03") val mi03: List<Mi03Item> = listOf(),
    @field:Json(name = "Mar 02") val mar02: List<Mar02Item> = listOf(),
    @field:Json(name = "Sáb 30") val sB30: List<SB30Item> = listOf(),
    @field:Json(name = "Dom 31") val dom31: List<Dom31Item> = listOf(),
    @field:Json(name = "Lun 01") val lun01: List<Lun01Item> = listOf()
)

data class Mar02Item(
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

data class Lun01Item(
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

data class Interests(
    @field:Json(name = "surprise") val surprise: String = "",
    @field:Json(name = "music") val music: String = "",
    @field:Json(name = "instructor") val instructor: Int = 0,
    @field:Json(name = "fitness") val fitness: String = "",
    @field:Json(name = "activities") val activities: String = "",
    @field:Json(name = "inspiration") val inspiration: String = "",
    @field:Json(name = "philosophy") val philosophy: String = ""
)

data class Mi03Item(
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

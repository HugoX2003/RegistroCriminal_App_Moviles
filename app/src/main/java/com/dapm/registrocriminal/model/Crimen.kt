package com.dapm.registrocriminal.model

import java.util.Date
import java.util.UUID

data class Crimen(
    val id: UUID,
    var titulo: String,
    var fecha: Date,
    var resuelto: Boolean
)
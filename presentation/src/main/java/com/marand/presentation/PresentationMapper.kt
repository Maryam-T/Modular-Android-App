package com.marand.presentation

import com.marand.domain.Entity

interface PresentationMapper<E: Entity, P: PresentationModel> {

    fun toPresentation(entity: E): P
}

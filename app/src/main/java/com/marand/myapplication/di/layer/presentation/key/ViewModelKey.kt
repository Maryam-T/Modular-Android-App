package com.marand.myapplication.di.layer.presentation.key

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

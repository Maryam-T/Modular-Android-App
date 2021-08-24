package com.marand.myapplication.di.global.module

import com.marand.myapplication.di.layer.presentation.main.component.MainComponent
import dagger.Module

@Module(subcomponents = [
    MainComponent::class
])
class SubComponentsModule

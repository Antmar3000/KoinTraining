package com.am.kointraining.di

import com.am.kointraining.MainActivity
import com.am.kointraining.data.entity.MockEntity
import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule = module {
    scope<MainActivity> {
        scoped(qualifier = named("hello")) { "Hello" }
        scoped(qualifier = named("bye")) { "Bye" }
        scoped(qualifier = named("entity")) { MockEntity("name", 1) }
    }
}
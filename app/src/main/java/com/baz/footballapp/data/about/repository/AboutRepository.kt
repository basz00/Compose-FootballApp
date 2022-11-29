package com.baz.footballapp.data.about.repository

import com.baz.footballapp.data.about.source.DummyDataSource
import kotlinx.coroutines.flow.flowOf

class AboutRepository {
    fun getAbout() = flowOf(DummyDataSource.dummyAbout)
}
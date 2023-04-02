package com.example.applab1.repository

import com.example.applab1.data.Item
import java.util.*

interface SampleRepository {
    fun getSampleList(): List<Item>
    fun getSampleItem(id: UUID): Item?
}
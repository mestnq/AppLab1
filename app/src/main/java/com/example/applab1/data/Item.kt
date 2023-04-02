package com.example.applab1.data

import java.util.*

sealed class Item
{
    abstract val id: UUID
    abstract val viewType :Int
    abstract val header: String
    abstract val subheadForHeader: String

    data class SmallItem(
        override val id: UUID = UUID.randomUUID(),
        override val viewType: Int,
        override val header: String,
        override val subheadForHeader: String,
    ) : Item ()

    data class BigItem(
        override val id: UUID = UUID.randomUUID(),
        override val viewType: Int,
        override val header: String,
        override val subheadForHeader: String,
        val title: String,
        val subheadForTitle: String,
        val description: String
    ) : Item()
}
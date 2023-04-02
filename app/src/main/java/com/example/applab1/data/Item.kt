package com.example.applab1.data

import java.util.*

sealed class Item {
    abstract val id: UUID
    abstract val viewType :Int
    abstract val header: String
    abstract val subheadForHeader: String
    abstract val title: String
    abstract val subheadForTitle: String
    abstract val description: String

    data class SmallItem(
        override val id: UUID = UUID.randomUUID(),
        override val viewType: Int,
        override val header: String,
        override val subheadForHeader: String,
        override val title: String,
        override val subheadForTitle: String,
        override val description: String
    ) : Item ()

    data class BigItem(
        override val id: UUID = UUID.randomUUID(),
        override val viewType: Int,
        override val header: String,
        override val subheadForHeader: String,
        override val title: String,
        override val subheadForTitle: String,
        override val description: String
    ) : Item()
}
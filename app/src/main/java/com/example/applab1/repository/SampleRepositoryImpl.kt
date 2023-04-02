package com.example.applab1.repository

import com.example.applab1.data.Item
import java.util.*

class SampleRepositoryImpl: SampleRepository {

    companion object {
        const val ONLY_ID_FOR_AVATAR = 0
    }

    private val items = listOf(
        Item.BigItem(
            viewType = 1,
            header = "Супер-крутой носок",
            subheadForHeader = "Ваще крутой мега потрясающий носок",
            title = "Носок с супер-крутым Дональдом Даком",
            subheadForTitle = "Потрясающий носок даст вам ощущение богатства в ваших ногах",
            description = "Снимает сглаз, порчу, завистников и притягивает деньги, не надо дышать ногами - деньги сами придут"
        ),
        Item.SmallItem(
            viewType = 0,
            header = "Чуть менее крутой носок",
            title = "Носок с супер-крутым Дональдом Даком",
            subheadForHeader = "Все еще крутой носок",
            subheadForTitle = "Потрясающий носок даст вам ощущение богатства в ваших ногах",
            description = "Снимает сглаз, порчу, завистников и притягивает деньги, не надо дышать ногами - деньги сами придут"
        ),
        Item.SmallItem(
            viewType = 0,
            header = "Мега-хороший носок",
            subheadForHeader = "Приемлемый уровень хорошести носка",
            title = "Носок с супер-крутым Дональдом Даком",
            subheadForTitle = "Потрясающий носок даст вам ощущение богатства в ваших ногах",
            description = "Снимает сглаз, порчу, завистников и притягивает деньги, не надо дышать ногами - деньги сами придут"
        ),
        Item.SmallItem(
            viewType = 0,
            header = "Приколдесный носок",
            title = "Носок с супер-крутым Дональдом Даком",
            subheadForHeader = "Приемлемый уровень приколдесности носка",
            subheadForTitle = "Потрясающий носок даст вам ощущение богатства в ваших ногах",
            description = "Снимает сглаз, порчу, завистников и притягивает деньги, не надо дышать ногами - деньги сами придут"
        ),
    )

    override fun getSampleList(): List<Item> {
        return items
    }

    override fun getSampleItem(id: UUID): Item? {
        return this.items.find { it.id == id }
    }
}
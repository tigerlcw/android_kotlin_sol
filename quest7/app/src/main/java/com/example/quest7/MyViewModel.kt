package com.example.quest7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Item(val name: String, val phone: String)

class MyViewModel: ViewModel() {
    val items = ArrayList<Item>()
    val itemsLiveData = MutableLiveData<ArrayList<Item>>()
    var changedItemPos = -1
    var longClickItem: Int = -1

    init {
        addItem(Item("이찬우", "010-1234-5678"))
        addItem(Item("허준영 교수님", "010-9876-5432"))
    }

    fun addItem(item: Item){
        items.add(item)
        itemsLiveData.value = items
    }

    fun updateItem(item: Item, pos: Int){
        items[pos] = item
        itemsLiveData.value = items
        changedItemPos = pos
    }

    fun deleteItem(pos: Int){
        items.removeAt(pos)
        itemsLiveData.value = items
    }

}
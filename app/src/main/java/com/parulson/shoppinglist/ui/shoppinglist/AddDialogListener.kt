package com.parulson.shoppinglist.ui.shoppinglist

import com.parulson.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}
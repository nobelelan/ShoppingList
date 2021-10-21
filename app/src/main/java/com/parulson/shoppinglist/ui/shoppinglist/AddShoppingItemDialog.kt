package com.parulson.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.parulson.shoppinglist.data.db.entities.ShoppingItem
import com.parulson.shoppinglist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener{
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()
            if (name.isEmpty()||amount.isEmpty()){
                Toast.makeText(context,"Please enter all the information", Toast.LENGTH_SHORT).show()
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        binding.tvCancel.setOnClickListener {
            cancel()
        }

    }
}
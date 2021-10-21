package com.parulson.shoppinglist.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parulson.shoppinglist.data.db.entities.ShoppingItem
import com.parulson.shoppinglist.databinding.ShoppingItemBinding
import com.parulson.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(ShoppingItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.binding.tvName.text = curShoppingItem.name
        holder.binding.tvAmount.text = curShoppingItem.amount.toString()

        holder.binding.ivDelete.setOnClickListener{
            viewModel.delete(curShoppingItem)
        }
        holder.binding.ivPlus.setOnClickListener {
            ++curShoppingItem.amount
            viewModel.upsert(curShoppingItem)
        }
        holder.binding.ivMinus.setOnClickListener {
            if (curShoppingItem.amount>0){
                --curShoppingItem.amount
                viewModel.upsert(curShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
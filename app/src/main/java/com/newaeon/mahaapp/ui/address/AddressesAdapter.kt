package com.newaeon.mahaapp.ui.address

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.ui.product.GetAllProductsData
import com.newaeon.mahaapp.ui.product.ProductAdapter
import org.w3c.dom.Text

class AddressesAdapter (private val items: List<GetCustomerAddressesData> ) :
    RecyclerView.Adapter<AddressesAdapter.ItemViewHolder>() {

  inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      private val city: TextView = itemView.findViewById(R.id.tv_city)
      private val address1: TextView = itemView.findViewById(R.id.tv_address1)
      private val address2: TextView = itemView.findViewById(R.id.tv_address2)
      private val longitude: TextView = itemView.findViewById(R.id.tv_longitude)
      private val latitude: TextView = itemView.findViewById(R.id.tv_latitude)
      private val edit: TextView = itemView.findViewById(R.id.tv_edit)
      private val delete: TextView = itemView.findViewById(R.id.tv_delete)


      @SuppressLint("SetTextI18n")
      fun setData(getAllAddresses: GetCustomerAddressesData) {
          city.text =   "City : ${getAllAddresses.city}"
          address1.text = "Address 1 : ${getAllAddresses.address1}"
          address2.text =  "Address 2 : ${getAllAddresses.address2}"
          longitude.text =  "Longitude : ${getAllAddresses.longitude}"
          latitude.text ="Latitude : ${getAllAddresses.latitude}"
      }
  }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AddressesAdapter.ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.address_cell, parent, false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: AddressesAdapter.ItemViewHolder, position: Int) {
        holder.setData(items[position])

        holder.itemView.setOnClickListener {


        }
    }

    override fun getItemCount() = items.size
    }



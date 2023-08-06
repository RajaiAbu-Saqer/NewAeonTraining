package com.newaeon.mahaapp.ui.address

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.newaeon.mahaapp.R

class AddressesAdapter(
    private val items: List<GetCustomerAddressesData>,
    val deleteClicked: (getAllAddresses: GetCustomerAddressesData) -> Unit,
    val editClicked: (getAllAddresses: GetCustomerAddressesData) -> Unit
) :
    RecyclerView.Adapter<AddressesAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val city: TextView = itemView.findViewById(R.id.tv_city)
        private val address1: TextView = itemView.findViewById(R.id.tv_address1)
        private val address2: TextView = itemView.findViewById(R.id.tv_address2)
        private val longitude: TextView = itemView.findViewById(R.id.tv_longitude)
        private val latitude: TextView = itemView.findViewById(R.id.tv_latitude)
        val edit: TextView = itemView.findViewById(R.id.tv_edit)
        private val delete: TextView = itemView.findViewById(R.id.tv_delete)


        @SuppressLint("SetTextI18n")
        fun initHolder(getAllAddresses: GetCustomerAddressesData) {
            city.text = "City : ${getAllAddresses.city}"
            address1.text = "Address 1 : ${getAllAddresses.address1}"
            address2.text = "Address 2 : ${getAllAddresses.address2}"
            longitude.text = "Longitude : ${getAllAddresses.longitude}"
            latitude.text = "Latitude : ${getAllAddresses.latitude}"
            itemCLicked(getAllAddresses)
        }

        fun itemCLicked(getAllAddresses: GetCustomerAddressesData) {
            edit.setOnClickListener {
                editClicked.invoke(getAllAddresses)

            }
            delete.setOnClickListener {
                deleteClicked.invoke(getAllAddresses)

            }
//            three({ one() })
        }
    }

    //    fun three(xx:()->Int){
//
//    }
//    fun one():Int{
//        return  5
//    }
//    fun two(){
//
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AddressesAdapter.ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.address_cell, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddressesAdapter.ItemViewHolder, position: Int) {
        holder.initHolder(items[position])
    }

    override fun getItemCount() = items.size


}



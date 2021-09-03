package me.burle.exorshock

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi

class ArrayAdapterBluetooth(context: Context, private val resource: Int, bluetoothDevices: List<BluetoothDevice>) : ArrayAdapter<BluetoothDevice>(context, resource, bluetoothDevices) {

    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var name: String? = getItem(position)!!.alias
        if(name == null || name == "") {
            name = getItem(position)!!.name
        }
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(resource, parent, false)
        val textViewName: TextView = view.findViewById(R.id.textName)
        textViewName.text = name
        return view
    }
}
package me.burle.exorshock

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import android.widget.AdapterView.OnItemLongClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var bluetoothManager: BluetoothManager
    private lateinit var bluetoothAdapter: BluetoothAdapter

    private lateinit var switchBluetooth: SwitchCompat
    private lateinit var listDevices: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchBluetooth = findViewById(R.id.switchBluetooth)
        listDevices = findViewById(R.id.listDevices)

        if(packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager

            switchBluetooth.setOnCheckedChangeListener {_, isChecked ->
                if(isChecked) {
                    if(!bluetoothAdapter.isEnabled) {
                        bluetoothAdapter.enable()
                    }
                } else {
                    if(bluetoothAdapter.isEnabled) {
                        bluetoothAdapter.disable()
                    }
                }
                listBondedDevices()
            }

            listDevices.onItemLongClickListener = OnItemLongClickListener { parent, _, position, _ ->
                val intent = Intent(this, ConnectionActivity::class.java)
                intent.putExtra("device", parent.getItemAtPosition(position) as BluetoothDevice)
                startActivity(intent)
                Toast.makeText(this, "Connecting ...", Toast.LENGTH_SHORT).show()
                true
            }
        } else {
            Toast.makeText(this, "This device doesn't have Bluetooth!", Toast.LENGTH_LONG).show()
            switchBluetooth.isEnabled = false
        }
    }

    override fun onResume() {
        super.onResume()
        bluetoothAdapter = bluetoothManager.adapter
        switchBluetooth.isChecked = bluetoothAdapter.isEnabled
        listBondedDevices()
    }

    private fun listBondedDevices() {
        val bluetoothArrayAdapter: ArrayAdapterBluetooth = ArrayAdapterBluetooth(this, R.layout.list_item, bluetoothAdapter.bondedDevices.toList())
        listDevices.adapter = bluetoothArrayAdapter
    }
}
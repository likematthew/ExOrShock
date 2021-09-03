package me.burle.exorshock

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.io.IOException
import java.io.OutputStream
import java.util.*

class ConnectionActivity : AppCompatActivity() {

    private val bluetoothConnectionService: BluetoothConnectionService = BluetoothConnectionService()
    private lateinit var device: BluetoothDevice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)
        val extras = intent.extras
        if (extras != null) {
            device = extras.get("device") as BluetoothDevice
            bluetoothConnectionService.start(device)
        }
    }
}
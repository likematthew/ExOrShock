package me.burle.exorshock

import android.bluetooth.BluetoothDevice
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ConnectionActivity : AppCompatActivity() {

    private val bluetoothConnectionService: BluetoothConnectionService = BluetoothConnectionService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)
        val extras = intent.extras
        if (extras != null) {
            bluetoothConnectionService.start(extras.get("device") as BluetoothDevice)
            Toast.makeText(this, "Connecting ...", Toast.LENGTH_SHORT).show()
            println("Start Bluetooth Connection.")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bluetoothConnectionService.close()
        println("Stop Bluetooth Connection.")
    }
}
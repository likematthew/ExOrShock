package me.burle.exorshock

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.Looper
import android.widget.Toast
import java.io.IOException
import java.io.OutputStream
import java.util.*

class BluetoothConnectionService(private var context: Context) {

    private val myUUID: UUID = UUID.fromString("5488c582-7fe8-4560-8523-4fc76ce44b7a")

    private lateinit var connectThread: ConnectThread

    @Synchronized
    fun start (bluetoothDevice: BluetoothDevice) {
        connectThread = ConnectThread(context, bluetoothDevice, myUUID)
        connectThread.start()
    }

    fun close() {
        connectThread.close()
    }

    fun send(seconds: Int) {
        connectThread.send(seconds)
    }

    private class ConnectThread(private val context: Context, private val bluetoothDevice: BluetoothDevice, private val uuid: UUID) : Thread() {

        private lateinit var outputStream: OutputStream
        private var bluetoothSocket: BluetoothSocket? = null

        override fun run() {
            Looper.prepare()
            try {
                bluetoothSocket?.let {
                    bluetoothSocket?.close()
                }
                bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuid)
                bluetoothSocket?.let {
                    for (i in 1..10) {
                        try {
                            bluetoothSocket?.connect()
                            outputStream = bluetoothSocket?.outputStream!!
                            println("Bluetooth Device Connected.")
                            break
                        } catch(error: IOException) {
                            if (i >= 9) {
                                Toast.makeText(context, "Connection failed ...", Toast.LENGTH_SHORT).show()
                            }
                            println(error.message)
                            try {
                                bluetoothSocket?.close()
                                println("Bluetooth Device Connection Closed.")
                            } catch(error: IOException) {
                                println(error.message)
                            }
                        }
                    }
                }
            } catch(error: IOException) {
                println(error.message)
            }
        }

        fun close() {
            bluetoothSocket?.let {
                if (bluetoothSocket?.isConnected == true) {
                    try {
                        bluetoothSocket?.close()
                        Toast.makeText(context, "Disconnecting ...", Toast.LENGTH_SHORT).show()
                        println("Bluetooth Device Connection Closed.")
                    } catch (error: IOException) {
                        println(error.message)
                    }
                }
            }
        }

        fun send(seconds: Int) {
            bluetoothSocket?.let {
                if (bluetoothSocket?.isConnected == true) {
                    try {
                        outputStream.write(seconds)
                        println("Sent $seconds Seconds to Bluetooth Device.")
                    } catch (error: IOException) {
                        println(error.message)
                    }
                } else {
                    Toast.makeText(context, "No Device Connected ...", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
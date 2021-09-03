package me.burle.exorshock

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

class BluetoothConnectionService() {

    private val myUUID: UUID = UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66")

    private lateinit var connectThread: ConnectThread

    @Synchronized
    fun start (bluetoothDevice: BluetoothDevice) {
        connectThread = ConnectThread(bluetoothDevice, myUUID)
        connectThread.start()
    }

    fun close() {
        connectThread.close()
    }

    fun send(seconds: Int) {
        connectThread.send(seconds)
    }

    private class ConnectThread(private val bluetoothDevice: BluetoothDevice, private val uuid: UUID) : Thread() {

        private lateinit var bluetoothSocket: BluetoothSocket
        private lateinit var outputStream: OutputStream

        override fun run() {
            try {
                bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuid)
                try {
                    bluetoothSocket.connect()
                    outputStream = bluetoothSocket.outputStream
                    println("Connected.")
                } catch(error: IOException) {
                    println(error.message)
                    try {
                        bluetoothSocket.close()
                        println("Closed.")
                    } catch(error: IOException) {
                        println(error.message)
                    }
                }
            } catch(error: IOException) {
                println(error.message)
            }
        }

        fun close() {
            if(bluetoothSocket.isConnected) {
                try {
                    bluetoothSocket.close()
                    println("Closed.")
                } catch(error: IOException) {
                    println(error.message)
                }
            }
        }

        fun send(seconds: Int) {
            if(bluetoothSocket.isConnected) {
                try {
                    outputStream.write(seconds)
                    println("Wrote $seconds Seconds.")
                } catch (error: IOException) {
                    println(error.message)
                }
            }
        }
    }
}
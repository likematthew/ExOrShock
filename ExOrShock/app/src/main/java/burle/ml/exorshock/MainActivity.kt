package burle.ml.exorshock

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.lang.NumberFormatException
import java.util.*
import android.view.View
import android.view.ViewGroup
import kotlin.collections.ArrayList
import android.view.LayoutInflater
import android.widget.*

private const val REQUEST_ENABLE_BLUETOOTH = 1

class MainActivity : AppCompatActivity() {

    companion object {
        private val myUUID: UUID? = UUID.randomUUID()
        private val bluetoothDevices: ArrayList<BluetoothDevice> = ArrayList()
        private val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        private var bluetoothSocket: BluetoothSocket? = null

        private fun checkIfConnected(pAddress: String): Boolean {
            return bluetoothSocket != null && bluetoothSocket!!.isConnected && bluetoothSocket!!.remoteDevice.address == pAddress
        }
        private fun doToast(pContext: Context, pText: String, pLength: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(pContext, pText, pLength).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!bluetoothAdapter.isEnabled) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, REQUEST_ENABLE_BLUETOOTH)
        } else {
            show()
        }

        listDevices.setOnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long -> connect(position) }
        btnShow.setOnClickListener { show() }
        btnStart.setOnClickListener { send() }
    }

    private fun show() {
        if (bluetoothAdapter.isEnabled) {
            bluetoothDevices.clear()
            for (device: BluetoothDevice in bluetoothAdapter.bondedDevices) {
                if(checkIfConnected(device.address)) {
                    bluetoothDevices.add(0, device)
                } else {
                    bluetoothDevices.add(device)
                }
            }
            listDevices.adapter = MyAdapter()
        } else {
            doToast(applicationContext, applicationContext.getString(R.string.activateBluetoothFirst))
        }
    }

    private fun send() {
        if (bluetoothAdapter.isEnabled) {
            if (bluetoothSocket != null && bluetoothSocket!!.isConnected) {
                val text = txtSeconds.text.toString()
                if (text != "") {
                    try {
                        bluetoothSocket!!.outputStream.write(Integer.parseInt(text))
                    } catch (e1: IOException) {
                        doToast(applicationContext, applicationContext.getString(R.string.sendingFailed))
                    } catch (e2: NumberFormatException) {
                        doToast(applicationContext, applicationContext.getString(R.string.inputANumber))
                    }
                } else {
                    doToast(applicationContext, applicationContext.getString(R.string.inputANumber))
                }
            } else {
                doToast(applicationContext, applicationContext.getString(R.string.notConnected))
            }
        } else {
            doToast(applicationContext, applicationContext.getString(R.string.activateBluetoothFirst))
        }
    }

    private fun connect(pIndex: Int) {
        disconnect()
        ConnectToDevice(bluetoothDevices[pIndex]).execute()
    }

    private fun disconnect() {
        if (bluetoothSocket != null && bluetoothSocket!!.isConnected) {
            try {
                bluetoothSocket!!.close()
                bluetoothSocket = null
            } catch (e: IOException) {
                doToast(applicationContext, applicationContext.getString(R.string.errorCloseConnection))
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ENABLE_BLUETOOTH) {
            if (resultCode == Activity.RESULT_OK) {
                if (bluetoothAdapter.isEnabled) {
                    doToast(applicationContext, applicationContext.getString(R.string.bluetoothActivated))
                    show()
                } else {
                    doToast(applicationContext, applicationContext.getString(R.string.bluetoothActivationFailed))
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                doToast(applicationContext, applicationContext.getString(R.string.useAppRight))
            }
        }
    }

    private inner class MyAdapter : BaseAdapter() {

        override fun getView(index: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val currView = inflater.run { inflate(R.layout.list_view_item_layout, parent, false) }
            val txtHeader = currView.findViewById(R.id.txtHeader) as TextView
            val txtContent = currView.findViewById(R.id.txtContent) as TextView
            val device = getItem(index) as BluetoothDevice
            txtHeader.text = device.name
            if(checkIfConnected(device.address))
            {
                txtContent.text = applicationContext.getString(R.string.connected)
                txtContent.visibility = View.VISIBLE
            }
            return currView
        }

        override fun getItem(index: Int): Any {
            return bluetoothDevices[index]
        }

        override fun getItemId(index: Int): Long {
            return index.toLong()
        }

        override fun getCount(): Int {
            return bluetoothDevices.count()
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class ConnectToDevice(private val device: BluetoothDevice) : AsyncTask<Void, Void, String>() {

        private var success: Boolean = false

        override fun onPreExecute() {
            super.onPreExecute()
            btnShow.isEnabled = false
            listDevices.isEnabled = false
            doToast(
                applicationContext,
                "Verbindung zu ${device.name} wird aufgebaut...",
                Toast.LENGTH_LONG
            )
        }

        override fun doInBackground(vararg p: Void?): String {
            try {
                if (bluetoothSocket == null || bluetoothSocket != null && !bluetoothSocket!!.isConnected) {
                    bluetoothSocket = device.createInsecureRfcommSocketToServiceRecord(
                        myUUID
                    )
                    bluetoothSocket!!.connect()
                    success = true
                }
            } catch (e: IOException) {
                success = false
            }
            return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(success) {
                doToast(
                    applicationContext,
                    "Erfolgreich mit ${device.name} verbunden"
                )
            } else {
                doToast(
                    applicationContext,
                    "Verbindung mit ${device.name} fehlgeschlagen"
                )
            }
            show()
            listDevices.isEnabled = true
            btnShow.isEnabled = true
        }
    }
}
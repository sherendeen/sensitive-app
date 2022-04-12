package edu.quintrix.senitive

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.quintrix.senitive.adapter.DeviceSensorAdapter
import edu.quintrix.senitive.model.DeviceSensorModel

private lateinit var sensorManager:SensorManager

class MainActivity : AppCompatActivity() {


    lateinit var deviceSensorModels : ArrayList<DeviceSensorModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        deviceSensorModels = ArrayList()

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        for ( deviceSensor in deviceSensors ) {
            deviceSensorModels.add(DeviceSensorModel(deviceSensor.vendor, deviceSensor.name))
        }

        val deviceSensorAdapter = DeviceSensorAdapter(this, deviceSensorModels)
        val linearLayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,
            false)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = deviceSensorAdapter
    }
}

package com.example.judas;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView gyroX, aceX, gyroY, gyroZ, aceY, aceZ, leiLX,groX,groY,groZ,huX,proX,magX,magY,magZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gyroX = findViewById(R.id.GyroX);
        gyroY = findViewById(R.id.GyroY);
        gyroZ = findViewById(R.id.GyroZ);
        aceX = findViewById(R.id.AcceleroX);
        aceY = findViewById(R.id.AcceleroY);
        aceZ = findViewById(R.id.AcceleroZ);
        leiLX = findViewById(R.id.LeivathanX);
        groX = findViewById(R.id.GrooveX);
        groY = findViewById(R.id.GrooveY);
        groZ = findViewById(R.id.GrooveZ);
        proX = findViewById(R.id.ProximityX);
        magX = findViewById(R.id.MagnetoX);
        magY = findViewById(R.id.MagnetoY);
        magZ = findViewById(R.id.MagnetoZ);

        SensorManager sensor = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensor != null) {
            Sensor acceleroSensor = sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (acceleroSensor != null) {
                sensor.registerListener(this, acceleroSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }
            Sensor gyroSensor = sensor.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
            if (gyroSensor != null) {
                sensor.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }
            Sensor ligSensor = sensor.getDefaultSensor(Sensor.TYPE_LIGHT);
            if (ligSensor != null) {
                sensor.registerListener(this, ligSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }
            Sensor graSensor = sensor.getDefaultSensor(Sensor.TYPE_GRAVITY);
            if (graSensor != null) {
                sensor.registerListener(this, graSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }

            Sensor proSensor = sensor.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if (proSensor != null) {
                sensor.registerListener(this, proSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }
            Sensor magSensor = sensor.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            if (magSensor != null) {
                sensor.registerListener(this, magSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }
        } else {
            Toast.makeText(this, "Sensor service not detected.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            gyroX.setText("x: " + event.values[0]);
            gyroY.setText("y: " + event.values[1]);
            gyroZ.setText("z:" + event.values[2]);
        }
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            aceX.setText("x: " + event.values[0]);
            aceY.setText("y: " + event.values[1]);
            aceZ.setText("z:" + event.values[2]);
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            magX.setText("x: " + event.values[0]);
            magY.setText("y: " + event.values[1]);
            magZ.setText("z:" + event.values[2]);
        }
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            leiLX.setText("lx: " + event.values[0]);
        }
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {
            groX.setText("x: " + event.values[0]);
            groY.setText("x: " + event.values[1]);
            groZ.setText("x: " + event.values[2]);
        }

        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proX.setText(event.values[0]+" %");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
}
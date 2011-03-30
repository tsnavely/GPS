package com.Blue.Map;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GPS extends Activity {	
	TextView Lat, Lon;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener(){
        	public void onLocationChanged(Location location){
        		displayGPS(location);
        	}

			@Override
			public void onProviderDisabled(String provider) {}

			@Override
			public void onProviderEnabled(String provider) {}

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
        };
        
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }
    
    public void displayGPS(Location location){
    	Lat = (TextView)findViewById(R.id.textView1);
    	Lon = (TextView)findViewById(R.id.textView2);
    	
    	float latValue = (float) location.getLatitude();
    	float lonValue = (float) location.getLongitude();
    	
    	Lat.setText("LAT: " + Float.toString(latValue));
    	Lon.setText("LON: " + Float.toString(lonValue));
    	
    }
}
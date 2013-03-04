package com.diabetes.util;

import java.io.InputStream;
import java.io.OutputStream;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class Utils {
	public static void CopyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1)
					break;
				os.write(bytes, 0, count);
			}
		} catch (Exception ex) {
		}
	}

	public static AlertDialog showOkAlertDialog(Context context, int id) {
		String message = "";
		AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
		
		
		alertbox.setMessage(message);

		alertbox.setNegativeButton(
				//context.getResources().getString(R.string.ok_alert_btn),
				"OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
						arg0.cancel();
						arg0.dismiss();
					}
				});

		// alertbox.setPositiveButton(context.getResources().getString(R.string.gps_error_setting),
		// new DialogInterface.OnClickListener()
		// {
		// public void onClick(DialogInterface arg0, int arg1)
		// {
		// //startActivityForResult(new
		// Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS),
		// 0);
		//
		// }
		// });
		AlertDialog alert = alertbox.create();
		// alert.show();
		return alert;
	}
	
	/**
	 * check if loaction provider setting is on or off.
	 * @return
	 */
	public static boolean isLocationProviderOn(Context context, LocationManager locMgr)
	{
		
		boolean isGPS = locMgr.isProviderEnabled (LocationManager.GPS_PROVIDER);
		boolean isNetowrk=locMgr.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		
		if(isGPS||isNetowrk)
			return true;
		else
			return false;
	}
	/**
	 * isOnline method is used to chack network is available or not.
	 * @return
	 */
	public static boolean isOnline(Context context) 
	{
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
        }
        return false;
	}
	
	public static Bitmap getBitmapFromAsset(Context context, String strName)
    {
		Bitmap bitmap=null;
		try
		{
	        InputStream istr = context.getAssets().open(strName);
	        bitmap = BitmapFactory.decodeStream(istr);
	        istr.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
        return bitmap;
    }

}
package org.c_base.c_beam;


import android.content.Context;
import android.util.Log;

/**
 * Handle (un)registering from Google Cloud Messaging service.
 *
 */
public class GCMManager {
	public static final String SENDER_ID = "987966345562";

	public static void register(Context context) {
		Log.v("org.c_base.c_beam.GCMManager", "register()");
		//GCMRegistrar.checkDevice(context);
		//GCMRegistrar.checkManifest(context);
		//GCMRegistrar.register(context, SENDER_ID);
	}

	public static void unregister(Context context) {
		Log.v("org.c_base.c_beam.GCMManager", "unregister()");
		//GCMRegistrar.unregister(context);
	}

//	public static String getRegistrationId(Context context) {
//		String registrationId = GCMRegistrar.getRegistrationId(context);
//
//		if ("".equals(registrationId)) {
//			register(context);
//			registrationId = GCMRegistrar.getRegistrationId(context);
//		}
//
//		Log.v("org.c_base.c_beam.GCMManager", "getRegistrationId() = " + registrationId);
//
//		return registrationId;
//	}
}

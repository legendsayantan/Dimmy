package com.legendsayantan.dimme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static boolean overlay,enabled;
    public static SharedPreferences.Editor editor;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getOverlayPerm();
        if(overlay){
            Toast.makeText(getApplicationContext(),"You can toggle DimMe from the quick settings panel",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", getPackageName(), null));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void getOverlayPerm() {
        checkOverlay();
        if (!overlay) {
            startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
            Toast.makeText(getApplicationContext(), "Find DimMe and enable this permission", Toast.LENGTH_LONG).show();
        }
        checkOverlay();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkOverlay() {
        overlay = Settings.canDrawOverlays(getApplicationContext());
        System.out.println(Settings.canDrawOverlays(getApplicationContext()));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
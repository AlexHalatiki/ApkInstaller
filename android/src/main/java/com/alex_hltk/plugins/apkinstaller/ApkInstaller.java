package com.alex_hltk.plugins.apkinstaller;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.content.ActivityNotFoundException;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileNotFoundException;

public class ApkInstaller {

    public void installAPK(String filePath, android.content.Context context) throws FileNotFoundException, ActivityNotFoundException, SecurityException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist: " + filePath);
        }

        Uri fileUri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            fileUri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
        } else {
            fileUri = Uri.fromFile(file);
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new ActivityNotFoundException("No activity found to handle Intent action: " + intent.getAction());
        } catch (SecurityException e) {
            throw new SecurityException("Permission denial while starting Intent: " + intent.getAction(), e);
        }
    }
}

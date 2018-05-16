package com.lekebir.loukmane.videoplayermanagerandsaver;
import android.content.Context;
import android.os.AsyncTask;
import android.app.ProgressDialog;
public class ReceivingDataFromYoutube extends AsyncTask<String, Void, Void> {
    private Context context;
    private ProgressDialog dialog ;
    private String result;

    protected void onPreExecute() {
        dialog.setMessage("Downloading...");
        dialog.show();
    }


    public ReceivingDataFromYoutube(Context ctx) {
        context = ctx;
    }
    @Override
    protected Void doInBackground(String... arg0) {
    return null;
    }
}
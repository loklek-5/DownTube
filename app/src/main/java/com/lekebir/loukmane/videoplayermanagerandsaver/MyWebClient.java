package com.lekebir.loukmane.videoplayermanagerandsaver;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;

public class MyWebClient extends WebViewClient
    {
        private Context context;

        public MyWebClient(Context ctx) {
            context = ctx;
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //Log.d("WebView", "your current url when webpage loading.. start" + url);
                //Toast.makeText(context, url, Toast.LENGTH_SHORT).show();


        }
        @Override
        public void onPageFinished(WebView view, String url) {
                //Log.d("WebView", "your current url when webpage loading.. finish" + url);
                super.onPageFinished(view, url);
                //Toast.makeText(context, "your current url when webpage loading.. finish" + url, Toast.LENGTH_SHORT).show();


        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            Toast.makeText(context, "should override url", Toast.LENGTH_SHORT).show();
            view.loadUrl(url);
            return true;

        }
        @Override
        public WebResourceResponse shouldInterceptRequest (WebView view, String url) {
            Toast.makeText(context, "Interception", Toast.LENGTH_SHORT).show();
            //return super.shouldInterceptRequest(view, url);
            return null;
        }
    }
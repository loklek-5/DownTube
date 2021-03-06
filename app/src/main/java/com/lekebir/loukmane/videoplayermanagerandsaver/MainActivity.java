package com.lekebir.loukmane.videoplayermanagerandsaver;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.util.Log;
import android.widget.Toast;
import android.webkit.WebResourceResponse;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    //public Button ytButton;
    private android.webkit.WebView webView;
    //private WebViewClient mWebViewClient;
    private MyWebClient mWebClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebClient = new MyWebClient(getApplicationContext());
        webView = (WebView) findViewById(R.id.youtube_view);
        webView.setWebViewClient(mWebClient);

        //webView.setWebChromeClient(new WebChromeClient());
        WebChromeClient mSWWebChromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                //super.onReceivedTitle(view, title);
                Toast.makeText(getApplicationContext(), "lok", Toast.LENGTH_SHORT).show();
            }

        };
        webView.setWebChromeClient(mSWWebChromeClient);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this),"Android");
        webView.loadUrl("https://m.youtube.com");



        mToolbar = findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //initytActivity();

    }







    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /*public void initytActivity(){
        ytButton = (Button) findViewById(R.id.ytButton);

        ytButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yt = new Intent(MainActivity.this,YTActivity.class);
                startActivity(yt);
            }
        });

    }*/
}

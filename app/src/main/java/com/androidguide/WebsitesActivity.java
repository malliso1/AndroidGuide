package com.androidguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WebsitesActivity extends ActionBarActivity {

    private ListView websiteList;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        webView = new WebView(this);
        websiteList = (ListView) findViewById(R.id.listView);
        String[] websiteArray = getResources().getStringArray(R.array.website_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,websiteArray);
        websiteList.setAdapter(arrayAdapter);

        websiteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
                String url = (String) (websiteList.getItemAtPosition(position));
                setContentView(webView);
                webView.loadUrl(url);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            showHelp();
            return true;
        }
        else if (id == R.id.action_about) {
            showAbout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showHelp() {
        Intent i = new Intent(getBaseContext(), HelpActivity.class);
        startActivity(i);
    }

    public void showAbout() {
        Intent i = new Intent(getBaseContext(), AboutActivity.class);
        startActivity(i);
    }
}

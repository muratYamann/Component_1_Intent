package com.yamankod.component_1_intent;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {


    Intent intent;
    int PERMISSIONS_REQUEST_CODE = 1;
    private Button button;
    private EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //persmisson Call
        getPermissionCall();

        button = (Button) findViewById(R.id.button1);
        editText = (EditText) findViewById(R.id.editText1);

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                   intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5452284808"));

                    // 1 // String data = editText.getText().toString();
                    // 1 // intent = new Intent(Intent.ACTION_CALL, Uri.parse(data));


                    // 2 // intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    // 2 // intent.putExtra(SearchManager.QUERY, "Ankaradaki halı sahalar");


                    // 3 //	intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:+905452284808"));
                    // 3 //	intent.putExtra("sms_body",	"Yarin halı sahada maç yapalım mı?");


                    // 4 // String data = "content://contacts/people/";
                    // 4 // intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));

                    // 5 // String myData = "http://youTube.com";
                    // 5 // intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));

                    // 6 //String data = "geo:0,0?q=14+1297+Erzincan+Turkey";
                    // 6 // intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));


                    // 7 // String data = "Kocaeli University";
                    // 7 // intent = new Intent(Intent.ACTION_VIEW,
                    // Uri.parse("geo:0,0?q=("+ data +")"));

                    // 8 // String data =
                    // "google.streetview:cbll=41.5020952,-81.6789717&cbp=1,270,,45,1&mz=1";
                    // 8 // intent = new Intent(Intent.ACTION_VIEW,
                    // Uri.parse(data));

                    // 9 // intent = new
                    // Intent("android.intent.action.MUSIC_PLAYER");

                    startActivity(intent);
                } catch (Exception e) {
                    // TODO: handle exception
                    Toast.makeText(getApplicationContext(),
                            "Lutfen dogru bilgi giriniz", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });


    }


    /**
     * Android  persmission for marshmallow
     *
     * gerekli izinler için aşagıda ki arama izmine benzer metodlar yazılıp çagırılmalıdır.
     */

    public void getPermissionCall() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {


            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.CALL_PHONE)) {

            }
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                    PERMISSIONS_REQUEST_CODE);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

  }

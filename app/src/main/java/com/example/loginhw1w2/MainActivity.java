package com.example.loginhw1w2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button login_button = findViewById(R.id.loginbutton);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean user_true;
                boolean pass_true;
                EditText temp_user = findViewById(R.id.username);
                EditText temp_pass = findViewById(R.id.password);
                String username = temp_user.getText().toString();
                String password = temp_pass.getText().toString();

                user_true = sucessfullUsername(username);
                pass_true = sucessfullPassword(password);

                if(!user_true) {
                    TextView msg =findViewById(R.id.username_text);
                    String text_to_highlight = msg.getText().toString();
                    String replaceWith = "<span style= 'background-color:yellow'>" + text_to_highlight + "</span>";
                    String originalText = msg.getText().toString();
                    String modifiedText = originalText.replaceAll(text_to_highlight,replaceWith);
                    msg.setText(Html.fromHtml(modifiedText));
                }

                if(!pass_true) {
                    TextView msg =findViewById(R.id.password_text);
                    String text_to_highlight = msg.getText().toString();
                    String replaceWith = "<span style= 'background-color:yellow'>" + text_to_highlight + "</span>";
                    String originalText = msg.getText().toString();
                    String modifiedText = originalText.replaceAll(text_to_highlight,replaceWith);
                    msg.setText(Html.fromHtml(modifiedText));
                }

                if(!user_true || !pass_true){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Username or Password is incorrect.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                Intent intent = returnIntent(user_true , pass_true);
                if(intent != null)
                {
                    intent = new Intent(MainActivity.this, LoginSuccessfulActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    public static boolean sucessfullUsername(String username)
    {
        boolean answer = true;
        if(!username.equals("din_djarin")) {
           answer =false;
        }
        return answer;
    }
    public static boolean sucessfullPassword(String password)
    {
        boolean answer = true;
        if(!password.equals("baby_yoda_ftw")) {
            answer =false;
        }
        return answer;
    }

    public static Intent returnIntent(boolean user_true,boolean pass_true){
        if(user_true && pass_true){
            Intent intent = new Intent();
            return intent;
        }
        else{
            return null;
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

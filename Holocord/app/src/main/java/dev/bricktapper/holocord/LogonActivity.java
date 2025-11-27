// All I have to say here is, god bless Google for Holo.
// Alright, have a good night! :)
package dev.bricktapper.holocord;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import android.content.SharedPreferences;

public class LogonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);

        SharedPreferences prefs = getSharedPreferences("app_prefs", MODE_PRIVATE);

        // We find our elements from the 'activity_logon' page and then use then later on
        EditText tokenBox = findViewById(R.id.discordTokenInput);
        Button signInBtn = findViewById(R.id.signInButton);

        // Here we save the token once the logon button is pressed
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = tokenBox.getText().toString().trim();
                prefs.edit()
                        .putString("dsc_token", token)
                        .apply();
                // DEBUG: Verify that the token does actually save correctly
                Log.d("Holocord", "Discord token has been saved, here's the output: " + token);
            }
        });

        // TODO: Verify the token with the Discord API by making a call to something like
        //       the endpoint 'users/@me' and if it's successful, it should let the user into the client.
    }
}
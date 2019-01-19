package joelespinal.com.pokemonapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import joelespinal.com.pokemonapp.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

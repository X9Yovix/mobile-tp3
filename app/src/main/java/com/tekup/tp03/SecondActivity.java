package com.tekup.tp03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText EtSecond;
    private TextView TvSecond;
    private Button BtnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EtSecond = (EditText) findViewById(R.id.EtSecond);
        TvSecond = (TextView) findViewById(R.id.TvSecond);
        BtnSecond = (Button)  findViewById(R.id.BtnSecond);

        TvSecond.setVisibility(View.VISIBLE);
        Intent intentMain = getIntent();
        String valueFromMain = intentMain.getStringExtra("mainValue").toString();
        TvSecond.setText(valueFromMain);
        Toast toast = valueFromMain.isEmpty()
                ? Toast.makeText(this, "empty from main", Toast.LENGTH_SHORT)
                : null;

        if (toast != null) {
            toast.show();
        }

        BtnSecond.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("secondValue", EtSecond.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
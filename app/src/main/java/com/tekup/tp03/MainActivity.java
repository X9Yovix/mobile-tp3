package com.tekup.tp03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText EtMain;
    private TextView TvMain;
    private Button BtnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtMain = (EditText) findViewById(R.id.EtMain);
        TvMain = (TextView) findViewById(R.id.TvMain);
        BtnMain = (Button) findViewById(R.id.BtnMain);


        BtnMain.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("mainValue", EtMain.getText().toString());
            startActivityForResult(intent, 1);
            //activityResultLauncher.launch(intent);
        });
    }

    //2nd method
/*
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == 1) {
                    Intent data = result.getData();
                    if (data != null) {
                        String resultValue = data.getStringExtra("resultValue");
                        TvMain.setText(resultValue);
                    }
                }
            }
    );

*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String resultValue = data.getStringExtra("secondValue");
                if (resultValue.isEmpty()) {
                    Toast.makeText(this, "empty from second", Toast.LENGTH_SHORT).show();
                }
                TvMain.setVisibility(View.VISIBLE);
                TvMain.setText(resultValue);
            }
        }
    }

}
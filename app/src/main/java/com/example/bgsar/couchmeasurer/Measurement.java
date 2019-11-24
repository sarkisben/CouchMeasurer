package com.example.bgsar.couchmeasurer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Measurement extends AppCompatActivity {

    private EditText height;
    private EditText width;
//    private EditText length;
    private EditText door_width;
    private EditText door_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);

        height = (EditText) findViewById(R.id.heightText);
        width = (EditText) findViewById(R.id.widthText);
//        length = (EditText) findViewById(R.id.lengthText);
        door_width = (EditText) findViewById(R.id.doorWidthText);
        door_height = (EditText) findViewById(R.id.doorWidthHeight);
        Button enterButton = (Button) findViewById(R.id.enterButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intCompareTo(door_width, height)) {
                    Toast.makeText(Measurement.this, R.string.can_fit, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Measurement.this, R.string.height_check, Toast.LENGTH_SHORT).show();
                    door_height.setVisibility(View.VISIBLE);
                    if(intCompareTo(door_height, width)){
                        Toast.makeText(Measurement.this, R.string.can_fit, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Measurement.this, R.string.not_fit, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public boolean intCompareTo(EditText left, EditText right){
        int rval = Integer.parseInt(left.getText().toString());
        int lval = Integer.parseInt(right.getText().toString());

        return rval > lval;
    }

}

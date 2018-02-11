package net.androidbootcamp.customaryconversionsericw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String txtEnglishNumber;
    String spinnerChoice;
    Double newEnglishNumber = 0.00;
    Double x;
    Integer NumSpinner = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText initialNumber =(EditText)findViewById(R.id.txtTitle);
        final Spinner conversionUnits = (Spinner)findViewById(R.id.spinner);


        Button convertedNumber = (Button)findViewById(R.id.myAnswer);
        convertedNumber.setOnClickListener(new View.OnClickListener() {

            final TextView result = ((TextView)findViewById(R.id.myAnswer));
            @Override
            public void onClick(View v) {
                txtEnglishNumber = (initialNumber.getText().toString());
                if (! TextUtils.isEmpty(txtEnglishNumber)){
                    newEnglishNumber = Double.parseDouble(txtEnglishNumber);
                    spinnerChoice = conversionUnits.getSelectedItem().toString();
                    NumSpinner = conversionUnits.getSelectedItemPosition();

                    switch (NumSpinner) {
                        case 0:
                            x = newEnglishNumber * 2.5;
                            break;
                        case 1:
                            x = newEnglishNumber * 3.3;
                            break;
                        case 2:
                            x = newEnglishNumber * 1.6;
                            break;
                        default:
                            x = newEnglishNumber * 30;
                            break;
                    }
                    result.setText(newEnglishNumber + " "  + spinnerChoice + " is " + x);
                }

            }
        });
    }
}

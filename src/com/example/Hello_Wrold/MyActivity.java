package com.example.Hello_Wrold;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MyActivity extends Activity {

    private TextView m_result = null;
    private EditText m_weightEntry = null;
    private EditText m_heightEntry = null;
    private RadioGroup m_heightChoice = null;
    private CheckBox m_megaCheck = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        m_result = (TextView) findViewById(R.id.e_result);
        m_weightEntry = (EditText) findViewById(R.id.e_weight);
        m_heightEntry = (EditText) findViewById(R.id.e_height);
        m_heightChoice = (RadioGroup) findViewById(R.id.e_heightType);
        m_megaCheck = (CheckBox) findViewById(R.id.e_megaFunc);

        Button buttonCalculateBMI = (Button) findViewById(R.id.e_buttonBMI);
        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMIScore() ;
            }
        });

        Button buttonRAZ = (Button) findViewById(R.id.e_buttonRAZ);
        buttonRAZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                reset();
            }
        });
    }

    private void calculateBMIScore(){
        double height=Double.valueOf(this.m_heightEntry.getText().toString());
        double weight=Double.valueOf(this.m_weightEntry.getText().toString());

        if(this.m_heightChoice.getCheckedRadioButtonId() == R.id.e_cm){
            height = height/100 ;
        }
        double res = weight/Math.pow(height, 2);

        String toShow;
        if(this.m_megaCheck.isChecked())
            toShow = R.string.s_resWithCheck + String.valueOf(res);
        else
            toShow = R.string.s_resWithoutCheck + String.valueOf(res);

        this.m_result.setText(toShow);
    }

    private void reset(){
        this.m_heightEntry.setText(R.string.s_messageHeight);
        this.m_weightEntry.setText(R.string.s_messageWeight);
    }
}

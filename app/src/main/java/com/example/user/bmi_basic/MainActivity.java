package com.example.user.bmi_basic;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.submit);
        button.setOnClickListener(listener);
    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double BMI= 0;
            try {
                BMI = calcBMI();
            } catch (Exception e) {
                e.printStackTrace();
            }
            showResult(BMI);
        }
    };
    private double calcBMI(){
        EditText fieldheight=(EditText)findViewById(R.id.height);
        EditText fieldweight=(EditText)findViewById(R.id.weight);
        double height=Double.parseDouble(fieldheight.getText()+"")/100;
        double weight=Double.parseDouble(fieldweight.getText()+"");
        double BMI=weight/(height*height);
        return BMI;
    }
    private void showResult(double BMI){
        DecimalFormat nf=new DecimalFormat("0.00");
        TextView result=(TextView)findViewById(R.id.result);
        result.setText("Your BMI is "+ nf.format(BMI));
        TextView fieldsuggest=(TextView)findViewById(R.id.suggest);

        if (BMI>25){
            fieldsuggest.setText(R.string.advice_heavy);
        }else if (BMI<20){
            fieldsuggest.setText(R.string.advice_light);
        }else {
            fieldsuggest.setText(R.string.advice_average);
        }
    }
}

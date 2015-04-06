package idv.leo.bmi_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 *
 */
public class ResultActivity extends ActionBarActivity {
          private EditText inputHeight,inputWeight;
          private Button calcBMI,clear,back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        findViews();
    }
    public void findViews() {
        inputHeight = (EditText) findViewById(R.id.inputHeight);
        inputWeight =(EditText)findViewById(R.id.inputWeight);
        clear =(Button)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputHeight.setText("");
                inputWeight.setText("");
            }
        });
        back =(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.this.finish();
            }
        });
        calcBMI =(Button)findViewById(R.id.calcBMI);
        calcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputHeight = (EditText) findViewById(R.id.inputHeight);
                inputWeight = (EditText) findViewById(R.id.inputWeight);
                Intent intent = new Intent();
                intent.setClass(ResultActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                try {
                    String height = inputHeight.getText().toString();
                    String weight = inputWeight.getText().toString();
                    //判斷字串是否為空值
                    if (height.isEmpty() || weight.isEmpty()) {
                        throw new Exception();
                    }

                    double height1 = Double.parseDouble(inputHeight.getText().toString()) / 100;

                    double weight1 = Double.parseDouble(inputWeight.getText().toString());


                    double BMI = weight1 / (height1 * height1);


                    bundle.putDouble("BMI",BMI);


                } catch (Exception e) {
                    Toast.makeText(ResultActivity.this, getString(R.string.inputError), Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}

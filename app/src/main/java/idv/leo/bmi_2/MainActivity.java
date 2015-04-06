package idv.leo.bmi_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private Button btnReal , btnEnd;
    private TextView textBMI , textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        showResult();

    }
public void findViews(){
    textBMI = (TextView)findViewById(R.id.textBMI);
    textResult =(TextView)findViewById(R.id.textResult);
    btnEnd = (Button)findViewById(R.id.btnEnd);
    btnEnd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
    btnReal = (Button) findViewById(R.id.btnReal);
    btnReal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ResultActivity.class);
            startActivity(intent);
        }
    });

}
public void showResult(){
    Bundle bundle = this.getIntent().getExtras();
    double BMI = bundle.getDouble("BMI");
    textBMI.setText(" BMI： " + BMI);
    if (BMI > 25) {

        textResult.setText(R.string.advice_heavy);

    } else if (BMI < 20) {

        textResult.setText(R.string.advice_light);

    } else {

        textResult.setText(R.string.advice_average);

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

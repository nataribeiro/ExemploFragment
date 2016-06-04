package br.com.natanaelribeiro.www.exemplofragment;

import android.app.FragmentManager;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setResult(RESULT_CANCELED);
            finish();
        }

        setContentView(R.layout.activity_detalhe);

        String time = getIntent().getStringExtra("time");

        FragmentManager fragManager = getFragmentManager();
        DetalheFrag detalheFrag = (DetalheFrag)fragManager.findFragmentById(R.id.detalheFrag);
        detalheFrag.setNome(time);
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}

package br.com.natanaelribeiro.www.exemplofragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CliqueLista {

    private static String timeBkp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void clicou(String time) {
        FragmentManager fragManager = getFragmentManager();
        DetalheFrag detalheFrag = (DetalheFrag)fragManager.findFragmentById(R.id.detalheFrag);

        if(detalheFrag != null && detalheFrag.isInLayout()){
            //Mudar o texto do fragment da direita
            detalheFrag.setNome(time);
        } else {
            timeBkp = time;
            //Abrir outra tela
            Intent intent = new Intent(this, DetalheActivity.class);
            intent.putExtra("time", time);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if (resultCode == RESULT_CANCELED) {
                clicou(timeBkp);
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}

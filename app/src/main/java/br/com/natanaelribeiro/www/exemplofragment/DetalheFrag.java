package br.com.natanaelribeiro.www.exemplofragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 631610277 on 04/06/16.
 */
public class DetalheFrag extends Fragment {
    //ButterKnife - Annotations
    //ROboGuice
    //Annotations
    private TextView txtNomeTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_detalhe, null);
        txtNomeTime = (TextView)view.findViewById(R.id.textView);
        return view;
    }

    public void setNome(String nome){
        txtNomeTime.setText(nome);
    }

}

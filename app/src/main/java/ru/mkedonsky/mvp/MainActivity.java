package ru.mkedonsky.mvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        initViews();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", "value");
    }






    @SuppressLint("ResourceType")
    private void initViews(){
     findViewById(R.id.btnCounter1).setId(0);
     findViewById(R.id.btnCounter2).setId(1);
     findViewById(R.id.btnCounter3).setId(2);
    }

    @Override
    public void onClick(View v) {
        presenter.buttonClick(v.getId());

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setButtonText(int index, int value) {
        Button button = getWindow().getDecorView().getRootView().findViewById(index);
        button.setText("Количество = " + value);
    }
}

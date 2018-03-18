package org.lym.sourcecodeparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

import org.lym.sourcecodeparse.source.parse.activity.ActivityA;
import org.lym.sourcecodeparse.source.parse.design.SuspensionActivity;
import org.lym.sourcecodeparse.source.parse.fileprovider.FileProviderActivity;
import org.lym.sourcecodeparse.source.parse.intentservice.IntentServiceActivity;
import org.lym.sourcecodeparse.source.parse.loader.LoaderActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnIntentService, mBtnLoader, mFileProvider, mBtnDesign, mBtnActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        bindListener();
    }

    private void bindListener() {
        mBtnIntentService.setOnClickListener(this);
        mBtnLoader.setOnClickListener(this);
        mFileProvider.setOnClickListener(this);
        mBtnDesign.setOnClickListener(this);
        mBtnActivityBtn.setOnClickListener(this);
    }

    private void bindView() {
        mBtnIntentService = findViewById(R.id.btn_intent_service);
        mBtnLoader = findViewById(R.id.btn_loader);
        mFileProvider = findViewById(R.id.btn_fileProvider);
        mBtnDesign = findViewById(R.id.btn_design);
        mBtnActivityBtn = findViewById(R.id.btn_activity_debug);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_intent_service:
                IntentServiceActivity.open(this);
                break;
            case R.id.btn_loader:
                LoaderActivity.open(this);
                break;
            case R.id.btn_fileProvider:
                FileProviderActivity.open(this);
                break;
            case R.id.btn_design:
                SuspensionActivity.open(this);
                break;
            case R.id.btn_activity_debug:
                ActivityA.open(this);
                break;
            default:
                break;
        }
    }
}

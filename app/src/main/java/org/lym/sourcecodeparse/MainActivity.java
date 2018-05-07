package org.lym.sourcecodeparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.lym.sourcecodeparse.source.parse.activity.ActivityA;
import org.lym.sourcecodeparse.source.parse.anim.AnimActivity;
import org.lym.sourcecodeparse.source.parse.design.SuspensionActivity;
import org.lym.sourcecodeparse.source.parse.eventparse.EventParseActivity;
import org.lym.sourcecodeparse.source.parse.fileprovider.FileProviderActivity;
import org.lym.sourcecodeparse.source.parse.intentservice.IntentServiceActivity;
import org.lym.sourcecodeparse.source.parse.loader.LoaderActivity;

public class MainActivity extends AppCompatActivity {

    private static final Class[] sClazz = {IntentServiceActivity.class, LoaderActivity.class, FileProviderActivity.class, SuspensionActivity.class, ActivityA.class, EventParseActivity.class,
            AnimActivity.class};
    private static final String[] sClassName = {"IntentService", "Loader", "FileProvider", "design", "Activity", "EventParse", "Anim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    private void bindView() {
        RecyclerView mRvList = findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvList.setHasFixedSize(true);
        mRvList.setLayoutManager(manager);
        mRvList.setAdapter(new MyRvListAdapter(this, sClazz, sClassName));
    }

}

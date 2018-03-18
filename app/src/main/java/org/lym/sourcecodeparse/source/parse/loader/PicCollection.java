package org.lym.sourcecodeparse.source.parse.loader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/7
 */

public class PicCollection implements LoaderManager.LoaderCallbacks<Cursor> {

    private WeakReference<Context> mWeakReference;
    private LoaderManager mLoadmger;
    private static final int LOAD_ID = 1;
    private LoadCallBack mLoadCallBack;

    @Override
    public Loader onCreateLoader(int i, Bundle bundle) {
        Context context = mWeakReference.get();
        if (null != context) {
            return PicLoader.newInstance(context);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (null != mLoadCallBack) {
            mLoadCallBack.loadResult(cursor);
        }
    }

    public void load(Activity activity, LoadCallBack callBack) {
        mWeakReference = new WeakReference<Context>(activity);
        mLoadCallBack = callBack;
        activity.getLoaderManager().initLoader(LOAD_ID, null, this);
    }

    public interface LoadCallBack {
        void loadResult(Cursor cursor);

        void loadReset();
    }


    @Override
    public void onLoaderReset(Loader loader) {
        if (null != mLoadCallBack) {
            mLoadCallBack.loadReset();
        }
    }
}

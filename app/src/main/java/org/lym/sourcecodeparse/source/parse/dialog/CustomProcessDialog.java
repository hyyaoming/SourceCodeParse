package org.lym.sourcecodeparse.source.parse.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.TextView;

import org.lym.sourcecodeparse.R;

/**
 * Created by asus on 2018/7/17.
 */

public class CustomProcessDialog extends Dialog {
    @SuppressWarnings("unused")
    private TextView mMessageView;
    private String mMessage;

    /**
     * constructor
     *
     * @param context Context
     * @param theme   int
     */
    public CustomProcessDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * constructor
     *
     * @param context Context
     */
    public CustomProcessDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.custom_dialog_layout);
        getWindow().getAttributes().gravity = Gravity.CENTER;
        mMessageView = (TextView) findViewById(R.id.tv_message);
        mMessageView.setText(mMessage);
    }

    /**
     * show
     *
     * @param context Context
     * @param message String
     * @return instance
     */
    public static CustomProcessDialog show(Context context, String message) {
        CustomProcessDialog dialog = new CustomProcessDialog(context, R.style.CustomDialogTheme);
        dialog.setCancelable(true);
        dialog.setContentMessage(message);
        dialog.show();
        return dialog;
    }

    /**
     * set message
     *
     * @param message String
     */
    public void setContentMessage(String message) {
        mMessage = message;
    }

}

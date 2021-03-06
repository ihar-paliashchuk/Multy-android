package io.multy.ui.fragments.dialogs;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.multy.R;

public class SimpleDialogFragment extends DialogFragment {

    @BindView(R.id.text_title)
    TextView textViewTitle;

    @BindView(R.id.text_message)
    TextView textViewMessage;

    @BindView(R.id.button_positive)
    Button buttonPositive;

    @BindView(R.id.button_negative)
    Button buttonNegative;

    private int titleResId;
    private int messageResId;
    private View.OnClickListener listener;
    private boolean isNegative = false;


    public static SimpleDialogFragment newInstance(int titleResId, int messageResId, View.OnClickListener positiveListener) {
        SimpleDialogFragment simpleDialogFragment = new SimpleDialogFragment();
        simpleDialogFragment.setTitleResId(titleResId);
        simpleDialogFragment.setMessageResId(messageResId);
        simpleDialogFragment.setListener(positiveListener);
        return simpleDialogFragment;
    }

    /**
     * Creates fragment with only one option enabled
     *
     * @param titleResId
     * @param messageResId
     * @param negativeListener
     * @return
     */
    public static SimpleDialogFragment newInstanceNegative(int titleResId, int messageResId, View.OnClickListener negativeListener) {
        SimpleDialogFragment simpleDialogFragment = new SimpleDialogFragment();
        simpleDialogFragment.setTitleResId(titleResId);
        simpleDialogFragment.setMessageResId(messageResId);
        simpleDialogFragment.setListenerNegative(negativeListener);
        return simpleDialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_blue, container, false);
        ButterKnife.bind(this, view);
        textViewMessage.setText(messageResId);
        textViewTitle.setText(titleResId);
        if (isNegative) {
            buttonNegative.setVisibility(View.GONE);
            buttonPositive.setText(R.string.ok);
        }
        return view;
    }

    @OnClick(R.id.button_positive)
    public void onClickPositive() {
        listener.onClick(null);
        dismiss();
    }

    @OnClick(R.id.button_negative)
    public void onClickNegative() {
        dismiss();
    }

    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
    }

    public void setMessageResId(int messageResId) {
        this.messageResId = messageResId;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public void setListenerNegative(View.OnClickListener listener) {
        this.listener = listener;
        this.isNegative = true;
    }
}

/*
 * Copyright 2017 Idealnaya rabota LLC
 * Licensed under Multy.io license.
 * See LICENSE for details
 */

package io.multy.ui.fragments.asset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.multy.R;
import io.multy.ui.fragments.BaseFragment;
import io.multy.ui.fragments.dialogs.SimpleDialogFragment;

/**
 * Created by anschutz1927@gmail.com on 07.12.17.
 */

public class AssetSettingsFragment extends BaseFragment {

    public static final String TAG = AssetSettingsFragment.class.getSimpleName();

    public static AssetSettingsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AssetSettingsFragment fragment = new AssetSettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public AssetSettingsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_asset_settings, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        super.showPinDialog();
    }

    private void saveSettings() {
        Toast.makeText(getContext(), "Delete this notification", Toast.LENGTH_SHORT).show();
    }

    private void choiceCurrencyToConvert() {

    }

    private void showMyPrivateKey() {

    }

    private void deleteWallet() {
        Toast.makeText(getContext(), "Delete this notification", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_cancel)
    void onCancelClick() {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.button_save)
    void onSaveClick() {
        saveSettings();
    }

    @OnClick(R.id.button_currency)
    void onCurrencyClick() {
        choiceCurrencyToConvert();
    }

    @OnClick(R.id.button_key)
    void onKeyClick() {
        showMyPrivateKey();
    }

    @OnClick(R.id.button_delete)
    void onDeleteClick() {
        SimpleDialogFragment dialogConfirmation = SimpleDialogFragment
                .newInstance(R.string.delete_wallet, R.string.delete_confirm, v -> deleteWallet());
        dialogConfirmation.show(getChildFragmentManager(),SimpleDialogFragment.class.getSimpleName());
    }
}

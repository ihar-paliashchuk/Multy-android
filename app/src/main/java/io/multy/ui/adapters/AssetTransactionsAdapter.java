package io.multy.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.multy.R;

/**
 * Created by appscrunch on 20.11.17.
 */

public class AssetTransactionsAdapter extends RecyclerView.Adapter<AssetTransactionsAdapter.Holder> {

//    private List<Transactions> transactions;

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_transaction_item, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
//        return transactions.size();
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_date)
        TextView date;

        @BindView(R.id.image_operation)
        ImageView operationImage;

        @BindView(R.id.text_name)
        TextView name;

        @BindView(R.id.text_description)
        TextView description;

        @BindView(R.id.text_amount)
        TextView amount;

        @BindView(R.id.text_time)
        TextView time;

        @BindView(R.id.text_comment)
        TextView comment;

        Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

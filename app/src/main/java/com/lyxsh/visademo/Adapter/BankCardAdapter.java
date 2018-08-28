package com.lyxsh.visademo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyxsh.visademo.Bean.BankCardList;
import com.lyxsh.visademo.R;

/**
 * Created by xushengheng on 2018/8/24.
 */
public class BankCardAdapter extends RecyclerView.Adapter<BankCardAdapter.MyViewHolder> {
    Context context;
    BankCardList bankCardList;

    public BankCardAdapter(Context context, BankCardList bankCardList) {
        this.context = context;
        this.bankCardList = bankCardList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_bankcard, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BankCardList.BankCard bankCard = bankCardList.get(position);

        holder.cvvtextview.setText(bankCard.getCardID());
        if (holder.image == 0) {
            switch (bankCard.getType()) {
                case 1:
                    holder.image = R.mipmap.addcard_card_image_1;
                    break;
                case 2:
                    holder.image = R.mipmap.addcard_card_image_2;
                    break;
                case 3:
                    holder.image = R.mipmap.addcard_card_image_3;
                    break;
                case 4:
                    holder.image = R.mipmap.addcard_card_image_4;
                    break;
            }
        }
        holder.imageView.setImageResource(holder.image);
    }

    @Override
    public int getItemCount() {
        return bankCardList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cvvtextview;
        ImageView imageView;
        int image;

        public MyViewHolder(View itemView) {
            super(itemView);
            cvvtextview = itemView.findViewById(R.id.adapter_bankcard_cvv_textview);
            imageView = itemView.findViewById(R.id.adapter_bankcard_imageview);
        }
    }
}

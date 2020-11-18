package com.example.no_brain___my_pain.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.no_brain___my_pain.R;

import java.util.ArrayList;

public class UndeadPainAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pain> painList;

    public UndeadPainAdapter(Context context, ArrayList<Pain> myPain){
        this.context = context;
        this.painList = new ArrayList<Pain>();
        this.painList = myPain;
    }

    @Override
    public int getCount() {
        return painList.size();
    }

    @Override
    public Object getItem(int i) {
        return painList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(
                    R.layout.list_raw, viewGroup, false);
        }
        Pain pain = (Pain)getItem(i);

        TextView textViewItemName = (TextView) view.findViewById(R.id.text_view_item_name);
        TextView textViewListAddit = (TextView) view.findViewById(R.id.text_view_list_addit);
        Button buttonListAddit = (Button)view.findViewById(R.id.button_list_addit);

        final String data = String.valueOf(pain.getOperand_1()) + " " + String.valueOf(pain.getOperation()) +
                " " + String.valueOf(pain.getOperand_2()) + " = " + String.valueOf(pain.getResult());
        textViewItemName.setText(data);
        textViewListAddit.setText(data);
        buttonListAddit.setText(data);

        buttonListAddit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

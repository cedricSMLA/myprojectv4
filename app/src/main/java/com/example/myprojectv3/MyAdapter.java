package com.example.myprojectv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

//Extend the RecyclerView.Adapter class//
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<RetroUsers> dataList;
    private OnItemClickListener listener;

    public MyAdapter(List<RetroUsers> dataList, OnItemClickListener listener)
    {
        this.listener = listener;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder
    {
        //Get a reference to the Views in our layout//
        public final View myView;

        TextView textUser;

        CustomViewHolder(View itemView)
        {
            super(itemView);
            myView = itemView;
            textUser = myView.findViewById(R.id.country);
        }

        public void bind(final RetroUsers item, final OnItemClickListener listener) {
            textUser.setText(item.getUser());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    @Override
    //Construct a RecyclerView.ViewHolder//
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    //Set the data//
    public void onBindViewHolder(CustomViewHolder holder, int position)
    {
       holder.bind(dataList.get(position), listener);

    }

    //Calculate the item count for the RecylerView//
    @Override
    public int getItemCount()
    {
        return dataList.size();
    }
}
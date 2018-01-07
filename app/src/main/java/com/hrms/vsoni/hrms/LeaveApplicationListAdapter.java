package com.hrms.vsoni.hrms;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HSoni on 1/7/2018.
 */

public class LeaveApplicationListAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Activity context;
    holder holder;
    private static class holder {
        TextView textViewTitle;
    }

    public LeaveApplicationListAdapter(Activity context, int resourceId, ArrayList<String> list){
        super (context , resourceId);
        this.context = context;
        this.list = list;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if (rootView == null){
            rootView = inflater.inflate(R.layout.leave_app_item, null);
            holder = new holder();
            holder.textViewTitle = (TextView) rootView.findViewById(R.id.txtTitle);
            rootView.setTag(holder);
        }
        else {
            holder = (holder) rootView.getTag();
        }

        holder.textViewTitle.setText(list.get(position));
        return rootView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

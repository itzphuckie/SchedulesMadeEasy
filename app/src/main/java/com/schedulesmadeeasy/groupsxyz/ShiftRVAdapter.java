package com.schedulesmadeeasy.groupsxyz;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by agaa2 on 4/15/2018.
 */

public class ShiftRVAdapter extends RecyclerView.Adapter<ShiftRVAdapter.GroupViewHolder>{
    public static class GroupViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView companyName;
        TextView dayOfWeek;
        TextView time;
        ConstraintLayout constraintLayout;

        GroupViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            companyName = (TextView)itemView.findViewById(R.id.cardViewTitle);
            dayOfWeek = (TextView)itemView.findViewById(R.id.cardViewNumberOfUser);
            time = (TextView)itemView.findViewById(R.id.cardViewStatus);
            constraintLayout = itemView.findViewById(R.id.card_layout);
        }
    }

    private List<Shift> shifts;
    private String TAG = "ShiftsrvaADAPTER";
    private Context mContext;

    ShiftsrvaADAPTER(List<Group> groups, Context context){
        this.shifts = shifts;
        mContext = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i ){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_card_view, viewGroup, false);
        GroupViewHolder gvh = new GroupViewHolder(v);
        return gvh;
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder,final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.companyName.setText(shifts.get(position).getCompany());
        String dayOfWeek = "Day: " + shifts.get(position).getDay();
        holder.dayOfWeek.setText(dayOfWeek);
        String time = "Time: " + shifts.get(position).getTime();
        holder.time.setText(time);
        boolean trueThing = true;

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, shifts.get(position).getCompany(), Toast.LENGTH_SHORT).show();
                if(trueThing){//IF YOU ARE A MANAGER OF THE APP GO LOOK AT THE SCHEDULE
                    Intent intent = new Intent(mContext, ManagerScheduleActivity.class);
                    intent.putExtra("Day", shifts.get(position).getDay());
                    intent.putExtra("Time", shifts.get(position).getTime());
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return shifts.size();
    }
}

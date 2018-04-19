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

public class GroupRVAdapter extends RecyclerView.Adapter<GroupRVAdapter.GroupViewHolder>{
    public static class GroupViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView groupTitle;
        TextView groupMembers;
        TextView groupStatus;
        ConstraintLayout constraintLayout;

        GroupViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            groupTitle = (TextView)itemView.findViewById(R.id.cardViewTitle);
            groupMembers = (TextView)itemView.findViewById(R.id.cardViewNumberOfUser);
            groupStatus = (TextView)itemView.findViewById(R.id.cardViewStatus);
            constraintLayout = itemView.findViewById(R.id.card_layout);
        }
    }

    private List<Group> groups;
    private String TAG = "GROUPrvaADAPTER";
    private Context mContext;

    GroupRVAdapter(List<Group> groups, Context context){
        this.groups = groups;
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
        holder.groupTitle.setText(groups.get(position).getTitle());
        String status = "Status: " + groups.get(position).getStatus();
        holder.groupStatus.setText(status);
        String members = "Members: " + groups.get(position).getMembers();
        holder.groupMembers.setText(members);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, groups.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                if(groups.get(position).getStatus().equals("Manager")){//IF YOU ARE A MANAGER OF THE APP GO LOOK AT THE SCHEDULE
                    Intent intent = new Intent(mContext, ManagerScheduleActivity.class);
                    intent.putExtra("ID", groups.get(position).getId());
                    intent.putExtra("TITLE", groups.get(position).getTitle());
                    mContext.startActivity(intent);
                }else{//YOU ARE NOT A MANAGER OF THE GROUP SO YOUR HAVE TO BE A MEMBER
                    Log.d(TAG, "NOT MANAGER:");
                    Intent intent = new Intent(mContext, MemberScheduleActivity.class);
                    intent.putExtra("ID", groups.get(position).getId());
                    intent.putExtra("TITLE", groups.get(position).getTitle());
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return groups.size();
    }
}

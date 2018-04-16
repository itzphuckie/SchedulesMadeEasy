package com.schedulesmadeeasy.groupsxyz;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        GroupViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            groupTitle = (TextView)itemView.findViewById(R.id.cardViewTitle);
            groupMembers = (TextView)itemView.findViewById(R.id.cardViewNumberOfUser);
            groupStatus = (TextView)itemView.findViewById(R.id.cardViewStatus);
        }
    }

    List<Group> groups;

    GroupRVAdapter(List<Group> groups){
        this.groups = groups;
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
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        holder.groupTitle.setText(groups.get(position).getTitle());
        String status = "Status: " + groups.get(position).getStatus();
        holder.groupStatus.setText(status);
        String members = "Members: " + groups.get(position).getMembers();
        holder.groupMembers.setText(members);
    }

    @Override
    public int getItemCount(){
        return groups.size();
    }
}

package com.eryxlabs.student.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eryxlabs.student.R;
import com.eryxlabs.student.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder> {
    private final Context mContext ;
    private List<User> mStudents;

    public StudentRecyclerAdapter(Context ctx) {
        mStudents = new ArrayList<>();
        this.mContext = ctx;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.student_list_item,viewGroup,false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int position) {
        User user = (User) mStudents.get(position);
        studentViewHolder.tvPhone.setText(user.getPhone());
        studentViewHolder.tvEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public void setmStudents(List<User> users) {
        this.mStudents.clear();
        this.mStudents.addAll(users);
        notifyDataSetChanged();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvEmail)
        public TextView tvEmail;
        @BindView(R.id.tvPhone)
        public TextView tvPhone;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //In case not using butterknife for views.
//            tvPhone = itemView.findViewById(R.id.tvPhone);
        }
    }
}

package com.eryxlabs.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.activeandroid.query.Select;
import com.eryxlabs.student.adapters.StudentRecyclerAdapter;
import com.eryxlabs.student.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentListActivity extends AppCompatActivity {

    @BindView(R.id.students_recycler)
    RecyclerView mRecyclerView;
    StudentRecyclerAdapter mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_activity);
        ButterKnife.bind(this);


        mStudentAdapter = new StudentRecyclerAdapter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mStudentAdapter);

        fetchStudents();
    }

    private void fetchStudents() {
        List<User> users = new Select().from(User.class).execute();
        if(users != null){
            mStudentAdapter.setmStudents(users);
        }
    }
}

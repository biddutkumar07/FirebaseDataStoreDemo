package com.example.biddutkumar.firebasedatastore;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public CustomAdapter(Activity context,List<Student> studentList) {
        super(context, R.layout.sample_layout, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout, null, true);
        Student student=studentList.get(position);

        TextView textView1=view.findViewById(R.id.nameTVId);
        TextView textView2=view.findViewById(R.id.ageTVId);

        textView1.setText("Name : "+student.getName());
        textView2.setText("Age : "+student.getAge());

        return view;
    }
}

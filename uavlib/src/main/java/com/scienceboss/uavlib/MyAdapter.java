package com.scienceboss.uavlib;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

     String data1[];

     Context context;

     RecyclerView recycler;

     private String remnantString;



    public MyAdapter(Context ct, String[] s1, RecyclerView recycler){

        context = ct;
        data1 = s1;
        recycler = recycler;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.transactio,viewGroup,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder myviewHolder, int i) {

         final ArrayList<String> data = new ArrayList<String>(Arrays.asList(data1[i].replaceAll("\\s", "").split(",")));


        final String ussd =  data.get(2) +   ", " + data.get(1) + "," + data.get(0);
     //   final String amount = data.get(2);
        final String report = data.get(3);

        myviewHolder.ussd.setText(ussd);
        myviewHolder.report.setText(report);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ussd;

            TextView report;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ussd = itemView.findViewById(R.id.ussd);
            report= itemView.findViewById(R.id.report);
        }
    }

    private void setmessage(Context context,String message){

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.receivedialog);
        dialog.show();

        final Button messageBox = dialog.findViewById(R.id.message);

        final TextView ok= dialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        messageBox.setText(message);

    }


}

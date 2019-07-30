package com.example.root.heart_tarang.blesample.operation;//package com.example.root.ecgble.blesample.operation;
//
//        import android.annotation.SuppressLint;
//        import android.app.Activity;
//        import android.content.Context;
//        import android.content.Intent;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.BaseAdapter;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//        import com.example.root.ecgble.R;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class CustomAdapter extends BaseAdapter {
//
//    Context context;
//
//
//    int[] imageId;
//
//
//    int layoutResourseId;
//
//
//    ArrayList<PhoneBook> data;
//
//    List<PhoneBook> arraylist;
//
//    //ArrayList<PhoneBook> data=new ArrayList<PhoneBook>();
//
//    private static LayoutInflater inflater = null;
//
//
//    public CustomAdapter(Context context, ArrayList<PhoneBook> data) {
//        // TODO Auto-generated constructor stub
//        //  result=prgmNameList;
//        super();
//
//        this.layoutResourseId = layoutResourseId;
//        this.context = context;
//        this.data = data;
//        arraylist = new ArrayList<PhoneBook>();
//        arraylist.addAll(data);
//
//
//        inflater = (LayoutInflater) context.
//                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    @Override
//    public int getCount() {
//        // TODO Auto-generated method stub
//        return data.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        // TODO Auto-generated method stub
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        // TODO Auto-generated method stub
//        return position;
//    }
//
//    public class Holder {
//        TextView txt1, txt2, txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12;
//    }
//    @SuppressWarnings("unused")
//    @SuppressLint("ViewHolder")
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        // TODO Auto-generated method stub
//        View row = convertView;
//        row = inflater.inflate(R.layout.displayactivity, null);
//        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//        //	row = inflater.inflate(layoutResourseId, parent, false);//1
//        Holder holder = new Holder();
//        holder.txt1 = (TextView) row.findViewById(R.id.vol1);
//        holder.txt2 = (TextView) row.findViewById(R.id.vol2);
//        holder.txt3 = (TextView) row.findViewById(R.id.vol3);
//        holder.txt4 = (TextView) row.findViewById(R.id.vol4);
//        holder.txt5 = (TextView) row.findViewById(R.id.vol5);
//        holder.txt6 = (TextView) row.findViewById(R.id.vol6);
//        holder.txt7 = (TextView) row.findViewById(R.id.vol7);
//        holder.txt8 = (TextView) row.findViewById(R.id.vol8);
//        holder.txt9 = (TextView) row.findViewById(R.id.vol9);
//        holder.txt10 = (TextView) row.findViewById(R.id.vol10);
//        holder.txt11 = (TextView) row.findViewById(R.id.vol11);
//        holder.txt12 = (TextView) row.findViewById(R.id.vol12);
//
//
//
//        holder.txt1.setText(data.get(position).getNickName());
//        holder.txt2.setText(data.get(position).getFullName());
//        holder.txt3.setText(data.get(position).getPhoneNo());
//
//
//        row.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(context, "You Clicked " + data.get(position).getNickName(), Toast.LENGTH_LONG).show();
//                MainActivity.MobileNUmber = data.get(position).getPhoneNo();
//                MainActivity.edNumber.setText(data.get(position).getPhoneNo());
//
//            }
//        });
//
//        holder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context,UpdateActivity.class);
//                i.putExtra("nickname",data.get(position).getNickName());
//                i.putExtra("username",data.get(position).getFullName());
//                i.putExtra("phonenumber",data.get(position).getPhoneNo());
//                context.startActivity(i);
//                ((Activity) context).finish();
////                ((Activity) context).finish();
//            }
//        });
//
//        return row;
//    }
//
//
//}

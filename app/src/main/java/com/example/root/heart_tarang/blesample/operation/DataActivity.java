package com.example.root.heart_tarang.blesample.operation;//package com.example.root.ecgble.blesample.operation;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.Adapter;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.example.root.ecgble.R;
//
//import java.util.ArrayList;
//
//public class DataActivity extends AppCompatActivity {
//
//    ListView lv;
//
//    public static ArrayList<PhoneBook> test = new ArrayList<>();
//    CustomAdapter customAdapter;
//
//
//    PhoneBookHandler phoneBookHandler;
//    PhoneBook phoneBook;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data);
//
//        phoneBook = new PhoneBook();
//
//        phoneBookHandler = new PhoneBookHandler(DataActivity.this);
//
//        lv = (ListView)findViewById(R.id.list);
//
//        test = phoneBookHandler.getAllContacts();
//        Adapter adapter=new CustomAdapter(DataActivity.this,test);
//        lv.setAdapter(customAdapter);
//    }
//}

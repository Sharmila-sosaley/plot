package com.example.root.heart_tarang;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.root.heart_tarang.R;
//import com.example.root.heart_tarang.blesample.MainActivity;
import java.util.ArrayList;
import java.util.List;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
public class ServiceActivity extends Activity implements AdapterView.OnItemSelectedListener
{

    LineChartView linechart1;
    LineChartView linechart2;
    LineChartView linechart3;
    LineChartView linechart4;
    LineChartView linechart5;
    LineChartView linechart6;
    LineChartView linechart7;
    LineChartView linechart8;
    LineChartView linechart9;
    LineChartView linechart10;
    LineChartView linechart11;
    LineChartView linechart12;

    ArrayList<Integer> timeInt = new ArrayList<>();
    ArrayList<Integer> lead1Volt = new ArrayList<>();
    ArrayList<Integer> lead2Volt = new ArrayList<>();
    ArrayList<Integer> lead3Volt = new ArrayList<>();
    ArrayList<Integer> lead4Volt = new ArrayList<>();
    ArrayList<Integer> lead5Volt = new ArrayList<>();
    ArrayList<Integer> lead6Volt = new ArrayList<>();
    ArrayList<Integer> lead7Volt = new ArrayList<>();
    ArrayList<Integer> lead8Volt = new ArrayList<>();
    ArrayList<Integer> lead9Volt = new ArrayList<>();
    ArrayList<Integer> lead10Volt = new ArrayList<>();
    ArrayList<Integer> lead11Volt = new ArrayList<>();
    ArrayList<Integer> lead12Volt = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        linechart1= (LineChartView) findViewById(R.id.chart1);
        linechart2= (LineChartView) findViewById(R.id.chart2);
        linechart3= (LineChartView) findViewById(R.id.chart3);
        linechart4= (LineChartView) findViewById(R.id.chart4);
        linechart5= (LineChartView) findViewById(R.id.chart5);
        linechart6= (LineChartView) findViewById(R.id.chart6);
        linechart7= (LineChartView) findViewById(R.id.chart7);
        linechart8= (LineChartView) findViewById(R.id.chart8);
        linechart9= (LineChartView) findViewById(R.id.chart9);
        linechart10= (LineChartView) findViewById(R.id.chart10);
        linechart11= (LineChartView) findViewById(R.id.chart11);
        linechart12= (LineChartView) findViewById(R.id.chart12);


        Intent l = getIntent();

        timeInt = l.getIntegerArrayListExtra("timeinterval");
        lead1Volt = l.getIntegerArrayListExtra("lead1voltage");
        lead2Volt = l.getIntegerArrayListExtra("lead2voltage");
        lead3Volt = l.getIntegerArrayListExtra("lead3voltage");
        lead4Volt = l.getIntegerArrayListExtra("lead4voltage");
        lead5Volt = l.getIntegerArrayListExtra("lead5voltage");
        lead6Volt = l.getIntegerArrayListExtra("lead6voltage");
        lead7Volt = l.getIntegerArrayListExtra("lead7voltage");
        lead8Volt = l.getIntegerArrayListExtra("lead8voltage");
        lead9Volt = l.getIntegerArrayListExtra("lead9voltage");
        lead10Volt = l.getIntegerArrayListExtra("lead10voltage");
        lead11Volt = l.getIntegerArrayListExtra("lead11voltage");
        lead12Volt = l.getIntegerArrayListExtra("lead12voltage");


        Log.d("XAXIS------",timeInt+"");
        Log.d("YAXIS1------",lead1Volt+"");
        Log.d("YAXIS2------",lead2Volt+"");
        Log.d("YAXIS3------",lead3Volt+"");
        Log.d("YAXIS4------",lead4Volt+"");
        Log.d("YAXIS5------",lead5Volt+"");
        Log.d("YAXIS6------",lead6Volt+"");
        Log.d("YAXIS7------",lead7Volt+"");
        Log.d("YAXIS8------",lead8Volt+"");
        Log.d("YAXIS9------",lead9Volt+"");
        Log.d("YAXIS10------",lead10Volt+"");
        Log.d("YAXIS11-----",lead11Volt+"");
        Log.d("YAXIS12------",lead12Volt+"");

        List axisValues = new ArrayList();
        List yAxisValues1 = new ArrayList();
        List yAxisValues2 = new ArrayList();
        List yAxisValues3 = new ArrayList();
        List yAxisValues4 = new ArrayList();
        List yAxisValues5 = new ArrayList();
        List yAxisValues6 = new ArrayList();
        List yAxisValues7 = new ArrayList();
        List yAxisValues8 = new ArrayList();
        List yAxisValues9 = new ArrayList();
        List yAxisValues10 = new ArrayList();
        List yAxisValues11= new ArrayList();
        List yAxisValues12= new ArrayList();


        Line line1 = new Line(yAxisValues1).setColor(Color.parseColor("#9C27B0"));
        Line line2 = new Line(yAxisValues2).setColor(Color.parseColor("#9C27B0"));
        Line line3 = new Line(yAxisValues3).setColor(Color.parseColor("#9C27B0"));
        Line line4 = new Line(yAxisValues4).setColor(Color.parseColor("#9C27B0"));
        Line line5 = new Line(yAxisValues5).setColor(Color.parseColor("#9C27B0"));
        Line line6 = new Line(yAxisValues6).setColor(Color.parseColor("#9C27B0"));
        Line line7 = new Line(yAxisValues7).setColor(Color.parseColor("#9C27B0"));
        Line line8 = new Line(yAxisValues8).setColor(Color.parseColor("#9C27B0"));
        Line line9= new Line(yAxisValues9).setColor(Color.parseColor("#9C27B0"));
        Line line10 = new Line(yAxisValues10).setColor(Color.parseColor("#9C27B0"));
        Line line11 = new Line(yAxisValues11).setColor(Color.parseColor("#9C27B0"));
        Line line12 = new Line(yAxisValues12).setColor(Color.parseColor("#9C27B0"));


        line1.setPointRadius(2);
        line2.setPointRadius(2);
        line3.setPointRadius(2);
        line4.setPointRadius(2);
        line5.setPointRadius(2);
        line6.setPointRadius(2);
        line7.setPointRadius(2);
        line8.setPointRadius(2);
        line9.setPointRadius(2);
        line10.setPointRadius(2);
        line11.setPointRadius(2);
        line12.setPointRadius(2);


        for(int x=0;x<timeInt.size();x++){
            axisValues.add(x,new AxisValue(x).setLabel(timeInt.get(x).toString()));
        }

        for(int y=0;y<lead1Volt.size();y++){
            yAxisValues1.add(new PointValue(y,lead1Volt.get(y)));
        }

        for(int y=0;y<lead2Volt.size();y++){
            yAxisValues2.add(new PointValue(y,lead2Volt.get(y)));
        }
        for(int y=0;y<lead3Volt.size();y++){
            yAxisValues3.add(new PointValue(y,lead3Volt.get(y)));
        }

        for(int y=0;y<lead4Volt.size();y++){
            yAxisValues4.add(new PointValue(y,lead4Volt.get(y)));
        }

        for(int y=0;y<lead5Volt.size();y++){
            yAxisValues5.add(new PointValue(y,lead5Volt.get(y)));
        }

        for(int y=0;y<lead6Volt.size();y++){
            yAxisValues6.add(new PointValue(y,lead6Volt.get(y)));
        }

        for(int y=0;y<lead7Volt.size();y++){
            yAxisValues7.add(new PointValue(y,lead7Volt.get(y)));
        }

        for(int y=0;y<lead8Volt.size();y++){
            yAxisValues8.add(new PointValue(y,lead8Volt.get(y)));
        }

        for(int y=0;y<lead9Volt.size();y++){
            yAxisValues9.add(new PointValue(y,lead9Volt.get(y)));
        }

        for(int y=0;y<lead10Volt.size();y++){
            yAxisValues10.add(new PointValue(y,lead10Volt.get(y)));
        }

        for(int y=0;y<lead11Volt.size();y++){
            yAxisValues11.add(new PointValue(y,lead11Volt.get(y)));
        }

        for(int y=0;y<lead12Volt.size();y++){
            yAxisValues12.add(new PointValue(y,lead12Volt.get(y)));
        }

        Log.d("axisvalues::::::",axisValues+"");
        Log.d("yaxisvalues1:::::",yAxisValues1+"");
        Log.d("yaxisvalues2:::::",yAxisValues2+"");
        Log.d("yaxisvalues3:::::",yAxisValues3+"");
        Log.d("yaxisvalues4:::::",yAxisValues4+"");
        Log.d("yaxisvalues5:::::",yAxisValues5+"");
        Log.d("yaxisvalues6:::::",yAxisValues6+"");
        Log.d("yaxisvalues7:::::",yAxisValues7+"");
        Log.d("yaxisvalues8:::::",yAxisValues8+"");
        Log.d("yaxisvalues9:::::",yAxisValues9+"");
        Log.d("yaxisvalues10:::::",yAxisValues10+"");
        Log.d("yaxisvalues11:::::",yAxisValues11+"");
        Log.d("yaxisvalues12:::::",yAxisValues12+"");

      /*  for (int i = 0,j = 0; i <= 1000; i+=2,j++) {
            axisValues.add(new PointValue(j, i));
        }
        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(i, new AxisValue(i).setLabel("Voltage (volts)"));
        }*/
        List lines1 = new ArrayList();
        lines1.add(line1);

        List lines2 = new ArrayList();
        lines2.add(line2);

        List lines3 = new ArrayList();
        lines3.add(line3);

        List lines4 = new ArrayList();
        lines4.add(line4);

        List lines5 = new ArrayList();
        lines5.add(line5);

        List lines6 = new ArrayList();
        lines6.add(line6);

        List lines7 = new ArrayList();
        lines7.add(line7);

        List lines8 = new ArrayList();
        lines8.add(line8);

        List lines9 = new ArrayList();
        lines9.add(line9);

        List lines10 = new ArrayList();
        lines10.add(line10);

        List lines11 = new ArrayList();
        lines11.add(line11);

        List lines12 = new ArrayList();
        lines12.add(line12);


        LineChartData data1 = new LineChartData();
        data1.setLines(lines1);

        LineChartData data2 = new LineChartData();
        data2.setLines(lines2);

        LineChartData data3 = new LineChartData();
        data3.setLines(lines3);

        LineChartData data4 = new LineChartData();
        data4.setLines(lines4);

        LineChartData data5 = new LineChartData();
        data5.setLines(lines5);

        LineChartData data6 = new LineChartData();
        data6.setLines(lines6);

        LineChartData data7 = new LineChartData();
        data7.setLines(lines7);

        LineChartData data8 = new LineChartData();
        data8.setLines(lines8);

        LineChartData data9 = new LineChartData();
        data9.setLines(lines9);

        LineChartData data10 = new LineChartData();
        data10.setLines(lines10);

        LineChartData data11 = new LineChartData();
        data11.setLines(lines11);

        LineChartData data12 = new LineChartData();
        data12.setLines(lines12);

        Axis axis1 = new Axis();
        axis1.setValues(axisValues);
        axis1.setTextSize(5);
//        axis1.setName("Time Interval (ms)");
        axis1.setTextColor(Color.parseColor("#FFFFFF"));
        data1.setAxisXBottom(axis1);


        Axis axis2 = new Axis();
        axis2.setValues(axisValues);
        axis2.setTextSize(5);
//        axis2.setName("Time Interval (ms)");
        axis2.setTextColor(Color.parseColor("#FFFFFF"));
        data2.setAxisXBottom(axis2);


        Axis axis3 = new Axis();
        axis3.setValues(axisValues);
        axis3.setTextSize(5);
//        axis3.setName("Time Interval (ms)");
        axis3.setTextColor(Color.parseColor("#FFFFFF"));
        data3.setAxisXBottom(axis3);


        Axis axis4 = new Axis();
        axis4.setValues(axisValues);
        axis4.setTextSize(5);
//        axis4.setName("Time Interval (ms)");
        axis4.setTextColor(Color.parseColor("#FFFFFF"));
        data4.setAxisXBottom(axis4);


        Axis axis5 = new Axis();
        axis5.setValues(axisValues);
        axis5.setTextSize(5);
//        axis5.setName("Time Interval (ms)");
        axis5.setTextColor(Color.parseColor("#FFFFFF"));
        data5.setAxisXBottom(axis5);


        Axis axis6 = new Axis();
        axis6.setValues(axisValues);
        axis6.setTextSize(5);
//        axis6.setName("Time Interval (ms)");
        axis6.setTextColor(Color.parseColor("#FFFFFF"));
        data6.setAxisXBottom(axis6);


        Axis axis7 = new Axis();
        axis7.setValues(axisValues);
        axis7.setTextSize(5);
//        axis7.setName("Time Interval (ms)");
        axis7.setTextColor(Color.parseColor("#FFFFFF"));
        data7.setAxisXBottom(axis7);


        Axis axis8 = new Axis();
        axis8.setValues(axisValues);
        axis8.setTextSize(5);
//        axis8.setName("Time Interval (ms)");
        axis8.setTextColor(Color.parseColor("#FFFFFF"));
        data8.setAxisXBottom(axis8);


        Axis axis9 = new Axis();
        axis9.setValues(axisValues);
        axis9.setTextSize(5);
//        axis9.setName("Time Interval (ms)");
        axis9.setTextColor(Color.parseColor("#FFFFFF"));
        data9.setAxisXBottom(axis9);


        Axis axis10 = new Axis();
        axis10.setValues(axisValues);
        axis10.setTextSize(5);
//        axis10.setName("Time Interval (ms)");
        axis10.setTextColor(Color.parseColor("#FFFFFF"));
        data10.setAxisXBottom(axis10);


        Axis axis11 = new Axis();
        axis11.setValues(axisValues);
        axis11.setTextSize(1);
//        axis11.setName("Time Interval (ms)");
        axis11.setTextColor(Color.parseColor("#FFFFFF"));
        data11.setAxisXBottom(axis11);


        Axis axis12 = new Axis();
        axis12.setValues(axisValues);
        axis12.setTextSize(1);
//        axis12.setName("Time Interval (ms)");
        axis12.setTextColor(Color.parseColor("#FFFFFF"));
        data12.setAxisXBottom(axis12);


        Axis yAxis1 = new Axis();
//        yAxis1.setName("Voltage (volts)");
        yAxis1.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis1.setTextSize(1);
        data1.setAxisYLeft(yAxis1);


        Axis yAxis2 = new Axis();
//        yAxis2.setName("Voltage (volts)");
        yAxis2.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis2.setTextSize(1);
        data2.setAxisYLeft(yAxis2);


        Axis yAxis3 = new Axis();
//        yAxis3.setName("Voltage (volts)");
        yAxis3.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis3.setTextSize(1);
        data3.setAxisYLeft(yAxis3);


        Axis yAxis4 = new Axis();
//        yAxis4.setName("Voltage (volts)");
        yAxis4.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis4.setTextSize(1);
        data4.setAxisYLeft(yAxis4);


        Axis yAxis5 = new Axis();
//        yAxis5.setName("Voltage (volts)");
        yAxis5.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis5.setTextSize(1);
        data5.setAxisYLeft(yAxis5);


        Axis yAxis6 = new Axis();
//        yAxis6.setName("Voltage (volts)");
        yAxis6.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis6.setTextSize(1);
        data6.setAxisYLeft(yAxis6);


        Axis yAxis7 = new Axis();
//        yAxis7.setName("Voltage (volts)");
        yAxis7.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis7.setTextSize(1);
        data7.setAxisYLeft(yAxis7);


        Axis yAxis8 = new Axis();
//        yAxis8.setName("Voltage (volts)");
        yAxis8.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis8.setTextSize(1);
        data8.setAxisYLeft(yAxis8);


        Axis yAxis9 = new Axis();
//        yAxis9.setName("Voltage (volts)");
        yAxis9.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis9.setTextSize(1);
        data9.setAxisYLeft(yAxis9);


        Axis yAxis10 = new Axis();
//        yAxis10.setName("Voltage (volts)");
        yAxis10.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis10.setTextSize(1);
        data10.setAxisYLeft(yAxis10);


        Axis yAxis11 = new Axis();
//        yAxis11.setName("Voltage (volts)");
        yAxis11.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis11.setTextSize(1);
        data11.setAxisYLeft(yAxis11);


        Axis yAxis12 = new Axis();
//        yAxis12.setName("Voltage (volts)");
        yAxis12.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis12.setTextSize(1);
        data12.setAxisYLeft(yAxis12);


        linechart1.setLineChartData(data1);
        Viewport viewport1 = new Viewport(linechart1.getMaximumViewport());
      /*  viewport1.top = 1850;
        viewport1.bottom =1350 ;*/
        linechart1.setMaximumViewport(viewport1);
        linechart1.setCurrentViewport(viewport1);


        linechart2.setLineChartData(data2);
        Viewport viewport2 = new Viewport(linechart1.getMaximumViewport());
        viewport2.top = 2000;
        viewport2.bottom =1350 ;
        linechart2.setMaximumViewport(viewport2);
        linechart2.setCurrentViewport(viewport2);


        linechart3.setLineChartData(data3);
        Viewport viewport3 = new Viewport(linechart3.getMaximumViewport());
        /*viewport3.top = 1850;
        viewport3.bottom =1350 ;*/
        linechart3.setMaximumViewport(viewport3);
        linechart3.setCurrentViewport(viewport3);


        linechart4.setLineChartData(data4);
        Viewport viewport4 = new Viewport(linechart4.getMaximumViewport());
       /* viewport4.top = 1750;
        viewport4.bottom =1000 ;*/
        linechart4.setMaximumViewport(viewport4);
        linechart4.setCurrentViewport(viewport4);


        linechart5.setLineChartData(data5);
        Viewport viewport5 = new Viewport(linechart5.getMaximumViewport());
//        viewport5.top = 1850;
//        viewport5.bottom =1350 ;
        linechart5.setMaximumViewport(viewport5);
        linechart5.setCurrentViewport(viewport5);


        linechart6.setLineChartData(data6);
        Viewport viewport6 = new Viewport(linechart6.getMaximumViewport());
//        viewport6.top = 1850;
//        viewport6.bottom =1350 ;
        linechart6.setMaximumViewport(viewport6);
        linechart6.setCurrentViewport(viewport6);


        linechart7.setLineChartData(data7);
        Viewport viewport7 = new Viewport(linechart7.getMaximumViewport());
//        viewport7.top = 1850;
//        viewport7.bottom =1350 ;
        linechart7.setMaximumViewport(viewport7);
        linechart7.setCurrentViewport(viewport7);


        linechart8.setLineChartData(data8);
        Viewport viewport8 = new Viewport(linechart8.getMaximumViewport());
//        viewport8.top = 1850;
//        viewport8.bottom =1350 ;
        linechart8.setMaximumViewport(viewport8);
        linechart8.setCurrentViewport(viewport8);


        linechart9.setLineChartData(data9);
        Viewport viewport9 = new Viewport(linechart9.getMaximumViewport());
//        viewport9.top = 4400;
//        viewport9.bottom =3300 ;
        linechart9.setMaximumViewport(viewport9);
        linechart9.setCurrentViewport(viewport9);


        linechart10.setLineChartData(data10);
        Viewport viewport10 = new Viewport(linechart10.getMaximumViewport());
//        viewport10.top = 4400;
//        viewport10.bottom =3300 ;
        linechart10.setMaximumViewport(viewport10);
        linechart10.setCurrentViewport(viewport10);


        linechart11.setLineChartData(data11);
        Viewport viewport11 = new Viewport(linechart11.getMaximumViewport());
//        viewport11.top = 4400;
//        viewport11.bottom =3300 ;
        linechart11.setMaximumViewport(viewport11);
        linechart11.setCurrentViewport(viewport11);


        linechart12.setLineChartData(data12);
        Viewport viewport12 = new Viewport(linechart12.getMaximumViewport());
//        viewport12.top = 4400;
//        viewport12.bottom =3300 ;
        linechart12.setMaximumViewport(viewport12);
        linechart12.setCurrentViewport(viewport12);


        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Lead 1");
        categories.add("Lead 2");
        categories.add("Lead 3");
        categories.add("Lead 4");
        categories.add("Lead 5");
        categories.add("Lead 6");
        categories.add("Lead 7");
        categories.add("Lead 8");
        categories.add("Lead 9");
        categories.add("Lead 10");
        categories.add("Lead 11");
        categories.add("Lead 12");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        {
            if (item.equals("Lead 1")) {
                linechart1.setVisibility(View.VISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 2")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.VISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 3")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.VISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 4")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.VISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 5")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.VISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 6")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.VISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 7")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.VISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 8")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.VISIBLE);
                linechart9.setVisibility(View.INVISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
            if (item.equals("Lead 9")) {
                linechart1.setVisibility(View.INVISIBLE);
                linechart2.setVisibility(View.INVISIBLE);
                linechart3.setVisibility(View.INVISIBLE);
                linechart4.setVisibility(View.INVISIBLE);
                linechart5.setVisibility(View.INVISIBLE);
                linechart6.setVisibility(View.INVISIBLE);
                linechart7.setVisibility(View.INVISIBLE);
                linechart8.setVisibility(View.INVISIBLE);
                linechart9.setVisibility(View.VISIBLE);
                linechart10.setVisibility(View.INVISIBLE);
                linechart11.setVisibility(View.INVISIBLE);
                linechart12.setVisibility(View.INVISIBLE);
            }
                if (item.equals("Lead 10")) {
                    linechart1.setVisibility(View.INVISIBLE);
                    linechart2.setVisibility(View.INVISIBLE);
                    linechart3.setVisibility(View.INVISIBLE);
                    linechart4.setVisibility(View.INVISIBLE);
                    linechart5.setVisibility(View.INVISIBLE);
                    linechart6.setVisibility(View.INVISIBLE);
                    linechart7.setVisibility(View.INVISIBLE);
                    linechart8.setVisibility(View.INVISIBLE);
                    linechart9.setVisibility(View.INVISIBLE);
                    linechart10.setVisibility(View.VISIBLE);
                    linechart11.setVisibility(View.INVISIBLE);
                    linechart12.setVisibility(View.INVISIBLE);
                }
                if (item.equals("Lead 11")) {
                    linechart1.setVisibility(View.INVISIBLE);
                    linechart2.setVisibility(View.INVISIBLE);
                    linechart3.setVisibility(View.INVISIBLE);
                    linechart4.setVisibility(View.INVISIBLE);
                    linechart5.setVisibility(View.INVISIBLE);
                    linechart6.setVisibility(View.INVISIBLE);
                    linechart7.setVisibility(View.INVISIBLE);
                    linechart8.setVisibility(View.INVISIBLE);
                    linechart9.setVisibility(View.INVISIBLE);
                    linechart10.setVisibility(View.INVISIBLE);
                    linechart11.setVisibility(View.VISIBLE);
                    linechart12.setVisibility(View.INVISIBLE);
                }
                if (item.equals("Lead 12")) {
                    linechart1.setVisibility(View.INVISIBLE);
                    linechart2.setVisibility(View.INVISIBLE);
                    linechart3.setVisibility(View.INVISIBLE);
                    linechart4.setVisibility(View.INVISIBLE);
                    linechart5.setVisibility(View.INVISIBLE);
                    linechart6.setVisibility(View.INVISIBLE);
                    linechart7.setVisibility(View.INVISIBLE);
                    linechart8.setVisibility(View.INVISIBLE);
                    linechart9.setVisibility(View.INVISIBLE);
                    linechart10.setVisibility(View.INVISIBLE);
                    linechart11.setVisibility(View.INVISIBLE);
                    linechart12.setVisibility(View.VISIBLE);
                }
                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}

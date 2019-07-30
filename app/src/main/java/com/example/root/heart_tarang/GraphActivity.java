package com.example.root.heart_tarang;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.Toast;

        import com.example.root.heart_tarang.R;

        import java.util.ArrayList;
        import java.util.List;

        import lecho.lib.hellocharts.model.Axis;
        import lecho.lib.hellocharts.model.AxisValue;
        import lecho.lib.hellocharts.model.Line;
        import lecho.lib.hellocharts.model.LineChartData;
        import lecho.lib.hellocharts.model.PointValue;
        import lecho.lib.hellocharts.model.Viewport;
        import lecho.lib.hellocharts.view.LineChartView;

        import static com.example.root.heart_tarang.R.string.characteristic;

public class GraphActivity extends AppCompatActivity {

    LineChartView lineChartView;
    private Spinner spinner1;
    private Button btnSubmit;

    ArrayList<Integer> timeInt = new ArrayList<>();
    ArrayList<Integer> lead1Volt = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        lineChartView =(LineChartView) findViewById(R.id.chart1);

        Intent l = getIntent();

        timeInt = l.getIntegerArrayListExtra("timeinterval");
        lead1Volt = l.getIntegerArrayListExtra("lead1voltage");


        Log.d("XAXIS------",timeInt+"");
        Log.d("YAXIS------",lead1Volt+"");

        List axisValues = new ArrayList();
        List yAxisValues = new ArrayList();


        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
        line.setPointRadius(2);

        for(int x=0;x<timeInt.size();x++){
            axisValues.add(x,new AxisValue(x).setLabel(timeInt.get(x).toString()));
        }

        for(int y=0;y<lead1Volt.size();y++){
            yAxisValues.add(new PointValue(y,lead1Volt.get(y)));
        }

        Log.d("axisvalues::::::",axisValues+"");
        Log.d("yaxisvalues:::::",yAxisValues+"");

      /*  for (int i = 0,j = 0; i <= 1000; i+=2,j++) {
            axisValues.add(new PointValue(j, i));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(i, new AxisValue(i).setLabel("Voltage (volts)"));
        }*/


        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);


        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setName("Time Interval (ms)");
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("Voltage (volts)");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 1850;
        viewport.bottom =1350 ;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
    }
}



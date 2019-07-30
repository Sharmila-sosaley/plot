package com.example.root.heart_tarang.blesample.operation;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.root.heart_tarang.R;
import com.example.root.heart_tarang.ServiceActivity;
import com.example.root.heart_tarang.fastble.BleManager;
import com.example.root.heart_tarang.fastble.callback.BleIndicateCallback;
import com.example.root.heart_tarang.fastble.callback.BleNotifyCallback;
import com.example.root.heart_tarang.fastble.callback.BleReadCallback;
import com.example.root.heart_tarang.fastble.callback.BleWriteCallback;
import com.example.root.heart_tarang.fastble.data.BleDevice;
import com.example.root.heart_tarang.fastble.exception.BleException;
import com.example.root.heart_tarang.fastble.utils.HexUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CharacteristicOperationFragment extends Fragment {
    public static final int PROPERTY_READ = 1;
    public static final int PROPERTY_WRITE = 2;
    public static final int PROPERTY_WRITE_NO_RESPONSE = 3;
    public static final int PROPERTY_NOTIFY = 4;
    public static final int PROPERTY_INDICATE = 5;
    private LinearLayout layout_container;
    private List<String> childList = new ArrayList<>();

    //    public static PhoneBookHandler phoneBookHandler;
//    public static PhoneBook phoneBook;
    public static int Timeint = 0;
    public static String f_dest = Environment.getExternalStorageDirectory() + File.separator + "heart_tarang.txt";
    public static File f = new File(f_dest);
    public static ArrayList<Integer> arrTimeInt = new ArrayList<>();
    public static ArrayList<Integer> arrLead1Volt = new ArrayList<>();
    public static ArrayList<Integer> arrLead2Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead3Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead4Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead5Volt = new ArrayList<>();
    public static ArrayList<Integer> arrLead6Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead7Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead8Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead9Volt = new ArrayList<>();
    public static ArrayList<Integer> arrLead10Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead11Volt =new ArrayList<>();
    public static ArrayList<Integer> arrLead12Volt =new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_characteric_operation, null);
        initView(v);
        arrTimeInt.clear();
        arrLead1Volt.clear();
        arrLead2Volt.clear();
        arrLead3Volt.clear();
        arrLead4Volt.clear();
        arrLead5Volt.clear();
        arrLead6Volt.clear();
        arrLead7Volt.clear();
        arrLead8Volt.clear();
        arrLead9Volt.clear();
        arrLead10Volt.clear();
        arrLead11Volt.clear();
        arrLead12Volt.clear();
//        phoneBook = new PhoneBook();
//        phoneBookHandler =new PhoneBookHandler(getActivity());
        return v;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void writeToFile(String data) {
        try {
            FileOutputStream fout = new FileOutputStream(f,true);
            OutputStreamWriter Writer = new OutputStreamWriter(fout);
            Writer.append(data);
            Writer.append("\n");
            Writer.close();
            fout.flush();
            fout.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    private void initView(View v) {
        layout_container = (LinearLayout) v.findViewById(R.id.layout_container);
    }
    public void showData() {
        final BleDevice bleDevice = ((OperationActivity) getActivity()).getBleDevice();
        final BluetoothGattCharacteristic characteristic = ((OperationActivity) getActivity()).getCharacteristic();
        final int charaProp = ((OperationActivity) getActivity()).getCharaProp();
        String child = characteristic.getUuid().toString() + String.valueOf(charaProp);
        for (int i = 0; i < layout_container.getChildCount(); i++) {
            layout_container.getChildAt(i).setVisibility(View.GONE);
        }
        if (childList.contains(child)) {
            layout_container.findViewWithTag(bleDevice.getKey() + characteristic.getUuid().toString() + charaProp).setVisibility(View.VISIBLE);
        } else {
            childList.add(child);
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_characteric_operation, null);
            view.setTag(bleDevice.getKey() + characteristic.getUuid().toString() + charaProp);
            LinearLayout layout_add = (LinearLayout) view.findViewById(R.id.layout_add);
            final TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
            txt_title.setText(String.valueOf(characteristic.getUuid().toString() + getActivity().getString(R.string.data_changed)));
            final TextView txt = (TextView) view.findViewById(R.id.txt);
            txt.setMovementMethod(ScrollingMovementMethod.getInstance());
            switch (charaProp) {
                case PROPERTY_READ: {
                    View view_add = LayoutInflater.from(getActivity()).inflate(R.layout.layout_characteric_operation_button, null);
                    Button btn = (Button) view_add.findViewById(R.id.btn);
                    btn.setText(getActivity().getString(R.string.read));
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            BleManager.getInstance().read(
                                    bleDevice,
                                    characteristic.getService().getUuid().toString(),
                                    characteristic.getUuid().toString(),
                                    new BleReadCallback() {
                                        @Override
                                        public void onReadSuccess(final byte[] data) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    addText(txt, HexUtil.formatHexString(data, true));
                                                }
                                            });
                                        }
                                        @Override
                                        public void onReadFailure(final BleException exception) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    addText(txt, exception.toString());
                                                }
                                            });
                                        }
                                    });
                        }
                    });
                    layout_add.addView(view_add);
                }
                break;
                case PROPERTY_WRITE: {
                    View view_add = LayoutInflater.from(getActivity()).inflate(R.layout.layout_characteric_operation_et, null);
                    final EditText et = (EditText) view_add.findViewById(R.id.et);
                    Button btn = (Button) view_add.findViewById(R.id.btn);
                    btn.setText(getActivity().getString(R.string.write));
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String hex = et.getText().toString();
                            if (TextUtils.isEmpty(hex)) {
                                return;
                            }
                            BleManager.getInstance().write(
                                    bleDevice,
                                    characteristic.getService().getUuid().toString(),
                                    characteristic.getUuid().toString(),
                                    HexUtil.hexStringToBytes(hex),
                                    new BleWriteCallback() {
                                        @Override
                                        public void onWriteSuccess(final int current, final int total, final byte[] justWrite) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    addText(txt, "write success, current: " + current
                                                            + " total: " + total
                                                            + " justWrite: " + HexUtil.formatHexString(justWrite, true));
                                                }
                                            });
                                        }
                                        @Override
                                        public void onWriteFailure(final BleException exception) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    addText(txt, exception.toString());
                                                }
                                            });
                                        }
                                    });
                        }
                    });
                    layout_add.addView(view_add);
                }
                break;
                case PROPERTY_WRITE_NO_RESPONSE: {
                    View view_add = LayoutInflater.from(getActivity()).inflate(R.layout.layout_characteric_operation_et, null);
                    final EditText et = (EditText) view_add.findViewById(R.id.et);
                    Button btn = (Button) view_add.findViewById(R.id.btn);
                    btn.setText(getActivity().getString(R.string.write));
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String hex = et.getText().toString();
                            if (TextUtils.isEmpty(hex)) {
                                return;
                            }
                            BleManager.getInstance().write(
                                    bleDevice,
                                    characteristic.getService().getUuid().toString(),
                                    characteristic.getUuid().toString(),
                                    HexUtil.hexStringToBytes(hex),
                                    new BleWriteCallback() {
                                        @Override
                                        public void onWriteSuccess(final int current, final int total, final byte[] justWrite) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    addText(txt, "write success, current: " + current
                                                            + " total: " + total
                                                            + " justWrite: " + HexUtil.formatHexString(justWrite, true));
                                                }
                                            });
                                        }
                                        @Override
                                        public void onWriteFailure(final BleException exception) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    addText(txt, exception.toString());
                                                }
                                            });
                                        }
                                    });
                        }
                    });
                    layout_add.addView(view_add);
                }
                break;
                case PROPERTY_NOTIFY: {
                    View view_add = LayoutInflater.from(getActivity()).inflate(R.layout.layout_characteric_operation_button, null);
                    final Button btn = (Button) view_add.findViewById(R.id.btn);
                    final Button button2 = (Button) view_add.findViewById(R.id.button2);
                    btn.setText(getActivity().getString(R.string.open_notification));
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            GraphActivity Graph = new GraphActivity();
//                            ServiceActivity Service= new ServiceActivity();
                            Intent i = new Intent(CharacteristicOperationFragment.this.getActivity(), ServiceActivity.class);
                            i.putExtra("timeinterval", arrTimeInt);
                            i.putExtra("lead1voltage", arrLead1Volt);
                            i.putExtra("lead2voltage", arrLead2Volt);
                            i.putExtra("lead3voltage", arrLead3Volt);
                            i.putExtra("lead4voltage", arrLead4Volt);
                            i.putExtra("lead5voltage", arrLead5Volt);
                            i.putExtra("lead6voltage", arrLead6Volt);
                            i.putExtra("lead7voltage", arrLead7Volt);
                            i.putExtra("lead8voltage", arrLead8Volt);
                            i.putExtra("lead9voltage", arrLead9Volt);
                            i.putExtra("lead10voltage", arrLead10Volt);
                            i.putExtra("lead11voltage", arrLead11Volt);
                            i.putExtra("lead12voltage", arrLead12Volt);
                            startActivity(i);
//                            Intent i =new Intent(CharacteristicOperationFragment.this.getActivity(),ServiceActivity.class);
//                            startActivity(i);
                        }
                    });
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btn.getText().toString().equals(getActivity().getString(R.string.open_notification))) {
                                btn.setText(getActivity().getString(R.string.close_notification));
                                BleManager.getInstance().notify(
                                        bleDevice,
                                        characteristic.getService().getUuid().toString(),
                                        characteristic.getUuid().toString(),
                                        new BleNotifyCallback() {
                                            @Override
                                            public void onNotifySuccess() {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        addText(txt, "notify success");
                                                    }
                                                });
                                            }
                                            @Override
                                            public void onNotifyFailure(final BleException exception) {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        addText(txt, exception.toString());
                                                    }
                                                });
                                            }
                                            @Override
                                            public void onCharacteristicChanged(byte[] data) {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {

                                                        try {
                                                            addText(txt, HexUtil.formatHexString(characteristic.getValue(), true));
                                                            Log.d("VOLTAGE", HexUtil.formatHexString(characteristic.getValue()));
                                                            String opValue = HexUtil.formatHexString(characteristic.getValue());
                                                            Log.d("opvalue::::", opValue);
//                                                        writeToFile(opValue);
//                                                        writeToFile(HexUtil.convertHexToString(opValue));
                                                            String splitVal[] = opValue.split("2c");
                                                            String lead1_Volt = HexUtil.convertHexToString(splitVal[1]);
                                                            String lead2_Volt = HexUtil.convertHexToString(splitVal[2]);
                                                            String lead3_Volt = HexUtil.convertHexToString(splitVal[3]);
                                                            String lead4_Volt = HexUtil.convertHexToString(splitVal[4]);
                                                            String lead5_Volt = HexUtil.convertHexToString(splitVal[5]);
                                                            String lead6_Volt = HexUtil.convertHexToString(splitVal[6]);
                                                            String lead7_Volt = HexUtil.convertHexToString(splitVal[7]);
                                                            String lead8_Volt = HexUtil.convertHexToString(splitVal[8]);
                                                            String lead9_Volt = HexUtil.convertHexToString(splitVal[9]);
                                                            String lead10_Volt = HexUtil.convertHexToString(splitVal[10]);
                                                            String lead11_Volt = HexUtil.convertHexToString(splitVal[11]);
                                                            String lead12_Volt = HexUtil.convertHexToString(splitVal[12]);
                                                            Long tsLong = System.currentTimeMillis() / 1000;
                                                            String ts = tsLong.toString();
                                                            writeToFile(Timeint + "-" + lead1_Volt + "-" + ts);
                                                            Log.d("TIMEINTERVAL1", Timeint + "    " + lead1_Volt);
                                                            Log.d("TIMEINTERVAL2", Timeint + "    " + lead2_Volt);
                                                            Log.d("TIMEINTERVAL3", Timeint + "    " + lead3_Volt);
                                                            Log.d("TIMEINTERVAL4", Timeint + "    " + lead4_Volt);
                                                            Log.d("TIMEINTERVAL5", Timeint + "    " + lead5_Volt);
                                                            Log.d("TIMEINTERVAL6", Timeint + "    " + lead6_Volt);
                                                            Log.d("TIMEINTERVAL7", Timeint + "    " + lead7_Volt);
                                                            Log.d("TIMEINTERVAL8", Timeint + "    " + lead8_Volt);
                                                            Log.d("TIMEINTERVAL9", Timeint + "    " + lead9_Volt);
                                                            Log.d("TIMEINTERVAL10", Timeint + "    " + lead10_Volt);
                                                            Log.d("TIMEINTERVAL11", Timeint + "    " + lead11_Volt);
                                                            Log.d("TIMEINTERVAL12", Timeint + "    " + lead12_Volt.substring(0, 4));
                                                            if (Timeint < 1000)
                                                            {
                                                                arrTimeInt.add(Timeint);
                                                                arrLead1Volt.add(Integer.valueOf(lead1_Volt));
                                                                arrLead2Volt.add(Integer.valueOf(lead2_Volt));
                                                                arrLead3Volt.add(Integer.valueOf(lead3_Volt));
                                                                arrLead4Volt.add(Integer.valueOf(lead4_Volt));
                                                                arrLead5Volt.add(Integer.valueOf(lead5_Volt));
                                                                arrLead6Volt.add(Integer.valueOf(lead6_Volt));
                                                                arrLead7Volt.add(Integer.valueOf(lead7_Volt));
                                                                arrLead8Volt.add(Integer.valueOf(lead8_Volt));
                                                                arrLead9Volt.add(Integer.valueOf(lead9_Volt));
                                                                arrLead10Volt.add(Integer.valueOf(lead10_Volt));
                                                                arrLead11Volt.add(Integer.valueOf(lead11_Volt));
                                                                arrLead12Volt.add(Integer.valueOf(lead12_Volt.substring(0, 4)));
                                                                Timeint = Timeint + 1;
                                                            }
                                                        }catch (Exception e){
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                });
                                            }
                                        });
                            } else {
                                btn.setText(getActivity().getString(R.string.open_notification));
                                BleManager.getInstance().stopNotify(
                                        bleDevice,
                                        characteristic.getService().getUuid().toString(),
                                        characteristic.getUuid().toString());
                            }
                        }
                    });
                    layout_add.addView(view_add);
                }
                break;
                case PROPERTY_INDICATE: {
                    View view_add = LayoutInflater.from(getActivity()).inflate(R.layout.layout_characteric_operation_button, null);
                    final Button btn = (Button) view_add.findViewById(R.id.btn);
                    btn.setText(getActivity().getString(R.string.open_notification));
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btn.getText().toString().equals(getActivity().getString(R.string.open_notification))) {
                                btn.setText(getActivity().getString(R.string.close_notification));
                                BleManager.getInstance().indicate(
                                        bleDevice,
                                        characteristic.getService().getUuid().toString(),
                                        characteristic.getUuid().toString(),
                                        new BleIndicateCallback() {
                                            @Override
                                            public void onIndicateSuccess() {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        addText(txt, "indicate success");
                                                    }
                                                });
                                            }
                                            @Override
                                            public void onIndicateFailure(final BleException exception) {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        addText(txt, exception.toString());
                                                    }
                                                });
                                            }
                                            @Override
                                            public void onCharacteristicChanged(byte[] data) {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        addText(txt, HexUtil.formatHexString(characteristic.getValue(), true));
                                                    }
                                                });
                                            }
                                        });
                            } else {
                                btn.setText(getActivity().getString(R.string.open_notification));
                                BleManager.getInstance().stopIndicate(
                                        bleDevice,
                                        characteristic.getService().getUuid().toString(),
                                        characteristic.getUuid().toString());
                            }
                        }
                    });
                    layout_add.addView(view_add);
                }
                break;
            }
            layout_container.addView(view);
        }
    }
    private void runOnUiThread(Runnable runnable) {
        if (isAdded() && getActivity() != null)
            getActivity().runOnUiThread(runnable);
    }
    private void addText(TextView textView, String content) {
        textView.append(content);
        textView.append("\n");
        int offset = textView.getLineCount() * textView.getLineHeight();
        if (offset > textView.getHeight()) {
            textView.scrollTo(0, offset - textView.getHeight());
        }
    }
}

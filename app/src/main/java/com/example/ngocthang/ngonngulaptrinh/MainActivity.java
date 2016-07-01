package com.example.ngocthang.ngonngulaptrinh;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> arrThumnai;
    ArrayList<NgonNgu> arrNgonNgu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvNgonNgu = (ListView) findViewById(R.id.listViewNgonNgu);
        arrNgonNgu = new ArrayList<>();
        final String arrName[]=getResources().getStringArray(R.array.NgonNgu);
        final String arrDetail[]=getResources().getStringArray(R.array.Detail);
        addThumnai();
        for (int i = 0; i < arrName.length; i++) {
            NgonNgu nn = new NgonNgu(arrName[i], arrDetail[i], arrThumnai.get(i));
            arrNgonNgu.add(nn);
        }
        MyAdapter adt = new MyAdapter(MainActivity.this, R.layout.dong_ngon_ngu, arrNgonNgu);
        lvNgonNgu.setAdapter(adt);
        lvNgonNgu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, arrNgonNgu.get(position).getDetail(), Toast.LENGTH_LONG).show();
                AlertDialog myAlertDialog = taoMotAlertDialog(arrNgonNgu.get(position).getName(), arrNgonNgu.get(position).getDetail());
                myAlertDialog.show();
            }
        });
    }

    //Hàm khởi tạo Dialog
    private AlertDialog taoMotAlertDialog(String nn, String detail){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề hiển thị
        builder.setTitle("Thông tin về ngôn ngữ " + nn);
        //Thiết lập thông báo hiển thị
        builder.setMessage(detail);
        builder.setCancelable(false);
        //Tạo nút Activity2

        //builder.setNegativeButton("OK",
        //        new DialogInterface.OnClickListener() {
        //            public void onClick(DialogInterface dialog,
        //                                int which) {
         //               finish();
         //           }
        //        });
        //Tạo nút Hủy
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        return dialog;
    }

    public void addThumnai(){
        arrThumnai = new ArrayList<>();
        arrThumnai.add(R.drawable.java);
        arrThumnai.add(R.drawable.c);
        arrThumnai.add(R.drawable.cplusplus);
        arrThumnai.add(R.drawable.csharp);
        arrThumnai.add(R.drawable.python);
        arrThumnai.add(R.drawable.php);
        arrThumnai.add(R.drawable.ruby);
        arrThumnai.add(R.drawable.html);
        arrThumnai.add(R.drawable.css);
        arrThumnai.add(R.drawable.javascript);
    }

}

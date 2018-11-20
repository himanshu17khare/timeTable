package com.example.prince.timetable;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String address=null;
    Spinner spinner1;
    Spinner spinner2;
    Button showTimeTable;
    int sem=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        showTimeTable=findViewById(R.id.button);
       showTimeTable.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(sem!=-1&&address!=null){
                   startActivity(new Intent(MainActivity.this,TimeTable.class).putExtra("Url",address.replace("-1",Integer.toString(sem))));
               }else {
                   Toast.makeText(MainActivity.this, "Please select the options", Toast.LENGTH_SHORT).show();
               }
           }
       });
    }
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
     int i= parent.getCount();
     if(i==6){
        switch (position){
            case 1:
              address="http://dscollegetimetable.in/admin/timetable_printpreview.php?mode=print&classId=34&semester="+sem;
              break;
            case 2:
                address="http://dscollegetimetable.in/admin/timetable_printpreview.php?mode=print&classId=17&semester="+sem;
                break;
            case 3:
                address="http://dscollegetimetable.in/admin/timetable_printpreview.php?mode=print&classId=5&semester="+sem;
                break;
            case 4:
                address="http://dscollegetimetable.in/admin/timetable_printpreview.php?mode=print&classId=12&semester="+sem;
            break;
                case 5:
                address="http://dscollegetimetable.in/admin/timetable_printpreview.php?mode=print&classId=4&semester="+sem;
                break;
                default:
                    address=null;
        }
       }else if(i==9){
         switch (position){
             case 1:
                 sem=position;
                 break;
             case 2:
                 sem=position;
                 break;
             case 3:
                 sem=position;
                 break;
             case 4:
                 sem=position;
                 break;
             case 5:
                 sem=position;
                 break;
             case 6:
                sem=position;
                break;
             case 7:
                 sem=position;
                 break;
             case 8:
                 sem=position;
                 break;
             default:
                 sem=-1;
         }
     }
  }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}

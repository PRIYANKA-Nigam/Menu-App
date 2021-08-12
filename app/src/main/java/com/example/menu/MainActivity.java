package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b; TextView textView; EditText editText; @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editTextTextPersonName); textView=(TextView)findViewById(R.id.textView);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=editText.getText().toString(); String r="<span style='background-color:yellow'>"+ t + "</span>";
                String o=textView.getText().toString(); String m=o.replaceAll(t,r);
                textView.setText(Html.fromHtml(m)); }}); } @Override
    public boolean onCreateOptionsMenu(Menu menu) {             //create menu bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu); }@Override                                                     //to handle event ie...allow clicking on menu bar
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { int id = item.getItemId();
        switch (id) { case R.id.new1:
               Intent intent1=new Intent(MainActivity.this,Item1.class); startActivity(intent1); break;
            case R.id.new2:
                Intent intent2=new Intent(MainActivity.this,Item2.class); startActivity(intent2); break;
                case R.id.new3:
                    Intent intent3=new Intent(MainActivity.this,Item3.class); startActivity(intent3); break;
        case R.id.new4:
            Intent intent4=new Intent(MainActivity.this,Item4.class);
            startActivity(intent4); break;
            case R.id.share:
                Intent intent =new Intent(Intent.ACTION_SEND); intent.setType("text/plain");
                String s="You are here"; String sub="Your Subject Here";
                intent.putExtra(Intent.EXTRA_TEXT,s); intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                startActivity(Intent.createChooser(intent,"Share Using..."));break; }
        return super.onOptionsItemSelected(item); }}

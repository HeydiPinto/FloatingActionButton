package com.example.floatingactionbutton;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.floating.R;
import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;


public class TransformarFloating extends AppCompatActivity implements View.OnClickListener{

    private FABToolbarLayout morph; private FABToolbarLayout layout;
    private View one, two, three, four;
    private ListView list;
    private View fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformar_floating);
        layout = (FABToolbarLayout) findViewById(R.id.fabtoolbar);
        one = findViewById(R.id.uno);
        two = findViewById(R.id.dos);
        three = findViewById(R.id.tres);
        four = findViewById(R.id.cuatro);
        list = (ListView) findViewById(R.id.list);
        fab = findViewById(R.id.fabtoolbar);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        String[] data = new String[30];
        for(int i = 0; i < 30; i++) {
            data[i] = "Test " + i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                layout.show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        layout.hide();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Element clicked", Toast.LENGTH_SHORT).show();
    }
}

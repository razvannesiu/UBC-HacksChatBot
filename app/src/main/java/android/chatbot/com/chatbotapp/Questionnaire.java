package android.chatbot.com.chatbotapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Questionnaire extends AppCompatActivity {

    private Button btnStart;
    private Button btnRef;
    DatabaseReference databaseReference;
    private ListView lvQuest;
    ArrayAdapter<Submission> mAdapter;
    List<Submission> subs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        subs = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://plumber-hub.firebaseio.com/submissions");
        lvQuest = (ListView) findViewById(R.id.lvQuest);
        btnStart = (Button) findViewById(R.id.btnAddSub);
        btnRef = (Button) findViewById(R.id.btnRefresh);

        btnRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subs.add(DialogNewQuest.newSub);
                mAdapter.notifyDataSetChanged();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(Questionnaire.this, DialogNewQuest.class);
                    startActivity(intent);
            }
        });

        mAdapter = new ArrayAdapter<Submission>(
                this,
                android.R.layout.simple_list_item_1,
                subs
        ){
            @NonNull
            @Override
            public View getView(int position, @Nullable View v1, @NonNull ViewGroup v) {
                TextView txtName = (TextView) v.findViewById(R.id.txtName);
                TextView txtMood = (TextView) v.findViewById(R.id.txtMood);
                TextView txtColor = (TextView) v.findViewById(R.id.txtColor);
                TextView txtScore = (TextView) v.findViewById(R.id.txtScore);

                Submission mod = DialogNewQuest.newSub;
                txtName.setText(mod.getName());
                txtMood.setText(mod.getMood());
                txtColor.setText(mod.getColor());
                txtColor.setTextColor(Color.parseColor(mod.getColor()));
                txtScore.setText("Score: " + mod.getScore());
                v.setBackgroundColor(position % 2 != 0? Color.LTGRAY : Color.WHITE);
                return v;
            }
        };
//        ) {
//            @Override
//            protected void populateView(View v, Submission model, int position) {
//                TextView txtName = (TextView) v.findViewById(R.id.txtName);
//                TextView txtMood = (TextView) v.findViewById(R.id.txtMood);
//                TextView txtColor = (TextView) v.findViewById(R.id.txtColor);
//                TextView txtScore = (TextView) v.findViewById(R.id.txtScore);
//
//                Submission mod = DialogNewQuest.newSub;
//                txtName.setText(mod.getName());
//                txtMood.setText(mod.getMood());
//                txtColor.setText(mod.getColor());
//                txtColor.setTextColor(Color.parseColor(mod.getColor()));
//                txtScore.setText("Score: " + mod.getScore());
//                v.setBackgroundColor(position % 2 != 0? Color.LTGRAY : Color.WHITE);
//            }
//        };

        lvQuest.setAdapter(mAdapter);

    }
}

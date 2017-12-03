package android.chatbot.com.chatbotapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogNewQuest extends AppCompatActivity {

    private Button btnSave;
    DatabaseReference databaseReference;
    private EditText edtNewName;
    private RadioGroup rgMood;
    private RadioGroup rgColor;
    public static Submission newSub;

    private void pushNewSubmission(){
        String name = edtNewName.getText().toString();
        String color = ((RadioButton) findViewById(rgColor.getCheckedRadioButtonId())).getText().toString();
        String mood = ((RadioButton) findViewById(rgMood.getCheckedRadioButtonId())).getText().toString();
        int score = 10;
        if(color == "Blue"){
         score-=1;
        }else if(color == "Orange"){
            score-=0;
        }else if(color == "Black"){
            score-=3;
        }else if(color == "Grey"){
            score-=2;
        }

        if(mood == "Pessimistic"){
            score-=2;
        }else if(mood == "Optimistic"){
            score-=0;
        }
        else if (mood == "Moody"){
            score-=1;
        }

        Submission submission = new Submission(name, color, mood, score);
        newSub = submission;

        databaseReference.push().setValue(submission);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_new_quest);

        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://plumber-hub.firebaseio.com/submissions");
        rgColor = (RadioGroup) findViewById(R.id.radioColor);
        rgMood = (RadioGroup) findViewById(R.id.radioMood);
        btnSave = (Button) findViewById(R.id.btnSave);
        edtNewName = (EditText) findViewById(R.id.edtNewName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushNewSubmission();
            }
        });
    }
}

package android.chatbot.com.chatbotapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnWayfinding;
    Button btnChatbot;
    Button btnQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChatbot = (Button) findViewById(R.id.btnChatbot);
        btnWayfinding = (Button) findViewById(R.id.btnWayfinding);
        btnQuest = (Button) findViewById(R.id.btnQuest);

        btnQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Questionnaire.class);
                startActivity(intent);
            }
        });

        btnChatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Chatbot.class);
                startActivity(intent);
            }
        });

        btnWayfinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}

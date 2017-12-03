package android.chatbot.com.chatbotapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Chatbot extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("https://kass-oui.github.io/MentalHealthChatBox/");
    }
}

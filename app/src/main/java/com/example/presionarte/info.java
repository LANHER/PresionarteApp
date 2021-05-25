package com.example.presionarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class info extends AppCompatActivity {

    TextView textView26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

         textView26 = (TextView)findViewById(R.id.textView26);
        SpannableString content = new SpannableString(textView26.getText());
        content.setSpan(new UnderlineSpan(), 0, textView26.length(), 0);
        textView26.setText(content);
        textView26.setOnClickListener(new View.OnClickListener() {
            @Override

            //DESCARGA DE PDF
        public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.heart.org/-/media/files/health-topics/answers-by-heart/answers-by-heart-spanish/what-is-highbloodpressure_span.pdf"));
                startActivity(i);
            }
        });

    }
}
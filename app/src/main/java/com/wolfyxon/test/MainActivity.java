package com.wolfyxon.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public interface TextCallback {
        public void onAccept(String text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnExit = findViewById(R.id.btnExit);
        Button btnEdit = findViewById(R.id.btnEdit);
        TextView text = findViewById(R.id.text);

        btnExit.setOnClickListener(view -> finishAffinity());

        btnEdit.setOnClickListener(view -> {
            queryText(text::setText);
        });
    }

    void queryText(TextCallback callback) {
        EditText input = new EditText(this);

        new AlertDialog.Builder(this)
                .setView(input)
                .setPositiveButton("Apply", (dialog, whichButton) -> {
                        callback.onAccept(input.getText().toString());
                    }
                )
                .show()
        ;

    }
}
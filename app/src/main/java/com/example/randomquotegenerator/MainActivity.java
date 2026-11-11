
package com.example.randomquotegenerator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView quoteText, authorText;
    Button newQuoteBtn;

    String[] quotes = {
            "Believe you can and you're halfway there.",
            "Great things take time.",
            "Dream big and dare to fail.",
            "Success is the sum of small efforts.",
            "Never stop learning.",
            "Your future depends on what you do today.",
            "Stay positive and keep moving forward.",
            "The secret of getting ahead is getting started.",
            "Every expert was once a beginner.",
            "Work hard and make your dreams happen."
    };

    String[] authors = {
            "Theodore Roosevelt",
            "Unknown",
            "Norman Vaughan",
            "Robert Collier",
            "Unknown",
            "Mahatma Gandhi",
            "Unknown",
            "Mark Twain",
            "Unknown",
            "Unknown"
    };

    Random random = new Random();
    int lastIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteText = findViewById(R.id.quoteText);
        authorText = findViewById(R.id.authorText);
        newQuoteBtn = findViewById(R.id.newQuoteBtn);

        // Display a random quote when app opens
        showRandomQuote();

        // Display another quote when button is clicked
        newQuoteBtn.setOnClickListener(v -> {
            showRandomQuote();
        });
    }

    private void showRandomQuote() {

        int newIndex;

        do {
            newIndex = random.nextInt(quotes.length);
        } while (quotes.length > 1 && newIndex == lastIndex);

        lastIndex = newIndex;

        quoteText.setText(quotes[newIndex]);
        authorText.setText("— " + authors[newIndex]);
    }
}

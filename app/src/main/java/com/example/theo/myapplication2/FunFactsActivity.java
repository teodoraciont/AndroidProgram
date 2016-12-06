package com.example.theo.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    // Declare our View variables
    private TextView mFactTextView;
    private Button mShowFactButton,mDeleteFactButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mDeleteFactButton = (Button) findViewById(R.id.deleteFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
//      for view
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();
                mFactTextView.setText(fact);
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }
        };
//      for delete
        View.OnClickListener listener_delete = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                String[] delete =mFactBook.removeElements(fact);
                String  allFactsString = mFactBook.showAllFactsLikeOneString();
                int color = mColorWheel.getColor();
                mFactTextView.setText(allFactsString);
                mRelativeLayout.setBackgroundColor(color);
                mDeleteFactButton.setTextColor(color);
            }
        };

        mShowFactButton.setOnClickListener(listener);
        mDeleteFactButton.setOnClickListener(listener_delete);
    }
}

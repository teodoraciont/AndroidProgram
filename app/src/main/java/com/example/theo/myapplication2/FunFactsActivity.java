package com.example.theo.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private TextView mFactTextView;
    private Button mNextFactButton,mDeleteFactButton,mPrevFactButton;
    private RelativeLayout mRelativeLayout;
    int numberIndex = 0;
    String fact = mFactBook.getFactByIndex(numberIndex);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mFactTextView.setText(fact);
        mNextFactButton = (Button) findViewById(R.id.showFactButton);
        mPrevFactButton = (Button) findViewById(R.id.prevFactButton);
        mDeleteFactButton = (Button) findViewById(R.id.deleteFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
//      for next
        View.OnClickListener next_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIndex++;
                fact = mFactBook.getFactByIndex(numberIndex);
                if (fact!=null){
                    int color = mColorWheel.getColor();
                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
//                    mNextFactButton.setTextColor(color);
                } else {
                    numberIndex=0;
                    fact = mFactBook.getFactByIndex(numberIndex);
                    int color = mColorWheel.getColor();
                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
//                    mNextFactButton.setTextColor(color);

                }
            }
        };
//      for prev
        View.OnClickListener prev_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIndex--;
                fact = mFactBook.getFactByIndex(numberIndex);
                if (fact!=null){
                    int color = mColorWheel.getColor();
                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
//                    mNextFactButton.setTextColor(color);
                } else {
                    numberIndex=mFactBook.getFacts().length-1;
                    fact = mFactBook.getFactByIndex(numberIndex);
                    int color = mColorWheel.getColor();
                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
//                    mNextFactButton.setTextColor(color);
                }
            }
        };
//      for delete
        View.OnClickListener listener_delete = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFactBook.removeElements(fact);
                fact = mFactBook.getFactByIndex(numberIndex);
                if (fact!=null) {
                    mFactTextView.setText(fact);
                } else {
                    fact=mFactBook.getFactByIndex(0);
                    mFactTextView.setText(fact);
                }
                int color = mColorWheel.getColor();
                mRelativeLayout.setBackgroundColor(color);
                mDeleteFactButton.setTextColor(color);
            }
        };

        mNextFactButton.setOnClickListener(next_listener);
        mPrevFactButton.setOnClickListener(prev_listener);
        mDeleteFactButton.setOnClickListener(listener_delete);
    }
}

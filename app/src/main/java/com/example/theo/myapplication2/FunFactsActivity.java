package com.example.theo.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class FunFactsActivity extends AppCompatActivity {
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private TextView mFactTextView;
    private EditText newFact;
    private Button mNextFactButton,mDeleteFactButton,mPrevFactButton,mAddFactButton,mEditFactButton,mSaveNewFact;
    private RelativeLayout mRelativeLayout;
    private ToggleButton mShowOption;

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
        mSaveNewFact = (Button) findViewById(R.id.mSaveNewFact);
        mDeleteFactButton = (Button) findViewById(R.id.deleteFactButton);
        mAddFactButton = (Button) findViewById(R.id.addFactButton);
        mEditFactButton = (Button) findViewById(R.id.editFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        mShowOption = (ToggleButton) findViewById(R.id.showOption);
        newFact = (EditText) findViewById(R.id.newFact);
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

        //      for add
        View.OnClickListener listener_add = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFactTextView.setVisibility(View.INVISIBLE);
                mNextFactButton.setVisibility(View.INVISIBLE);
                mPrevFactButton.setVisibility(View.INVISIBLE);
                mDeleteFactButton.setVisibility(View.INVISIBLE);
                mEditFactButton.setVisibility(View.INVISIBLE);
                mEditFactButton.setVisibility(View.INVISIBLE);
                mAddFactButton.setVisibility(View.INVISIBLE);
                mShowOption.setVisibility(View.INVISIBLE);
                newFact.setVisibility(View.VISIBLE);
                mSaveNewFact.setVisibility(View.VISIBLE);
            }
        };
        //      for add a new fACT
        View.OnClickListener listener_add_fact = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFactText= newFact.getText().toString();
                mFactBook.addElement(newFactText);
//                to do - delete are un bug
                numberIndex++;
                fact = mFactBook.getFactByIndex(numberIndex);
                mFactTextView.setText( newFactText);
                mFactTextView.setVisibility(View.VISIBLE);
                mNextFactButton.setVisibility(View.VISIBLE);
                mPrevFactButton.setVisibility(View.VISIBLE);
                mDeleteFactButton.setVisibility(View.VISIBLE);
                mEditFactButton.setVisibility(View.VISIBLE);
                mEditFactButton.setVisibility(View.VISIBLE);
                mAddFactButton.setVisibility(View.VISIBLE);
                mShowOption.setVisibility(View.VISIBLE);
                newFact.setVisibility(View.INVISIBLE);
                mSaveNewFact.setVisibility(View.INVISIBLE);

            }
        };

        mNextFactButton.setOnClickListener(next_listener);
        mPrevFactButton.setOnClickListener(prev_listener);
        mDeleteFactButton.setOnClickListener(listener_delete);
        mAddFactButton.setOnClickListener(listener_add);
        mSaveNewFact.setOnClickListener(listener_add_fact);
    }
}

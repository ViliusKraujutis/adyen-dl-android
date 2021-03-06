package com.adyen.dl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.adyen.adyendl.PaymentsProcessor;

/**
 * Created by andrei on 9/16/16.
 */
public class PaymentResultActivity extends Activity {

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_result);

        Intent intent = getIntent();
        Uri callbackUri = intent.getData();

        mResultTextView = (TextView) findViewById(R.id.result);

        String response = PaymentsProcessor.getInstance().verifyResultUrl(callbackUri.toString());

        mResultTextView.setText(response);

    }
}

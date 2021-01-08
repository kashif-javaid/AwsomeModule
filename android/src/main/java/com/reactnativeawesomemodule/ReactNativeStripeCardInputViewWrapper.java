package com.reactnativeawesomemodule;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import com.stripe.android.view.CardMultilineWidget;

public class ReactNativeStripeCardInputViewWrapper extends LinearLayout {

  private CardMultilineWidget paymentView;
  private  View cardMultilineView;
  private ThemedReactContext _context;
  public ReactNativeStripeCardInputViewWrapper(ThemedReactContext context) {
    super(context);
    _context = context;

    cardMultilineView = View.inflate(context, R.layout.react_native_stripe_card_input, this);
    paymentView = cardMultilineView.findViewById(R.id.card_multiline_widget);
    paymentView.setShouldShowPostalCode(false);

  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();

    Log.d("PaymentView ID", String.valueOf(paymentView.getId()));
    Log.d("View ID", String.valueOf(cardMultilineView.getId()));

    paymentView.setCardValidCallback(new CardValidCallBack(paymentView, _context));
  }
}

package com.reactnativeawesomemodule;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.stripe.android.view.CardMultilineWidget;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class CardValidCallBack implements com.stripe.android.view.CardValidCallback {

  private final CardMultilineWidget paymentView;
  private final ThemedReactContext _context;

  public CardValidCallBack(final CardMultilineWidget paymentView, ThemedReactContext context) {
    this.paymentView = paymentView;
    this._context = context;
  }

  @Override
  public void onInputChanged(boolean isValid, @NotNull Set<? extends Fields> set) {
    final WritableMap event = Arguments.createMap();

    _context.getNativeModule(UIManagerModule.class).getEventDispatcher()
      .dispatchEvent(new Event(paymentView.getId()) {
        @Override
        public String getEventName() {
          return "onInputChanged";
        }

        @Override
        public void dispatch(RCTEventEmitter rctEventEmitter) {
          rctEventEmitter.receiveEvent(getViewTag(), getEventName(), event);
        }
      });

    if(isValid){
      hideSoftKeyboard(paymentView);
    }
  }

  protected void hideSoftKeyboard( CardMultilineWidget input) {
    InputMethodManager inputMethodManager = (InputMethodManager) _context.getSystemService(Context.INPUT_METHOD_SERVICE);
    View focusedView = _context.getCurrentActivity().getCurrentFocus();
    if (focusedView != null) {
      inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
        InputMethodManager.HIDE_NOT_ALWAYS);
    }
  }
}

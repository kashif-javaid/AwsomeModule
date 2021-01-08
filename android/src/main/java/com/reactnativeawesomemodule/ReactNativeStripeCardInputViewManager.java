package com.reactnativeawesomemodule;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.stripe.android.view.CardInputListener;
import com.stripe.android.view.CardMultilineWidget;
import com.stripe.android.view.CardValidCallback;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;


class ReactNativeStripeCardInputViewManager extends ViewGroupManager<LinearLayout> {
  public static final String REACT_CLASS = "ReactNativeStripeCardInput";

  @NonNull
  @Override
  public String getName() {
    return REACT_CLASS;
  }

//  @Override
//  @Nullable
//  public Map getExportedCustomDirectEventTypeConstants() {
//    return MapBuilder.of(
//      "onInputChanged",
//      MapBuilder.of("registrationName", "onInputChanged")
//    );
//  }

  public Map getExportedCustomBubblingEventTypeConstants() {
    return MapBuilder.builder()
      .put(
        "topTouch",
        MapBuilder.of(
          "phasedRegistrationNames",
          MapBuilder.of("bubbled", "onTouch")))
      .build();
  }


  @Override
  protected void addEventEmitters(@NonNull ThemedReactContext reactContext, @NonNull LinearLayout view) {
    super.addEventEmitters(reactContext, view);

    ((CardMultilineWidget)view.findViewById(R.id.card_multiline_widget)).setCardValidCallback(new CardValidCallback() {
      @Override
      public void onInputChanged(boolean b, @NotNull Set<? extends Fields> set) {
        final WritableMap eventData = Arguments.createMap();
        reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
          .dispatchEvent(new Event(view.getId()) {
            @Override
            public String getEventName() {
              return "topTouch";
            }

            @Override
            public void dispatch(RCTEventEmitter rctEventEmitter) {
              rctEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
            }
          });
      }
    });
  }

  @NonNull
  @Override
  protected LinearLayout createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new ReactNativeStripeCardInputViewWrapper(reactContext);
  }
}


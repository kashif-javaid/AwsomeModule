package com.reactnativeawesomemodule;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

//public class ReactNativeStripeCardInputViewManager extends SimpleViewManager {
//  @NotNull
//  @Override
//  public String getName() {
//    return "ReactNativeStripeCardInput";
//  }
//
//  @NotNull
//  @Override
//  protected TextView createViewInstance(@NotNull ThemedReactContext reactContext) {
//    return new TextView(reactContext);
//  }
//
//  @ReactProp(name = "text")
//  public void setText(TextView view, @Nullable String text) {
//    view.setText(text);
//  }
//
//  @Override
//  protected void addEventEmitters(@NonNull ThemedReactContext reactContext, @NonNull View view) {
//    super.addEventEmitters(reactContext, view);
//
//    view.setOnTouchListener(new View.OnTouchListener() {
//      @Override
//      public boolean onTouch(View v, MotionEvent event) {
//        final WritableMap eventData = Arguments.createMap();
//        eventData.putDouble("y", event.getY());
//        eventData.putDouble("x", event.getX());
//
//        reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
//          .dispatchEvent(new Event(view.getId()) {
//            @Override
//            public String getEventName() {
//              return "topTouch";
//            }
//
//            @Override
//            public void dispatch(RCTEventEmitter rctEventEmitter) {
//              rctEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
//            }
//          });
//        return true;
//      }
//    });
//  }
//
//  public Map getExportedCustomBubblingEventTypeConstants() {
//    return MapBuilder.builder()
//      .put(
//        "topTouch",
//        MapBuilder.of(
//          "phasedRegistrationNames",
//          MapBuilder.of("bubbled", "onTouch")))
//      .build();
//  }
//
//}



class ReactNativeStripeCardInputViewManager extends ViewGroupManager<ReactNativeStripeCardInputViewWrapper> {
  public static final String REACT_CLASS = "ReactNativeStripeCardInput";

  @NonNull
  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  @Nullable
  public Map getExportedCustomDirectEventTypeConstants() {
    return MapBuilder.of(
      "onInputChange",
      MapBuilder.of("registrationName", "onInputChange")
    );
  }
  
  @NonNull
  @Override
  protected ReactNativeStripeCardInputViewWrapper createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new ReactNativeStripeCardInputViewWrapper(reactContext);
  }
}


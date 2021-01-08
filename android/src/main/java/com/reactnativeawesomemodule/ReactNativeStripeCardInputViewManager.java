package com.reactnativeawesomemodule;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
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


class ReactNativeStripeCardInputViewManager extends ViewGroupManager<LinearLayout> {
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
  protected LinearLayout createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new ReactNativeStripeCardInputViewWrapper(reactContext);
  }
}


package com.reactnativeawesomemodule;

import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

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
      "onInputChanged",
      MapBuilder.of("registrationName", "onInputChanged")
    );
  }

  @NonNull
  @Override
  protected LinearLayout createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new ReactNativeStripeCardInputViewWrapper(reactContext);
  }
}


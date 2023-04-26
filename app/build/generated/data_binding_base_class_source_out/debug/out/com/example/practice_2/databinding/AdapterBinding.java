// Generated by view binder compiler. Do not edit!
package com.example.practice_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.practice_2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdapterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  private AdapterBinding(@NonNull ConstraintLayout rootView, @NonNull TextView textView,
      @NonNull TextView textView2) {
    this.rootView = rootView;
    this.textView = textView;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new AdapterBinding((ConstraintLayout) rootView, textView, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

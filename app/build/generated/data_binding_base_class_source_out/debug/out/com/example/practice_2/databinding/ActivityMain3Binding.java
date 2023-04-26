// Generated by view binder compiler. Do not edit!
package com.example.practice_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.practice_2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMain3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button deleteButton;

  @NonNull
  public final EditText record;

  @NonNull
  public final Button saveButton;

  private ActivityMain3Binding(@NonNull ConstraintLayout rootView, @NonNull Button deleteButton,
      @NonNull EditText record, @NonNull Button saveButton) {
    this.rootView = rootView;
    this.deleteButton = deleteButton;
    this.record = record;
    this.saveButton = saveButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMain3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMain3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMain3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.deleteButton;
      Button deleteButton = ViewBindings.findChildViewById(rootView, id);
      if (deleteButton == null) {
        break missingId;
      }

      id = R.id.record;
      EditText record = ViewBindings.findChildViewById(rootView, id);
      if (record == null) {
        break missingId;
      }

      id = R.id.saveButton;
      Button saveButton = ViewBindings.findChildViewById(rootView, id);
      if (saveButton == null) {
        break missingId;
      }

      return new ActivityMain3Binding((ConstraintLayout) rootView, deleteButton, record,
          saveButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

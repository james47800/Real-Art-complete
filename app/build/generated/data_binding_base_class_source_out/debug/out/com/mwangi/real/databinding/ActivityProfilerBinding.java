// Generated by view binder compiler. Do not edit!
package com.mwangi.real.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.mwangi.real.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfilerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView ProfileemailDisplay;

  @NonNull
  public final CircleImageView imageViewProfile;

  @NonNull
  public final TextInputEditText profileBio;

  @NonNull
  public final Button selectImageProfile;

  @NonNull
  public final Button updateProfileBtn;

  private ActivityProfilerBinding(@NonNull LinearLayout rootView,
      @NonNull TextView ProfileemailDisplay, @NonNull CircleImageView imageViewProfile,
      @NonNull TextInputEditText profileBio, @NonNull Button selectImageProfile,
      @NonNull Button updateProfileBtn) {
    this.rootView = rootView;
    this.ProfileemailDisplay = ProfileemailDisplay;
    this.imageViewProfile = imageViewProfile;
    this.profileBio = profileBio;
    this.selectImageProfile = selectImageProfile;
    this.updateProfileBtn = updateProfileBtn;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfilerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfilerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profiler, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfilerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ProfileemailDisplay;
      TextView ProfileemailDisplay = ViewBindings.findChildViewById(rootView, id);
      if (ProfileemailDisplay == null) {
        break missingId;
      }

      id = R.id.imageViewProfile;
      CircleImageView imageViewProfile = ViewBindings.findChildViewById(rootView, id);
      if (imageViewProfile == null) {
        break missingId;
      }

      id = R.id.profileBio;
      TextInputEditText profileBio = ViewBindings.findChildViewById(rootView, id);
      if (profileBio == null) {
        break missingId;
      }

      id = R.id.selectImageProfile;
      Button selectImageProfile = ViewBindings.findChildViewById(rootView, id);
      if (selectImageProfile == null) {
        break missingId;
      }

      id = R.id.updateProfileBtn;
      Button updateProfileBtn = ViewBindings.findChildViewById(rootView, id);
      if (updateProfileBtn == null) {
        break missingId;
      }

      return new ActivityProfilerBinding((LinearLayout) rootView, ProfileemailDisplay,
          imageViewProfile, profileBio, selectImageProfile, updateProfileBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

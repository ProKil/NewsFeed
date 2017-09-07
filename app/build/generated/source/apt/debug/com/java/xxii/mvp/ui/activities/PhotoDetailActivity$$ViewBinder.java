// Generated code from Butter Knife. Do not modify!
package com.java.xxii.mvp.ui.activities;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class PhotoDetailActivity$$ViewBinder<T extends PhotoDetailActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558511, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558511, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558528, "field 'mPhotoIv'");
    target.mPhotoIv = finder.castView(view, 2131558528, "field 'mPhotoIv'");
    view = finder.findRequiredView(source, 2131558527, "field 'mPullBackLayout'");
    target.mPullBackLayout = finder.castView(view, 2131558527, "field 'mPullBackLayout'");
    view = finder.findRequiredView(source, 2131558529, "field 'mPhotoTouchIv'");
    target.mPhotoTouchIv = finder.castView(view, 2131558529, "field 'mPhotoTouchIv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PhotoDetailActivity> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.mToolbar = null;
      target.mPhotoIv = null;
      target.mPullBackLayout = null;
      target.mPhotoTouchIv = null;
    }
  }
}

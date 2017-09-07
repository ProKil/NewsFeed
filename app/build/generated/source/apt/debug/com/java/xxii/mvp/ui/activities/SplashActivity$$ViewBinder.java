// Generated code from Butter Knife. Do not modify!
package com.java.xxii.mvp.ui.activities;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SplashActivity$$ViewBinder<T extends SplashActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558530, "field 'mLogoOuterIv'");
    target.mLogoOuterIv = finder.castView(view, 2131558530, "field 'mLogoOuterIv'");
    view = finder.findRequiredView(source, 2131558531, "field 'mLogoInnerIv'");
    target.mLogoInnerIv = finder.castView(view, 2131558531, "field 'mLogoInnerIv'");
    view = finder.findRequiredView(source, 2131558532, "field 'mAppNameTv'");
    target.mAppNameTv = finder.castView(view, 2131558532, "field 'mAppNameTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends SplashActivity> implements Unbinder {
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
      target.mLogoOuterIv = null;
      target.mLogoInnerIv = null;
      target.mAppNameTv = null;
    }
  }
}

// Generated code from Butter Knife. Do not modify!
package com.java.xxii.mvp.ui.activities;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class NewsDetailActivity$$ViewBinder<T extends NewsDetailActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558521, "field 'mNewsDetailPhotoIv'");
    target.mNewsDetailPhotoIv = finder.castView(view, 2131558521, "field 'mNewsDetailPhotoIv'");
    view = finder.findRequiredView(source, 2131558511, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558511, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558520, "field 'mToolbarLayout'");
    target.mToolbarLayout = finder.castView(view, 2131558520, "field 'mToolbarLayout'");
    view = finder.findRequiredView(source, 2131558519, "field 'mAppBar'");
    target.mAppBar = finder.castView(view, 2131558519, "field 'mAppBar'");
    view = finder.findRequiredView(source, 2131558536, "field 'mNewsDetailFromTv'");
    target.mNewsDetailFromTv = finder.castView(view, 2131558536, "field 'mNewsDetailFromTv'");
    view = finder.findRequiredView(source, 2131558537, "field 'mNewsDetailBodyTv'");
    target.mNewsDetailBodyTv = finder.castView(view, 2131558537, "field 'mNewsDetailBodyTv'");
    view = finder.findRequiredView(source, 2131558523, "field 'mFab' and method 'onClick'");
    target.mFab = finder.castView(view, 2131558523, "field 'mFab'");
    unbinder.view2131558523 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    view = finder.findRequiredView(source, 2131558515, "field 'mProgressBar'");
    target.mProgressBar = finder.castView(view, 2131558515, "field 'mProgressBar'");
    view = finder.findRequiredView(source, 2131558522, "field 'mMaskView'");
    target.mMaskView = view;
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends NewsDetailActivity> implements Unbinder {
    private T target;

    View view2131558523;

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
      target.mNewsDetailPhotoIv = null;
      target.mToolbar = null;
      target.mToolbarLayout = null;
      target.mAppBar = null;
      target.mNewsDetailFromTv = null;
      target.mNewsDetailBodyTv = null;
      view2131558523.setOnClickListener(null);
      target.mFab = null;
      target.mProgressBar = null;
      target.mMaskView = null;
    }
  }
}

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

public class PhotoActivity$$ViewBinder<T extends PhotoActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558511, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558511, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558539, "field 'mPhotoRv'");
    target.mPhotoRv = finder.castView(view, 2131558539, "field 'mPhotoRv'");
    view = finder.findRequiredView(source, 2131558514, "field 'mNavView'");
    target.mNavView = finder.castView(view, 2131558514, "field 'mNavView'");
    view = finder.findRequiredView(source, 2131558513, "field 'mDrawerLayout'");
    target.mDrawerLayout = finder.castView(view, 2131558513, "field 'mDrawerLayout'");
    view = finder.findRequiredView(source, 2131558515, "field 'mProgressBar'");
    target.mProgressBar = finder.castView(view, 2131558515, "field 'mProgressBar'");
    view = finder.findRequiredView(source, 2131558538, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131558538, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131558540, "field 'mEmptyView' and method 'onClick'");
    target.mEmptyView = finder.castView(view, 2131558540, "field 'mEmptyView'");
    unbinder.view2131558540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558523, "field 'mFab' and method 'onClick'");
    target.mFab = finder.castView(view, 2131558523, "field 'mFab'");
    unbinder.view2131558523 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PhotoActivity> implements Unbinder {
    private T target;

    View view2131558540;

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
      target.mToolbar = null;
      target.mPhotoRv = null;
      target.mNavView = null;
      target.mDrawerLayout = null;
      target.mProgressBar = null;
      target.mSwipeRefreshLayout = null;
      view2131558540.setOnClickListener(null);
      target.mEmptyView = null;
      view2131558523.setOnClickListener(null);
      target.mFab = null;
    }
  }
}

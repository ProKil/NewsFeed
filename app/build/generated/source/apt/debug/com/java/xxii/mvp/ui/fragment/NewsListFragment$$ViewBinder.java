// Generated code from Butter Knife. Do not modify!
package com.java.xxii.mvp.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class NewsListFragment$$ViewBinder<T extends NewsListFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558550, "field 'mNewsRV'");
    target.mNewsRV = finder.castView(view, 2131558550, "field 'mNewsRV'");
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
        target.onClick();
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends NewsListFragment> implements Unbinder {
    private T target;

    View view2131558540;

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
      target.mNewsRV = null;
      target.mProgressBar = null;
      target.mSwipeRefreshLayout = null;
      view2131558540.setOnClickListener(null);
      target.mEmptyView = null;
    }
  }
}

// Generated code from Butter Knife. Do not modify!
package com.java.xxii.mvp.ui.activities;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class NewsChannelActivity$$ViewBinder<T extends NewsChannelActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558511, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558511, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558517, "field 'mNewsChannelMineRv'");
    target.mNewsChannelMineRv = finder.castView(view, 2131558517, "field 'mNewsChannelMineRv'");
    view = finder.findRequiredView(source, 2131558518, "field 'mNewsChannelMoreRv'");
    target.mNewsChannelMoreRv = finder.castView(view, 2131558518, "field 'mNewsChannelMoreRv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends NewsChannelActivity> implements Unbinder {
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
      target.mNewsChannelMineRv = null;
      target.mNewsChannelMoreRv = null;
    }
  }
}

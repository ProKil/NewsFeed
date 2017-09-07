// Generated code from Butter Knife. Do not modify!
package com.java.xxii.mvp.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class PhotoDetailFragment$$ViewBinder<T extends PhotoDetailFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558551, "field 'mPhotoView'");
    target.mPhotoView = finder.castView(view, 2131558551, "field 'mPhotoView'");
    view = finder.findRequiredView(source, 2131558515, "field 'mProgressBar'");
    target.mProgressBar = finder.castView(view, 2131558515, "field 'mProgressBar'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PhotoDetailFragment> implements Unbinder {
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
      target.mPhotoView = null;
      target.mProgressBar = null;
    }
  }
}

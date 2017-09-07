// Generated code from Butter Knife. Do not modify!
package com.java.xxii.mvp.ui.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class NewsListAdapter$PhotoViewHolder$$ViewBinder<T extends NewsListAdapter.PhotoViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558553, "field 'mNewsSummaryTitleTv'");
    target.mNewsSummaryTitleTv = finder.castView(view, 2131558553, "field 'mNewsSummaryTitleTv'");
    view = finder.findRequiredView(source, 2131558557, "field 'mNewsSummaryPhotoIvGroup'");
    target.mNewsSummaryPhotoIvGroup = finder.castView(view, 2131558557, "field 'mNewsSummaryPhotoIvGroup'");
    view = finder.findRequiredView(source, 2131558558, "field 'mNewsSummaryPhotoIvLeft'");
    target.mNewsSummaryPhotoIvLeft = finder.castView(view, 2131558558, "field 'mNewsSummaryPhotoIvLeft'");
    view = finder.findRequiredView(source, 2131558559, "field 'mNewsSummaryPhotoIvMiddle'");
    target.mNewsSummaryPhotoIvMiddle = finder.castView(view, 2131558559, "field 'mNewsSummaryPhotoIvMiddle'");
    view = finder.findRequiredView(source, 2131558560, "field 'mNewsSummaryPhotoIvRight'");
    target.mNewsSummaryPhotoIvRight = finder.castView(view, 2131558560, "field 'mNewsSummaryPhotoIvRight'");
    view = finder.findRequiredView(source, 2131558555, "field 'mNewsSummaryPtimeTv'");
    target.mNewsSummaryPtimeTv = finder.castView(view, 2131558555, "field 'mNewsSummaryPtimeTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends NewsListAdapter.PhotoViewHolder> implements Unbinder {
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
      target.mNewsSummaryTitleTv = null;
      target.mNewsSummaryPhotoIvGroup = null;
      target.mNewsSummaryPhotoIvLeft = null;
      target.mNewsSummaryPhotoIvMiddle = null;
      target.mNewsSummaryPhotoIvRight = null;
      target.mNewsSummaryPtimeTv = null;
    }
  }
}

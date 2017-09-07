package com.java.xxii.mvp.ui.activities;

import android.content.Context;
import com.java.xxii.mvp.presenter.impl.PhotoDetailPresenterImpl;
import dagger.MembersInjector;
import dagger.internal.DoubleCheckLazy;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhotoDetailActivity_MembersInjector
    implements MembersInjector<PhotoDetailActivity> {
  private final Provider<PhotoDetailPresenterImpl> mPhotoDetailPresenterProvider;

  private final Provider<Context> mContextProvider;

  public PhotoDetailActivity_MembersInjector(
      Provider<PhotoDetailPresenterImpl> mPhotoDetailPresenterProvider,
      Provider<Context> mContextProvider) {
    assert mPhotoDetailPresenterProvider != null;
    this.mPhotoDetailPresenterProvider = mPhotoDetailPresenterProvider;
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
  }

  public static MembersInjector<PhotoDetailActivity> create(
      Provider<PhotoDetailPresenterImpl> mPhotoDetailPresenterProvider,
      Provider<Context> mContextProvider) {
    return new PhotoDetailActivity_MembersInjector(mPhotoDetailPresenterProvider, mContextProvider);
  }

  @Override
  public void injectMembers(PhotoDetailActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPhotoDetailPresenter = DoubleCheckLazy.create(mPhotoDetailPresenterProvider);
    instance.mContext = mContextProvider.get();
  }

  public static void injectMPhotoDetailPresenter(
      PhotoDetailActivity instance,
      Provider<PhotoDetailPresenterImpl> mPhotoDetailPresenterProvider) {
    instance.mPhotoDetailPresenter = DoubleCheckLazy.create(mPhotoDetailPresenterProvider);
  }

  public static void injectMContext(
      PhotoDetailActivity instance, Provider<Context> mContextProvider) {
    instance.mContext = mContextProvider.get();
  }
}

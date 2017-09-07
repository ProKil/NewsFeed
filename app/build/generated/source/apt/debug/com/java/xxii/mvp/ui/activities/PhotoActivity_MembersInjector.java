package com.java.xxii.mvp.ui.activities;

import android.app.Activity;
import com.java.xxii.mvp.presenter.impl.PhotoPresenterImpl;
import com.java.xxii.mvp.ui.adapter.PhotoListAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhotoActivity_MembersInjector implements MembersInjector<PhotoActivity> {
  private final Provider<PhotoPresenterImpl> mPhotoPresenterProvider;

  private final Provider<PhotoListAdapter> mPhotoListAdapterProvider;

  private final Provider<Activity> mActivityProvider;

  public PhotoActivity_MembersInjector(
      Provider<PhotoPresenterImpl> mPhotoPresenterProvider,
      Provider<PhotoListAdapter> mPhotoListAdapterProvider,
      Provider<Activity> mActivityProvider) {
    assert mPhotoPresenterProvider != null;
    this.mPhotoPresenterProvider = mPhotoPresenterProvider;
    assert mPhotoListAdapterProvider != null;
    this.mPhotoListAdapterProvider = mPhotoListAdapterProvider;
    assert mActivityProvider != null;
    this.mActivityProvider = mActivityProvider;
  }

  public static MembersInjector<PhotoActivity> create(
      Provider<PhotoPresenterImpl> mPhotoPresenterProvider,
      Provider<PhotoListAdapter> mPhotoListAdapterProvider,
      Provider<Activity> mActivityProvider) {
    return new PhotoActivity_MembersInjector(
        mPhotoPresenterProvider, mPhotoListAdapterProvider, mActivityProvider);
  }

  @Override
  public void injectMembers(PhotoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPhotoPresenter = mPhotoPresenterProvider.get();
    instance.mPhotoListAdapter = mPhotoListAdapterProvider.get();
    instance.mActivity = mActivityProvider.get();
  }

  public static void injectMPhotoPresenter(
      PhotoActivity instance, Provider<PhotoPresenterImpl> mPhotoPresenterProvider) {
    instance.mPhotoPresenter = mPhotoPresenterProvider.get();
  }

  public static void injectMPhotoListAdapter(
      PhotoActivity instance, Provider<PhotoListAdapter> mPhotoListAdapterProvider) {
    instance.mPhotoListAdapter = mPhotoListAdapterProvider.get();
  }

  public static void injectMActivity(PhotoActivity instance, Provider<Activity> mActivityProvider) {
    instance.mActivity = mActivityProvider.get();
  }
}

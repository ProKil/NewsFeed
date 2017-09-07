package com.java.xxii.mvp.presenter.impl;

import android.app.Activity;
import com.java.xxii.mvp.interactor.impl.PhotoDetailInteractorImpl;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhotoDetailPresenterImpl_Factory implements Factory<PhotoDetailPresenterImpl> {
  private final MembersInjector<PhotoDetailPresenterImpl> photoDetailPresenterImplMembersInjector;

  private final Provider<PhotoDetailInteractorImpl> photoDetailInteractorProvider;

  private final Provider<Activity> activityProvider;

  public PhotoDetailPresenterImpl_Factory(
      MembersInjector<PhotoDetailPresenterImpl> photoDetailPresenterImplMembersInjector,
      Provider<PhotoDetailInteractorImpl> photoDetailInteractorProvider,
      Provider<Activity> activityProvider) {
    assert photoDetailPresenterImplMembersInjector != null;
    this.photoDetailPresenterImplMembersInjector = photoDetailPresenterImplMembersInjector;
    assert photoDetailInteractorProvider != null;
    this.photoDetailInteractorProvider = photoDetailInteractorProvider;
    assert activityProvider != null;
    this.activityProvider = activityProvider;
  }

  @Override
  public PhotoDetailPresenterImpl get() {
    return MembersInjectors.injectMembers(
        photoDetailPresenterImplMembersInjector,
        new PhotoDetailPresenterImpl(photoDetailInteractorProvider.get(), activityProvider.get()));
  }

  public static Factory<PhotoDetailPresenterImpl> create(
      MembersInjector<PhotoDetailPresenterImpl> photoDetailPresenterImplMembersInjector,
      Provider<PhotoDetailInteractorImpl> photoDetailInteractorProvider,
      Provider<Activity> activityProvider) {
    return new PhotoDetailPresenterImpl_Factory(
        photoDetailPresenterImplMembersInjector, photoDetailInteractorProvider, activityProvider);
  }
}

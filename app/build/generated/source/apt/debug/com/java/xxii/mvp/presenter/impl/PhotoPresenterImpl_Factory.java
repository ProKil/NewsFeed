package com.java.xxii.mvp.presenter.impl;

import com.java.xxii.mvp.interactor.impl.PhotoInteractorImpl;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhotoPresenterImpl_Factory implements Factory<PhotoPresenterImpl> {
  private final MembersInjector<PhotoPresenterImpl> photoPresenterImplMembersInjector;

  private final Provider<PhotoInteractorImpl> photoInteractorProvider;

  public PhotoPresenterImpl_Factory(
      MembersInjector<PhotoPresenterImpl> photoPresenterImplMembersInjector,
      Provider<PhotoInteractorImpl> photoInteractorProvider) {
    assert photoPresenterImplMembersInjector != null;
    this.photoPresenterImplMembersInjector = photoPresenterImplMembersInjector;
    assert photoInteractorProvider != null;
    this.photoInteractorProvider = photoInteractorProvider;
  }

  @Override
  public PhotoPresenterImpl get() {
    return MembersInjectors.injectMembers(
        photoPresenterImplMembersInjector, new PhotoPresenterImpl(photoInteractorProvider.get()));
  }

  public static Factory<PhotoPresenterImpl> create(
      MembersInjector<PhotoPresenterImpl> photoPresenterImplMembersInjector,
      Provider<PhotoInteractorImpl> photoInteractorProvider) {
    return new PhotoPresenterImpl_Factory(
        photoPresenterImplMembersInjector, photoInteractorProvider);
  }
}

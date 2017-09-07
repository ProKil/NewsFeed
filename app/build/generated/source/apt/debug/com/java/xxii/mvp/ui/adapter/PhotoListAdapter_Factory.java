package com.java.xxii.mvp.ui.adapter;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhotoListAdapter_Factory implements Factory<PhotoListAdapter> {
  private final MembersInjector<PhotoListAdapter> photoListAdapterMembersInjector;

  public PhotoListAdapter_Factory(
      MembersInjector<PhotoListAdapter> photoListAdapterMembersInjector) {
    assert photoListAdapterMembersInjector != null;
    this.photoListAdapterMembersInjector = photoListAdapterMembersInjector;
  }

  @Override
  public PhotoListAdapter get() {
    return MembersInjectors.injectMembers(photoListAdapterMembersInjector, new PhotoListAdapter());
  }

  public static Factory<PhotoListAdapter> create(
      MembersInjector<PhotoListAdapter> photoListAdapterMembersInjector) {
    return new PhotoListAdapter_Factory(photoListAdapterMembersInjector);
  }
}

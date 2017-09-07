package com.java.xxii.di.component;

import android.app.Activity;
import android.content.Context;
import com.java.xxii.di.module.ActivityModule;
import com.java.xxii.di.module.ActivityModule_ProvideActivityContextFactory;
import com.java.xxii.di.module.ActivityModule_ProvideActivityFactory;
import com.java.xxii.mvp.interactor.impl.NewsChannelInteractorImpl_Factory;
import com.java.xxii.mvp.interactor.impl.NewsDetailInteractorImpl_Factory;
import com.java.xxii.mvp.interactor.impl.NewsInteractorImpl_Factory;
import com.java.xxii.mvp.interactor.impl.PhotoDetailInteractorImpl_Factory;
import com.java.xxii.mvp.interactor.impl.PhotoInteractorImpl_Factory;
import com.java.xxii.mvp.presenter.impl.NewPresenterImpl;
import com.java.xxii.mvp.presenter.impl.NewPresenterImpl_Factory;
import com.java.xxii.mvp.presenter.impl.NewsChannelPresenterImpl;
import com.java.xxii.mvp.presenter.impl.NewsChannelPresenterImpl_Factory;
import com.java.xxii.mvp.presenter.impl.NewsDetailPresenterImpl;
import com.java.xxii.mvp.presenter.impl.NewsDetailPresenterImpl_Factory;
import com.java.xxii.mvp.presenter.impl.PhotoDetailPresenterImpl;
import com.java.xxii.mvp.presenter.impl.PhotoDetailPresenterImpl_Factory;
import com.java.xxii.mvp.presenter.impl.PhotoPresenterImpl;
import com.java.xxii.mvp.presenter.impl.PhotoPresenterImpl_Factory;
import com.java.xxii.mvp.ui.activities.NewsActivity;
import com.java.xxii.mvp.ui.activities.NewsActivity_MembersInjector;
import com.java.xxii.mvp.ui.activities.NewsChannelActivity;
import com.java.xxii.mvp.ui.activities.NewsChannelActivity_MembersInjector;
import com.java.xxii.mvp.ui.activities.NewsDetailActivity;
import com.java.xxii.mvp.ui.activities.NewsDetailActivity_MembersInjector;
import com.java.xxii.mvp.ui.activities.NewsPhotoDetailActivity;
import com.java.xxii.mvp.ui.activities.PhotoActivity;
import com.java.xxii.mvp.ui.activities.PhotoActivity_MembersInjector;
import com.java.xxii.mvp.ui.activities.PhotoDetailActivity;
import com.java.xxii.mvp.ui.activities.PhotoDetailActivity_MembersInjector;
import com.java.xxii.mvp.ui.adapter.PhotoListAdapter;
import com.java.xxii.mvp.ui.adapter.PhotoListAdapter_Factory;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Context> ProvideActivityContextProvider;

  private Provider<Context> getApplicationProvider;

  private Provider<Activity> ProvideActivityProvider;

  private Provider<NewPresenterImpl> newPresenterImplProvider;

  private MembersInjector<NewsActivity> newsActivityMembersInjector;

  private Provider<NewsDetailPresenterImpl> newsDetailPresenterImplProvider;

  private MembersInjector<NewsDetailActivity> newsDetailActivityMembersInjector;

  private Provider<NewsChannelPresenterImpl> newsChannelPresenterImplProvider;

  private MembersInjector<NewsChannelActivity> newsChannelActivityMembersInjector;

  private Provider<PhotoPresenterImpl> photoPresenterImplProvider;

  private Provider<PhotoListAdapter> photoListAdapterProvider;

  private MembersInjector<PhotoActivity> photoActivityMembersInjector;

  private Provider<PhotoDetailPresenterImpl> photoDetailPresenterImplProvider;

  private MembersInjector<PhotoDetailActivity> photoDetailActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.ProvideActivityContextProvider =
        ScopedProvider.create(
            ActivityModule_ProvideActivityContextFactory.create(builder.activityModule));

    this.getApplicationProvider =
        new Factory<Context>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public Context get() {
            return Preconditions.checkNotNull(
                applicationComponent.getApplication(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.ProvideActivityProvider =
        ScopedProvider.create(ActivityModule_ProvideActivityFactory.create(builder.activityModule));

    this.newPresenterImplProvider =
        NewPresenterImpl_Factory.create(
            MembersInjectors.<NewPresenterImpl>noOp(), NewsInteractorImpl_Factory.create());

    this.newsActivityMembersInjector =
        NewsActivity_MembersInjector.create(newPresenterImplProvider);

    this.newsDetailPresenterImplProvider =
        NewsDetailPresenterImpl_Factory.create(
            MembersInjectors.<NewsDetailPresenterImpl>noOp(),
            NewsDetailInteractorImpl_Factory.create());

    this.newsDetailActivityMembersInjector =
        NewsDetailActivity_MembersInjector.create(newsDetailPresenterImplProvider);

    this.newsChannelPresenterImplProvider =
        NewsChannelPresenterImpl_Factory.create(
            MembersInjectors.<NewsChannelPresenterImpl>noOp(),
            NewsChannelInteractorImpl_Factory.create());

    this.newsChannelActivityMembersInjector =
        NewsChannelActivity_MembersInjector.create(newsChannelPresenterImplProvider);

    this.photoPresenterImplProvider =
        PhotoPresenterImpl_Factory.create(
            MembersInjectors.<PhotoPresenterImpl>noOp(), PhotoInteractorImpl_Factory.create());

    this.photoListAdapterProvider =
        PhotoListAdapter_Factory.create(MembersInjectors.<PhotoListAdapter>noOp());

    this.photoActivityMembersInjector =
        PhotoActivity_MembersInjector.create(
            photoPresenterImplProvider, photoListAdapterProvider, ProvideActivityProvider);

    this.photoDetailPresenterImplProvider =
        PhotoDetailPresenterImpl_Factory.create(
            MembersInjectors.<PhotoDetailPresenterImpl>noOp(),
            PhotoDetailInteractorImpl_Factory.create(),
            ProvideActivityProvider);

    this.photoDetailActivityMembersInjector =
        PhotoDetailActivity_MembersInjector.create(
            photoDetailPresenterImplProvider, ProvideActivityContextProvider);
  }

  @Override
  public Context getActivityContext() {
    return ProvideActivityContextProvider.get();
  }

  @Override
  public Context getApplicationContext() {
    return getApplicationProvider.get();
  }

  @Override
  public Activity getActivity() {
    return ProvideActivityProvider.get();
  }

  @Override
  public void inject(NewsActivity newsActivity) {
    newsActivityMembersInjector.injectMembers(newsActivity);
  }

  @Override
  public void inject(NewsDetailActivity newsDetailActivity) {
    newsDetailActivityMembersInjector.injectMembers(newsDetailActivity);
  }

  @Override
  public void inject(NewsChannelActivity newsChannelActivity) {
    newsChannelActivityMembersInjector.injectMembers(newsChannelActivity);
  }

  @Override
  public void inject(NewsPhotoDetailActivity newsPhotoDetailActivity) {
    MembersInjectors.<NewsPhotoDetailActivity>noOp().injectMembers(newsPhotoDetailActivity);
  }

  @Override
  public void inject(PhotoActivity photoActivity) {
    photoActivityMembersInjector.injectMembers(photoActivity);
  }

  @Override
  public void inject(PhotoDetailActivity photoDetailActivity) {
    photoDetailActivityMembersInjector.injectMembers(photoDetailActivity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}

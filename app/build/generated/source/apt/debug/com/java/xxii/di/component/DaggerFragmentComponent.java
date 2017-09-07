package com.java.xxii.di.component;

import android.app.Activity;
import android.content.Context;
import com.java.xxii.di.module.FragmentModule;
import com.java.xxii.di.module.FragmentModule_ProvideActivityContextFactory;
import com.java.xxii.di.module.FragmentModule_ProvideActivityFactory;
import com.java.xxii.mvp.interactor.impl.NewsListInteractorImpl_Factory;
import com.java.xxii.mvp.presenter.impl.NewsListPresenterImpl;
import com.java.xxii.mvp.presenter.impl.NewsListPresenterImpl_Factory;
import com.java.xxii.mvp.ui.adapter.NewsListAdapter;
import com.java.xxii.mvp.ui.adapter.NewsListAdapter_Factory;
import com.java.xxii.mvp.ui.fragment.NewsListFragment;
import com.java.xxii.mvp.ui.fragment.NewsListFragment_MembersInjector;
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
public final class DaggerFragmentComponent implements FragmentComponent {
  private Provider<Context> provideActivityContextProvider;

  private Provider<Context> getApplicationProvider;

  private Provider<Activity> provideActivityProvider;

  private Provider<NewsListAdapter> newsListAdapterProvider;

  private Provider<NewsListPresenterImpl> newsListPresenterImplProvider;

  private MembersInjector<NewsListFragment> newsListFragmentMembersInjector;

  private DaggerFragmentComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideActivityContextProvider =
        ScopedProvider.create(
            FragmentModule_ProvideActivityContextFactory.create(builder.fragmentModule));

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

    this.provideActivityProvider =
        ScopedProvider.create(FragmentModule_ProvideActivityFactory.create(builder.fragmentModule));

    this.newsListAdapterProvider =
        NewsListAdapter_Factory.create(MembersInjectors.<NewsListAdapter>noOp());

    this.newsListPresenterImplProvider =
        NewsListPresenterImpl_Factory.create(
            MembersInjectors.<NewsListPresenterImpl>noOp(),
            NewsListInteractorImpl_Factory.create());

    this.newsListFragmentMembersInjector =
        NewsListFragment_MembersInjector.create(
            newsListAdapterProvider, newsListPresenterImplProvider, provideActivityProvider);
  }

  @Override
  public Context getActivityContext() {
    return provideActivityContextProvider.get();
  }

  @Override
  public Context getApplicationContext() {
    return getApplicationProvider.get();
  }

  @Override
  public Activity getActivity() {
    return provideActivityProvider.get();
  }

  @Override
  public void inject(NewsListFragment newsListFragment) {
    newsListFragmentMembersInjector.injectMembers(newsListFragment);
  }

  public static final class Builder {
    private FragmentModule fragmentModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public FragmentComponent build() {
      if (fragmentModule == null) {
        throw new IllegalStateException(FragmentModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerFragmentComponent(this);
    }

    public Builder fragmentModule(FragmentModule fragmentModule) {
      this.fragmentModule = Preconditions.checkNotNull(fragmentModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}

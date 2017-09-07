package com.java.xxii.di.component;

import android.content.Context;
import com.java.xxii.di.module.ServiceModule;
import com.java.xxii.di.module.ServiceModule_ProvideServiceContextFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServiceComponent implements ServiceComponent {
  private Provider<Context> ProvideServiceContextProvider;

  private Provider<Context> getApplicationProvider;

  private DaggerServiceComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.ProvideServiceContextProvider =
        ScopedProvider.create(
            ServiceModule_ProvideServiceContextFactory.create(builder.serviceModule));

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
  }

  @Override
  public Context getServiceContext() {
    return ProvideServiceContextProvider.get();
  }

  @Override
  public Context getApplicationContext() {
    return getApplicationProvider.get();
  }

  public static final class Builder {
    private ServiceModule serviceModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ServiceComponent build() {
      if (serviceModule == null) {
        throw new IllegalStateException(ServiceModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerServiceComponent(this);
    }

    public Builder serviceModule(ServiceModule serviceModule) {
      this.serviceModule = Preconditions.checkNotNull(serviceModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}

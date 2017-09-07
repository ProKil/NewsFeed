package com.java.xxii.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ServiceModule_ProvideServiceContextFactory implements Factory<Context> {
  private final ServiceModule module;

  public ServiceModule_ProvideServiceContextFactory(ServiceModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        module.ProvideServiceContext(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Context> create(ServiceModule module) {
    return new ServiceModule_ProvideServiceContextFactory(module);
  }
}

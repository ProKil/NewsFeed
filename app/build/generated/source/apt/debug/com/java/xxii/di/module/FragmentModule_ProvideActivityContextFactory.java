package com.java.xxii.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideActivityContextFactory implements Factory<Context> {
  private final FragmentModule module;

  public FragmentModule_ProvideActivityContextFactory(FragmentModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        module.provideActivityContext(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Context> create(FragmentModule module) {
    return new FragmentModule_ProvideActivityContextFactory(module);
  }
}

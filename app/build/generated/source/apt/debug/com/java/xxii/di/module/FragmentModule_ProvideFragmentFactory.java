package com.java.xxii.di.module;

import android.support.v4.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideFragmentFactory implements Factory<Fragment> {
  private final FragmentModule module;

  public FragmentModule_ProvideFragmentFactory(FragmentModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Fragment get() {
    return Preconditions.checkNotNull(
        module.provideFragment(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Fragment> create(FragmentModule module) {
    return new FragmentModule_ProvideFragmentFactory(module);
  }
}

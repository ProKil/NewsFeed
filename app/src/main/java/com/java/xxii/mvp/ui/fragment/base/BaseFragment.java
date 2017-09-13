/*

 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.java.xxii.mvp.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.java.xxii.App;
import com.java.xxii.di.component.DaggerFragmentComponent;
import com.java.xxii.di.component.FragmentComponent;
import com.java.xxii.di.module.FragmentModule;
import com.java.xxii.mvp.presenter.base.BasePresenter;
import com.java.xxii.utils.MyUtils;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import rx.Subscription;


public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    public FragmentComponent getFragmentComponent() {
        return mFragmentComponent;
    }

    protected FragmentComponent mFragmentComponent;
    protected T mPresenter;

    private View mFragmentView;

    public abstract void initInjector();

    public abstract void initViews(View view);

    public abstract int getLayoutId();

    protected Subscription mSubscription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
        initInjector();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mFragmentView);
            initViews(mFragmentView);
        }
        return mFragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }

        MyUtils.cancelSubscription(mSubscription);
    }
}

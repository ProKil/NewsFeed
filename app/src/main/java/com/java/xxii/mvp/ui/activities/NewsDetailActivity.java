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
package com.java.xxii.mvp.ui.activities;


import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.java.xxii.App;
import com.java.xxii.R;
import com.java.xxii.common.Constants;
import com.java.xxii.greendao.BanNews;
import com.java.xxii.greendao.BanNewsDao;
import com.java.xxii.greendao.LikeNews;
import com.java.xxii.greendao.LikeNewsDao;
import com.java.xxii.greendao.News;
import com.java.xxii.greendao.NewsDao;
import com.java.xxii.mvp.entity.NewsDetail;
import com.java.xxii.mvp.presenter.impl.NewsDetailPresenterImpl;
import com.java.xxii.mvp.ui.activities.base.BaseActivity;
import com.java.xxii.mvp.ui.fragment.BanKeywordFragment;
import com.java.xxii.mvp.view.NewsDetailView;
import com.java.xxii.utils.MyUtils;
import com.java.xxii.utils.NetUtil;
import com.java.xxii.utils.TransformUtils;
import com.java.xxii.widget.URLImageGetter;
import com.socks.library.KLog;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.dao.query.Query;
import rx.Observable;
import rx.Subscriber;


public class NewsDetailActivity extends BaseActivity implements NewsDetailView {
    @BindView(R.id.news_detail_photo_iv)
    ImageView mNewsDetailPhotoIv;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;
    /*    @BindView(R.id.news_detail_title_tv)
        TextView mNewsDetailTitleTv;*/
    @BindView(R.id.news_detail_from_tv)
    TextView mNewsDetailFromTv;
    @BindView(R.id.news_detail_body_tv)
    TextView mNewsDetailBodyTv;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.mask_view)
    View mMaskView;

    @Inject
    NewsDetailPresenterImpl mNewsDetailPresenter;

    private URLImageGetter mUrlImageGetter;
    private String mNewsTitle;
    private NewsDetail mNewsDetail;
    private String mShareLink;
    private boolean mIsLiked ;
    private MenuItem mLikeItem;
    private String mNewsContent;
    private SpeechSynthesizer mySynthesizer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViews() {
        String postId = getIntent().getStringExtra(Constants.NEWS_POST_ID);
        mNewsDetailPresenter.setPosId(postId);
        mPresenter = mNewsDetailPresenter;
        mPresenter.attachView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SpeechUtility.createUtility(NewsDetailActivity.this, "appid=59b543da");
        //处理语音合成关键类
        mySynthesizer = SpeechSynthesizer.createSynthesizer(this, myInitListener);

    }

    private InitListener myInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d("mySynthesiezer:", "InitListener init() code = " + code);
        }
    };
    @SuppressWarnings("deprecation")
    @Override
    public void setNewsDetail(NewsDetail newsDetail) {
        mNewsDetail = newsDetail;
        mNewsContent = newsDetail.getNews_Content();
        NewsDao dao = App.getNewsDao();
        News entity = new News(newsDetail.getNews_ID(), newsDetail.getKeywords().get(0).getWord());
        dao.update(entity);
        mShareLink = newsDetail.getNews_URL();
        mNewsTitle = newsDetail.getNews_Title();
        String newsSource = newsDetail.getNews_Source();
        String newsTime = MyUtils.formatDate(newsDetail.getNews_Time());
        String newsBody = newsDetail.getNews_Content();
        String NewsImgSrc = getImgSrcs(newsDetail);
        String newsId = newsDetail.getNews_ID();
        Query<LikeNews> newsQuery = App.getLikeNewsDao().queryBuilder()
                .where(LikeNewsDao.Properties.News_Id.eq(newsId))
                .build();
        List<LikeNews> list = newsQuery.list();
        mIsLiked = !list.isEmpty();
        invalidateOptionsMenu();

        setToolBarLayout(mNewsTitle);
//        mNewsDetailTitleTv.setText(newsTitle);
        mNewsDetailFromTv.setText(getString(R.string.news_from, newsSource, newsTime));
        if(!MyUtils.isTextMode())
            setNewsDetailPhotoIv(NewsImgSrc);
        setNewsDetailBodyTv(newsDetail, newsBody);
    }

    private void setToolBarLayout(String newsTitle) {
        mToolbarLayout.setTitle(newsTitle);
        mToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        mToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.primary_text_white));
    }

    private void setNewsDetailPhotoIv(String imgSrc) {
        Glide.with(this).load(imgSrc).asBitmap()
                .placeholder(R.drawable.ic_loading)
                .format(DecodeFormat.PREFER_ARGB_8888)
                .error(R.drawable.ic_load_fail)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mNewsDetailPhotoIv)/*(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        mNewsDetailPhotoIv.setImageBitmap(resource);
                        mMaskView.setVisibility(View.VISIBLE);
                    }
                })*/;
    }

    private void setNewsDetailBodyTv(final NewsDetail newsDetail, final String newsBody) {
        mSubscription = Observable.timer(500, TimeUnit.MILLISECONDS)
                .compose(TransformUtils.<Long>defaultSchedulers())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        mProgressBar.setVisibility(View.GONE);
                        mFab.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.RollIn).playOn(mFab);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        setBody(newsDetail, newsBody);
                    }
                });
    }
    private void setBody(NewsDetail newsDetail, String newsBody) {
        int imgTotal = newsDetail.getNews_Pictures().length;
        if (isShowBody(newsBody, imgTotal)&&!MyUtils.isTextMode()) {
//              mNewsDetailBodyTv.setMovementMethod(LinkMovementMethod.getInstance());//加这句才能让里面的超链接生效,实测经常卡机崩溃
            mUrlImageGetter = new URLImageGetter(mNewsDetailBodyTv, newsBody, imgTotal);
            mNewsDetailBodyTv.setText(Html.fromHtml(newsBody, mUrlImageGetter, null));
        } else {
            mNewsDetailBodyTv.setText(Html.fromHtml(newsBody));
        }
        mNewsDetailBodyTv.setMovementMethod(new LinkMovementMethod());
    }

    private boolean isShowBody(String newsBody, int imgTotal) {
        return App.isHavePhoto() && imgTotal >= 2 && newsBody != null;
    }

    private String getImgSrcs(NewsDetail newsDetail) {
        String[] imgSrcs = newsDetail.getNews_Pictures();
        String imgSrc;
        if (imgSrcs != null && imgSrcs.length > 0) {
            imgSrc = imgSrcs[0];
        } else {
            imgSrc = getIntent().getStringExtra(Constants.NEWS_IMG_RES);
        }
        return imgSrc;
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
//        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void showMsg(String message) {
        mProgressBar.setVisibility(View.GONE);
        if (NetUtil.isNetworkAvailable()) {
            Snackbar.make(mAppBar, message, Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mLikeItem = menu.getItem(0);
        if(mIsLiked){
            mLikeItem.setIcon(R.drawable.ic_action_favorite);
        }else {
            mLikeItem.setIcon(R.drawable.ic_action_unfav);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filter:
                BanNewsDao banNewsDao = App.getBanNewsDao();
                if(banNewsDao.queryBuilder().where(BanNewsDao.Properties.News_ID.eq(mNewsDetail.getNews_ID())).list().size() == 0)
                    banNewsDao.insert(new BanNews(mNewsDetail.getNews_ID()));
                showDialog();
                break;
            case R.id.action_likes:
                LikeNewsDao dao = App.getLikeNewsDao();
                if(mIsLiked){
                    Toast.makeText(getApplicationContext(), "已取消收藏",Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_action_unfav);
                    mIsLiked = false;
                    dao.deleteByKey(mNewsDetail.getNews_ID());
                }else {
                    Toast.makeText(getApplicationContext(), "已收藏", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_action_favorite);
                    mIsLiked = true;
                    long time=System.currentTimeMillis();
                    String intro = mNewsDetail.getNews_Content();
                    intro = intro.replaceAll("<[^<]*>", "").substring(0,40);
                    LikeNews entity = new LikeNews(mNewsDetail.getNews_ID(), mNewsDetail.getNews_Title(), mNewsDetail.getNews_Time(), mNewsDetail.getNews_onePicture(),intro, time);
                    dao.insert(entity);
                }
                break;
            case R.id.action_web_view:
                openByWebView();
                break;
            case R.id.action_browser:
                openByBrowser();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openByWebView() {
        //TODO: Audio


        mySynthesizer.setParameter(SpeechConstant.VOICE_NAME,"xiaoyan");
        //设置音调
        mySynthesizer.setParameter(SpeechConstant.PITCH,"50");
        //设置音量
        mySynthesizer.setParameter(SpeechConstant.VOLUME,"50");

        mNewsContent = mNewsContent.replaceAll("<[^<]*>","");

        int code = mySynthesizer.startSpeaking(mNewsContent, mTtsListener);
        Log.d("mySynthesiezer start code:", code + " ");
        /*

        Intent intent = new Intent(this, NewsBrowserActivity.class);
        intent.putExtra(Constants.NEWS_LINK, mShareLink);
        intent.putExtra(Constants.NEWS_TITLE, mNewsTitle);
        startActivity(intent);
        */
    }
    private SynthesizerListener mTtsListener = new SynthesizerListener() {
        @Override
        public void onSpeakBegin() {
        }
        @Override
        public void onSpeakPaused() {
        }
        @Override
        public void onSpeakResumed() {
        }
        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
        }
        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
        }

        @Override
        public void onCompleted(SpeechError error) {
            if(error!=null)
            {
                Log.d("mySynthesiezer complete code:", error.getErrorCode()+"");
            }
            else
            {
                Log.d("mySynthesiezer complete code:", "0");
            }
        }

        public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
            // TODO Auto-generated method stub

        }
    };
    private void openByBrowser() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        if (canBrowse(intent)) {
            Uri uri = Uri.parse(mShareLink);
            intent.setData(uri);
            startActivity(intent);
        }
    }

    private boolean canBrowse(Intent intent) {
        return intent.resolveActivity(getPackageManager()) != null && mShareLink != null;
    }

    @Override
    protected void onDestroy() {
        cancelUrlImageGetterSubscription();
        mySynthesizer.destroy();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySynthesizer.pauseSpeaking();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mySynthesizer.resumeSpeaking();
    }

    private void cancelUrlImageGetterSubscription() {
        try {
            if (mUrlImageGetter != null && mUrlImageGetter.mSubscription != null
                    && !mUrlImageGetter.mSubscription.isUnsubscribed()) {
                mUrlImageGetter.mSubscription.unsubscribe();
                KLog.d("UrlImageGetter unsubscribe");
            }
        } catch (Exception e) {
            KLog.e("取消UrlImageGetter Subscription 出现异常： " + e.toString());
        }
    }

    @OnClick(R.id.fab)
    public void onClick() {
        share();
    }

    public Uri getLocalBitmapUri(Bitmap bmp) {
        Uri bmpUri = null;
        try {
            File file =  new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    private void share() {
        String url = mNewsDetail.getNews_onePicture();
        Picasso.with(getApplicationContext()).load(url).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                KLog.d();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra("Kdescription", "wwwwwwwwwwwwwwwwwwww");
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
                intent.putExtra(Intent.EXTRA_TEXT, getShareContents());
                intent.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(bitmap));
                startActivity(Intent.createChooser(intent, getTitle()));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        });
    }

    @NonNull
    private String getShareContents() {
        if (mShareLink == null) {
            mShareLink = "";
        }
        return getString(R.string.share_contents, mNewsTitle, mShareLink);
    }

    public void showDialog(){
        FragmentManager fm = getFragmentManager();
        Bundle bundle = new Bundle();
        List<NewsDetail.KeywordsBean> keywordsBeanList = mNewsDetail.getKeywords();
        ArrayList<String> tmp = new ArrayList<String>();
        for (NewsDetail.KeywordsBean i: keywordsBeanList){
            if(mNewsDetail.getNews_Title().contains(i.getWord()))
                tmp.add(i.getWord());
        }
        String[] passIn = new String[tmp.size()];
        if(passIn.length == 0){
            return;
        }
        for (int i = 0;i<passIn.length;i++)
            passIn[i] = tmp.get(i);
        bundle.putStringArray("KeywordList", passIn);
        BanKeywordFragment banKeywordFragment = new BanKeywordFragment();
        banKeywordFragment.setArguments(bundle);
        banKeywordFragment.show(fm, "");
    }
}

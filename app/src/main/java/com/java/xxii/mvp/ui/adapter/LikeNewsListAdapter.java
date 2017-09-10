package com.java.xxii.mvp.ui.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.java.xxii.App;
import com.java.xxii.R;
import com.java.xxii.greendao.LikeNews;
import com.java.xxii.greendao.News;
import com.java.xxii.greendao.NewsDao;
import com.java.xxii.listener.OnItemClickListener;
import com.java.xxii.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.java.xxii.utils.DimenUtil;
import com.java.xxii.utils.MyUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.dao.query.Query;

/**
 * Created by Shinelon on 2017/9/10.
 */

public class LikeNewsListAdapter extends BaseRecyclerViewAdapter<LikeNews> {

    public static final int TYPE_PHOTO_ITEM = 2;

    public interface OnNewsListItemClickListener extends OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @Inject
    public LikeNewsListAdapter() {
        super(null);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view;
        switch (viewType) {
            case TYPE_FOOTER:
                view = getView(parent, R.layout.item_news_footer_none);
                return new FooterViewHolder(view);
            case TYPE_ITEM:
                if(MyUtils.isTextMode())
                    view = getView(parent, R.layout.item_news_text);
                else
                    view = getView(parent, R.layout.item_news);
                final com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter.MyItemViewHolder itemViewHolder = new com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter.MyItemViewHolder(view);
                setItemOnClickEvent(itemViewHolder, false);
                return itemViewHolder;
            default:
                throw new RuntimeException("there is no type that matches the type " +
                        viewType + " + make sure your using types correctly");
        }
    }

    private void setItemOnClickEvent(final RecyclerView.ViewHolder holder, final boolean isPhoto) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter.OnNewsListItemClickListener) mOnItemClickListener).onItemClick(v, holder.getLayoutPosition());
                    if (holder instanceof com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter.MyItemViewHolder){
                        int position = holder.getLayoutPosition();
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsShowFooter && isFooterPosition(position)) {
            return TYPE_FOOTER;
        } else if (!TextUtils.isEmpty(mList.get(position).getNews_Intro())) {
            return TYPE_ITEM;
        } else {
            return TYPE_PHOTO_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        setValues(holder, position);
        setItemAppearAnimation(holder, position, R.anim.anim_bottom_in);
    }

    private void setValues(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter.MyItemViewHolder) {
            setItemValues((com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter.MyItemViewHolder) holder, position);
        }
    }

    private void setItemValues(com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter.MyItemViewHolder holder, int position) {
        LikeNews LikeNews = mList.get(position);
        String title = LikeNews.getNews_Title();
        if (title == null) {
            title = LikeNews.getNews_Title();
        }
        String ptime = LikeNews.getNews_Time();
        ptime = MyUtils.formatDate(ptime);
        String digest = LikeNews.getNews_Intro();
        String imgSrc = LikeNews.getNews_Img();
        String newsId = LikeNews.getNews_Id();
        holder.mLikeNewsTitleTv.setText(title);
        holder.mLikeNewsTitleTv.setTextColor(Color.BLACK);
        holder.mLikeNewsPtimeTv.setText(ptime);
        holder.mLikeNewsDigestTv.setText(digest);
        if (!MyUtils.isTextMode()){
            Glide.with(App.getAppContext()).load(imgSrc).asBitmap() // gif格式有时会导致整体图片不显示，貌似有冲突
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.color.image_place_holder)
                    .error(R.drawable.ic_load_fail)
                    .into(holder.mLikeNewsPhotoIv);
        }
    }



    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (isShowingAnimation(holder)) {
            holder.itemView.clearAnimation();
        }
    }

    private boolean isShowingAnimation(RecyclerView.ViewHolder holder) {
        return holder.itemView.getAnimation() != null && holder.itemView
                .getAnimation().hasStarted();
    }

    class MyItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_summary_photo_iv)
        ImageView mLikeNewsPhotoIv;
        @BindView(R.id.news_summary_title_tv)
        TextView mLikeNewsTitleTv;
        @BindView(R.id.news_summary_digest_tv)
        TextView mLikeNewsDigestTv;
        @BindView(R.id.news_summary_ptime_tv)
        TextView mLikeNewsPtimeTv;

        public MyItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}


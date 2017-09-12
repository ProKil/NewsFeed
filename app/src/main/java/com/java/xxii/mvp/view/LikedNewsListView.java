package com.java.xxii.mvp.view;

import com.java.xxii.common.LoadNewsType;
import com.java.xxii.greendao.LikeNews;
import com.java.xxii.mvp.entity.NewsSummary;
import com.java.xxii.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by Shinelon on 2017/9/10.
 */

public interface LikedNewsListView extends BaseView {
    void setNewsList(List<LikeNews> newsSummary, @LoadNewsType.checker int loadType);
}

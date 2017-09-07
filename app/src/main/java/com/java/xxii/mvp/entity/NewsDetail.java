/*
 * Copyright (c) 2016 咖枯 <java201313@163.com | 3772304@qq.com>
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
package com.java.xxii.mvp.entity;

import java.util.List;

/**
 * @author 咖枯
 * @version 1.0 2016/6/4
 */
public class NewsDetail {

    /**
     * Keywords : [{"word":"柔道","score":284.757301873237},{"word":"运动员","score":175.96153591945614},{"word":"密切相关","score":146.500260494047},{"word":"金牌","score":108.11181674559495},{"word":"兴奋剂","score":50.14964240213721},{"word":"奥委会","score":49.38850075600552},{"word":"夺金","score":49.24865103515016},{"word":"奥运会","score":42.91700778292255},{"word":"得主","score":42.50979872503125},{"word":"荣誉","score":39.03616838941658},{"word":"丑闻","score":38.97666228870314},{"word":"国际","score":38.85940043341527},{"word":"参赛","score":36.96654132083348},{"word":"资格","score":34.30003547895221},{"word":"心理","score":34.02135500267455},{"word":"体育运动","score":32.12061612285196},{"word":"主席","score":32.02401640007587},{"word":"总统","score":31.73815649340386},{"word":"压力","score":31.335727645564415},{"word":"获得","score":29.9331202895849},{"word":"报道","score":29.83396330149134},{"word":"世界","score":27.505749761990682},{"word":"审稿","score":24.356345520036772},{"word":"代表团","score":23.62951016297436},{"word":"联合会","score":23.506998877306604},{"word":"不止","score":21.993190327463626},{"word":"尊敬","score":21.289911476789367},{"word":"禁赛","score":20.865082608053903},{"word":"实习","score":20.705866466136715},{"word":"频道","score":20.20851588018819},{"word":"提到","score":19.492868361353313},{"word":"夺冠","score":19.43645059711442},{"word":"承受","score":18.76193169909379},{"word":"喜欢","score":18.49648025647454},{"word":"奖励","score":18.25010866383643},{"word":"正是","score":18.15872964623},{"word":"共有","score":17.828496405670112},{"word":"值得","score":17.656386848448054},{"word":"文章","score":17.443500291230176},{"word":"训练","score":17.419534732100484},{"word":"讨论","score":17.27879906096889},{"word":"评论","score":17.26054077659955},{"word":"允许","score":17.14766915335238},{"word":"此前","score":16.834021038112642},{"word":"取消","score":16.798974536384243},{"word":"意义","score":16.713421402804553},{"word":"选手","score":16.672551667575867},{"word":"准备","score":16.441288496709927},{"word":"完全","score":16.339286361463877},{"word":"综合","score":15.618350414565915}]
     * bagOfWords : [{"word":"参赛","score":1},{"word":"重要","score":1},{"word":"段","score":1},{"word":"普京","score":5},{"word":"但","score":2},{"word":"德","score":1},{"word":"得主","score":1},{"word":"最终","score":1},{"word":"本","score":1},{"word":"来说","score":1},{"word":"承受","score":1},{"word":"报","score":1},{"word":"主席","score":1},{"word":"准备","score":1},{"word":"尊敬","score":1},{"word":"训练","score":1},{"word":"国际","score":2},{"word":"可以","score":1},{"word":"因此","score":1},{"word":"柔道","score":6},{"word":"弗拉基米尔","score":2},{"word":"最","score":1},{"word":"文章","score":1},{"word":"曼","score":1},{"word":"丑闻","score":1},{"word":"好","score":1},{"word":"此次","score":2},{"word":"金牌","score":5},{"word":"数","score":1},{"word":"奥委会","score":1},{"word":"心理","score":1},{"word":"已","score":1},{"word":"武","score":1},{"word":"资格","score":1},{"word":"一起","score":1},{"word":"总统","score":2},{"word":"编译","score":1},{"word":"实习","score":1},{"word":"我们","score":1},{"word":"兴奋剂","score":1},{"word":"参加","score":1},{"word":"频道","score":1},{"word":"没有","score":1},{"word":"夺得","score":1},{"word":"他","score":3},{"word":"重大","score":1},{"word":"作为","score":1},{"word":"首","score":2},{"word":"里约","score":2},{"word":"问题","score":1},{"word":"就","score":1},{"word":"垮","score":1},{"word":"次","score":1},{"word":"获得最高","score":1},{"word":"大","score":1},{"word":"而","score":1},{"word":"7日","score":1},{"word":"密切相关","score":2},{"word":"代表团","score":1},{"word":"说","score":2},{"word":"媒","score":1},{"word":"掉","score":1},{"word":"：","score":4},{"word":"称","score":3},{"word":"运动员","score":4},{"word":"喜欢","score":1},{"word":"了","score":4},{"word":"·","score":2},{"word":"对","score":1},{"word":"，","score":13},{"word":"体育运动","score":1},{"word":"翟","score":1},{"word":"\u201d","score":1},{"word":"\u201c","score":1},{"word":"据","score":1},{"word":"表示","score":1},{"word":"其","score":1},{"word":"报道","score":2},{"word":"意义","score":1},{"word":"潞","score":1},{"word":"评论","score":1},{"word":"正是","score":1},{"word":"周","score":1},{"word":"德国","score":1},{"word":"本人","score":1},{"word":"最后","score":1},{"word":"还有","score":1},{"word":"8月","score":1},{"word":"非常","score":1},{"word":"值得","score":1},{"word":"世界","score":1},{"word":"奥运会","score":2},{"word":"夺冠","score":1},{"word":"共有","score":1},{"word":"也","score":2},{"word":"奖励","score":1},{"word":"综合","score":1},{"word":"被","score":2},{"word":"穆德拉诺夫","score":2},{"word":"取消","score":1},{"word":"完全","score":1},{"word":"审稿","score":1},{"word":"俄","score":2},{"word":"是","score":1},{"word":"夺金","score":1},{"word":"为","score":1},{"word":"新闻","score":1},{"word":"压力","score":1},{"word":"联合会","score":1},{"word":"在","score":1},{"word":"枚","score":4},{"word":"易","score":1},{"word":"的","score":5},{"word":"此前","score":1},{"word":"选手","score":1},{"word":"名","score":1},{"word":"与","score":3},{"word":"不","score":1},{"word":"讨论","score":1},{"word":"时","score":1},{"word":"这","score":2},{"word":"8","score":1},{"word":"还","score":1},{"word":"一","score":2},{"word":"俄罗斯","score":11},{"word":"平","score":1},{"word":"】","score":1},{"word":"【","score":1},{"word":"禁赛","score":1},{"word":"提到","score":1},{"word":"》","score":1},{"word":"《","score":1},{"word":")","score":1},{"word":"获得","score":1},{"word":"(","score":1},{"word":"。","score":9},{"word":"、","score":1},{"word":"　","score":8},{"word":"环球网","score":1},{"word":"因","score":1},{"word":"获","score":1},{"word":"271","score":1},{"word":"不止","score":1},{"word":"很多","score":1},{"word":"允许","score":1},{"word":"消息","score":1},{"word":"荣誉","score":1}]
     * crawl_Source : news.21cn.com
     * crawl_Time : 20160809034317
     * inborn_KeyWords :
     * lang_Type : zh-CN
     * locations : [{"word":"里约","count":2},{"word":"俄罗斯","count":11},{"word":"德国","count":1}]
     * newsClassTag : 体育
     * news_Author : 环球网|
     * news_Category : 首页 > 新闻 > 环球扫描 > 正文
     * news_Content : 　　【环球网综合报道】据俄罗斯新闻频道8月7日消息，德国《世界报》评论俄罗斯在里约奥运会获得其首枚金牌时称，俄罗斯柔道选手夺得金牌与俄罗斯总统弗拉基米尔·普京密切相关。 　　文章称，俄首枚金牌得主、柔道运动员穆德拉诺夫不止一次与俄罗斯总统弗拉基米尔·普京一起训练。柔道正是普京喜欢的体育运动，因此此次夺冠对俄罗斯来说非常重要。报道还提到，普京作为国际柔道联合会荣誉主席，已获柔道8段。 　　穆德拉诺夫本人也表示，这枚金牌意义重大。他说：“俄罗斯承受了最大的心理压力，但我们准备好了，也没有垮掉。”他称，还有很多值得尊敬的运动员本可以为俄罗斯获得最高奖励，但被禁赛了。他说，这不是俄罗斯的最后一枚金牌。 　　此前国际奥委会就因兴奋剂丑闻而完全取消俄罗斯代表团的参赛资格问题讨论了数周，最终共有271名俄罗斯运动员被允许参加此次奥运会。(实习编译：易武平 审稿：翟潞曼)
     * news_ID : 201608090432c815a85453c34d8ca43a591258701e9b
     * news_Journal : 翟潞曼
     * news_Pictures : http://img003.21cnimg.com/photos/album/20160808/m600/A3B78A702DF9BF0EE02ADFD5D4F53D54.jpeg
     * news_Source : 其他
     * news_Time : 20160808000000
     * news_Title : 德媒：俄柔道运动员里约夺金与普京密切相关
     * news_URL : http://news.21cn.com/world/guojisaomiao/a/2016/0808/15/31396661.shtml
     * news_Video :
     * organizations : []
     * persons : [{"word":"弗拉基米尔","count":2},{"word":"穆德拉诺夫","count":2},{"word":"普京","count":5}]
     * repeat_ID : 0
     * seggedPListOfContent : ["　/x 　/x 【/w 环球网/MEDIA 综合/v 报道/v 】/w 据/p 俄罗斯/LOC 新闻/n 频道/n 8月/t 7日/t 消息/n ，/w 德国/LOC 《/w 世界/n 报/n 》/w 评论/n 俄罗斯/LOC 在/p 里约/LOC 奥运会/n 获得/v 其/r 首/m 枚/q 金牌/n 时/g 称/v ，/w 俄罗斯/LOC 柔道/n 选手/n 夺得/v 金牌/n 与/p 俄罗斯/LOC 总统/n 弗拉基米尔/PER ·/w 普京/PER 密切相关/n 。/w  　/x 　/x 文章/n 称/v ，/w 俄/b 首/m 枚/q 金牌/n 得主/n 、/w 柔道/n 运动员/n 穆德拉诺夫/PER 不止/v 一/m 次/qv 与/p 俄罗斯/LOC 总统/n 弗拉基米尔/PER ·/w 普京/PER 一起/s 训练/vn 。/w 柔道/n 正是/v 普京/PER 喜欢/v 的/u 体育运动/n ，/w 因此/c 此次/r 夺冠/v 对/p 俄罗斯/LOC 来说/u 非常/d 重要/a 。/w 报道/v 还/d 提到/v ，/w 普京/PER 作为/p 国际/n 柔道/n 联合会/n 荣誉/n 主席/n ，/w 已/d 获/v 柔道/n 8/a 段/q 。/w  　/x 　/x 穆德拉诺夫/PER 本人/r 也/d 表示/v ，/w 这/r 枚/q 金牌/n 意义/n 重大/a 。/w 他/r 说/v ：/w \u201c/w 俄罗斯/LOC 承受/v 了/u 最/d 大/a 的/u 心理/n 压力/n ，/w 但/c 我们/r 准备/v 好/a 了/y ，/w 也/d 没有/v 垮/v 掉/v 。/w \u201d/w 他/r 称/v ，/w 还有/v 很多/m 值得/v 尊敬/v 的/u 运动员/n 本/r 可以/v 为/p 俄罗斯/LOC 获得最高/n 奖励/vn ，/w 但/c 被/p 禁赛/v 了/y 。/w 他/r 说/v ，/w 这/r 不/d 是/v 俄罗斯/LOC 的/u 最后/f 一/m 枚/q 金牌/n 。/w  　/x 　/x 此前/t 国际/n 奥委会/n 就/d 因/p 兴奋剂/n 丑闻/n 而/cc 完全/ad 取消/v 俄罗斯/LOC 代表团/n 的/u 参赛/vn 资格/n 问题/n 讨论/v 了/u 数/m 周/qt ，/w 最终/d 共有/v 271/m 名/q 俄罗斯/LOC 运动员/n 被/p 允许/v 参加/v 此次/r 奥运会/n 。/w (/w 实习/v 编译/v ：/w 易/g 武/g 平/v  审稿/v ：/w 翟/PER 潞/g 曼/g )/w "]
     * seggedTitle : 德/n 媒/g ：/w 俄/b 柔道/n 运动员/n 里约/LOC 夺金/vn 与/cc 普京/PER 密切相关/n
     * wordCountOfContent : 226
     * wordCountOfTitle : 11
     */

    private String crawl_Source;
    private String crawl_Time;
    private String inborn_KeyWords;
    private String lang_Type;
    private String newsClassTag;
    private String news_Author;
    private String news_Category;
    private String news_Content;
    private String news_ID;
    private String news_Journal;
    private String news_Pictures;
    private String news_Source;
    private String news_Time;
    private String news_Title;
    private String news_URL;
    private String news_Video;
    private String repeat_ID;
    private String seggedTitle;
    private int wordCountOfContent;
    private int wordCountOfTitle;
    private List<KeywordsBean> Keywords;
    private List<BagOfWordsBean> bagOfWords;
    private List<LocationsBean> locations;
    private List<?> organizations;
    private List<PersonsBean> persons;
    private List<String> seggedPListOfContent;

    public String getCrawl_Source() {
        return crawl_Source;
    }

    public void setCrawl_Source(String crawl_Source) {
        this.crawl_Source = crawl_Source;
    }

    public String getCrawl_Time() {
        return crawl_Time;
    }

    public void setCrawl_Time(String crawl_Time) {
        this.crawl_Time = crawl_Time;
    }

    public String getInborn_KeyWords() {
        return inborn_KeyWords;
    }

    public void setInborn_KeyWords(String inborn_KeyWords) {
        this.inborn_KeyWords = inborn_KeyWords;
    }

    public String getLang_Type() {
        return lang_Type;
    }

    public void setLang_Type(String lang_Type) {
        this.lang_Type = lang_Type;
    }

    public String getNewsClassTag() {
        return newsClassTag;
    }

    public void setNewsClassTag(String newsClassTag) {
        this.newsClassTag = newsClassTag;
    }

    public String getNews_Author() {
        return news_Author;
    }

    public void setNews_Author(String news_Author) {
        this.news_Author = news_Author;
    }

    public String getNews_Category() {
        return news_Category;
    }

    public void setNews_Category(String news_Category) {
        this.news_Category = news_Category;
    }

    public String getNews_Content() {
        return news_Content;
    }

    public void setNews_Content(String news_Content) {
        this.news_Content = news_Content;
    }

    public String getNews_ID() {
        return news_ID;
    }

    public void setNews_ID(String news_ID) {
        this.news_ID = news_ID;
    }

    public String getNews_Journal() {
        return news_Journal;
    }

    public void setNews_Journal(String news_Journal) {
        this.news_Journal = news_Journal;
    }

    public String[] getNews_Pictures() {

        return news_Pictures.split(" ");
    }

    public void setNews_Pictures(String news_Pictures) {
        this.news_Pictures = news_Pictures;
    }

    public String getNews_Source() {
        return news_Source;
    }

    public void setNews_Source(String news_Source) {
        this.news_Source = news_Source;
    }

    public String getNews_Time() {
        return news_Time;
    }

    public void setNews_Time(String news_Time) {
        this.news_Time = news_Time;
    }

    public String getNews_Title() {
        return news_Title;
    }

    public void setNews_Title(String news_Title) {
        this.news_Title = news_Title;
    }

    public String getNews_URL() {
        return news_URL;
    }

    public void setNews_URL(String news_URL) {
        this.news_URL = news_URL;
    }

    public String getNews_Video() {
        return news_Video;
    }

    public void setNews_Video(String news_Video) {
        this.news_Video = news_Video;
    }

    public String getRepeat_ID() {
        return repeat_ID;
    }

    public void setRepeat_ID(String repeat_ID) {
        this.repeat_ID = repeat_ID;
    }

    public String getSeggedTitle() {
        return seggedTitle;
    }

    public void setSeggedTitle(String seggedTitle) {
        this.seggedTitle = seggedTitle;
    }

    public int getWordCountOfContent() {
        return wordCountOfContent;
    }

    public void setWordCountOfContent(int wordCountOfContent) {
        this.wordCountOfContent = wordCountOfContent;
    }

    public int getWordCountOfTitle() {
        return wordCountOfTitle;
    }

    public void setWordCountOfTitle(int wordCountOfTitle) {
        this.wordCountOfTitle = wordCountOfTitle;
    }

    public List<KeywordsBean> getKeywords() {
        return Keywords;
    }

    public void setKeywords(List<KeywordsBean> Keywords) {
        this.Keywords = Keywords;
    }

    public List<BagOfWordsBean> getBagOfWords() {
        return bagOfWords;
    }

    public void setBagOfWords(List<BagOfWordsBean> bagOfWords) {
        this.bagOfWords = bagOfWords;
    }

    public List<LocationsBean> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationsBean> locations) {
        this.locations = locations;
    }

    public List<?> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<?> organizations) {
        this.organizations = organizations;
    }

    public List<PersonsBean> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonsBean> persons) {
        this.persons = persons;
    }

    public List<String> getSeggedPListOfContent() {
        return seggedPListOfContent;
    }

    public void setSeggedPListOfContent(List<String> seggedPListOfContent) {
        this.seggedPListOfContent = seggedPListOfContent;
    }

    public static class KeywordsBean {
        /**
         * word : 柔道
         * score : 284.757301873237
         */

        private String word;
        private double score;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public static class BagOfWordsBean {
        /**
         * word : 参赛
         * score : 1.0
         */

        private String word;
        private double score;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public static class LocationsBean {
        /**
         * word : 里约
         * count : 2
         */

        private String word;
        private int count;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class PersonsBean {
        /**
         * word : 弗拉基米尔
         * count : 2
         */

        private String word;
        private int count;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
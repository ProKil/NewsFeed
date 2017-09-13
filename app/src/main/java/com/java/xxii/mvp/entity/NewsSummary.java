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
package com.java.xxii.mvp.entity;


public class NewsSummary {

    /**
     * lang_Type : zh-CN
     * newsClassTag : 科技
     * news_Author : 人民网
     * news_ID : 2016091304130fa2b951a9994d4ab5e4b938a0eef205
     * news_Pictures : http://upload.qianlong.com/2016/0912/1473661206139.jpg http://upload.qianlong.com/2016/0912/1473665750616.jpg
     * news_Source : 其他
     * news_Time : 20160912000000
     * news_Title : 《口袋妖怪GO》重拳出击打击作弊 不再支持越狱设备
     * news_URL : http://tech.qianlong.com/2016/0912/924162.shtml
     * news_Video :
     * news_Intro : 9月12日消息，据外媒报道，作为《口袋妖怪GO》开发商之一的Niantic游...
     */

    private String lang_Type;
    private String newsClassTag;
    private String news_Author;
    private String news_ID;
    private String news_Pictures;
    private String news_Source;
    private String news_Time;
    private String news_Title;
    private String news_URL;
    private String news_Video;
    private String news_Intro;

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

    public String getNews_ID() {
        return news_ID;
    }

    public void setNews_ID(String news_ID) {
        this.news_ID = news_ID;
    }

    public String getNews_Pictures() {
//        return "http://upload.qianlong.com/2016/0912/1473661206139.jpg";
        try {
            if (news_Pictures != "")
                return news_Pictures.split(" |;")[0];
            else
                return "http://res2.esf.leju.com/esf_www/statics/images/default-img/detail.png";
        }
        catch (Exception e){
            return "http://res2.esf.leju.com/esf_www/statics/images/default-img/detail.png";
        }
//        TODO: ...
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

    public String getNews_Intro() {
        return news_Intro;
    }

    public void setNews_Intro(String news_Intro) {
        this.news_Intro = news_Intro;
    }
}

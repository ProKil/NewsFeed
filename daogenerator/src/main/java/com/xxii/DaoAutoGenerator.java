package com.xxii;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class DaoAutoGenerator {
    public static void main(String[] args) throws Exception {
        int version = 1;
        String defaultJavaPackage = "com.java.xxii.greendao";

        Schema schema = new Schema(version, defaultJavaPackage);

        createTable(schema);


        new DaoGenerator().generateAll(schema, "./app/src/main/java-gen");
    }

    private static void createTable(Schema schema) {

        Entity entity = schema.addEntity("NewsChannelTable");

        /**
         * 频道名称
         */
        entity.addStringProperty("newsChannelName").notNull().primaryKey().index();
        /**
         * 频道id
         */
        entity.addStringProperty("newsChannelId").notNull();
        /**
         * 频道类型
         */
        entity.addStringProperty("newsChannelType").notNull();
        /**

         */
        entity.addBooleanProperty("newsChannelSelect").notNull();
        /**

         */
        entity.addIntProperty("newsChannelIndex").notNull();
        /**
         * 频道是否是固定的
         */
        entity.addBooleanProperty("newsChannelFixed");
        Entity banCollection = schema.addEntity("BanCollection");
        banCollection.addIdProperty();
        Entity banNews = schema.addEntity("BanNews");
        banNews.addIdProperty();
        Property newsFromCollection = banNews.addLongProperty("banCollection_id").notNull().getProperty();
        banNews.addToOne(banCollection, newsFromCollection);
        banCollection.addToMany(banNews, newsFromCollection);
        Entity news = schema.addEntity("News");
        news.addStringProperty("News_ID").notNull().primaryKey().index();
        news.addStringProperty("Key_Words");
        Entity likednews = schema.addEntity("LikeNews");
        likednews.addStringProperty("News_Id").notNull().primaryKey();
        likednews.addStringProperty("News_Title").notNull();
        likednews.addStringProperty("News_Time").notNull();
        likednews.addStringProperty("News_Img").notNull();
        likednews.addStringProperty("News_Intro");
        likednews.addLongProperty("add_Time").notNull().index();
        //news.addStringProperty("");
    }
}
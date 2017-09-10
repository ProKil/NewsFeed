package com.java.xxii.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.java.xxii.greendao.News;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table NEWS.
*/
public class NewsDao extends AbstractDao<News, String> {

    public static final String TABLENAME = "NEWS";

    /**
     * Properties of entity News.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property News_ID = new Property(0, String.class, "News_ID", true, "NEWS__ID");
    };


    public NewsDao(DaoConfig config) {
        super(config);
    }
    
    public NewsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'NEWS' (" + //
                "'NEWS__ID' TEXT PRIMARY KEY NOT NULL );"); // 0: News_ID
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_NEWS_NEWS__ID ON NEWS" +
                " (NEWS__ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'NEWS'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, News entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getNews_ID());
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public News readEntity(Cursor cursor, int offset) {
        News entity = new News( //
            cursor.getString(offset + 0) // News_ID
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, News entity, int offset) {
        entity.setNews_ID(cursor.getString(offset + 0));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(News entity, long rowId) {
        return entity.getNews_ID();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(News entity) {
        if(entity != null) {
            return entity.getNews_ID();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}

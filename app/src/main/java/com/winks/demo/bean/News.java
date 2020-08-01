package com.winks.demo.bean;

import com.google.gson.annotations.SerializedName;

public class News {

    /**
     * abstract : 习近平在回信中指出，当前，中国正在统筹推进疫情防控和经济社会发展工作，决胜全面建成小康社会，决战脱贫攻坚。
     */

    @SerializedName("abstract")
    private String abstractX;

    @Override
    public String toString() {
        return "News{" +
                "chinese_tag='" + chinese_tag + '\'' +
                ", media_avatar_url='" + media_avatar_url + '\'' +
                ", is_feed_ad=" + is_feed_ad +
                ", tag_url='" + tag_url + '\'' +
                ", title='" + title + '\'' +
                ", single_mode=" + single_mode +
                ", middle_mode=" + middle_mode +
                ", tag='" + tag + '\'' +
                ", behot_time=" + behot_time +
                ", source_url='" + source_url + '\'' +
                ", source='" + source + '\'' +
                ", more_mode=" + more_mode +
                ", article_genre='" + article_genre + '\'' +
                ", comments_count=" + comments_count +
                ", is_stick=" + is_stick +
                ", group_source=" + group_source +
                ", item_id='" + item_id + '\'' +
                ", has_gallery=" + has_gallery +
                ", group_id='" + group_id + '\'' +
                ", media_url='" + media_url + '\'' +
                '}';
    }

    /**
     * chinese_tag : 时政
     * media_avatar_url : //p9.pstatp.com/large/pgc-image/03f6307ae99745119fa95747f9d9e525
     * is_feed_ad : false
     * tag_url : search/?keyword=%E6%97%B6%E6%94%BF
     * title : 习近平给“全球首席执行官委员会”成员代表回信
     * single_mode : false
     * middle_mode : false
     * abstract : 习近平在回信中指出，当前，中国正在统筹推进疫情防控和经济社会发展工作，决胜全面建成小康社会，决战脱贫攻坚。
     * tag : news_politics
     * behot_time : 1594882679
     * source_url : /group/6849933672448164360/
     * source : 新华网客户端
     * more_mode : false
     * article_genre : article
     * comments_count : 123
     * is_stick : true
     * group_source : 2
     * item_id : 6849933672448164360
     * has_gallery : false
     * group_id : 6849933672448164360
     * media_url : /c/user/token/MS4wLjABAAAAP09LrX61xFpIWrgGdBDqkp-5om9Lans_kuIZ_ipAGRE/
     */

    private String chinese_tag;
    private String media_avatar_url;
    private boolean is_feed_ad;
    private String tag_url;
    private String title;
    private boolean single_mode;
    private boolean middle_mode;
    private String tag;
    private int behot_time;
    private String source_url;
    private String source;
    private boolean more_mode;
    private String article_genre;
    private int comments_count;
    private boolean is_stick;
    private int group_source;
    private String item_id;
    private boolean has_gallery;
    private String group_id;
    private String media_url;

    public String getChinese_tag() {
        return chinese_tag;
    }

    public void setChinese_tag(String chinese_tag) {
        this.chinese_tag = chinese_tag;
    }

    public String getMedia_avatar_url() {
        return media_avatar_url;
    }

    public void setMedia_avatar_url(String media_avatar_url) {
        this.media_avatar_url = media_avatar_url;
    }

    public boolean isIs_feed_ad() {
        return is_feed_ad;
    }

    public void setIs_feed_ad(boolean is_feed_ad) {
        this.is_feed_ad = is_feed_ad;
    }

    public String getTag_url() {
        return tag_url;
    }

    public void setTag_url(String tag_url) {
        this.tag_url = tag_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSingle_mode() {
        return single_mode;
    }

    public void setSingle_mode(boolean single_mode) {
        this.single_mode = single_mode;
    }

    public boolean isMiddle_mode() {
        return middle_mode;
    }

    public void setMiddle_mode(boolean middle_mode) {
        this.middle_mode = middle_mode;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isMore_mode() {
        return more_mode;
    }

    public void setMore_mode(boolean more_mode) {
        this.more_mode = more_mode;
    }

    public String getArticle_genre() {
        return article_genre;
    }

    public void setArticle_genre(String article_genre) {
        this.article_genre = article_genre;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public boolean isIs_stick() {
        return is_stick;
    }

    public void setIs_stick(boolean is_stick) {
        this.is_stick = is_stick;
    }

    public int getGroup_source() {
        return group_source;
    }

    public void setGroup_source(int group_source) {
        this.group_source = group_source;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public boolean isHas_gallery() {
        return has_gallery;
    }

    public void setHas_gallery(boolean has_gallery) {
        this.has_gallery = has_gallery;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }
}

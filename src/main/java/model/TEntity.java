package model;


import javax.persistence.*;
import java.sql.Timestamp;

/*
 @Entity: 定义数据表对象
 @Id: 声明主键
 @Column: 声明列
 @GeneratedValue: 主键生成方式
 @Table: 定义数据表
*/

@Entity
@Table(name = "lab_t")
public class TEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "t_id")
    private int tId;

    @Column(name = "t_title",length = 50)
    private String tTitle;

    @Column(name = "t_subtitle",length = 50)
    private String tSubtitle;

    @Column(name = "t_author",length = 10)
    private String tAuthor;

    @Column(name = "t_type")
    private int tType;

    @Column(name = "tag_id")
    private int tagId;

    @Column(name = "t_date")
    private Timestamp tDate;

    @Column(name = "t_url")
    private String tUrl;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "checktime")
    private Timestamp checkTime;

    @Column(name = "checked")
    private int checked;

    @Column(name = "enable")
    private int enable;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public String gettSubtitle() {
        return tSubtitle;
    }

    public void settSubtitle(String tSubtitle) {
        this.tSubtitle = tSubtitle;
    }

    public String gettAuthor() {
        return tAuthor;
    }

    public void settAuthor(String tAuthor) {
        this.tAuthor = tAuthor;
    }

    public int gettType() {
        return tType;
    }

    public void settType(int tType) {
        this.tType = tType;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public Timestamp gettDate() {
        return tDate;
    }

    public void settDate(Timestamp tDate) {
        this.tDate = tDate;
    }

    public String gettUrl() {
        return tUrl;
    }

    public void settUrl(String tUrl) {
        this.tUrl = tUrl;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }
}

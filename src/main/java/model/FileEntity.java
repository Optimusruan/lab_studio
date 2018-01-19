package model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/*
 @Entity: 定义数据表对象
 @Id: 声明主键
 @Column: 声明列
 @GeneratedValue: 主键生成方式
 @Table: 定义数据表
*/

@Entity
@Table(name = "lab_file")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@Id")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id")
    private int fileId;

    @Column(name = "file_type")
    private int fileType;

    @Column(name = "file_tag")
    private String fileTag;

    @Column(name = "file_url",length = 300)
    private String fileUrl;

    @Column(name = "file_date")
    private Timestamp fileDate;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "checktime")
    private Timestamp checkTime;

    @Column(name = "checked")
    private int checked;

    @Column(name = "enabled")
    private int enable;

    @ManyToMany
    @JoinTable(name = "lab_pic_slider",joinColumns={@JoinColumn(name = "file_id",referencedColumnName = "file_id")},inverseJoinColumns = {@JoinColumn(name = "slider_id",referencedColumnName = "slider_id")})
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Set<SliderEntity> sliderEntities = new HashSet<>();


    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getFileTag() {
        return fileTag;
    }

    public void setFileTag(String fileTag) {
        this.fileTag = fileTag;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Timestamp getFileDate() {
        return fileDate;
    }

    public void setFileDate(Timestamp fileDate) {
        this.fileDate = fileDate;
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

    public Set<SliderEntity> getSliderEntities() {
        return sliderEntities;
    }

    public void setSliderEntities(Set<SliderEntity> sliderEntities) {
        this.sliderEntities = sliderEntities;
    }
}

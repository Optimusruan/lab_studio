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
@Table (name = "lab_slider")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@Id")
public class SliderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "slider_id")
    private Integer sliderId;

    @Column(name = "slider_name",length = 100)
    private String  sliderName;

    @Column(name = "slider_desc",length = 300)
    private String sliderDesc;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "checktime")
    private Timestamp checkTime;

    @Column(name = "checked")
    private int checked;

    @Column(name = "enabled")
    private int enable;

    @ManyToMany
    @JoinTable(name = "lab_pic_slider",joinColumns={@JoinColumn(name = "slider_id",referencedColumnName = "slider_id")},inverseJoinColumns = {@JoinColumn(name = "file_id",referencedColumnName = "file_id")})

    private Set<FileEntity> fileEntities = new HashSet<>();


    public Integer getSliderId() {
        return sliderId;
    }

    public void setSliderId(Integer sliderId) {
        this.sliderId = sliderId;
    }

    public String getSliderName() {
        return sliderName;
    }

    public void setSliderName(String sliderName) {
        this.sliderName = sliderName;
    }

    public String getSliderDesc() {
        return sliderDesc;
    }

    public void setSliderDesc(String sliderDesc) {
        this.sliderDesc = sliderDesc;
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

    public Set<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(Set<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }
}

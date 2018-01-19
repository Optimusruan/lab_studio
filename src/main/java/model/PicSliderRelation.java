package model;


import javax.persistence.*;


/*
 @Entity: 定义数据表对象
 @Id: 声明主键
 @Column: 声明列
 @GeneratedValue: 主键生成方式
 @Table: 定义数据表
*/
@Entity
@Table(name = "lab_pic_slider")
public class PicSliderRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pic_slider")
    private int id;

    @Column(name = "file_id")
    private int fileId;

    @Column(name = "slider_id")
    private int sliderId;


}

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
@Table(name = "lab_file")
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

    @Column(name = "enable")
    private int enable;
}

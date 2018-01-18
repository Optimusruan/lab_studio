package model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity

@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private int memberId;

    @Column(length = 50,name = "member_name")
    private String memberName;

    @Column(length = 50,name = "member_phone")
    private String memberPhone;

    @Column(length = 300,name = "member_photo")
    private String memberPhoto;

    @Column(name = "member_breviary")
    private String memberBreviary;

    @Column(name = "t_id")
    private int tId;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "checktime")
    private Timestamp checkTime;

    @Column(name = "checked")
    private int checked;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(String memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    public String getMemberBreviary() {
        return memberBreviary;
    }

    public void setMemberBreviary(String memberBreviary) {
        this.memberBreviary = memberBreviary;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
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
}

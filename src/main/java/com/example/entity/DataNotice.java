package com.example.entity;

import java.io.Serializable;

/**
 * Created by Elliot Ji on 2018/8/24.
 */
public class DataNotice implements Serializable {
    private static final long serialVersionUID = -8632865970399121269L;

    private Integer id;
    private String ZoneCode;
    private String NoticeDate;
    private Integer NoticeCount;
    private String msrepl_tran_version;



    public String getMsrepl_tran_version() {
        return msrepl_tran_version;
    }

    public void setMsrepl_tran_version(String msrepl_tran_version) {
        this.msrepl_tran_version = msrepl_tran_version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZoneCode() {
        return ZoneCode;
    }

    public void setZoneCode(String zoneCode) {
        ZoneCode = zoneCode;
    }

    public String getNoticeDate() {
        return NoticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        NoticeDate = noticeDate;
    }

    public Integer getNoticeCount() {
        return NoticeCount;
    }

    public void setNoticeCount(Integer noticeCount) {
        NoticeCount = noticeCount;
    }
}

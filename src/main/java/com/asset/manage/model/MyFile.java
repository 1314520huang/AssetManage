package com.asset.manage.model;

import java.util.Date;

/**
 * 文件类相关
 * 
 * @author Administrator
 *
 */
public class MyFile {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.upload_time
     *
     * @mbggenerated
     */
    private Date uploadTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.describute
     *
     * @mbggenerated
     */
    private String describute;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myfile.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.id
     *
     * @return the value of myfile.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.id
     *
     * @param id the value for myfile.id
     *
     * @mbggenerated
     */
    public MyFile setId(String id) {
        this.id = id == null ? null : id.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.name
     *
     * @return the value of myfile.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.name
     *
     * @param name the value for myfile.name
     *
     * @mbggenerated
     */
    public MyFile setName(String name) {
        this.name = name == null ? null : name.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.type
     *
     * @return the value of myfile.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.type
     *
     * @param type the value for myfile.type
     *
     * @mbggenerated
     */
    public MyFile setType(String type) {
        this.type = type == null ? null : type.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.state
     *
     * @return the value of myfile.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.state
     *
     * @param state the value for myfile.state
     *
     * @mbggenerated
     */
    public MyFile setState(Integer state) {
        this.state = state;
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.upload_time
     *
     * @return the value of myfile.upload_time
     *
     * @mbggenerated
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.upload_time
     *
     * @param uploadTime the value for myfile.upload_time
     *
     * @mbggenerated
     */
    public MyFile setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.remark
     *
     * @return the value of myfile.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.remark
     *
     * @param remark the value for myfile.remark
     *
     * @mbggenerated
     */
    public MyFile setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.describute
     *
     * @return the value of myfile.describute
     *
     * @mbggenerated
     */
    public String getDescribute() {
        return describute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.describute
     *
     * @param describute the value for myfile.describute
     *
     * @mbggenerated
     */
    public MyFile setDescribute(String describute) {
        this.describute = describute == null ? null : describute.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myfile.url
     *
     * @return the value of myfile.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myfile.url
     *
     * @param url the value for myfile.url
     *
     * @mbggenerated
     */
    public MyFile setUrl(String url) {
        this.url = url == null ? null : url.trim();
		return this;
    }
}
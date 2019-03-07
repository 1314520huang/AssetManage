package com.asset.manage.model;

import java.util.Date;

public class Borrow {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.asset_id
     *
     * @mbggenerated
     */
    private String assetId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.asset_name
     *
     * @mbggenerated
     */
    private String assetName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.result
     *
     * @mbggenerated
     */
    private String result;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.admin_id
     *
     * @mbggenerated
     */
    private String adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column borrow.admin_name
     *
     * @mbggenerated
     */
    private String adminName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.id
     *
     * @return the value of borrow.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.id
     *
     * @param id the value for borrow.id
     *
     * @mbggenerated
     */
    public Borrow setId(String id) {
        this.id = id == null ? null : id.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.user_id
     *
     * @return the value of borrow.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.user_id
     *
     * @param userId the value for borrow.user_id
     *
     * @mbggenerated
     */
    public Borrow setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.asset_id
     *
     * @return the value of borrow.asset_id
     *
     * @mbggenerated
     */
    public String getAssetId() {
        return assetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.asset_id
     *
     * @param assetId the value for borrow.asset_id
     *
     * @mbggenerated
     */
    public Borrow setAssetId(String assetId) {
        this.assetId = assetId == null ? null : assetId.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.user_name
     *
     * @return the value of borrow.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.user_name
     *
     * @param userName the value for borrow.user_name
     *
     * @mbggenerated
     */
    public Borrow setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.asset_name
     *
     * @return the value of borrow.asset_name
     *
     * @mbggenerated
     */
    public String getAssetName() {
        return assetName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.asset_name
     *
     * @param assetName the value for borrow.asset_name
     *
     * @mbggenerated
     */
    public Borrow setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.create_time
     *
     * @return the value of borrow.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.create_time
     *
     * @param createTime the value for borrow.create_time
     *
     * @mbggenerated
     */
    public Borrow setCreateTime(Date createTime) {
        this.createTime = createTime;
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.state
     *
     * @return the value of borrow.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.state
     *
     * @param state the value for borrow.state
     *
     * @mbggenerated
     */
    public Borrow setState(Integer state) {
        this.state = state;
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.remark
     *
     * @return the value of borrow.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.remark
     *
     * @param remark the value for borrow.remark
     *
     * @mbggenerated
     */
    public Borrow setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.result
     *
     * @return the value of borrow.result
     *
     * @mbggenerated
     */
    public String getResult() {
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.result
     *
     * @param result the value for borrow.result
     *
     * @mbggenerated
     */
    public Borrow setResult(String result) {
        this.result = result == null ? null : result.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.admin_id
     *
     * @return the value of borrow.admin_id
     *
     * @mbggenerated
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.admin_id
     *
     * @param adminId the value for borrow.admin_id
     *
     * @mbggenerated
     */
    public Borrow setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
		return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column borrow.admin_name
     *
     * @return the value of borrow.admin_name
     *
     * @mbggenerated
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column borrow.admin_name
     *
     * @param adminName the value for borrow.admin_name
     *
     * @mbggenerated
     */
    public Borrow setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
		return this;
    }
}
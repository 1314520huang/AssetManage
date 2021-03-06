package com.asset.manage.model;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.login_name
     *
     * @mbggenerated
     */
    private String loginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.salt
     *
     * @mbggenerated
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.last_login_time
     *
     * @mbggenerated
     */
    private Date lastLoginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.level
     *
     * @mbggenerated
     */
    private String level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.dept_id
     *
     * @mbggenerated
     */
    private String deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.image_id
     *
     * @mbggenerated
     */
    private String imageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.state
     *
     * @mbggenerated
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.dept_name
     *
     * @mbggenerated
     */
    private String deptName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myuser.level_name
     *
     * @mbggenerated
     */
    private String levelName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.id
     *
     * @return the value of myuser.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.id
     *
     * @param id the value for myuser.id
     *
     * @mbggenerated
     */
    public User setId(String id) {
        this.id = id == null ? null : id.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.login_name
     *
     * @return the value of myuser.login_name
     *
     * @mbggenerated
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.login_name
     *
     * @param loginName the value for myuser.login_name
     *
     * @mbggenerated
     */
    public User setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.user_name
     *
     * @return the value of myuser.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.user_name
     *
     * @param userName the value for myuser.user_name
     *
     * @mbggenerated
     */
    public User setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.password
     *
     * @return the value of myuser.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.password
     *
     * @param password the value for myuser.password
     *
     * @mbggenerated
     */
    public User setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.salt
     *
     * @return the value of myuser.salt
     *
     * @mbggenerated
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.salt
     *
     * @param salt the value for myuser.salt
     *
     * @mbggenerated
     */
    public User setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.create_time
     *
     * @return the value of myuser.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.create_time
     *
     * @param createTime the value for myuser.create_time
     *
     * @mbggenerated
     */
    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.last_login_time
     *
     * @return the value of myuser.last_login_time
     *
     * @mbggenerated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.last_login_time
     *
     * @param lastLoginTime the value for myuser.last_login_time
     *
     * @mbggenerated
     */
    public User setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.level
     *
     * @return the value of myuser.level
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.level
     *
     * @param level the value for myuser.level
     *
     * @mbggenerated
     */
    public User setLevel(String level) {
        this.level = level == null ? null : level.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.remark
     *
     * @return the value of myuser.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.remark
     *
     * @param remark the value for myuser.remark
     *
     * @mbggenerated
     */
    public User setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.dept_id
     *
     * @return the value of myuser.dept_id
     *
     * @mbggenerated
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.dept_id
     *
     * @param deptId the value for myuser.dept_id
     *
     * @mbggenerated
     */
    public User setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.image_id
     *
     * @return the value of myuser.image_id
     *
     * @mbggenerated
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.image_id
     *
     * @param imageId the value for myuser.image_id
     *
     * @mbggenerated
     */
    public User setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.phone
     *
     * @return the value of myuser.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.phone
     *
     * @param phone the value for myuser.phone
     *
     * @mbggenerated
     */
    public User setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.state
     *
     * @return the value of myuser.state
     *
     * @mbggenerated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.state
     *
     * @param state the value for myuser.state
     *
     * @mbggenerated
     */
    public User setState(String state) {
        this.state = state == null ? null : state.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.dept_name
     *
     * @return the value of myuser.dept_name
     *
     * @mbggenerated
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.dept_name
     *
     * @param deptName the value for myuser.dept_name
     *
     * @mbggenerated
     */
    public User setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myuser.level_name
     *
     * @return the value of myuser.level_name
     *
     * @mbggenerated
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myuser.level_name
     *
     * @param levelName the value for myuser.level_name
     *
     * @mbggenerated
     */
    public User setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
        return this;
    }
}
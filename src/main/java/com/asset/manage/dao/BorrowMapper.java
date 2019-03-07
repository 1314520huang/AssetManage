package com.asset.manage.dao;

import com.asset.manage.model.Borrow;
import com.asset.manage.model.BorrowExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BorrowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int countByExample(BorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int deleteByExample(BorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int insert(Borrow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int insertSelective(Borrow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    List<Borrow> selectByExample(BorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    Borrow selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Borrow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table borrow
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Borrow record);
}
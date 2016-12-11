package com.devzb.metal.dao.model;

import java.util.Date;

public class MetalZincPrice {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metal_zinc_price.id
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metal_zinc_price.date_day
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    private String dateDay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metal_zinc_price.price
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    private Long price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metal_zinc_price.gmt_created
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    private Date gmtCreated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metal_zinc_price.gmt_modified
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metal_zinc_price.id
     *
     * @return the value of metal_zinc_price.id
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column metal_zinc_price.id
     *
     * @param id the value for metal_zinc_price.id
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metal_zinc_price.date_day
     *
     * @return the value of metal_zinc_price.date_day
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public String getDateDay() {
        return dateDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column metal_zinc_price.date_day
     *
     * @param dateDay the value for metal_zinc_price.date_day
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public void setDateDay(String dateDay) {
        this.dateDay = dateDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metal_zinc_price.price
     *
     * @return the value of metal_zinc_price.price
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column metal_zinc_price.price
     *
     * @param price the value for metal_zinc_price.price
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metal_zinc_price.gmt_created
     *
     * @return the value of metal_zinc_price.gmt_created
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column metal_zinc_price.gmt_created
     *
     * @param gmtCreated the value for metal_zinc_price.gmt_created
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metal_zinc_price.gmt_modified
     *
     * @return the value of metal_zinc_price.gmt_modified
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column metal_zinc_price.gmt_modified
     *
     * @param gmtModified the value for metal_zinc_price.gmt_modified
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
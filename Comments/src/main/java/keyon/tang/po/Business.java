package keyon.tang.po;

import java.math.BigDecimal;

public class Business {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.id
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.img_file_name
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private String imgFileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.title
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.subtitle
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private String subtitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.price
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.distance
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private Integer distance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.number
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private Integer number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.desc
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.city
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.category
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.star_total_num
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private Integer starTotalNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.comment_total_num
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    private Integer commentTotalNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.id
     *
     * @return the value of business.id
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.id
     *
     * @param id the value for business.id
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.img_file_name
     *
     * @return the value of business.img_file_name
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public String getImgFileName() {
        return imgFileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.img_file_name
     *
     * @param imgFileName the value for business.img_file_name
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName == null ? null : imgFileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.title
     *
     * @return the value of business.title
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.title
     *
     * @param title the value for business.title
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.subtitle
     *
     * @return the value of business.subtitle
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.subtitle
     *
     * @param subtitle the value for business.subtitle
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.price
     *
     * @return the value of business.price
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.price
     *
     * @param price the value for business.price
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.distance
     *
     * @return the value of business.distance
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.distance
     *
     * @param distance the value for business.distance
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.number
     *
     * @return the value of business.number
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.number
     *
     * @param number the value for business.number
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.desc
     *
     * @return the value of business.desc
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.desc
     *
     * @param desc the value for business.desc
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.city
     *
     * @return the value of business.city
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.city
     *
     * @param city the value for business.city
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.category
     *
     * @return the value of business.category
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.category
     *
     * @param category the value for business.category
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.star_total_num
     *
     * @return the value of business.star_total_num
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public Integer getStarTotalNum() {
        return starTotalNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.star_total_num
     *
     * @param starTotalNum the value for business.star_total_num
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setStarTotalNum(Integer starTotalNum) {
        this.starTotalNum = starTotalNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.comment_total_num
     *
     * @return the value of business.comment_total_num
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public Integer getCommentTotalNum() {
        return commentTotalNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.comment_total_num
     *
     * @param commentTotalNum the value for business.comment_total_num
     *
     * @mbg.generated Sun Apr 21 22:02:20 CST 2019
     */
    public void setCommentTotalNum(Integer commentTotalNum) {
        this.commentTotalNum = commentTotalNum;
    }
}
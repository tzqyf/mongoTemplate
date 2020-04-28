package com.mongodb.demo.entity;

/**
 *UserEntity实体对应的领域模型
 */
public class UserEntityDO {
    /**
     * 默认分页大小为5
     */
    private int pageSize = 5;

    /**
     * 默认当前页为1
     */
    private int currentPage = 1;

    private Long id;
    private String userName;
    private String passWord;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

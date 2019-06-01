package com.wyd.cat.model;

import java.util.Date;

public class Life {
    private Integer id;

    private String title;

    private String author;

    private String context;

    private String imgId;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    private String isDelete;
    
    private Date time;
    
    private String content1;
    private String img1;
    
    private String content2;
    private String img2;
    
    private String content3;
    private String img3;
    
    private String content4;
    private String img4;
    
    private String content5;
    private String img5;
    
    

    /** 
	* 获取content1 
	* @return content1
	*/
	public String getContent1() {
		return content1;
	}

	/** 
	* 设置content1 
	* @param content1 
	*/
	public void setContent1(String content1) {
		this.content1 = content1;
	}

	/** 
	* 获取img1 
	* @return img1
	*/
	public String getImg1() {
		return img1;
	}

	/** 
	* 设置img1 
	* @param img1 
	*/
	public void setImg1(String img1) {
		this.img1 = img1;
	}

	/** 
	* 获取content2 
	* @return content2
	*/
	public String getContent2() {
		return content2;
	}

	/** 
	* 设置content2 
	* @param content2 
	*/
	public void setContent2(String content2) {
		this.content2 = content2;
	}

	/** 
	* 获取img2 
	* @return img2
	*/
	public String getImg2() {
		return img2;
	}

	/** 
	* 设置img2 
	* @param img2 
	*/
	public void setImg2(String img2) {
		this.img2 = img2;
	}

	/** 
	* 获取content3 
	* @return content3
	*/
	public String getContent3() {
		return content3;
	}

	/** 
	* 设置content3 
	* @param content3 
	*/
	public void setContent3(String content3) {
		this.content3 = content3;
	}

	/** 
	* 获取img3 
	* @return img3
	*/
	public String getImg3() {
		return img3;
	}

	/** 
	* 设置img3 
	* @param img3 
	*/
	public void setImg3(String img3) {
		this.img3 = img3;
	}

	/** 
	* 获取content4 
	* @return content4
	*/
	public String getContent4() {
		return content4;
	}

	/** 
	* 设置content4 
	* @param content4 
	*/
	public void setContent4(String content4) {
		this.content4 = content4;
	}

	/** 
	* 获取img4 
	* @return img4
	*/
	public String getImg4() {
		return img4;
	}

	/** 
	* 设置img4 
	* @param img4 
	*/
	public void setImg4(String img4) {
		this.img4 = img4;
	}

	/** 
	* 获取content5 
	* @return content5
	*/
	public String getContent5() {
		return content5;
	}

	/** 
	* 设置content5 
	* @param content5 
	*/
	public void setContent5(String content5) {
		this.content5 = content5;
	}

	/** 
	* 获取img5 
	* @return img5
	*/
	public String getImg5() {
		return img5;
	}

	/** 
	* 设置img5 
	* @param img5 
	*/
	public void setImg5(String img5) {
		this.img5 = img5;
	}

	/** 
	* 获取time 
	* @return time
	*/
	public Date getTime() {
		return time;
	}

	/** 
	* 设置time 
	* @param time 
	*/
	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}
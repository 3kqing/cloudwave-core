package com.cloudwave.fwcore.entity.page;

import java.util.List;

/**
 * 分页类
 *
 * @author Van
 *
 * @param <T>
 */
public class PageEntity<T> {
	
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_ROW_NUM = 20;
	
    private int totalSize;
    /**分页诗数据*/
    private List<T> data;
    /**当前页码数据*/
    private int page;
    /**总页数*/
    private int total;
    /**每页数据量*/
    private int rows = DEFAULT_ROW_NUM;

    public int getRows() {

        return rows;
    }

    public void setRows(int rows) {

        this.rows = rows;
    }

    public int getPage() {

        return page;
    }

    public void setPage(int page) {

        this.page = page;
    }

    public int getTotal() {

        total = totalSize / rows;

        if ((totalSize % rows) != 0) {

            total = total + 1;
        }
        
        
        

        return total;
    }

    public void setTotal(int total) {

        this.total = total;
    }

    public int getTotalSize() {

        return totalSize;
    }

    public void setTotalSize(int totalSize) {

        this.totalSize = totalSize;
    }

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public PageEntity(QueryEntity query, int totalSize, List<T> data ) {
		super();
		this.totalSize = totalSize;
		this.data = data;
		this.page = query.getPi();
		this.rows = query.getRows();
	}
	
	/**
	 * 
	 * @param page 页码数
	 * @param rows 每页显示记录数
	 * @param totalSize 总行数
	 * @param data 数据
	 */
	public PageEntity(int page, int rows, int totalSize, List<T> data ) {
		super();
		this.totalSize = totalSize;
		this.data = data;
		this.page = page;
		this.rows = rows;
	}
	
	private int gameCount;
	private int softCount;

	public int getGameCount() {
		return gameCount;
	}

	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}

	public int getSoftCount() {
		return softCount;
	}

	public void setSoftCount(int softCount) {
		this.softCount = softCount;
	}
	
	

	
}

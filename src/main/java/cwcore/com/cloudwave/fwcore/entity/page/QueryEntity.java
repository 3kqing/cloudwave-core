package com.cloudwave.fwcore.entity.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用查询实体.
 * @author Van
 *
 */
public class QueryEntity {
	

	/**排序ID*/
	private String sortId="id";
	/**排序类型*/
	private String sortType="DESC";
	/**开始查询数据行*/
	private int start=0;
	/**每次查询数据量*/
	private int limit=15;
	/**页码数*/
	private int pi=1;
	/**查询附加参数*/
	private Map<String,Object> params;
	/**指定查询的字段*/
	private String columns;
	/**每页数据条数*/
	private int rows;

	public QueryEntity(String columns){
		this.columns=columns;
	}
	

	/**
	 * 产生缓存Key.
	 * @return
	 */
	public String generateCacheKey(){
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("sortId");
		sb.append("_");
		sb.append(sortId);
		sb.append("_");
		sb.append("sortType");
		sb.append("_");
		sb.append(sortType);
		sb.append("_");
		sb.append("start");
		sb.append("_");
		sb.append(start);
		sb.append("_");
		sb.append("limit");
		sb.append("_");
		sb.append(limit);
		
		//将Map中的Key加入缓存Key
		if(params!=null && params.size()>0){
			for(String key:params.keySet()){
				sb.append("_");
				sb.append(key);
				sb.append("_");
				sb.append(params.get(key));
			}
		}

		return sb.toString();
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}

	public QueryEntity() {
		super();
	}
	
	/**
	 * 构造1:
	 * @param sortId 排序id
	 * @param sortType 排序类型
	 * @param pi 页码数
	 * @param rows 每页数据条数
	 */
	public QueryEntity(String sortId, String sortType, int pi, int rows) {
		super();
		pi=pi<1?1:pi;
		this.sortId = sortId;
		this.sortType = sortType;
		this.pi = pi;
		this.rows = rows;
		this.start=(pi-1)*rows;
		this.limit=rows;
	}

	/**
	 * 构造2:
	 * @param pi 页码数
	 * @param rows 每页数据条数
	 */
	public QueryEntity(int pi,int rows) {
		
		super();
		if(pi<1){
			pi=1;
		}
		this.rows=rows;
		this.limit = rows;
		this.pi = pi;
		this.start=(pi-1)*limit;
		
	}
	
	
	public void put(String key,Object value){
		if(params==null){
			params=new HashMap<String,Object>();
		}
		params.put(key, value);
	}
	
	public void remove(String key){
		if(params==null){
			return;
		}
		
		if(params.containsKey(key)){
			params.remove(key);
		}
		
	}
	
	public Object get(String key){
		if(params!=null){
			return params.get(key);
		}
		return null;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
}

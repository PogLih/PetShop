package pet.petshop.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class BillDTO {
	@JsonIgnore
	private Integer id;
	
	private Integer date;
	@JsonIgnore
	private Integer userid;
	@JsonIgnore
	private Integer status;
	private Integer totalprice;
	public BillDTO(Integer id, Integer date, Integer userid, Integer status, Integer totalprice) {
		super();
		this.id = id;
		this.date = date;
		this.userid = userid;
		this.status = status;
		this.totalprice = totalprice;
	}
	public BillDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	
}

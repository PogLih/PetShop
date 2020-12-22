package pet.petshop.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BillStatusDTO {
	
	private Integer id;
	@JsonIgnore
	private Date date;
	@JsonIgnore
	private Integer userid;
	
	private Integer status;
	@JsonIgnore
	private Integer totalprice;
	
	
	public BillStatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillStatusDTO(Integer id, Date date, Integer userid, Integer status, Integer totalprice) {
		super();
		this.id = id;
		this.date = date;
		this.userid = userid;
		this.status = status;
		this.totalprice = totalprice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
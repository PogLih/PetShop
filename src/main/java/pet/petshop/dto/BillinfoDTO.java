package pet.petshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BillinfoDTO {
	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private Integer idbill;
	private String idproduct;
	private Integer countitem;
	
	public BillinfoDTO(Integer id, Integer idbill, String idproduct, Integer countitem) {
		super();
		this.id = id;
		this.idbill = idbill;
		this.idproduct = idproduct;
		this.countitem = countitem;
	}
	public BillinfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdbill() {
		return idbill;
	}
	public void setIdbill(Integer idbill) {
		this.idbill = idbill;
	}
	
	public String getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}
	public Integer getCountitem() {
		return countitem;
	}
	public void setCountitem(Integer countitem) {
		this.countitem = countitem;
	}
	
	
}

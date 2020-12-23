package pet.petshop.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	
	private int status;
	private int totalprice;
	@OneToMany(mappedBy = "bill",cascade = CascadeType.ALL)
	private Collection<BillInfo> billInfo;
	private int userid;
	@ManyToOne
	@JoinColumn(name = "userid",insertable=false, updatable=false )
	private User user;
	public Bill() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public Collection<BillInfo> getBillInfo() {
		return billInfo;
	}
	public void setBillInfo(Collection<BillInfo> billInfo) {
		this.billInfo = billInfo;
	}
	
	
}

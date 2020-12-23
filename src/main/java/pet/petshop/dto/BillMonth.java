package pet.petshop.dto;

import java.io.Serializable;

public class BillMonth implements Serializable {

    public BillMonth(int month, int totalprice) {
        this.month = month;
        this.totalprice = totalprice;
    }

    private int month;
    private int totalprice;
	@Override
	public String toString() {
		return "BillMonth [month=" + month + ", totalprice=" + totalprice + "]";
	}

    
}

package main;

public class Regular extends Kamar {
	protected String checkIn;
	protected int tinggal;
	protected String checkOut;
	protected String typeKamar;
	protected int price;
	
	public Regular(String nama, String dOB, String iD, String roomID, String fc, String checkIn, int tinggal,
			String checkOut, String typeKamar) {
		super(nama, dOB, iD, roomID, fc);
		this.checkIn = checkIn;
		this.tinggal = tinggal;
		this.checkOut = checkOut;
		this.typeKamar = typeKamar;
	}

	public String getTypeKamar() {
		return typeKamar;
	}
	public void setTypeKamar(String typeKamar) {
		this.typeKamar = typeKamar;
	}
	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public int getTinggal() {
		return tinggal;
	}

	public void setTinggal(int tinggal) {
		this.tinggal = tinggal;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void calculate(){
		if(this.typeKamar.equals("Standart")){
			this.price=500000;
		}
		else if(this.typeKamar.equals("Deluxe")){
			this.price = 750000;
		}
		else if (this.typeKamar.equals("Suite")){
			this.price = 1000000;
		}
		
		this.price = this.price * this.tinggal;
	}
	
	
	


}

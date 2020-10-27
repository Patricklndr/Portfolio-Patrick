package main;

public class Permanent extends Kamar{

	protected String checkIn;
	protected String checkOut;
	protected String extendStatus;
	protected int tinggal;
	protected String typeKamar;
	protected int price;
	
	public Permanent(String nama, String dOB, String iD, String roomID, String fc, String checkIn, String checkOut,
			String extendStatus, int tinggal, String typeKamar) {
		super(nama, dOB, iD, roomID, fc);
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.extendStatus = extendStatus;
		this.tinggal = tinggal;
		this.typeKamar = typeKamar;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
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

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getExtendStatus() {
		return extendStatus;
	}

	public void setExtendStatus(String extendStatus) {
		this.extendStatus = extendStatus;
	}

	public int getTinggal() {
		return tinggal;
	}

	public void setTinggal(int tinggal) {
		this.tinggal = tinggal;
	}

	public void calculate(){
		if(this.typeKamar.equals("Standart")){
			this.price=60000000;
		}
		else if(this.typeKamar.equals("Deluxe")){
			this.price = 75000000;
		}
		else if (this.typeKamar.equals("Suite")){
			this.price = 100000000;
		}
		
		this.price = this.price * this.tinggal;
	}
	
}

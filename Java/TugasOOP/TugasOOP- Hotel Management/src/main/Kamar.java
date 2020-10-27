package main;

public class Kamar {
	protected String nama;
	protected String DOB;
	protected String ID;
	protected String roomID;
	protected String fc;
	
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getFc() {
		return fc;
	}
	public void setFc(String fc) {
		this.fc = fc;
	}
	public Kamar(String nama, String dOB, String iD, String roomID, String fc) {
		super();
		this.nama = nama;
		DOB = dOB;
		ID = iD;
		this.roomID = roomID;
		this.fc = fc;
	}
	
}

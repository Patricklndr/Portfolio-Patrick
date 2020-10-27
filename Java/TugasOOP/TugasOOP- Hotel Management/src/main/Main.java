package main;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.lang.*;
import java.util.Calendar;
//import java.util.Date;
//import java.util.Locale;
//import javax.swing.JOptionPane;
//import javax.swing.JTextArea;
//import java.io.IOException;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<Regular> listReg = new Vector<Regular>();
	Vector<Permanent>listPmn = new Vector<Permanent>();

	public void sampleData1(){
		//Regular
		String nama = "";
		nama = "Patrick";
		
		String DOB = "";
		DOB = "13/02/2000";
		
		String ID = "";
		ID = "331103120200010101";
		
		String roomID ="";
		roomID ="REG001";
		
		String typeKamar = "";
		typeKamar = "Deluxe";
		
		String checkIn = "";
		checkIn ="17/06/2019";
		
		int tinggal = 0;
		tinggal = 3;
		
		String checkOut ="";
		checkOut ="19/06/2019";
		
		String fc ="";
		fc ="Smoking Room";
		
		Regular data = new Regular(nama, DOB, ID, roomID, fc, checkIn, tinggal, checkOut, typeKamar);
		listReg.add(data);
		data.calculate();
		
		//Permanent
		
	}
	
	public void sampleData2(){

		String nama = "";
		nama = "Komarudin";
		
		String DOB = "";
		DOB = "01/12/1989";
		
		String ID = "";
		ID = "33110301128910101";
		
		String roomID ="";
		roomID ="PMN001";
		
		String typeKamar = "";
		typeKamar = "Suite";
		
		String checkIn = "";
		checkIn ="22/08/2018";
		
		int tinggal = 0;
		tinggal = 1;
		
		String checkOut ="";
		checkOut ="22/08/2019";
		
		String fc ="";
		fc ="Street View";
		
		String extendStatus ="";
		extendStatus = "No";
		
		Permanent data = new Permanent(nama, DOB, ID, roomID, fc, checkIn, checkOut, extendStatus, tinggal, typeKamar);
		listPmn.add(data);
		data.calculate();
	}
	
	public void clearScreen(){
		for(int i = 0 ; i < 50 ; i++){
			System.out.println("");
		}
	}
	
	public void printMenu(){
		clearScreen();
		System.out.printf("-----------------------------------------------------------------------------------------\n");
		System.out.printf("|\t\t\t\t    - W E L C O M E -\t\t\t\t\t|\n");
		System.out.printf("|\t\t\t\t- B I N U S _ H O T E L -\t\t\t\t|\n");
		System.out.printf("-----------------------------------------------------------------------------------------\n");
		System.out.println("|1. Input Data of Guest to System\t\t\t\t\t\t\t|");
		System.out.println("|2. Search an Information of Guest\t\t\t\t\t\t\t|");
		System.out.println("|3. Delete Data of Guest\t\t\t\t\t\t\t\t|");
		System.out.println("|4. Update Data of a Guest\t\t\t\t\t\t\t\t|");
		System.out.println("|5. Exit\t\t\t\t\t\t\t\t\t\t|");
		System.out.printf("-----------------------------------------------------------------------------------------\n");
		System.out.print("Choose : ");
	}
	
	public void searchData(){
		int chooose =-1;
		do{
			viewAll();
			System.out.println("");
			printMenu1();
			try {
				chooose = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be an integer");
			}
			scan.nextLine();
			
			switch(chooose){
			case 1:
				clearScreen();
				viewJustPermanent();
				searchDataPermanent();
				break;
			case 2:
				clearScreen();
				viewJustRegular();
				searchDataRegular();
				break;
			}
		}while(chooose !=3);
	}
	
	public void searchDataRegular() {
		int cari = 0;
		int index=0;
		System.out.print("Input Number yg mau dicari : ");
		try {
			cari = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input Must be an Integer");
		}
		scan.nextLine();
		
		if(listReg.isEmpty()){
			System.out.println("No Data !");
		}else{
			for(int i =0; i<listReg.size();i++){
				if(i == (cari-1)){
					index = i;
				}else{
					System.out.println("No Data Found");
				}
			}
		}
		while(true){
			//Search Data berhasil
			System.out.println("\nData : ");
			System.out.println("Nama\t\t: "+listReg.get(index).getNama());
			System.out.println("ID\t\t: "+listReg.get(index).getID());
			System.out.println("Date Of Birth\t: "+listReg.get(index).getDOB());
			System.out.println("Room ID\t\t: "+listReg.get(index).getRoomID());
			System.out.println("Type Kamar\t: "+listReg.get(index).getTypeKamar());
			System.out.println("Check In\t: "+listReg.get(index).getCheckIn());
			System.out.println("Check Out\t: "+listReg.get(index).getCheckOut());
			System.out.println("Facilities\t: "+listReg.get(index).getFc());
			System.out.println("Price\t\t: "+listReg.get(index).getPrice());
			
			String exit;
			System.out.println("Exit [Yes/No] : ");
			exit = scan.nextLine();
		
			if(exit.equals("Yes")){
				clearScreen();
				break;
			}else if(exit.equals("No")){
				clearScreen();
			}
		}
	}
	
	public void searchDataPermanent() {
		int cari = 0;
		int index=0;
		System.out.print("Input Number yg mau dicari : ");
		try {
			cari = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input Must be an Integer");
		}
		scan.nextLine();
		
		if(listPmn.isEmpty()){
			System.out.println("No Data !");
		}else{
			for(int i =0; i<listPmn.size();i++){
				if(i == (cari-1)){
					index = i;
				}else{
					System.out.println("No Data Found");
				}
			}
		}
		while(true){
			//Search Data berhasil
			System.out.println("Data : ");
			System.out.println("Nama\t\t: "+listPmn.get(index).getNama());
			System.out.println("ID\t\t: "+listPmn.get(index).getID());
			System.out.println("Date Of Birth\t: "+listPmn.get(index).getDOB());
			System.out.println("Room ID\t: "+listPmn.get(index).getRoomID());
			System.out.println("Type Kamar\t: "+listPmn.get(index).getTypeKamar());
			System.out.println("Check In\t: "+listPmn.get(index).getCheckIn());
			System.out.println("Check Out\t: "+listPmn.get(index).getCheckOut());
			System.out.println("Facilities\t: "+listPmn.get(index).getFc());
			System.out.println("Price\t\t: "+listPmn.get(index).getPrice());

			String exit;
			System.out.println("Exit [Yes/No] : ");
			exit = scan.nextLine();
			
			if(exit.equals("Yes")){
				clearScreen();
				break;
			}else if(exit.equals("No")){
				clearScreen();
			}
		}
		
	}
	
	public void viewPermanent(){
		if(listPmn.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i =0 ; i < listPmn.size() ; i++){
				System.out.println((i+1)+"\t\t"+listPmn.get(i).getNama()+"\t\t"+listPmn.get(i).getID()+"\t\t"+listPmn.get(i).getRoomID()+"\t\t"+listPmn.get(i).getCheckIn()+"\t\t"+listPmn.get(i).getCheckOut()+"\t\t"+listPmn.get(i).getExtendStatus());
				
			}
		}
	}
	
	public void viewRegular(){
		if(listReg.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i = 0 ; i<listReg.size() ; i++){
				System.out.println((i+1)+"\t\t"+listReg.get(i).nama+"\t\t"+listReg.get(i).ID+"\t\t"+listReg.get(i).roomID+"\t\t"+listReg.get(i).checkIn+"\t\t"+listReg.get(i).checkOut+"\t\t"+listReg.get(i).typeKamar+"\t\t"+listReg.get(i).fc);
			}
		}
		
	}
	
	public void viewJustRegular(){
		System.out.println("");
		System.out.println("Regular");
		System.out.println("==============================================================");
		if(listReg.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i = 0 ; i < listReg.size() ; i++){
				System.out.printf("|No.|      Nama     |Room ID|Tipe Kamar| Check In | Check Out|\n");
				System.out.printf("--------------------------------------------------------------\n");
				System.out.printf("|%-3d|%-15s|%-7s|%-10s|%-10s|%-10s|", i+1, listReg.get(i).getNama(), listReg.get(i).getRoomID(), listReg.get(i).getTypeKamar(), listReg.get(i).getCheckIn(), listReg.get(i).getCheckOut());
				System.out.println("\n");
			}
		}
	}
	
	public void viewJustPermanent(){
		System.out.println("");
		System.out.println("Permanent");
		System.out.println("==============================================================");
		if(listPmn.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i=0 ; i<listPmn.size() ; i++){
				System.out.printf("|No.|      Nama     |Room ID|Tipe Kamar| Check In | Check Out|\n");
				System.out.printf("--------------------------------------------------------------\n");
				System.out.printf("|%-3d|%-15s|%-7s|%-10s|%-10s|%-10s|", i+1, listPmn.get(i).getNama(), listPmn.get(i).getRoomID(), listPmn.get(i).getTypeKamar(), listPmn.get(i).getCheckIn(), listPmn.get(i).getCheckOut());
				System.out.println("\n");
			}
		}
	}
	
	public void viewAll(){
		System.out.println("");
		System.out.println("Permanent");
		System.out.println("==============================================================");
		if(listPmn.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i=0 ; i<listPmn.size() ; i++){
				System.out.printf("|No.|      Nama     |Room ID|Tipe Kamar| Check In | Check Out|\n");
				System.out.printf("--------------------------------------------------------------\n");
				System.out.printf("|%-3d|%-15s|%-7s|%-10s|%-10s|%-10s|", i+1, listPmn.get(i).getNama(), listPmn.get(i).getRoomID(), listPmn.get(i).getTypeKamar(), listPmn.get(i).getCheckIn(), listPmn.get(i).getCheckOut());
				System.out.println("\n");
				//+"\t\t"+listPmn.get(i).getNama()+"\t\t"+listPmn.get(i).getRoomID()+"\t\t"+listPmn.get(i).getCheckIn()+"\t\t"+listPmn.get(i).getCheckOut()		
			}
		}
		
		System.out.println("");
		
		System.out.println("Regular");
		System.out.println("==============================================================");
		if(listReg.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i = 0 ; i < listReg.size() ; i++){
				System.out.printf("|No.|      Nama     |Room ID|Tipe Kamar| Check In | Check Out|\n");
				System.out.printf("--------------------------------------------------------------\n");
				System.out.printf("|%-3d|%-15s|%-7s|%-10s|%-10s|%-10s|", i+1, listReg.get(i).getNama(), listReg.get(i).getRoomID(), listReg.get(i).getTypeKamar(), listReg.get(i).getCheckIn(), listReg.get(i).getCheckOut());
				System.out.println("");
			}
			//System.out.println((i+1)+"\t\t"+listReg.get(i).getNama()+"\t\t"+listReg.get(i).getRoomID()+"\t\t"+listReg.get(i).getTypeKamar()+"\t\t"+listReg.get(i).getCheckIn()+"\t\t"+listReg.get(i).getCheckOut());
		}
		
	
		
		
	}
	
	public void printMenu1(){
		System.out.println("1. Permanent");
		System.out.println("2. Regular");
		System.out.println("3. Back");
		System.out.println("Choose :");
	}
	
	public void inputData(){
		int menu1 = -1;
		do{
			clearScreen();
			printMenu1();
			try {
				menu1 = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input Must be a Number ");
			}
			scan.nextLine();
			
			switch(menu1){
			case 1:
				inputDataPermanent();
				break;
			case 2:
				inputDataRegular();
				break;
			}
		}while(menu1 !=3);
	}
	
	public void inputDataRegular(){
				clearScreen();
				//Input Ke Vector
				//Input Nama
				String nama ="";
				Boolean cekNama =false;
				do{
					System.out.print("Input Nama [3-15] : ");
					nama = scan.nextLine();
					
					if(nama.length()>2 && nama.length()<16){
						cekNama = true;
					}
				}while(cekNama != true);
				
				//Input Tgl Ultah
				String DOB = "";
				Boolean cekDob = false;
				Boolean cekPnjg = false;
				do{
					System.out.print("Input Tanggal Lahir [dd/mm/yyyy] : ");
					DOB = scan.nextLine();
					
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					format.setLenient(false);
					
					String date = DOB;
					try {
						format.parse(date);
						cekDob = true;
					} catch (Exception e) {
						System.out.println("Date"+date+" is not valid according to "+((SimpleDateFormat)format).toPattern()+" pattern.");
					}
					
					if(DOB.length() == 10){
						cekPnjg = true;
					}
				}while(cekDob !=true || cekPnjg !=true);
				
				//Input ID
				//Contoh ID : 3311091912990003
				//Anggap 4 huruf pertama memang 3311
				String ID = "";
				//Boolean cekDpn = false;
				Boolean cektgl = false;
				Boolean cektotal = false;
				do{
					System.out.print("Input ID Number [KTP]:");
					ID = scan.nextLine();
					
					
					if(ID.length() == 16){
						cektotal = true;
					}else if(ID.length()<16){
						cektotal = false;
					}
//					if(cektotal == true){
//						System.out.println("3");
//					}else if(cektotal == false){
//						System.out.println("Salah3");
//					}
					//System.out.println(ID.length());
					
					String Tanggal = DOB;
					//Hilangin "/"
					StringBuilder str= new StringBuilder(Tanggal);
					str.deleteCharAt(2);
					//System.out.println(str);
					str.deleteCharAt(4);
					//System.out.println(str);
					
					//Hilangin Year jadi 2 angka
					str.deleteCharAt(4);
					str.deleteCharAt(4);
					//System.out.println(str);
					
					if(ID.length()<6){
						cektgl = false;
					}else{
						if(ID.charAt(6) == str.charAt(0) && ID.charAt(7) == str.charAt(1) && ID.charAt(8) == str.charAt(2) && ID.charAt(9) == str.charAt(3) && ID.charAt(10) == str.charAt(4) && ID.charAt(11) == str.charAt(5)){
							cektgl =true;
							
						}
//						if(cektgl == true){
//							System.out.println("2");
//						}else{
//							System.out.println("Salah2");
//						}
					}
					
					
				}while( cektgl != true || cektotal !=true);
				
				//Room ID
				//Nnti kalau sudah dimasukin vektor harus dicheck kalau mau input lagi supaya gaada roomnumber yg sama !
				int room = 0;
				String roomID = "";
				for(int i=0;i<3;i++){
					room = room + rand.nextInt(9);
				}
				if(room <=9){
					roomID ="REG00"+room;
				}else if(room > 9 && room <=99){
					roomID ="REG0"+room;
				}else{
					roomID ="REG"+room;
				}
				
				//Cek ROOM ID
				if(listReg.isEmpty()){
					System.out.println("No Data Avalaible");
				}else{
					for(int i=0; i<listReg.size();i++){
						if(listReg.get(i).getRoomID() == roomID){
							for(int j=0;j<3;j++){
								room = room + rand.nextInt(9);
							}
							if(room <=9){
								roomID ="REG00"+room;
							}else if(room > 9 && room <=99){
								roomID ="REG0"+room;
							}else{
								roomID ="REG"+room;
							}
							
							System.out.println("Nomor Kamar : "+roomID);
						}else{
							System.out.println("Nomor Kamar : "+roomID);
						}
					}
				}
				
				//Pilih Type Kamar
				String typeKamar = "";
				Boolean cekKamar = false;
				do{
					System.out.println("Type Kamar [Standart | Deluxe | Suite] : ");
					typeKamar = scan.nextLine();
					
					if(typeKamar.equals("Standart")|| typeKamar.equals("Deluxe") || typeKamar.equals("Suite")){
						cekKamar = true;
					}
				}while(cekKamar !=true);
				
				//Input Additional Facilities
				//Smoking Room | Balcony | Street View
				String fc = "";
				Boolean cekFc = false;
				System.out.println("[CASE SENSITIVE]");
				do{
					System.out.print("Input Another Facilities [Smoking Room | Balcony | Street View] : ");
					fc = scan.nextLine();
					
					if(fc.equals("Smoking Room") || fc.equals("Balcony") || fc.equals("Street View")){
						cekFc = true;
					}
				}while(cekFc != true);
				
				//Input Tgl CheckIn
//				String checkIn;	
//				Boolean cekCI = false; // Cek format
//				Boolean cekP = false; // Cek panjang
//				do{
//					System.out.print("Input Tanggal CheckIn [dd/mm/yyyy] : ");
//					checkIn = scan.nextLine();
//					
//					DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
//					format.setLenient(false);
//					
//					String date = checkIn;
//					try {
//						format.parse(date);
//						cekCI = true;
//					} catch (Exception e) {
//						System.out.println("Date"+date+" is not valid according to "+((SimpleDateFormat)format).toPattern()+" pattern.");
//					}
//					
//					if(checkIn.length() == 10){
//						cekP = true;
//					}
//				}while(cekCI != true || cekP != true);
				
				//CheckIn Pake waktu sekarang
				Calendar now = Calendar.getInstance();
				System.out.println("Tanggal Check In : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
				int CI1 = now.get(Calendar.DATE);
				int CI2 = now.get(Calendar.MONTH)+1;
				int CI3 = now.get(Calendar.YEAR);
				String checkIn1 = CI1+"/"+CI2+"/"+CI3;
			
				//System.out.println(checkIn1);
				
				
				//Tanya berapa lama Tinggal
				int tinggal = 0;
				System.out.print("Berapa Malam di Hotel ? ");
				try {
					tinggal = scan.nextInt();
				} catch (Exception e) {
					System.out.println("Input must be an integer");
				}
				scan.nextLine();
							
				//Hitung Tanggal Check Out
				now.add(Calendar.DATE, tinggal);
				System.out.println("Tanggal Check Out : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
				int CI4 = now.get(Calendar.DATE);
				int CI5 = now.get(Calendar.MONTH);
				int CI6 = now.get(Calendar.YEAR);
				String checkIn2 = CI4+"/"+CI5+"/"+CI6;
				
//				System.out.println(checkIn2);
				
				
				
				String save;
				Boolean cekSave = false;
				do{
					System.out.println("Save Data [Yes / No]: ");
					save = scan.nextLine();
					
					if(save.equals("Yes") || save.equals("No")){
						cekSave = true;
					}
					
					if(save.equals("Yes")){
						//MASUK VECTORRR
						Regular data = new Regular(nama, DOB, ID, roomID, fc, checkIn1, tinggal, checkIn2, typeKamar);
						listReg.add(data);
						data.calculate();
					}else if(save.equals("No")){
						break;
					}
				}while(cekSave != true);
				
				
				
	}
	
	public void inputDataPermanent() {
		clearScreen();
		//Input Ke Vector
		//Input Nama
		String nama;
		Boolean cekNama =false;
		do{
			System.out.print("Input Nama [3-15] : ");
			nama = scan.nextLine();
			
			if(nama.length()>2 && nama.length()<16){
				cekNama = true;
			}
		}while(cekNama != true);
		
		//Input Tgl Ultah
		String DOB;
		Boolean cekDob = false;
		Boolean cekPnjg = false;
		do{
			System.out.print("Input Tanggal Lahir [dd/mm/yyyy] : ");
			DOB = scan.nextLine();
			
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			format.setLenient(false);
			
			String date = DOB;
			try {
				format.parse(date);
				cekDob = true;
			} catch (Exception e) {
				System.out.println("Date"+date+" is not valid according to "+((SimpleDateFormat)format).toPattern()+" pattern.");
			}
			
			if(DOB.length() == 10){
				cekPnjg = true;
			}
		}while(cekDob !=true || cekPnjg !=true);
		
		//Input ID
		//Contoh ID : 3311091912990003
		//Anggap 4 huruf pertama memang 3311
		String ID = "";
		//Boolean cekDpn = false;
		Boolean cektgl = false;
		Boolean cektotal = false;
		do{
			System.out.print("Input ID Number [KTP]:");
			ID = scan.nextLine();
			
			
			if(ID.length() == 16){
				cektotal = true;
			}else if(ID.length()<16){
				cektotal = false;
			}
//			if(cektotal == true){
//				System.out.println("3");
//			}else if(cektotal == false){
//				System.out.println("Salah3");
//			}
			//System.out.println(ID.length());
			
			String Tanggal = DOB;
			//Hilangin "/"
			StringBuilder str= new StringBuilder(Tanggal);
			str.deleteCharAt(2);
			//System.out.println(str);
			str.deleteCharAt(4);
			//System.out.println(str);
			
			//Hilangin Year jadi 2 angka
			str.deleteCharAt(4);
			str.deleteCharAt(4);
			//System.out.println(str);
			
			if(ID.length()<6){
				cektgl = false;
			}else{
				if(ID.charAt(6) == str.charAt(0) && ID.charAt(7) == str.charAt(1) && ID.charAt(8) == str.charAt(2) && ID.charAt(9) == str.charAt(3) && ID.charAt(10) == str.charAt(4) && ID.charAt(11) == str.charAt(5)){
					cektgl =true;
					
				}
//				if(cektgl == true){
//					System.out.println("2");
//				}else{
//					System.out.println("Salah2");
//				}
			}
			
			
		}while( cektgl != true || cektotal !=true);
		
		
		//Pilih Type Kamar
		String typeKamar;
		Boolean cekKamar = false;
		do{
			System.out.println("Type Kamar [Standart | Deluxe | Suite] : ");
			typeKamar = scan.nextLine();
			
			if(typeKamar.equals("Standart")|| typeKamar.equals("Deluxe") || typeKamar.equals("Suite")){
				cekKamar = true;
			}
		}while(cekKamar !=true);
		
		//Room ID
		//Nnti kalau sudah dimasukin vektor harus dicheck kalau mau input lagi supaya gaada roomnumber yg sama !
		int room = 0;
		String roomID;
		for(int i=0;i<3;i++){
			room = room + rand.nextInt(9);
		}
		if(room <=9){
			roomID ="PMN00"+room;
		}else if(room > 9 && room <=99){
			roomID ="PMN0"+room;
		}else{
			roomID ="PMN"+room;
		}
		
		//Cek ROOM ID
		if(listPmn.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i=0; i<listPmn.size();i++){
				if(listPmn.get(i).getRoomID() == roomID){
					for(int j=0;j<3;j++){
						room = room + rand.nextInt(9);
					}
					if(room <=9){
						roomID ="PMN00"+room;
					}else if(room > 9 && room <=99){
						roomID ="PMN0"+room;
					}else{
						roomID ="PMN"+room;
					}
					
					System.out.println("Nomor Kamar : "+roomID);
				}else{
					System.out.println("Nomor Kamar : "+roomID);
				}
			}
		}
		
		
		//Input Additional Facilities
		//Smoking Room | Balcony | Street View
		String fc;
		Boolean cekFc = false;
		System.out.println("[CASE SENSITIVE]");
		do{
			System.out.print("Input Another Facilities [Smoking Room | Balcony | Street View] : ");
			fc = scan.nextLine();
			
			if(fc.equals("Smoking Room") || fc.equals("Balcony") || fc.equals("Street View")){
				cekFc = true;
			}
		}while(cekFc != true);
		
		//CheckIn Pake waktu sekarang
		Calendar now = Calendar.getInstance();
		System.out.println("Tanggal Check In : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
		int CI1 = now.get(Calendar.DATE);
		int CI2 = now.get(Calendar.MONTH)+1;
		int CI3 = now.get(Calendar.YEAR);
		String checkIn3 = CI1+"/"+CI2+"/"+CI3;
	
		//System.out.println(checkIn1);
		
		
		//Tanya berapa lama Tinggal
		int tinggal = 0;
		System.out.print("Berapa Lama Sewa [Min 1 Tahun]? ");
		try {
			tinggal = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input must be an integer");
		}
		scan.nextLine();
					
		//Hitung Tanggal Check Out
		now.add(Calendar.YEAR, tinggal);
		System.out.println("Tanggal Check Out : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
		int CI4 = now.get(Calendar.DATE);
		int CI5 = now.get(Calendar.MONTH);
		int CI6 = now.get(Calendar.YEAR);
		String checkIn4 = CI4+"/"+CI5+"/"+CI6;
		
//		System.out.println(checkIn2);
		
		//Extend Status
		String extendStatus;
		Boolean cekE = false;
		do{
			System.out.print("Extend Status [Yes|No]: ");
			extendStatus =scan.nextLine();
			
			if(extendStatus.equals("Yes") || extendStatus.equals("No")){
				cekE = true;
			}
		}while(cekE != true);
		
		String save;
		Boolean cekSave = false;
		do{
			System.out.println("Save Data [Yes / No]: ");
			save = scan.nextLine();
			
			if(save.equals("Yes") || save.equals("No")){
				cekSave = true;
			}
			
			if(save.equals("Yes")){
				//MASUK VECTORRR
				Permanent data = new Permanent(nama, DOB, ID, roomID, fc, checkIn3, checkIn4, extendStatus, tinggal,typeKamar);
				listPmn.add(data);
				data.calculate();
			}else if(save.equals("No")){
				break;
			}
		}while(cekSave != true);


	}
	
	public void deleteData() {
		viewAll();
		System.out.println("");
		printMenu1();
		int choose =0;
		try {
			choose = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input must be an integer");
		}
		scan.nextLine();
		
		switch(choose){
		case 1:
			viewPermanent();
			deleteDataPermanent();
			break;
		case 2:
			viewRegular();
			deleteDataRegular();
			break;
		}
		
		

	}

	public void deleteDataPermanent(){
		int cari = 0;
		System.out.println("Input Number mau didelete : ");
		try {
			cari = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input must be an integer");
		}
		scan.nextLine();
		
		int index=0;
		if(listPmn.isEmpty()){
			System.out.println("No data");
		}else{
			for(int i = 0; i<listPmn.size();i++){
				if(i == (cari-1)){
					index = i;
				}else{
					System.out.println("Data not Found");
				}
			}
		}
		
		//Delete data index
		//tampilkan dlu indexnya
		System.out.println("Data : ");
		System.out.println("Nama\t\t: "+listPmn.get(index).getNama());
		System.out.println("ID\t\t: "+listPmn.get(index).getID());
		System.out.println("Date Of Birth\t: "+listPmn.get(index).getDOB());
		System.out.println("Room ID\t: "+listPmn.get(index).getRoomID());
		System.out.println("Type Kamar\t: "+listPmn.get(index).getTypeKamar());
		System.out.println("Check In\t: "+listPmn.get(index).getCheckIn());
		System.out.println("Check Out\t: "+listPmn.get(index).getCheckOut());
		System.out.println("Facilities\t: "+listPmn.get(index).getFc());
		
		String delDat;
		System.out.println("Are you sure want to delete this data ? [Yes/No] : ");
		delDat = scan.nextLine();
		
		if(delDat.equals("Yes")){
			listPmn.remove(index);
		}else if(delDat.equals("No")){
			clearScreen();
		}
		
	}
	
	public void deleteDataRegular(){
		int cari = 0;
		System.out.println("Input Number mau didelete : ");
		try {
			cari = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input must be an integer");
		}
		scan.nextLine();
		
		int index=0;
		if(listReg.isEmpty()){
			System.out.println("No data");
		}else{
			for(int i = 0; i<listReg.size();i++){
				if(i == (cari-1)){
					index = i;
				}else{
					System.out.println("Data not Found");
				}
			}
		}
		
		//Delete data index
		//tampilkan dlu indexnya
		System.out.println("Data : ");
		System.out.println("Nama\t\t: "+listReg.get(index).getNama());
		System.out.println("ID\t\t: "+listReg.get(index).getID());
		System.out.println("Date Of Birth\t: "+listReg.get(index).getDOB());
		System.out.println("Room ID\t: "+listReg.get(index).getRoomID());
		System.out.println("Type Kamar\t: "+listReg.get(index).getTypeKamar());
		System.out.println("Check In\t: "+listReg.get(index).getCheckIn());
		System.out.println("Check Out\t: "+listReg.get(index).getCheckOut());
		System.out.println("Facilities\t: "+listReg.get(index).getFc());
		
		String delDat;
		System.out.println("Are you sure want to delete this data ? [Yes/No] : ");
		delDat = scan.nextLine();
		
		if(delDat.equals("Yes")){
			listReg.remove(index);
		}else if(delDat.equals("No")){
			clearScreen();
		}
	}
	
	public void updateData() {
		viewAll();
		System.out.println("");
		printMenu1();
		
		int choose =0;
		try {
			choose = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input harus integer");
		}
		scan.nextLine();
		
		switch(choose){
		case 1:
			viewPermanent();
			updateDataPermanent();
			break;
		case 2:
			viewRegular();
			updateDataRegular();
			break;
			
		}
	
	}
	
	public void updateDataRegular(){
		if(listReg.isEmpty()){
			return;
		}
		
		int cari =0;
		System.out.println("Input number mau di update :");
		try {
			cari = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input harus integer");
		}
		scan.nextLine();
		int index =0;
		if(listReg.isEmpty()){
			System.out.println("Kosong");
		}else{
			for(int i=0;i < listReg.size();i++){
				if(i == (cari-1)){
					index =i;
				}else{
					System.out.println("gaketemu");
				}
			}
		}
		
		//insert
		//Input Ke Vector
		//Input Nama
		String nama ="";
		Boolean cekNama =false;
		do{
			System.out.print("Input Nama [3-15] : ");
			nama = scan.nextLine();
			
			if(nama.length()>2 && nama.length()<16){
				cekNama = true;
			}
		}while(cekNama != true);
		
		//Input Tgl Ultah
		String DOB = "";
		Boolean cekDob = false;
		Boolean cekPnjg = false;
		do{
			System.out.print("Input Tanggal Lahir [dd/mm/yyyy] : ");
			DOB = scan.nextLine();
			
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			format.setLenient(false);
			
			String date = DOB;
			try {
				format.parse(date);
				cekDob = true;
			} catch (Exception e) {
				System.out.println("Date"+date+" is not valid according to "+((SimpleDateFormat)format).toPattern()+" pattern.");
			}
			
			if(DOB.length() == 10){
				cekPnjg = true;
			}
		}while(cekDob !=true || cekPnjg !=true);
		
		//Input ID
		//Contoh ID : 3311091912990003
		//Anggap 4 huruf pertama memang 3311
		String ID = "";
		//Boolean cekDpn = false;
		Boolean cektgl = false;
		Boolean cektotal = false;
		do{
			System.out.print("Input ID Number [KTP]:");
			ID = scan.nextLine();
			
			
			if(ID.length() == 16){
				cektotal = true;
			}else if(ID.length()<16){
				cektotal = false;
			}
//			if(cektotal == true){
//				System.out.println("3");
//			}else if(cektotal == false){
//				System.out.println("Salah3");
//			}
			//System.out.println(ID.length());
			
			String Tanggal = DOB;
			//Hilangin "/"
			StringBuilder str= new StringBuilder(Tanggal);
			str.deleteCharAt(2);
			//System.out.println(str);
			str.deleteCharAt(4);
			//System.out.println(str);
			
			//Hilangin Year jadi 2 angka
			str.deleteCharAt(4);
			str.deleteCharAt(4);
			//System.out.println(str);
			
			if(ID.length()<6){
				cektgl = false;
			}else{
				if(ID.charAt(6) == str.charAt(0) && ID.charAt(7) == str.charAt(1) && ID.charAt(8) == str.charAt(2) && ID.charAt(9) == str.charAt(3) && ID.charAt(10) == str.charAt(4) && ID.charAt(11) == str.charAt(5)){
					cektgl =true;
					
				}
//				if(cektgl == true){
//					System.out.println("2");
//				}else{
//					System.out.println("Salah2");
//				}
			}
			
			
		}while( cektgl != true || cektotal !=true);
		
		
		//Room ID
		//Nnti kalau sudah dimasukin vektor harus dicheck kalau mau input lagi supaya gaada roomnumber yg sama !
		int room = 0;
		String roomID = "";
		for(int i=0;i<3;i++){
			room = room + rand.nextInt(9);
		}
		if(room <=9){
			roomID ="REG00"+room;
		}else if(room > 9 && room <=99){
			roomID ="REG0"+room;
		}else{
			roomID ="REG"+room;
		}
		
		//Cek ROOM ID
		if(listReg.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i=0; i<listReg.size();i++){
				if(listReg.get(i).getRoomID() == roomID){
					for(int j=0;j<3;j++){
						room = room + rand.nextInt(9);
					}
					if(room <=9){
						roomID ="REG00"+room;
					}else if(room > 9 && room <=99){
						roomID ="REG0"+room;
					}else{
						roomID ="REG"+room;
					}
					
					System.out.println("Nomor Kamar : "+roomID);
				}else{
					System.out.println("Nomor Kamar : "+roomID);
				}
			}
		}
		
		//Pilih Type Kamar
		String typeKamar = "";
		Boolean cekKamar = false;
		do{
			System.out.println("Type Kamar [Standart | Deluxe | Suite] : ");
			typeKamar = scan.nextLine();
			
			if(typeKamar.equals("Standart")|| typeKamar.equals("Deluxe") || typeKamar.equals("Suite")){
				cekKamar = true;
			}
		}while(cekKamar !=true);
		
		//Input Additional Facilities
		//Smoking Room | Balcony | Street View
		String fc = "";
		Boolean cekFc = false;
		System.out.println("[CASE SENSITIVE]");
		do{
			System.out.print("Input Another Facilities [Smoking Room | Balcony | Street View] : ");
			fc = scan.nextLine();
			
			if(fc.equals("Smoking Room") || fc.equals("Balcony") || fc.equals("Street View")){
				cekFc = true;
			}
		}while(cekFc != true);
		
		//Input Tgl CheckIn
//		String checkIn;	
//		Boolean cekCI = false; // Cek format
//		Boolean cekP = false; // Cek panjang
//		do{
//			System.out.print("Input Tanggal CheckIn [dd/mm/yyyy] : ");
//			checkIn = scan.nextLine();
//			
//			DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
//			format.setLenient(false);
//			
//			String date = checkIn;
//			try {
//				format.parse(date);
//				cekCI = true;
//			} catch (Exception e) {
//				System.out.println("Date"+date+" is not valid according to "+((SimpleDateFormat)format).toPattern()+" pattern.");
//			}
//			
//			if(checkIn.length() == 10){
//				cekP = true;
//			}
//		}while(cekCI != true || cekP != true);
		
		//CheckIn Pake waktu sekarang
		Calendar now = Calendar.getInstance();
		System.out.println("Tanggal Check In : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
		int CI1 = now.get(Calendar.DATE);
		int CI2 = now.get(Calendar.MONTH)+1;
		int CI3 = now.get(Calendar.YEAR);
		String checkIn1 = CI1+"/"+CI2+"/"+CI3;
	
		//System.out.println(checkIn1);
		
		
		//Tanya berapa lama Tinggal
		int tinggal = 0;
		System.out.print("Berapa Malam di Hotel ? ");
		try {
			tinggal = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input must be an integer");
		}
		scan.nextLine();
					
		//Hitung Tanggal Check Out
		now.add(Calendar.DATE, tinggal);
		System.out.println("Tanggal Check Out : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
		int CI4 = now.get(Calendar.DATE);
		int CI5 = now.get(Calendar.MONTH);
		int CI6 = now.get(Calendar.YEAR);
		String checkIn2 = CI4+"/"+CI5+"/"+CI6;
		
		
		
		String save;
		Boolean cekSave = false;
		do{
			System.out.println("Save Data [Yes / No]: ");
			save = scan.nextLine();
			
			if(save.equals("Yes") || save.equals("No")){
				cekSave = true;
			}
			
			if(save.equals("Yes")){
				//MASUK VECTORRR
				Regular data = new Regular(nama, DOB, ID, roomID, fc, checkIn1, tinggal, checkIn2, typeKamar);
				listReg.set(index,data);
				data.calculate();
			}else if(save.equals("No")){
				break;
			}
		}while(cekSave != true);
		
		
	}
	
	public void updateDataPermanent(){
		if(listPmn.isEmpty()){
			return;
		}
		
		int cari =0;
		System.out.println("Input number mau di update :");
		try {
			cari = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input harus integer");
		}
		scan.nextLine();
		int index =0;
		if(listPmn.isEmpty()){
			System.out.println("Kosong");
		}else{
			for(int i=0;i < listPmn.size();i++){
				if(i == (cari-1)){
					index =i;
				}else{
					System.out.println("gaketemu");
				}
			}
		}
		
		//Insert lagi
		String nama;
		Boolean cekNama =false;
		do{
			System.out.print("Input Nama [3-15] : ");
			nama = scan.nextLine();
			
			if(nama.length()>2 && nama.length()<16){
				cekNama = true;
			}
		}while(cekNama != true);
		
		//Input Tgl Ultah
		String DOB;
		Boolean cekDob = false;
		Boolean cekPnjg = false;
		do{
			System.out.print("Input Tanggal Lahir [dd/mm/yyyy] : ");
			DOB = scan.nextLine();
			
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			format.setLenient(false);
			
			String date = DOB;
			try {
				format.parse(date);
				cekDob = true;
			} catch (Exception e) {
				System.out.println("Date"+date+" is not valid according to "+((SimpleDateFormat)format).toPattern()+" pattern.");
			}
			
			if(DOB.length() == 10){
				cekPnjg = true;
			}
		}while(cekDob !=true || cekPnjg !=true);
		
		//Input ID
		//Contoh ID : 3311091912990003
		//Anggap 4 huruf pertama memang 3311
		String ID = "";
		//Boolean cekDpn = false;
		Boolean cektgl = false;
		Boolean cektotal = false;
		do{
			System.out.print("Input ID Number [KTP]:");
			ID = scan.nextLine();
			
			
			if(ID.length() == 16){
				cektotal = true;
			}else if(ID.length()<16){
				cektotal = false;
			}
//			if(cektotal == true){
//				System.out.println("3");
//			}else if(cektotal == false){
//				System.out.println("Salah3");
//			}
			//System.out.println(ID.length());
			
			String Tanggal = DOB;
			//Hilangin "/"
			StringBuilder str= new StringBuilder(Tanggal);
			str.deleteCharAt(2);
			//System.out.println(str);
			str.deleteCharAt(4);
			//System.out.println(str);
			
			//Hilangin Year jadi 2 angka
			str.deleteCharAt(4);
			str.deleteCharAt(4);
			//System.out.println(str);
			
			if(ID.length()<6){
				cektgl = false;
			}else{
				if(ID.charAt(6) == str.charAt(0) && ID.charAt(7) == str.charAt(1) && ID.charAt(8) == str.charAt(2) && ID.charAt(9) == str.charAt(3) && ID.charAt(10) == str.charAt(4) && ID.charAt(11) == str.charAt(5)){
					cektgl =true;
					
				}
//				if(cektgl == true){
//					System.out.println("2");
//				}else{
//					System.out.println("Salah2");
//				}
			}
			
			
		}while( cektgl != true || cektotal !=true);
		
		
		//Pilih Type Kamar
		String typeKamar;
		Boolean cekKamar = false;
		do{
			System.out.println("Type Kamar [Standart | Deluxe | Suite] : ");
			typeKamar = scan.nextLine();
			
			if(typeKamar.equals("Standart")|| typeKamar.equals("Deluxe") || typeKamar.equals("Suite")){
				cekKamar = true;
			}
		}while(cekKamar !=true);
		
		//Room ID
		//Nnti kalau sudah dimasukin vektor harus dicheck kalau mau input lagi supaya gaada roomnumber yg sama !
		int room = 0;
		String roomID;
		for(int i=0;i<3;i++){
			room = room + rand.nextInt(9);
		}
		if(room <=9){
			roomID ="PMN00"+room;
		}else if(room > 9 && room <=99){
			roomID ="PMN0"+room;
		}else{
			roomID ="PMN"+room;
		}
		
		//Cek ROOM ID
		if(listPmn.isEmpty()){
			System.out.println("No Data Avalaible");
		}else{
			for(int i=0; i<listPmn.size();i++){
				if(listPmn.get(i).getRoomID() == roomID){
					for(int j=0;j<3;j++){
						room = room + rand.nextInt(9);
					}
					if(room <=9){
						roomID ="PMN00"+room;
					}else if(room > 9 && room <=99){
						roomID ="PMN0"+room;
					}else{
						roomID ="PMN"+room;
					}
					
					System.out.println("Nomor Kamar : "+roomID);
				}else{
					System.out.println("Nomor Kamar : "+roomID);
				}
			}
		}
		
		
		//Input Additional Facilities
		//Smoking Room | Balcony | Street View
		String fc;
		Boolean cekFc = false;
		System.out.println("[CASE SENSITIVE]");
		do{
			System.out.print("Input Another Facilities [Smoking Room | Balcony | Street View] : ");
			fc = scan.nextLine();
			
			if(fc.equals("Smoking Room") || fc.equals("Balcony") || fc.equals("Street View")){
				cekFc = true;
			}
		}while(cekFc != true);
		
		//CheckIn Pake waktu sekarang
				Calendar now = Calendar.getInstance();
				System.out.println("Tanggal Check In : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
				int CI1 = now.get(Calendar.DATE);
				int CI2 = now.get(Calendar.MONTH)+1;
				int CI3 = now.get(Calendar.YEAR);
				String checkIn3 = CI1+"/"+CI2+"/"+CI3;
			
				//System.out.println(checkIn1);
				
				
				//Tanya berapa lama Tinggal
				int tinggal = 0;
				System.out.print("Berapa Lama Sewa [Min 1 Tahun]? ");
				try {
					tinggal = scan.nextInt();
				} catch (Exception e) {
					System.out.println("Input must be an integer");
				}
				scan.nextLine();
							
				//Hitung Tanggal Check Out
				now.add(Calendar.YEAR, tinggal);
				System.out.println("Tanggal Check Out : "+now.get(Calendar.DATE)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.YEAR));
				int CI4 = now.get(Calendar.DATE);
				int CI5 = now.get(Calendar.MONTH);
				int CI6 = now.get(Calendar.YEAR);
				String checkIn4 = CI4+"/"+CI5+"/"+CI6;
		
		//Extend Status
		String extendStatus;
		Boolean cekE = false;
		do{
			System.out.print("Extend Status [Yes|No]: ");
			extendStatus =scan.nextLine();
			
			if(extendStatus.equals("Yes") || extendStatus.equals("No")){
				cekE = true;
			}
		}while(cekE != true);
		
		String save;
		Boolean cekSave = false;
		do{
			System.out.println("Save Data [Yes / No]: ");
			save = scan.nextLine();
			
			if(save.equals("Yes") || save.equals("No")){
				cekSave = true;
			}
			
			if(save.equals("Yes")){
				//MASUK VECTORRR
				Permanent data = new Permanent(nama, DOB, ID, roomID, fc, checkIn3, checkIn4, extendStatus, tinggal,typeKamar);
				listPmn.set(index, data);
				data.calculate();
			}else if(save.equals("No")){
				break;
			}
		}while(cekSave != true);
	}
	
	public Main() {
		//Buat MENU	
		int menu =-1;
		sampleData1();
		sampleData2();
		do{

			printMenu();
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input Must be an Integer ");
			}
			scan.nextLine();
			
			switch(menu){
			case 1:
				inputData();
				break;
			case 2:
				searchData();
				break;
			case 3:
				deleteData();
				break;
			case 4:
				updateData();
				break;
				
			}
			
		}while(menu !=5);
	}

	public static void main(String[] args) {
		new Main();

	}

}

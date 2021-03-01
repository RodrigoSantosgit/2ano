package aula2;

import java.util.Scanner;

public class Prob2_1Menu {

	public static void main(String[] args) {
		
		VideoClub vc = new VideoClub(3);
		Scanner opt = new Scanner(System.in);
		int op;
		
		do {
			System.out.println();
			System.out.println("  ---------------------------- ");
			System.out.println("  --  VideoClub Management  -- ");
			System.out.println("  ---------------------------- ");
			System.out.println("  1. Add Video");
			System.out.println("  2. Add Partner");
			System.out.println("  3. List Video by Rating");
			System.out.println("  4. List Videos");
			System.out.println("  5. Check Video Availability");
			System.out.println("  6. Check Requests by Partner");
			System.out.println("  7. Check Requests by Video");
			System.out.println("  8. Check Out");
			System.out.println("  9. Check In");
			System.out.println("  10. Remove Video");
			System.out.println("  11. Remove Partner");
			System.out.println("  12. End");
			System.out.println("  ---------------------------- ");
			System.out.print(" >>> ");
			
			op = opt.nextInt();
			
			switch(op) {
				case 1:
					String gb = opt.nextLine();
					System.out.println("Title: ");
					String t = opt.nextLine();
					System.out.println("Category: ");
					String c = opt.nextLine();
					System.out.println("Age: ");
					String a = opt.nextLine();
					
					vc.addVideo(new Video(t, c, a));
					break;
					
				case 2:
					gb = opt.nextLine();
					System.out.println("Name: ");
					String n = opt.nextLine();
					System.out.println("Num CC: ");
					int numCC = opt.nextInt();
					gb = opt.nextLine();
					System.out.println("Date of Birth (dd-mm-yy): ");
					String data = opt.nextLine();
						
					String[] comp = data.split("-");
					Data d = new Data(Integer.parseInt(comp[0]),Integer.parseInt(comp[1]),Integer.parseInt(comp[2]));
					
					System.out.println("Date of Partnership (dd-mm-yy): ");
					String datap = opt.nextLine();
						
					String[] compp = datap.split("-");
					Data dp = new Data(Integer.parseInt(compp[0]),Integer.parseInt(compp[1]),Integer.parseInt(compp[2]));
					
					
					System.out.println("Type: ");
					String type = opt.nextLine();
					if(type.toLowerCase().equals("student")) {
						System.out.println("Num Mec: ");
						int numMec = opt.nextInt();
						gb = opt.nextLine();
						System.out.println("Course: ");
						String course = opt.nextLine();
						vc.addPartner(new Student(n, numCC, d, dp, numMec, course));
					}
					else{
						if(type.toLowerCase().equals("employee")) {
							System.out.println("NIF: ");
							int nif = opt.nextInt();
							System.out.println("Num Employee: ");
							int numEmp = opt.nextInt();
							vc.addPartner(new Employee(n, numCC, d, dp, nif, numEmp));
						}
						else
							System.out.println("Invalid Type");
					}
					break;
					
				case 3:
					Video[] v = vc.sortRatings();
					System.out.println("Videos sorted: ");
					for(int i = 0; i < v.length; i++) {
						System.out.println(v[i].toString() + ", Rating: " + v[i].getRating());
					}
					break;
					
				case 4:
					v = vc.getVideos();
					System.out.println("Videos: ");
					for(int i = 0; i < v.length; i++) {
						System.out.println(v[i].toString());
					}
					break;
				
				case 5:
					System.out.println("Video ID: ");
					int id2 = opt.nextInt();
					System.out.println("Available: " + vc.checkVideoAvailability(id2));
					break;
					
				case 6:
					System.out.println("Partner ID:");
					id2 = opt.nextInt();
					System.out.println(vc.getRequestsByPartner(id2));
					break;
				
				case 7:
					System.out.println("Video ID:");
					id2 = opt.nextInt();
					System.out.println(vc.getRequestsByVideo(id2));
					break;
					
				case 8:
					System.out.println("Video ID:");
					int vdIDr = opt.nextInt();
					System.out.println("Partner ID:");
					int pIDr = opt.nextInt();
					
					if(vc.checkOut(vdIDr, pIDr))
						System.out.println("Check Out Sucess!");
					else
						System.out.println("Invalid Check Out!");
					break;
				
				case 9:
					System.out.println("Video ID: ");
					int vdID = opt.nextInt();
					System.out.println("Partner ID: ");
					int pID = opt.nextInt();
					System.out.println("Rating: ");
					int r = opt.nextInt();
					
					if(vc.checkIn(vdID, pID, r))
						System.out.println("Check In Sucess!");
					else
						System.out.println("Invalid Check In!");
					break;
					
				case 10:
					System.out.println("Video ID:");
					id2 = opt.nextInt();
					vc.removeVideo(id2);
					break;
				
				case 11:
					System.out.println("Partner ID:");
					id2 = opt.nextInt();
					vc.removePartner(id2);
					break;
				
				case 12:
					break;
					
				default:
					System.out.println("Invalid Option!");
					break;
			}
				
		}while(op!=12);
		
		opt.close();
	}
	
}

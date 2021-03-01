package aula2;

import java.util.Hashtable;
import java.util.LinkedList;

public class VideoClub {
	
	private Hashtable<Integer, Video> videos; 
	private Hashtable<Integer, Partner> partners;
	private Hashtable<Integer, LinkedList<Integer>> requestsVideo;
	private Hashtable<Integer, LinkedList<Integer>> requestsPartner;
	private int n;
	
	public VideoClub(int n) {
		this.n = n;
		this.videos = new Hashtable<>(10);
		this.partners = new Hashtable<>(10);
		this.requestsVideo = new Hashtable<>(10);
		this.requestsPartner = new Hashtable<>(10);
	}
	
	public void addVideo(Video v) {
		videos.put(v.getId(), v);
	}
	
	public void addPartner(Partner p) {
		partners.put(p.getId(), p);
	}
	
	public boolean checkVideoAvailability(int videoID) {
		if(!videos.containsKey(videoID))
			return false;
		return videos.get(videoID).isAvailable();
	}
	
	public boolean checkIn(int videoID, int clientID, int r) {
		if (r < 1 || r > 10 || !videos.containsKey(videoID) || !partners.containsKey(clientID) || !requestsVideo.containsKey(videoID) || !requestsPartner.containsKey(clientID)) {
			return false;
		}		
		videos.get(videoID).setAvailable(true);
		videos.get(videoID).addRating(r);
		
		return true;
	}
	
	public boolean checkOut(int videoID, int clientID) {
		if(videos.containsKey(videoID) && partners.containsKey(clientID)) {
			if (!requestsPartner.containsKey(clientID)) {
				requestsPartner.put(clientID, new LinkedList<Integer>());
			}
			
			LinkedList<Integer> videoIDs = requestsPartner.get(clientID);
			if (videoIDs.size() > n) 
				return false;
			videoIDs.addLast(videoID);
			
			if (!requestsVideo.containsKey(videoID)) {
				requestsVideo.put(videoID, new LinkedList<Integer>());
			}
			LinkedList<Integer> clientsIDs = requestsVideo.get(videoID);
			clientsIDs.addLast(clientID);
			
			videos.get(videoID).setAvailable(false);
			
			return true;
		}
		
		return false;
	}
	
	public void removePartner(int id) {
		if (partners.contains(id))
			partners.remove(id);
	}
	
	public void removeVideo(int id) {
		if (videos.contains(id))
			videos.remove(id);
	}
	
	public Video[] getVideos() {
		return videos.values().toArray(new Video[videos.size()]);
	}
	
	public String getRequestsByVideo(int id) {
		if(!videos.containsKey(id))
			return "Video Not Found!";
		if(!requestsVideo.containsKey(id))
			return "No one requested that video!";
		
		Object[] p = requestsVideo.get(id).toArray();
		String s = "Video " + videos.get(id).getTitle() + " requested by: ";
		for(int i = 0; i< p.length; i++) {
			s += partners.get(p[i]).getNome() + "\n";
		}
		return s;
	}
	
	public String getRequestsByPartner(int id) {
		if(!partners.containsKey(id))
			return "Partner Not Found!";
		if(!requestsPartner.containsKey(id))
			return "No requests done!";
		
		Object[] v = requestsPartner.get(id).toArray();
		String s = partners.get(id).getNome() + " requested: ";
		for(int i = 0; i< v.length; i++) {
			s += videos.get(v[i]).getTitle() + "\n";
		}
		return s;
	}
	
	public Video[] sortRatings() {
		Video[] v = videos.values().toArray(new Video[videos.size()]);
		for (int i = 0; i < v.length-1; i++) { 
			for (int j = i + 1; j < v.length; j++) {   
				if (v[j].getRating() < v[i].getRating()) {            
					swap(v, i, j);              
				}
			}
		}
		return v;
	}
	
	private void swap(Video[] v, int i, int j) {
		Video tmp = v[i];
		v[i]=v[j];
		v[j]=tmp;
	}
}
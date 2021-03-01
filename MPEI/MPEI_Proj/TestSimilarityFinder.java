package MPEI_Proj;

import java.util.HashSet;
import java.util.Set;

public class TestSimilarityFinder {

	public static void main(String args[]) {
		
		Set<String> telm1 = new HashSet<String>();
		
		String t = "Huawei,P10 Plus,GSM / HSPA / LTE,GSM 850 / 900 / 1800 / 1900 - SIM 1 & SIM 2 (dual-SIM model only),"
				+ "HSDPA 800 / 850 / 900 / 1700(AWS) / 1800 / 1900 / 2100 ,LTE band 1(2100)| 2(1900)| 3(1800)| 4(1700/2100)| 5(850)| 7(2600)| 8(900)| 9(1800)| 12(700)| 17(700)| 18(800)| 19(800)| 20(800)| 26(850)| 28(700)| 29(700)| 38(2600)| 39(1900)| 40(2300),"
				+ "HSPA  LTE,Yes,Yes,2017  February,Available. Released 2017  April,153.5 x 74.2 x 7 mm (6.04 x 2.92 x 0.28 in),165,5.82,Single SIM (Nano-SIM) or Dual SIM (Nano-SIM| dual stand-by),IPS-NEO LCD capacitive touchscreen  16M colors,5.5 inches (~71.6% screen-to-body ratio),"
				+ "1440 x 2560 pixels (~540 ppi pixel density),Android 7.0 (Nougat),Octa-core (4x2.4 GHz Cortex-A73 & 4x1.8 GHz Cortex-A53),HiSilicon Kirin 960,Mali-G71 MP8,microSD  up to 256 GB (uses SIM 2 slot),"
				+ "64 GB,4 GB RAM (L09) or 128 GB| 6 GB RAM (L29),Dual 20 MP + 12 MP| f/1.8| OIS| Leica optics| phase detection and laser autofocus| dual-LED (dual tone) flash| ,"
				+ "8 MP| f/1.9,Yes with stereo speakers,Yes,Wi-Fi 802.11 a/b/g/n/ac| dual-band| DLNA| WiFi Direct| hotspot,4.2| A2DP| LE,Yes with A-GPS GLONASS BDS GALILEO,Yes,No,2.0| Type-C 1.0 reversible connector,"
				+ "Fingerprint (front-mounted)| accelerometer| gyro| proximity| compass,Non-removable Li-Ion 3750 mAh battery,Ceramic White| Dazzling Blue| Dazzling Gold| Graphite Black| Mystic Silver| Rose Gold| Greenery,700,http://cdn2.gsmarena.com/vv/bigpic/huawei-p10-plus-r1.jpg";
		
		String[] specs = t.split(",");
		for(int i = 0; i < specs.length; i++)
			telm1.add(specs[i].toUpperCase());
		
		Set<String> telm2 = new HashSet<String>();
		
		String t2 = "Xiaomi,Mi 5s Plus,GSM / CDMA / HSPA / EVDO / LTE,GSM 850 / 900 / 1800 / 1900 - SIM 1 & SIM 2,HSDPA 850 / 900 / 1900 / 2100 ,LTE band 1(2100)| 3(1800)| 5(850)| 7(2600)| 38(2600)| 39(1900)| 40(2300)| 41(2500),HSPA  LTE,Yes,Yes,2016  September,"
				+ "Available. Released 2016  October,154.6 x 77.7 x 8 mm (6.09 x 3.06 x 0.31 in),168,5.93,Dual SIM (Nano-SIM| dual stand-by),IPS LCD capacitive touchscreen  16M colors,5.7 inches (~74.6% screen-to-body ratio),1080 x 1920 pixels (~386 ppi pixel density),"
				+ "Android 6.0 (Marshmallow),Quad-core (2x2.35 GHz Kryo & 2x2.2 GHz Kryo),Qualcomm MSM8996 Snapdragon 821,Adreno 530,No,64 GB,4 GB RAM or 128 GB| 6 GB RAM,Dual 13 MP| f/2.0| phase detection autofocus| dual-LED (dual tone) flash| ,4 MP| f/2.0| 1/3'' sensor size| 2µm pixel size| 1080p,"
				+ "Yes,Yes,Wi-Fi 802.11 a/b/g/n/ac| dual-band| Wi-Fi Direct| DLNA| hotspot,4.2| A2DP| LE,Yes with A-GPS GLONASS BDS,Yes,No,Type-C 1.0 reversible connector,Fingerprint (rear-mounted)| accelerometer| gyro| proximity| compass| barometer,Non-removable 3800 mAh battery,Silver| Gray| Gold| Rose Gold,"
				+ "370,http://cdn2.gsmarena.com/vv/bigpic/xiaomi-mi-5s-plus.jpg";
		
		specs = t2.split(",");
		for(int i = 0; i < specs.length; i++)
			telm2.add(specs[i].toUpperCase());
		
		
		SimilarityFinder sf = new SimilarityFinder(telm1.size() + telm2.size());
		
		System.out.println(sf.toString() + ":" 
						+ "\nSimilaridade entre os telemóveis 1 e 2: " + sf.getSimilarity(telm1, telm2)
						+ "\nSimilaridade entre os telemóveis 1 e 1: " + sf.getSimilarity(telm1, telm1));
		
	}
}

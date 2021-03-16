// Generated from ImageManipulator.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.opencv.core.*;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.highgui.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import java.util.*;


public class Functions
{
	public static JFrame frame = new JFrame();
	public static JLabel lbl = new JLabel();
	public static boolean Match = false;
	public static boolean faceDetected = false;
	/*****************************************************************************************************
	 * Function to display Image
	 ****************************************************************************************************/
	static public void displayImg(Image image)
	{
		if (image == null)
			return;

		ImageIcon icon = new ImageIcon(image);
		frame.setLayout(new FlowLayout());
		frame.setSize(image.getWidth(null) + 50, image.getHeight(null) + 50);
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*****************************************************************************************************
	 * Function to convert Mat to BufferedImage
	 ****************************************************************************************************/
	static public BufferedImage matToImage(Mat m)
	{
		if (m == null)
			return null;

		try
		{
			int type = BufferedImage.TYPE_BYTE_GRAY;
			if (m.channels() > 1) {
				type = BufferedImage.TYPE_3BYTE_BGR;
			}
			int bufferSize = m.channels() * m.cols() * m.rows();
			byte[] b = new byte[bufferSize];
			m.get(0, 0, b); // get all the pixels
			BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
			final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			System.arraycopy(b, 0, targetPixels, 0, b.length);
			return image;
		}
		catch (Exception e)
		{
			System.err.println(" >>> Action not Done: IMAGE NOT FOUND!");
			return null;
		}
	}

	/*****************************************************************************************************
	 * Function to convert BufferedImage to Mat
	 ****************************************************************************************************/
	static public Mat bufferedToMat(BufferedImage img)
	{
		if (img == null)
			return null;

		Mat mat = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
		byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
		mat.put(0, 0, pixels);

		return mat;
	}

	/*****************************************************************************************************
	 * Function to display side by side images
	 ****************************************************************************************************/
	static public Mat sideBySide(Mat matA, Mat matB)
	{
		Mat m = new Mat(matA.rows(), matA.cols() +  matB.cols(), matA.type());
		int aCols = matA.cols();
		int aRows = matA.rows();

		for (int i = 0; i < aRows; i++)
		{
			for (int j = 0; j < aCols; j++)
			{
				m.put(i, j, matA.get(i, j));
			}
		}

		for (int i = 0; i < matB.rows(); i++)
		{
			for (int j = 0; j < matB.cols(); j++)
			{
				m.put(i, aCols + j, matB.get(i, j));
			}
		}
		return m;
	}

	/*****************************************************************************************************
	 * Function to apply filter
	 ****************************************************************************************************/
	static public Mat filterImage(BufferedImage img, Mat imgsrc, String filter)
	{
		int width = img.getWidth();
		int height = img.getHeight();

		switch (filter)
		{
			case "gray":    /******* GRAY ********/
				Imgproc.cvtColor(imgsrc, imgsrc, Imgproc.COLOR_RGB2GRAY);
				return imgsrc;

			case "green":    /******* GREEN ********/
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						int p = img.getRGB(x, y);

						int a = (p >> 24) & 0xff;
						int g = (p >> 8) & 0xff;

						p = (a << 24) | (0 << 16) | (g << 8) | 0;

						img.setRGB(x, y, p);
					}
				}
				break;

			case "blue":    /******* BLUE ********/
				for (int y = 0; y < height; y++)
				{
					for (int x = 0; x < width; x++)
					{
						int p = img.getRGB(x, y);
						int a = (p >> 24) & 0xff;
						int g = (p >> 0) & 0x0ff;

						//set new RGB
						p = (a << 24) | (0 << 16) | (g << 0) | 0;
						img.setRGB(x, y, p);
					}
				}
				break;

			case "red":        /******* RED ********/
				for (int y = 0; y < height; y++)
				{
					for (int x = 0; x < width; x++)
					{
						int p = img.getRGB(x, y);
						int a = (p >> 24) & 0xff;
						int g = (p >> 16) & 0x0ff;

						//set new RGB
						p = (a << 24) | (0 << 16) | (g << 16) | 0;
						img.setRGB(x, y, p);
					}
				}
				break;
			case "2d":
				int ind = 0;
				while(true){
					Point anchor = new Point( -1, -1);
					double delta = 0.0;
					int ddepth = -1;
					int kernel_size = 3 + 2*( ind%5 );
					Mat ones = Mat.ones( kernel_size, kernel_size, CvType.CV_32F );
					Mat kernel = new Mat();

					Core.multiply(ones, new Scalar(1/(double)(kernel_size*kernel_size)), kernel);
					
					//! [update_kernel]

					//! [apply_filter]
					// Apply filter
					Mat dst = new Mat();

					Imgproc.filter2D(imgsrc, dst, ddepth , kernel, anchor, delta, Core.BORDER_DEFAULT );

					HighGui.imshow( "2d teste", dst );
					int c = HighGui.waitKey(500);

					if( c == 27 )
					{ break; }
		
					ind++;
				}
			default:
				return null;
		}
		Mat matImage = new Mat();
		matImage = bufferedToMat(img);
		bufferedToMat(img);

		return matImage;
	}

	/*****************************************************************************************************
	 * Function to zoom Image
	 ****************************************************************************************************/
	static public Mat zoomImage(Mat image, int factor)
	{
		int zoomingFactor = factor/10;

		Mat source = image;
		Mat destination = new Mat(source.rows() * zoomingFactor, source.cols()* zoomingFactor,source.type());

		Imgproc.resize(source, destination, destination.size(), zoomingFactor,zoomingFactor,Imgproc.INTER_NEAREST);

		return destination;
	}

	/*****************************************************************************************************
	 * Function to detect faces in images
	 ****************************************************************************************************/
	static public void FaceDetect(Mat image)
	{
		Mat imgsrc = image;

		CascadeClassifier faceDetector = new CascadeClassifier();
		faceDetector.load("haarcascade_frontalface_alt.xml");

		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(imgsrc, faceDetections);

		// Creating a rectangular box showing faces detected
		for (Rect rect : faceDetections.toArray())
		{
			Imgproc.rectangle(imgsrc, new Point(rect.x, rect.y),
					new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 255, 0));
		}

		// Saving the output image
		String filename = "FacesDetected.jpg";
		Imgcodecs.imwrite(filename, imgsrc);
	}

	/*****************************************************************************************************
	 * Function to crop images
	 ****************************************************************************************************/
	static public Mat CropImage(Mat image,int startX, int startY, int width, int height)
	{
		Mat imgsrc = image;
		
		Rect roi = new Rect(startX, startY, width, height);
		Mat cropped = new Mat(imgsrc, roi);
		return cropped;
	}

	/*****************************************************************************************************
	 * Function to change image brightness and gamma
	 ****************************************************************************************************/
	static public Mat brightness(Mat image, String brightness, String gamma)
	{
		Mat newImage = Mat.zeros(image.size(), image.type());
		int brigh = Integer.parseInt(brightness);
		double g = Double.parseDouble(gamma);

		brigh = brigh - 50;

		if (brigh > 100)
			brigh = 100;

		double alpha = g;  		//gamma control
		int beta = brigh;       //brightness control


		byte[] imageData = new byte[(int) (image.total()*image.channels())];
		image.get(0, 0, imageData);
		byte[] newImageData = new byte[(int) (newImage.total()*newImage.channels())];
		for (int y = 0; y < image.rows(); y++)
		{
			for (int x = 0; x < image.cols(); x++)
			{
				for (int c = 0; c < image.channels(); c++)
				{
					double pixelValue = imageData[(y * image.cols() + x) * image.channels() + c];
					pixelValue = pixelValue < 0 ? pixelValue + 256 : pixelValue;
					newImageData[(y * image.cols() + x) * image.channels() + c] = saturate(alpha * pixelValue + beta);
				}
			}
		}
		newImage.put(0, 0, newImageData);
		return newImage;
	}

	private static byte saturate(double val)
	{
		int iVal = (int) Math.round(val);
		iVal = iVal > 255 ? 255 : (iVal < 0 ? 0 : iVal);
		return (byte) iVal;
	}

	static public Mat SmoothingImage(Mat image, int blur)
	{
		int DELAY_BLUR = 100;
		int MAX_KERNEL_LENGTH = 31;
		Mat src = image;

        if( src.empty() ) {
            System.out.println("Error opening image");
            System.out.println("Usage: ./Smoothing [image_name -- default ../data/lena.jpg] \n");
            System.exit(-1);
		}
        Mat dst = src.clone();
		
		switch(blur){
			case 1:
				for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
					Imgproc.blur(src, dst, new Size(i, i), new Point(-1, -1));
				}
			case 2:
				for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
					Imgproc.GaussianBlur(src, dst, new Size(i, i), 0, 0);
				}
			case 3:
				for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
					Imgproc.medianBlur(src, dst, i);
				}
			case 4:
				for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
					Imgproc.bilateralFilter(src, dst, i, i * 2, i / 2);
				}
		}
		return dst;
	}

	static public Mat Histogram(Mat src){
		List<Mat> bgrPlanes = new ArrayList<>();
        Core.split(src, bgrPlanes);
        //! [Separate the image in 3 places ( B, G and R )]

        //! [Establish the number of bins]
        int histSize = 256;
        //! [Establish the number of bins]

        //! [Set the ranges ( for B,G,R) )]
        float[] range = {0, 256}; //the upper boundary is exclusive
        MatOfFloat histRange = new MatOfFloat(range);
        //! [Set the ranges ( for B,G,R) )]

        //! [Set histogram param]
        boolean accumulate = false;
        //! [Set histogram param]

        //! [Compute the histograms]
        Mat bHist = new Mat(), gHist = new Mat(), rHist = new Mat();
        Imgproc.calcHist(bgrPlanes, new MatOfInt(0), new Mat(), bHist, new MatOfInt(histSize), histRange, accumulate);
        Imgproc.calcHist(bgrPlanes, new MatOfInt(1), new Mat(), gHist, new MatOfInt(histSize), histRange, accumulate);
        Imgproc.calcHist(bgrPlanes, new MatOfInt(2), new Mat(), rHist, new MatOfInt(histSize), histRange, accumulate);
        //! [Compute the histograms]

        //! [Draw the histograms for B, G and R]
        int histW = 512, histH = 400;
        int binW = (int) Math.round((double) histW / histSize);

        Mat histImage = new Mat( histH, histW, CvType.CV_8UC3, new Scalar( 0,0,0) );
        //! [Draw the histograms for B, G and R]

        //! [Normalize the result to ( 0, histImage.rows )]
        Core.normalize(bHist, bHist, 0, histImage.rows(), Core.NORM_MINMAX);
        Core.normalize(gHist, gHist, 0, histImage.rows(), Core.NORM_MINMAX);
        Core.normalize(rHist, rHist, 0, histImage.rows(), Core.NORM_MINMAX);
        //! [Normalize the result to ( 0, histImage.rows )]

        //! [Draw for each channel]
        float[] bHistData = new float[(int) (bHist.total() * bHist.channels())];
        bHist.get(0, 0, bHistData);
        float[] gHistData = new float[(int) (gHist.total() * gHist.channels())];
        gHist.get(0, 0, gHistData);
        float[] rHistData = new float[(int) (rHist.total() * rHist.channels())];
        rHist.get(0, 0, rHistData);

        for( int i = 1; i < histSize; i++ ) {
            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(bHistData[i - 1])),
                    new Point(binW * (i), histH - Math.round(bHistData[i])), new Scalar(255, 0, 0), 2);
            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(gHistData[i - 1])),
                    new Point(binW * (i), histH - Math.round(gHistData[i])), new Scalar(0, 255, 0), 2);
            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(rHistData[i - 1])),
                    new Point(binW * (i), histH - Math.round(rHistData[i])), new Scalar(0, 0, 255), 2);
        }
        //! [Draw for each channel]

        //! [Display]
        HighGui.imshow( "Source image", src );
        return histImage;
        // HighGui.waitKey(0);
	}
	static public Mat CompareHistogram(Mat src, Mat src2){
		Mat hsvBase = new Mat(), hsvTest1 = new Mat();

        Imgproc.cvtColor( src, hsvBase, Imgproc.COLOR_BGR2HSV );
        Imgproc.cvtColor( src2, hsvTest1, Imgproc.COLOR_BGR2HSV );
        //Imgproc.cvtColor( srcTest2, hsvTest2, Imgproc.COLOR_BGR2HSV );
        //! [Convert to HSV]

        //! [Convert to HSV half]
        Mat hsvHalfDown = hsvBase.submat( new Range( hsvBase.rows()/2, hsvBase.rows() - 1 ), new Range( 0, hsvBase.cols() - 1 ) );
        //! [Convert to HSV half]

        //! [Using 50 bins for hue and 60 for saturation]
        int hBins = 50, sBins = 60;
        int[] histSize = { hBins, sBins };

        // hue varies from 0 to 179, saturation from 0 to 255
        float[] ranges = { 0, 180, 0, 256 };

        // Use the 0-th and 1-st channels
        int[] channels = { 0, 1 };
        //! [Using 50 bins for hue and 60 for saturation]

        //! [Calculate the histograms for the HSV images]
        Mat histBase = new Mat(), histHalfDown = new Mat(), histTest1 = new Mat();

        List<Mat> hsvBaseList = Arrays.asList(hsvBase);
        Imgproc.calcHist(hsvBaseList, new MatOfInt(channels), new Mat(), histBase, new MatOfInt(histSize), new MatOfFloat(ranges), false);
        Core.normalize(histBase, histBase, 0, 1, Core.NORM_MINMAX);

        List<Mat> hsvHalfDownList = Arrays.asList(hsvHalfDown);
        Imgproc.calcHist(hsvHalfDownList, new MatOfInt(channels), new Mat(), histHalfDown, new MatOfInt(histSize), new MatOfFloat(ranges), false);
        Core.normalize(histHalfDown, histHalfDown, 0, 1, Core.NORM_MINMAX);

        List<Mat> hsvTest1List = Arrays.asList(hsvTest1);
        Imgproc.calcHist(hsvTest1List, new MatOfInt(channels), new Mat(), histTest1, new MatOfInt(histSize), new MatOfFloat(ranges), false);
        Core.normalize(histTest1, histTest1, 0, 1, Core.NORM_MINMAX);

        //! [Calculate the histograms for the HSV images]

        //! [Apply the histogram comparison methods]
        for( int compareMethod = 0; compareMethod < 4; compareMethod++ ) {
            double baseBase = Imgproc.compareHist( histBase, histBase, compareMethod );
            double baseHalf = Imgproc.compareHist( histBase, histHalfDown, compareMethod );
            double baseTest1 = Imgproc.compareHist( histBase, histTest1, compareMethod );

            System.out.println("Method " + compareMethod + " Perfect, Base-Half, Base-Test(1), Base-Test(2) : " + baseBase + " / " + baseHalf
                    + " / " + baseTest1);
		}
		
		return src;
	}
	
		
	/*****************************************************************************************************
	 * Function Match Template
	 ****************************************************************************************************/
	static public Image MatchTemplate(Mat src, Mat template)
	{
	Match=false;
	
	Boolean use_mask = false;
	Mat img = src, templ = template;
    Mat mask = new Mat();
    int match_method=5;

    img = src;
    templ = templ;
        
    /* if (img.empty() || templ.empty() || (use_mask && mask.empty())) {
            System.out.println("Can't read one of the images");
            System.exit(-1);
	*/

    Mat result = new Mat();
    Mat img_display = new Mat();
    img.copyTo(img_display);
    int result_cols = img.cols() - templ.cols() + 1;
    int result_rows = img.rows() - templ.rows() + 1;
    result.create(result_rows, result_cols, CvType.CV_32FC1);

    Imgproc.matchTemplate(img, templ, result, match_method);

    Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
    Point matchLoc;
    Core.MinMaxLocResult mmr = Core.minMaxLoc(result);

	matchLoc = mmr.maxLoc;
	
	if(mmr.maxVal > 0.5) {Match=true;}
	
    Imgproc.rectangle(img_display, matchLoc, new Point(matchLoc.x + templ.cols(), matchLoc.y + templ.rows()),
            new Scalar(0, 0, 0), 2, 8, 0);
    Imgproc.rectangle(result, matchLoc, new Point(matchLoc.x + templ.cols(), matchLoc.y + templ.rows()),
            new Scalar(0, 0, 0), 2, 8, 0);
      
    Image tmpImg = HighGui.toBufferedImage(img_display);

    return tmpImg; 
    }

}

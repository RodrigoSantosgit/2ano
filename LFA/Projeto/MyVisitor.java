
// Generated from ImageManipulator.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.opencv.core.*;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.highgui.*;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class MyVisitor extends ImageManipulatorParserBaseVisitor<String> {

    public SymbolTable vars = new SymbolTable();
    public Mat Recent = new Mat();

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    @Override
    public String visitMain(ImageManipulatorParser.MainContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitInstruction(ImageManipulatorParser.InstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLoad(ImageManipulatorParser.LoadContext ctx) {
        String id = ctx.ID().getText();
        String imgPath = visit(ctx.e);
        imgPath = imgPath.replace("\"", "");
        String format[] = imgPath.split("\\.");
        Mat m = Imgcodecs.imread(imgPath);

        if (m.empty()) {
            id = ctx.ID().getText();
            if (vars.exists(visit(ctx.e)))
                m = vars.get(visit(ctx.e));
        }

        vars.put(id, m); // save variable
        return visitChildren(ctx);
    }

    @Override
    public String visitRotate(ImageManipulatorParser.RotateContext ctx) {
        String id = ctx.ID().getText();
        int angle = Integer.parseInt(visit(ctx.e));

        Mat src = new Mat();
        src = vars.get(id);

        //Creating an empty matrix to store the result
        Mat dst = new Mat();

        //Creating the transformation matrix M
        Mat rotationMatrix = Imgproc.getRotationMatrix2D(new Point(src.width() / 2, src.height() / 2), angle, 1);

        //Rotating the given image
        Imgproc.warpAffine(src, dst, rotationMatrix, new Size(src.cols(), src.cols()));

        vars.put(id, dst); // save variable

        return visitChildren(ctx);
    }

    @Override
    public String visitFilter(ImageManipulatorParser.FilterContext ctx)
    {
        String id = ctx.ID().getText();
        String filter = visit(ctx.e);

        Mat imgsrc = new Mat();

        imgsrc = vars.get(id);

        BufferedImage img = null;
        img = Functions.matToImage(imgsrc);
        Mat matImage = Functions.filterImage(img, imgsrc, filter);

        vars.put(id, matImage); // save variable
        return filter;
    }

    @Override
    public String visitBrightness(ImageManipulatorParser.BrightnessContext ctx)
    {
        String id = ctx.ID().getText();
        String brightness = ctx.INT().getText();

        Mat img = new Mat();
        img = vars.get(id);

        Mat matImage = Functions.brightness(img, brightness, "1");

        vars.put(id, matImage);

        return brightness;
    }

    @Override
    public String visitGamma(ImageManipulatorParser.GammaContext ctx)
    {
        String id = ctx.ID().getText();
        String gamma = ctx.INT().getText();

        Mat img = new Mat();
        img = vars.get(id);

        Mat matImage = Functions.brightness(img, "0", gamma);

        vars.put(id, matImage);

        return gamma;
    }

    @Override
    public String visitSave(ImageManipulatorParser.SaveContext ctx) {

        String file = visit(ctx.e);
        file = file.replace("\"", "");
        String format[] = file.split("\\.");

        String id = ctx.ID().getText();

        Mat m = vars.get(id);
        Imgcodecs.imwrite(file, m);

        return visitChildren(ctx);
    }

    @Override
    public String visitExprStr(ImageManipulatorParser.ExprStrContext ctx) {
        return ctx.STRING().getText();
    }

    @Override
    public String visitExprInt(ImageManipulatorParser.ExprIntContext ctx) {
        return ctx.INT().getText();
    }

    @Override
    public String visitExprID(ImageManipulatorParser.ExprIDContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitShow(ImageManipulatorParser.ShowContext ctx) {
        String id = ctx.ID().getText();

        Functions.displayImg(Functions.matToImage(vars.get(id)));

        return visitChildren(ctx);
    }

    @Override
    public String visitAdd(ImageManipulatorParser.AddContext ctx) {

        String id = ctx.ID().getText();
        String s1 = visit(ctx.e1);
        String s2 = visit(ctx.e2);

        Mat matA = new Mat();
        Mat matB = new Mat();

        if (vars.exists(s1) && vars.exists(s2)) {
            matA = vars.get(s1);
            matB = vars.get(s2);
        } else if (vars.exists(s1)) {
            matA = vars.get(s1);
            s2 = s2.replace("\"", "");
            matB = Imgcodecs.imread(s2);
        } else if (vars.exists(s2)) {
            matB = vars.get(s2);
            s1 = s1.replace("\"", "");
            matA = Imgcodecs.imread(s1);
        } else {
            s1 = s1.replace("\"", "");
            s2 = s2.replace("\"", "");
            matA = Imgcodecs.imread(s1);
            matB = Imgcodecs.imread(s2);
        }

        Mat m = Functions.sideBySide(matA, matB);
        vars.put(id, m); // save variable
        return visitChildren(ctx);
    }

    @Override
    public String visitFacedetect(ImageManipulatorParser.FacedetectContext ctx) {

        String id = ctx.ID().getText();

        Mat imgsrc = new Mat();

        imgsrc = vars.get(id);

        Functions.FaceDetect(imgsrc);

        return visitChildren(ctx);
    }

    @Override
    public String visitZoom(ImageManipulatorParser.ZoomContext ctx) {

        String id = ctx.ID().getText();
        String integer = ctx.INT().getText();

        int factor = Integer.parseInt(integer);

        Mat m = new Mat();
        Mat m1 = new Mat();

        m = vars.get(id);

        if (factor < 0 || factor > 100) {
            System.err.println(" >>> Action not Done: Zoom Value must be in range [0-100] <<< ");
            return visitChildren(ctx);
        }

        m1 = Functions.zoomImage(m, factor);

        vars.put(id, m1);

        return visitChildren(ctx);
    }

    @Override
    public String visitCrop(ImageManipulatorParser.CropContext ctx)
    {
        String id = ctx.ID().getText(); 
		int sx = Integer.parseInt(visit(ctx.e1));
		int sy = Integer.parseInt(visit(ctx.e2));
		int x = Integer.parseInt(visit(ctx.e3));
		int y = Integer.parseInt(visit(ctx.e4));
		
		BufferedImage img = null;
		Mat imgsrc = new Mat();
		Mat m = new Mat();
		
		imgsrc = vars.get(id);
		img = Functions.matToImage(imgsrc);
		
		int width = img.getWidth();
		int height = img.getHeight();
		if ((x > width || x < 0) && (y > height || y < 0)){
			System.err.println(" >>> Action not Done: Out of bounds point! (" + x + "*" + ", " + y + "*" +")");
			System.exit(1);
		}
		
		if (x > width || x < 0 ){
			System.err.println(" >>> Action not Done: Out of bounds point! (" + x + "*" + ", " + y +")");
			System.exit(1);
		}
		if (y > height || y < 0){
			System.err.println(" >>> Action not Done: Out of bounds point! (" + x + ", " + y + "*" +")");
			System.exit(1);
		}
		
		
		m = Functions.CropImage(imgsrc, sx, sy, x, y);
		
		vars.put(id, m);
		
		return visitChildren(ctx);
    }
    @Override 
    public String visitDetails(ImageManipulatorParser.DetailsContext ctx) {
		String id = ctx.ID().getText();
		
		Mat imgsrc = new Mat();
		BufferedImage img = null;
		
		imgsrc = vars.get(id);
		
		img = Functions.matToImage(imgsrc);
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		System.out.println("Dimensions: width -> "+width+"px; height ->"+height + "px");
		 
		return visitChildren(ctx); 
    }
    @Override
    public String visitSmoothing(ImageManipulatorParser.SmoothingContext ctx) {
		String id = ctx.ID().getText();
        String integer = ctx.INT().getText();

        
        Mat imgsrc = vars.get(id);
        int factor = Integer.parseInt(integer);

        Mat img2 = Functions.SmoothingImage(imgsrc,factor);

        BufferedImage img = null;
        img = Functions.matToImage(img2);
        vars.put(id, img2);

		return visitChildren(ctx); 
    }
    @Override
    public String visitHistogram(ImageManipulatorParser.HistogramContext ctx){
        String id = ctx.ID().getText();
       
        Mat imgsrc = vars.get(id);
        Mat img2 = Functions.Histogram(imgsrc);

        BufferedImage img = null;
        img = Functions.matToImage(img2);
        vars.put(id, img2);

		return visitChildren(ctx);        
    }
    @Override
    public String visitCompare_histogram(ImageManipulatorParser.Compare_histogramContext ctx){
        //String id = ctx.ID().getText()[0];
        String id = ctx.ID(0).toString();
        String id2 = ctx.ID(1).toString();
        System.out.println(id);
        System.out.println(id2);

        Mat img1 = vars.get(id);
        Mat img2 = vars.get(id2);

        Mat img = Functions.CompareHistogram(img1, img2);
       
        
        //Mat imgsrc = vars.get(id);
        return visitChildren(ctx);
    }
    
        /*@Override
    public String visitBooleanexpr(ImageManipulatorParser.BooleanexprContext ctx) {
        //boolean check = visit(ctx.);
        
        String s1 = visit(ctx.e1);
        String s2 = visit(ctx.e2);
        
        boolean x= Boolean.parseBoolean(s1);
        boolean x1= Boolean.parseBoolean(s2);
        if(x || x1) { return "true"; }
        else { return "false";}
    }*/
        @Override
    public String visitMatch ( ImageManipulatorParser.MatchContext ctx ) {

        String s1 = visit(ctx.e1);
        String s2 = visit(ctx.e2);
        String s3 = ctx.ID().getText();
        Mat A = new Mat();
        Mat B = new Mat();
        
        
        A = vars.get(s1);
        B = vars.get(s2);
        

        Image result;
        
        result = Functions.MatchTemplate(A,B);
        BufferedImage img = toBufferedImage(result);
        Mat var = bufferedToMat(img);
        
        vars.put(s3,var);
         
        //Functions.displayImg(result);
        String s = String.valueOf(Functions.Match);
        return s;
    }
    

    
     private Mat bufferedToMat(BufferedImage img)
	{
		if (img == null)
			return null;

		Mat mat = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
		byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
		mat.put(0, 0, pixels);

		return mat;
	}
	private static BufferedImage toBufferedImage(Image img)
    {
    if (img instanceof BufferedImage)
    {
        return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
    }

}

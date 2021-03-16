// Generated from ImageManipulator.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.opencv.core.*;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.CascadeClassifier; 

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.*;

public class SemanticCheck extends ImageManipulatorParserBaseVisitor<String> {

	 static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
	 private HashMap<String, String> vars = new HashMap<>();
	 private String[] filters = {"green", "red", "blue", "gray"};
	 
	@Override
	public String visitLoad(ImageManipulatorParser.LoadContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + ctx.ID().getText() + " ' ALREADY EXISTS <<< ");
			System.exit(1);
		}
		
		String imgPath = visit(ctx.e);
		imgPath = imgPath.replace("\"", "");
		String format[] = imgPath.split("\\.");
		
		if(!imgPath.contains(".jpeg") && !imgPath.contains(".png") && !imgPath.contains(".jpg"))
		{
			if(!vars.containsKey(visit(ctx.e)))	{
				System.err.println(" >>> Action not Done: ' " + imgPath + " ' NOT DECLARED <<< ");
				System.exit(1);}
		}
		else
		{	
			switch (format[1])
			{
				case "jpg":
					break;
				case "jpeg":
					break;
				case "png":
					break;
				default:
					System.err.println(" >>> Action not Done: INVALID FORMAT! <<< ");
					System.exit(1);
			}
			
			Mat m = Imgcodecs.imread(imgPath);
			
			if(m.empty())
			{
				System.out.println(" >>> Action not Done: FAILED TO LOAD! " + "' " + imgPath + " ' <<< ");
				System.exit(1);
			}
		}
		
		vars.put(id, "true");
		
		return visitChildren(ctx);
	}

	@Override public String visitRotate(ImageManipulatorParser.RotateContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		try{
			int angle = Integer.parseInt(visit(ctx.e));
		}
		catch(Exception e)
		{
			System.err.println(" >>> Action not Done: ' " + visit(ctx.e) + " ' INVALID NUMBER <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx);
	}

	@Override
	public String visitFilter(ImageManipulatorParser.FilterContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		String filter = visit(ctx.e);
		filter = filter.replace("-", "").replace(">", "");
		boolean found=false;
		
		for(int i = 0; i < filters.length; i++)
		{
			if(filter.equals(filters[i]))
				found = true;
		}
		
		if(!found)
		{
			System.err.println(" >>> Action not Done: ' " + filter + " ' INVALID FILTER! <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx);
	}

	@Override
	public String visitBrightness(ImageManipulatorParser.BrightnessContext ctx)
	{
		String id = ctx.ID().getText();
		String brightness = ctx.INT().getText();
		
		try{
			int brigh = Integer.parseInt(brightness);
			
			if (brigh < 0 || brigh > 100)
			{
				System.err.println(" >>> Action not Done: Brightness value must be in range [0-100] (default: 50) <<< ");
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			System.err.println(" >>> Action not Done: ' " + brightness + " ' INVALID NUMBER <<< ");
			System.exit(1);
		}

		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}

		return visitChildren(ctx);
	}

	@Override
	public String visitGamma(ImageManipulatorParser.GammaContext ctx)
	{
		String id = ctx.ID().getText();
		String gamma = ctx.INT().getText();
		
		try{
			int g = Integer.parseInt(gamma);
			
			if (g < 0 || g > 3)
			{
				System.err.println(" >>> Action not Done: Gamma value must be in range [1-3] (default: 1) <<< ");
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			System.err.println(" >>> Action not Done: ' " + gamma + " ' INVALID NUMBER <<< ");
			System.exit(1);
		}

		

		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}

		return visitChildren(ctx);
	}

	@Override
	public String visitSave(ImageManipulatorParser.SaveContext ctx)
	{
		
		String file = visit(ctx.e);
		file = file.replace("\"", "");
		String format[] = file.split("\\.");
		
		switch (format[1])
		{
			case "jpg":
				break;
			case "jpeg":
				break;
			case "png":
				break;
			default:
				System.err.println(" >>> Action not Done: INVALID FORMAT! <<< ");
				System.exit(1);
				break;
		}

		String id = ctx.ID().getText();

		if (!vars.containsKey(id)) 
		{
			System.err.println(" >>> Action not Done: ' " + ctx.ID().getText() + " ' DOESN'T EXIST <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx); 
	}

	@Override
	public String visitShow(ImageManipulatorParser.ShowContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + ctx.ID().getText() + " ' DOESN'T EXIST <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx); 
	}

	@Override
	public String visitAdd(ImageManipulatorParser.AddContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + ctx.ID().getText() + " ' ALREADY EXISTS <<< ");
			System.exit(1);
		}
		
		vars.put(id, "true");
		String s1 = visit(ctx.e1);
		
		if(!vars.containsKey(s1))
		{
			
			if(!s1.contains(".jpeg") && !s1.contains(".png") && !s1.contains(".jpg"))
			{
				System.err.println(" >>> Action not Done: ' " + s1 + " ' NOT DECLARED <<< ");
				System.exit(1);
			}
			else
			{
				Mat m = Imgcodecs.imread(s1.replace("\"", ""));
				if(m.empty())
				{
					System.out.println(" >>> Action not Done: FAILED TO LOAD! " + "' " + s1 + " ' <<< ");
					System.exit(1);
				}
			}
		}
		
		String s2 = visit(ctx.e2);
		
		if(!vars.containsKey(s2))
		{
			if(!s2.contains(".jpeg") && !s2.contains(".png") && !s2.contains(".jpg"))
			{
				System.err.println(" >>> Action not Done: ' " + s2 + " ' NOT DECLARED <<< ");
				System.exit(1);
			}
			else
			{
				Mat m1 = Imgcodecs.imread(s2.replace("\"", ""));
				if(m1.empty())
				{
					System.out.println(" >>> Action not Done: FAILED TO LOAD! " + "' " + s2 + " ' <<< ");
					System.exit(1);
				}
			}
		}
		
		return visitChildren(ctx); 
	}

	@Override
	public String visitFacedetect(ImageManipulatorParser.FacedetectContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx); 
	}

	@Override
	public String visitCrop(ImageManipulatorParser.CropContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx); 
	}
	
	@Override
	public String visitZoom(ImageManipulatorParser.ZoomContext ctx)
	{
		
		String id = ctx.ID().getText();
		String zoom = ctx.INT().getText();
		
		try{
			int z = Integer.parseInt(zoom);
			
			if (z < 0 || z > 100)
			{
				System.err.println(" >>> Action not Done: Zoom value must be in range [0-100] (default: 0) <<< ");
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			System.err.println(" >>> Action not Done: ' " + zoom + " ' INVALID NUMBER <<< ");
			System.exit(1);
		}
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx);
		 
	}
	
	@Override
	public String visitDetails(ImageManipulatorParser.DetailsContext ctx)
	{
		
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitHistogram(ImageManipulatorParser.HistogramContext ctx) 
	{ 
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		return visitChildren(ctx); 
	}

	@Override 
	public String visitSmoothing(ImageManipulatorParser.SmoothingContext ctx) 
	{ 
		
		String id = ctx.ID().getText();
		
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		
		String value = ctx.INT().getText();
		
		try{
			int blur = Integer.parseInt(value);
		}
		catch(Exception e)
		{
			System.err.println(" >>> Action not Done: ' " + value + " ' INVALID NUMBER <<< ");
			System.exit(1);
		}
		
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
    public String visitMatch ( ImageManipulatorParser.MatchContext ctx ) {

		String imgPath = visit(ctx.e1);
		imgPath = imgPath.replace("\"", "");
		String format[] = imgPath.split("\\.");
		
		if(!imgPath.contains(".jpeg") && !imgPath.contains(".png") && !imgPath.contains(".jpg"))
		{
			if(!vars.containsKey(visit(ctx.e1)))	{
				System.err.println(" >>> Action not Done: ' " + imgPath + " ' NOT DECLARED <<< ");
				System.exit(1);}
		}
		else
		{	
			switch (format[1])
			{
				case "jpg":
					break;
				case "jpeg":
					break;
				case "png":
					break;
				default:
					System.err.println(" >>> Action not Done: INVALID FORMAT! <<< ");
					System.exit(1);
			}
			
			Mat m = Imgcodecs.imread(imgPath);
			
			if(m.empty())
			{
				System.out.println(" >>> Action not Done: FAILED TO LOAD! " + "' " + imgPath + " ' <<< ");
				System.exit(1);
			}
		}
		
		String imgPath2 = visit(ctx.e2);
		imgPath2 = imgPath2.replace("\"", "");
		String format2[] = imgPath2.split("\\.");
		
		if(!imgPath2.contains(".jpeg") && !imgPath2.contains(".png") && !imgPath2.contains(".jpg"))
		{
			if(!vars.containsKey(visit(ctx.e2)))	{
				System.err.println(" >>> Action not Done: ' " + imgPath2 + " ' NOT DECLARED <<< ");
				System.exit(1);}
		}
		else
		{	
			switch (format2[1])
			{
				case "jpg":
					break;
				case "jpeg":
					break;
				case "png":
					break;
				default:
					System.err.println(" >>> Action not Done: INVALID FORMAT! <<< ");
					System.exit(1);
			}
			
			Mat m2 = Imgcodecs.imread(imgPath2);
			
			if(m2.empty())
			{
				System.out.println(" >>> Action not Done: FAILED TO LOAD! " + "' " + imgPath2 + " ' <<< ");
				System.exit(1);
			}
		}
		String id = ctx.ID().getText();
		if(!vars.containsKey(id))
		{
			System.err.println(" >>> Action not Done: ' " + id + " ' NOT DECLARED <<< ");
			System.exit(1);
		}
		return visitChildren(ctx);
	}
}	


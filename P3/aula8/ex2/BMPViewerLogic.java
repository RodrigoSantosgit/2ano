package aula8.ex2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class BMPViewerLogic {

	private JFrame window = null;
	private Container container = null;
	private JPanel imageContainer = null;
	private Bitmap image = null;
	
	public BMPViewerLogic() {
		window = new JFrame("BMPViewer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(700,700);
		
		File fileRoot = new File(System.getProperty("user.home"));
		DefaultTreeModel treeModel = new DefaultTreeModel(buildDirectoryTree(fileRoot,".Bmp"));
		JTree fileNavigator = new JTree(treeModel);
		
		fileNavigator.addTreeSelectionListener(new TreeSelectionListener(){
		    public void valueChanged(TreeSelectionEvent e) {
		        DefaultMutableTreeNode node = (DefaultMutableTreeNode) fileNavigator.getLastSelectedPathComponent();
		        File imageFile = (File)node.getUserObject();
		        if(!imageFile.isFile()) 
		        	return;
		        Bitmap bmp = new Bitmap(imageFile);
		        image = bmp;
		        showImage(bmp);
		    }
		});
		
		fileNavigator.setSize(new Dimension(200,240));
		fileNavigator.setBackground(Color.WHITE);
		colapseAllRows(fileNavigator);
		
		JButton flipHorizontalButton = new JButton("Flip Horizontal");
		flipHorizontalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(image == null) 
					return;
				image = Bitmap.flipHorizontal(image);
				showImage(image);
				SwingUtilities.updateComponentTreeUI(window);
			}
			
		});
		
		JButton flipVerticalButton = new JButton("Flip Vertical");
		flipVerticalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(image == null) 
					return;
				image = Bitmap.flipVertical(image);
				showImage(image);
				SwingUtilities.updateComponentTreeUI(window);
			}
			
		});
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(image == null) 
					return;
				image.saveAsCopy(image.name());
			}
			
		});
		
		JButton saveAsButton = new JButton("Save As");
		saveAsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(image == null) 
					return;
				String newFileName = (String)JOptionPane.showInputDialog(window, "File Name: ", null);
				if(newFileName == null) 
					return;
				if(newFileName.length() == 0) {
					JOptionPane.showMessageDialog(null, "Image name cannot be empty!");
					return;
				}
				image.saveAsCopy(newFileName);
			}
			
		});
		
		JButton resizeButton = new JButton("Resize");
		resizeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(image == null) return;
				if(image.width() <= 80 ||  image.height() <= 80) {
					JOptionPane.showMessageDialog(null,
							"Resize limit reached. Cannot resize image.");
					return;
				}
				image = Bitmap.resize(image);
				showImage(image);
				SwingUtilities.updateComponentTreeUI(window);
			}
			
		});
		
		Container buttons = new Container();
		buttons.setLayout(new GridLayout(2,3));
		buttons.setBackground(Color.WHITE);
		buttons.add(flipHorizontalButton);
		buttons.add(flipVerticalButton);
		buttons.add(saveButton);
		buttons.add(saveAsButton);
		buttons.add(resizeButton);
		
		Container leftContainer = new Container();
		leftContainer.setLayout(new BorderLayout());
		leftContainer.setSize(2*700/3,700);
		leftContainer.setBackground(Color.WHITE);
		leftContainer.add(fileNavigator,BorderLayout.NORTH);
		leftContainer.add(buttons,BorderLayout.SOUTH);
		
		imageContainer = new JPanel();
		imageContainer.setSize(new Dimension((2/3)*700,700));
		imageContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		imageContainer.setBackground(Color.WHITE);
		imageContainer.setVisible(true);
		imageContainer.setLayout(new BorderLayout());
		imageContainer.setBackground(Color.WHITE);
		
		//Adds all the components to the main container
		container = window.getContentPane();
		container.add(leftContainer,BorderLayout.WEST); //Adds the directory navigator
		container.add(imageContainer,BorderLayout.EAST); //Adds the space when the image will appear
		container.setBackground(Color.WHITE);
		container.setVisible(true);
		
		window.setVisible(true);
	}
	
	private void colapseAllRows(JTree tree) {
		for(int i = 0; i < tree.getRowCount(); i++) {
			tree.collapseRow(i);
		}
	}
	
	private DefaultMutableTreeNode buildDirectoryTree(File fileRoot,String extension) {
		File[] directories = fileRoot.listFiles();
		//Returns null if the are no .bmp files in subdirectories
		//Returns a file if rootFile is a .bmp file
		if(directories == null) {
			if(fileRoot.getName().toUpperCase().endsWith(extension.toUpperCase())) {
				return new DefaultMutableTreeNode(fileRoot);
			}
			return null;
		}
		
		//Returns the current node with all the subdirectories
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileRoot);
		for(File file : directories) {
			DefaultMutableTreeNode nextNode = buildDirectoryTree(file,extension);
			if(nextNode != null) node.add(nextNode);
		}
		//If node is null, it means that no .bmp file as been found in subdirectories
		return node.getChildCount() == 0 ? null : node;
	}
	
	private void showImage(Bitmap image) {
		container.remove(imageContainer);
		PanelImage imagePanel = new PanelImage(image.data(),image.width(),image.height());
		imagePanel.setVisible(true);
		imageContainer = new JPanel();
		imageContainer.add(imagePanel);
		container.add(imageContainer, BorderLayout.CENTER);
	}
}

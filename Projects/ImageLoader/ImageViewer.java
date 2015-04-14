
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;
import java.io.*;

public class ImageViewer extends JFrame {

    private FileList     fileList_;
    private JList        jfileList_;
    private JLabel       imageL_;
    private String       imageName_;
    private JTextField   dirText_;

    public ImageViewer( String dir ) {
	initDir(dir);
	init();
	buildPanel();
	setVisible(true);
    }

    private void initDir( String dir ) {
	fileList_ = new FileList();
	fileList_.load(dir);
	imageName_ = new String();
    }
    
    private void init() {
	setSize(400,400);
	setLocation(200,200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void buildPanel() {
	JPanel p = new JPanel();
	p.setLayout(new BorderLayout() );
	jfileList_ = new JList(fileList_.getFiles().toArray());
	jfileList_.addListSelectionListener(new ListL());
	JScrollPane scroll = new JScrollPane(jfileList_);
	p.add(scroll,BorderLayout.WEST);
	imageL_ = new JLabel();
	p.add(imageL_,BorderLayout.CENTER);
	p.add( new JLabel("   ") , BorderLayout.EAST);

	dirText_= new JTextField(40);
	dirText_.setText(fileList_.getDir());
	p.add(dirText_,BorderLayout.NORTH);
	add(p);
    }

    private void updateImageName( String iName ) {
	if ( imageName_.equals(iName) ) return;
	int ix = iName.indexOf(".jpg");
	String absPath = fileList_.getDir() + iName;
	imageName_=iName;
	ImageIcon img = ix > 0 ? getJPGIcon(absPath) : getGIFIcon(absPath);
	imageL_.setIcon(img);
	//pack();
    }

    private ImageIcon getJPGIcon( String file ) {
	File f = new File(file);
	//System.out.println("File len=" + f.length() + " " + f.getTotalSpace() );
	boolean useScale = f.length() > 400000;
	if ( useScale ) {
	    BufferedImage scaledImage = JPGLoader.getScaledImage(file,200,200);
	    return new ImageIcon(scaledImage);
	}
	return new ImageIcon(file);
    }

    private ImageIcon getGIFIcon(String file ) {
	return new ImageIcon(file);
    }

    private class ListL implements ListSelectionListener {
	public void valueChanged( ListSelectionEvent e ) {
	    String sel = (String)jfileList_.getSelectedValue();
	    updateImageName(sel);
	}
    }

    public static void main(String [] args ){
	boolean useJPG = args.length > 0;
	String dir = "/Users/johnreynolds/git/CMP-129/Images/";
	new ImageViewer(dir);
    }

}


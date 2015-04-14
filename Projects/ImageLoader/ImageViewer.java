
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;

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

	dirText_= new JTextField(100);
	dirText_.setText(fileList_.getDir());
	p.add(dirText_,BorderLayout.NORTH);
	add(p);
    }

    private void updateImageName( String iName ) {
	System.out.println("image = " + iName );
	if ( imageName_.equals(iName) ) return;
	int ix = iName.indexOf(".jpg");
	String absPath = fileList_.getDir() + iName;
	imageName_=iName;
	ImageIcon img = ix > 0 ? getJPGIcon(absPath) : getGIFIcon(absPath);
	imageL_.setIcon(img);
    }

    private ImageIcon getJPGIcon( String file ) {
	BufferedImage scaledImage = JPGLoader.getScaledImage(file,200,200);
	return new ImageIcon(scaledImage);
    }

    private ImageIcon getGIFIcon(String file ) {
	return new ImageIcon(file);
    }

    private class ListL implements ListSelectionListener {
	public void valueChanged( ListSelectionEvent e ) {
	    String sel = (String)jfileList_.getSelectedValue();
	    updateImageName(sel);
	    //mSel.setText(sel);
	}
    }

    public static void main(String [] args ){
	boolean useJPG = args.length > 0;
	String dir = "/System/Library/Frameworks/Tk.framework/Versions/8.5/Resources/Scripts/demos/images/";
	if ( useJPG )
	    dir = "/Users/johnreynolds/git/img/";
	new ImageViewer(dir);
    }

}


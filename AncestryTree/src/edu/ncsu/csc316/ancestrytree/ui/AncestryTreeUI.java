package edu.ncsu.csc316.ancestrytree.ui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import edu.ncsu.csc316.ancestrytree.manager.AncestryTreeManager;

/**
 * Creates the Ancesrty UI
 * @author John Ruisi
 *
 */
public class AncestryTreeUI extends JFrame {
	
	//Serial version id
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates the UI from the command args
	 * @param args the command lines arguments
	 */
	public static void main(String args[]) {
		AncestryTreeManager am = null;
		String level = null; String pre = null; String post = null;
		
		try {
			if (args.length == 1) {
				level = args[0];
				am = new AncestryTreeManager(level);
			} else if (args.length == 2) {
				pre = args[0];
				post = args[1];
				am = new AncestryTreeManager(pre, post);
			} else if (args.length == 0) {
				throw new IllegalArgumentException("No file given");
			} else {
				throw new IllegalArgumentException("Please only enter one or two commands.");
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "File errors", JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
		
		AncestryTreeUI at = new AncestryTreeUI(am);
		at.setVisible(true);
	}

	/**
	 * Creates the UI for the manager
	 * @param am the ancestry manager
	 */
	public AncestryTreeUI(AncestryTreeManager am) {
		setSize(1000, 150);
		setLocation(100, 100);
		setTitle("Ancestry Tree Manager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		JLabel s = new JLabel(am.getLevelOrder());
		c.add(s, BorderLayout.CENTER);
		JLabel s1 = new JLabel("I didn't have enough time to finish gui, all I have is level order :(");
		c.add(s1, BorderLayout.SOUTH);
		
	}

}

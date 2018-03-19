
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LetSwing extends JFrame {

	private static final long serialVersionUID = -5212244297791218331L;

	JButton button1;
	JTextField textField1;
	JTextArea textArea1;
	int buttonClicked;

	public static void main(String[] args) {

		new LetSwing();

	}

	public LetSwing() {

		this.setSize(400, 400);
		// this.setLocationRelativeTo(null);//centers window
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);

		// this.setUndecorated(true); //fills the screen
		/*
		 * Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 * this.width = (int) screenSize.getWidth(); this.height = (int)
		 * screenSize.getHeight();
		 * 
		 * this.setBounds(0, 0, (int) this.width, (int) this.height);
		 */

		this.setLocation(xPos, yPos);

		// this.setResizable(false);//resize window

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My First Frame");

		// #############################################################
		// CREATE PANEL to get components inside
		JPanel thePanel = new JPanel();
		// #############################################################

		// COMPONENTS###################################################

		// create a button
		button1 = new JButton("Click Here");
		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);

		// create a text field
		textField1 = new JTextField("", 15);
		ListenForKeys lForKeys = new ListenForKeys();
		textField1.addKeyListener(lForKeys);

		// create a Text Area and put inside a scrollbar
		textArea1 = new JTextArea(19, 30);
		textArea1.setText("A Bunch Of Text In The Area A Bunch Of Text In The Area A Bunch Of Text In The Area\n");
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);// avoid broken words
		textArea1.append(" number of lines: " + textArea1.getLineCount() + "\n");
		JScrollPane scrollbar = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ListenForWindow lForWindow = new ListenForWindow();
		this.addWindowListener(lForWindow);

		// create Mouse Listener
		ListenForMouse lForMouse = new ListenForMouse();

		// Add all stuff in the panel
		thePanel.add(button1);
		thePanel.add(textField1);
		thePanel.add(scrollbar);
		thePanel.addMouseListener(lForMouse);
		// END COMPONENTS###########################################

		// Add the panel with the stuff inside over the frame
		// #########################################################
		this.add(thePanel);
		// #########################################################

		// Show everything
		// #########################################################
		this.setVisible(true);
		// #########################################################
		// textField.requestFocus();
		// textArea.requestFocus();

	}

	// Implements ActionListener so it can react to events on components

	private class ListenForButton implements ActionListener {

		// This method is called when an event occurs

		public void actionPerformed(ActionEvent e) {

			// Check if the source of the event was the button

			if (e.getSource() == button1) {

				buttonClicked++;

				// Change the text for the label

				textArea1.append("Button clicked " + buttonClicked + " times\n");

				// e.getSource().toString() returns information on the button
				// and the event that occurred

			}

		}

	}

	// By using KeyListener you can track keys on the keyboard

	private class ListenForKeys implements KeyListener {

		// Handle the key typed event from the text field.
		public void keyTyped(KeyEvent e) {
			textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
		}

		// Handle the key-pressed event from the text field.
		public void keyPressed(KeyEvent e) {

		}

		// Handle the key-released event from the text field.
		public void keyReleased(KeyEvent e) {

		}

	}

	private class ListenForMouse implements MouseListener {

		// Called when a mouse button is clicked

		public void mouseClicked(MouseEvent e) {

			textArea1.append("Mouse Panel Pos: " + e.getX() + " " + e.getY() + "\n");
			textArea1.append("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
			textArea1.append("Mouse Button: " + e.getButton() + "\n");
			textArea1.append("Mouse Clicks: " + e.getClickCount() + "\n");

		}

		// Called when the mouse enters the component assigned
		// the MouseListener

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		// Called when the mouse leaves the component assigned
		// the MouseListener

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		// Mouse button pressed

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		// Mouse button released

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	private class ListenForWindow implements WindowListener {

		// Called when window is the active window

		public void windowActivated(WindowEvent e) {
			textArea1.append("Window Activated\n");

		}

		// Called when window is closed using dispose
		// this.dispose(); can be used to close a window

		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		// Called when the window is closed from the menu

		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		// Called when a window is no longer the active window

		public void windowDeactivated(WindowEvent e) {
			textArea1.append("Window Activated\n");

		}

		// Called when the window goes from minimized to a normal state

		public void windowDeiconified(WindowEvent arg0) {
			textArea1.append("Window in Normal State\n");

		}

		// Called when the window goes from normal to a minimized state

		public void windowIconified(WindowEvent arg0) {
			textArea1.append("Window Minimized\n");

		}

		// Called when the window is first created

		public void windowOpened(WindowEvent arg0) {
			textArea1.append("Window Created\n");

		}

	}

}

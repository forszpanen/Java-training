package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;

	public MainFrame() {
		super("Hello World");

		setLayout(new BorderLayout());

		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		setJMenuBar(createMenuBar());
		toolbar.setStringListener(new StringListener() {
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory();
				String empCat = e.getEmploymentCategory();
				String gender = e.getGender();

				textPanel.appendText(name + ": " + occupation + ": " + ageCat + ", " + empCat + ":" + gender + "\n");
			}
		});

		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");

		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import data...");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu show = new JMenu("Show");
		JMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		showFormItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
		});

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String showInputDialog = JOptionPane.showInputDialog(MainFrame.this, "Enter the user name", "Enter user name", JOptionPane.OK_OPTION|JOptionPane.QUESTION_MESSAGE);
				System.out.println(showInputDialog);
				
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit the app?",
						"Confirm exit", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		importDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});

		exportDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		
		show.add(showFormItem);
		windowMenu.add(show);
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		return menuBar;
	}
}

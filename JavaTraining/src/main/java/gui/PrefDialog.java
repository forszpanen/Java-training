package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PrefDialog extends JDialog {

	private JButton okButton;
	private JButton cancelButton;
	private JSpinner portSpinner;
	private SpinnerNumberModel spinnerModel;

	public PrefDialog(final JFrame aParent) {
		super(aParent, "Preferences", false);

		setSize(400, 300);
		setLocationRelativeTo(aParent);

		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
		portSpinner = new JSpinner(spinnerModel);

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Port: "), gc);

		gc.gridx++;
		add(portSpinner, gc);

		// next row
		gc.gridy++;

		gc.gridx = 0;
		add(okButton, gc);

		gc.gridx++;
		add(cancelButton, gc);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Integer value = (Integer) portSpinner.getValue();
				System.out.println(value);

				setVisible(false);

			}
		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}
}

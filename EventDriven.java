import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventDriven extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfMiddleName;
    private JTextField tfMobileNumber;
    private JTextField tfEmailAddress;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblMiddleName;
    private JLabel lblMobileNumber;
    private JLabel lblEmailAddress;
    private Output outputFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EventDriven frame = new EventDriven();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EventDriven() {
        setTitle("INPUT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 245, 312);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tfFirstName = new JTextField();
        tfFirstName.setBounds(10, 26, 209, 20);
        contentPane.add(tfFirstName);
        tfFirstName.setColumns(10);

        lblFirstName = new JLabel("First Name:");
        lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
        lblFirstName.setBounds(10, 11, 209, 14);
        contentPane.add(lblFirstName);

        tfLastName = new JTextField();
        tfLastName.setColumns(10);
        tfLastName.setBounds(10, 69, 209, 20);
        contentPane.add(tfLastName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
        lblLastName.setBounds(10, 54, 209, 14);
        contentPane.add(lblLastName);

        tfMiddleName = new JTextField();
        tfMiddleName.setColumns(10);
        tfMiddleName.setBounds(10, 115, 209, 20);
        contentPane.add(tfMiddleName);

        lblMiddleName = new JLabel("Middle Name:");
        lblMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
        lblMiddleName.setBounds(10, 100, 209, 14);
        contentPane.add(lblMiddleName);

        tfMobileNumber = new JTextField();
        tfMobileNumber.setColumns(10);
        tfMobileNumber.setBounds(10, 161, 209, 20);
        contentPane.add(tfMobileNumber);

        lblMobileNumber = new JLabel("Mobile Number:");
        lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblMobileNumber.setBounds(10, 146, 209, 14);
        contentPane.add(lblMobileNumber);

        tfEmailAddress = new JTextField();
        tfEmailAddress.setColumns(10);
        tfEmailAddress.setBounds(10, 207, 209, 20);
        contentPane.add(tfEmailAddress);

        lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmailAddress.setBounds(10, 192, 209, 14);
        contentPane.add(lblEmailAddress);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(10, 238, 100, 23);
        contentPane.add(btnSubmit);

        // btnSubmit button action
        class btnSubmit implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input values from text fields
                String firstNameValue = tfFirstName.getText();
                String lastNameValue = tfLastName.getText();
                String middleNameValue = tfMiddleName.getText();
                String mobileNumberValue = tfMobileNumber.getText();
                String emailAddressValue = tfEmailAddress.getText();

                // Pass the input values then display
                outputFrame = new Output(firstNameValue, lastNameValue, middleNameValue, mobileNumberValue, emailAddressValue);
                outputFrame.setVisible(true);

                // Disable the submit button to prevent multiple submissions
                btnSubmit.setEnabled(false);
            }
        }
        btnSubmit.addActionListener(new btnSubmit());

        JButton btnClearAll = new JButton("Clear All");
        btnClearAll.setBounds(119, 238, 100, 23);
        contentPane.add(btnClearAll);
        
        // btnClearAll button action
        class btnClearAll implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Removes all value of each input
				tfFirstName.setText("");
	            tfLastName.setText("");
	            tfMiddleName.setText("");
	            tfMobileNumber.setText("");
	            tfEmailAddress.setText("");
	            btnSubmit.setEnabled(true);

	            // Output window disposer
	            if (outputFrame != null) {
	                outputFrame.dispose();
	                outputFrame = null;
	            }
			}
        }
        btnClearAll.addActionListener(new btnClearAll());
    }
}

class Output extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblMiddleName;
    private JLabel lblMobileNumber;
    private JLabel lblEmailAddress;
    private JLabel lblFirstNameOutput;
    private JLabel lblLastNameOutput;
    private JLabel lblMiddleNameOutput;
    private JLabel lblMobileNumberOutput;
    private JLabel lblEmailAddressOutput;

	public Output(String firstName, String lastName, String middleName, String mobileNumber, String emailAddress) {
        setTitle("OUTPUT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnOkay = new JButton("Okay");
        btnOkay.setBounds(173, 221, 100, 23);
        contentPane.add(btnOkay);
        
        // btnOkay button action
        class btnOkay implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Dispose or close the output window
				dispose();
			}
        	
        }
        btnOkay.addActionListener(new btnOkay());

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 11, 414, 196);
        contentPane.add(panel);
        panel.setLayout(null);

        lblFirstName = new JLabel("First Name:");
        lblFirstName.setVerticalAlignment(SwingConstants.TOP);
        lblFirstName.setBounds(10, 11, 88, 14);
        panel.add(lblFirstName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setVerticalAlignment(SwingConstants.TOP);
        lblLastName.setBounds(10, 28, 88, 14);
        panel.add(lblLastName);

        lblMiddleName = new JLabel("Middle Name:");
        lblMiddleName.setVerticalAlignment(SwingConstants.TOP);
        lblMiddleName.setBounds(10, 44, 88, 14);
        panel.add(lblMiddleName);

        lblMobileNumber = new JLabel("Mobile Number:");
        lblMobileNumber.setVerticalAlignment(SwingConstants.TOP);
        lblMobileNumber.setBounds(10, 62, 88, 14);
        panel.add(lblMobileNumber);

        lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setVerticalAlignment(SwingConstants.TOP);
        lblEmailAddress.setBounds(10, 79, 88, 14);
        panel.add(lblEmailAddress);

        lblFirstNameOutput = new JLabel(firstName);
        lblFirstNameOutput.setBounds(108, 11, 296, 14);
        panel.add(lblFirstNameOutput);

        lblLastNameOutput = new JLabel(lastName);
        lblLastNameOutput.setBounds(108, 28, 296, 14);
        panel.add(lblLastNameOutput);

        lblMiddleNameOutput = new JLabel(middleName);
        lblMiddleNameOutput.setBounds(108, 44, 296, 14);
        panel.add(lblMiddleNameOutput);

        lblMobileNumberOutput = new JLabel(mobileNumber);
        lblMobileNumberOutput.setBounds(108, 62, 296, 14);
        panel.add(lblMobileNumberOutput);

        lblEmailAddressOutput = new JLabel(emailAddress);
        lblEmailAddressOutput.setBounds(108, 79, 296, 14);
        panel.add(lblEmailAddressOutput);
    }
}
package pe.com.examen.views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import pe.com.examen.model.User;
import pe.com.examen.validator.UserFieldValidator;
import pe.com.examen.exception.FieldPolicyException;
import pe.com.examen.model.DomainResponseModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Patterns extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txtpassword;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patterns frame = new Patterns();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Patterns() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(39, 37, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(39, 81, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setBounds(121, 34, 174, 20);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(121, 78, 174, 20);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Validar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user=new User();
				String usuario=txtusername.getText().toString();
				String password=txtpassword.getText().toString();
				
					user.setUsername(usuario);
					user.setPassword(password);
					DomainResponseModel model = validar(user);
					if(model.getCode() == 201) {
						JOptionPane.showMessageDialog(null, model.getMessage(), "Validacion", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else {
						JOptionPane.showMessageDialog(null, model.getMessage(), "Validacion", JOptionPane.ERROR_MESSAGE);
					}
									
			}
		});
		btnNewButton.setBounds(139, 122, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	
private DomainResponseModel validar(User user) {
		
		DomainResponseModel model = new DomainResponseModel();
		UserFieldValidator userFieldValidator=new UserFieldValidator();
		
		try {
			
			if(user == null) {
				throw new NullPointerException("user object is null!");
			}
			else {
				// second level of defense to check username and password
				if(!userFieldValidator.validateUsername(user.getUsername())) {
					throw new FieldPolicyException("Username does not matches policy!");
				}
				if(!userFieldValidator.validatePassword(user.getPassword())) {
					throw new FieldPolicyException("Password does not matches policy!");
				}
			}
						
			model.setCode(201);
			model.setMessage("Registration Successful! Login Again");
			
		}
		catch(NullPointerException ex) {
			model.setCode(499);
			model.setMessage("Failed to register the user cause no user is passed!");			
		}
		catch(FieldPolicyException ex) {
			model.setCode(498);
			model.setMessage(ex.getMessage());			
		}
		catch(Exception ex) {
			model.setCode(497);
			model.setMessage(ex.getMessage());
		}

		return model;
				
	}
	
}

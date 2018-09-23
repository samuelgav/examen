package pe.com.examen.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class GET extends JFrame {

	private JPanel contentPane;
	private static final String url="http://localhost/Android/getAllPersonas.php";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GET frame = new GET();
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
	public GET() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblget = new JLabel("");
		lblget.setBounds(10, 55, 360, 144);
		contentPane.add(lblget);
		
		JButton btnGet = new JButton("GET");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String respuesta=ConvertJson(url);
				lblget.setText(respuesta);
			}
		});
		btnGet.setBounds(134, 21, 89, 23);
		contentPane.add(btnGet);
	}
	
	public String ConvertJson(String requesturl){
		String response=null;
		try {
			URL url=new URL(requesturl);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream is=new BufferedInputStream(connection.getInputStream());
			response=ConvertStreamToString(is);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch(ProtocolException e){
			System.out.println(e.getMessage());
		} catch(IOException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return response;
	}

	private String ConvertStreamToString(InputStream is) {
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		StringBuilder result=new StringBuilder();
		String line=null;
		try {
			while((line=reader.readLine())!=null){
				result.append(line).append("\n");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return result.toString();
	}
	
}

package com.webbyext.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Panel;

import com.webbyext.*;
import com.webbyext.parser.UrlParser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Social Extractor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setBounds(5, 5, 440, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		final JLabel lblTwitter = new JLabel("Twitter");
		lblTwitter.setBounds(26, 124, 404, 16);
		contentPane.add(lblTwitter);

		final JLabel lblFacebook = new JLabel("Facebook");
		lblFacebook.setBounds(25, 152, 405, 16);
		contentPane.add(lblFacebook);

		final JLabel lblBehance = new JLabel("Behance");
		lblBehance.setBounds(25, 180, 405, 16);
		contentPane.add(lblBehance);

		final JLabel lblGithub = new JLabel("Github");
		lblGithub.setBounds(25, 208, 405, 16);
		contentPane.add(lblGithub);

		final JLabel lblGoogle = new JLabel("Google+");
		lblGoogle.setBounds(25, 236, 405, 16);
		contentPane.add(lblGoogle);

		final JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(25, 262, 405, 16);
		contentPane.add(lblMail);

		final JLabel title = new JLabel("");
		Font f = title.getFont();
		title.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		title.setBounds(5, 86, 439, 16);
		title.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(title);

		
		
		
		
		/*
		 * 
		 * Initializing URl Parser
		 */
		
		
		
		

		JButton btnExtractLinks = new JButton("Extract links");
		btnExtractLinks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				final UrlParser parser = new UrlParser();
				
				//Restoring values to 0
				parser.setBehance("");
				parser.setTwitter("");
				parser.setFacebook("");
				parser.setGithub("");
				parser.setGooglePlus("");
				parser.setMail("");

				if (textField.getText().contains("http://")) {
					parser.setUrl(textField.getText());
				} else {
					parser.setUrl("http://" + textField.getText());
				}

				try {
					
					parser.parseLink();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				title.setText(parser.getWebsiteTitle());
				
				
				
				
				
				
				
				/*
				 * 
				 * JLabel text transform
				 */
				
				
				
				
				

				// Twitter label
				//
				//
				lblTwitter.setText("Twitter: " + parser.getTwitter());
				lblTwitter.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				Font font = lblTwitter.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblTwitter.setFont(font.deriveFont(attributes));

				// Initializing mouse listener
				//
				lblTwitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Desktop.getDesktop().browse(
									new URI(parser.getTwitter()));
							parser.setTwitter("");
						} catch (URISyntaxException | IOException ex) {
							ex.printStackTrace();
						}
					}
				});

				// Facebook label
				//
				//
				lblFacebook.setText("Facebook: " + parser.getFacebook());
				lblFacebook.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				Font font2 = lblFacebook.getFont();
				Map attributes2 = font.getAttributes();
				attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblFacebook.setFont(font.deriveFont(attributes2));

				// Initializing mouse listener
				lblFacebook.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Desktop.getDesktop().browse(
									new URI(parser.getFacebook()));
							parser.setFacebook("");
						} catch (URISyntaxException | IOException ex) {
							ex.printStackTrace();
						}
					}
				});

				// GooglePlus label
				//
				//
				lblGoogle.setText("Google+: " + parser.getGooglePlus());
				lblGoogle.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				Font font3 = lblGoogle.getFont();
				Map attributes3 = font.getAttributes();
				attributes3.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblGoogle.setFont(font.deriveFont(attributes3));

				// Initializing mouse listener
				lblGoogle.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Desktop.getDesktop().browse(
									new URI(parser.getGooglePlus()));
							parser.setGooglePlus("");
						} catch (URISyntaxException | IOException ex) {
							ex.printStackTrace();
						}
					}
				});

				// Behance label
				//
				//
				lblBehance.setText("Behance: " + parser.getBehance());
				lblBehance.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				Font font4 = lblBehance.getFont();
				Map attributes4 = font.getAttributes();
				attributes4.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblBehance.setFont(font.deriveFont(attributes4));

				// Initializing mouse listener
				lblBehance.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Desktop.getDesktop().browse(
									new URI(parser.getBehance()));
							parser.setBehance("");
						} catch (URISyntaxException | IOException ex) {
							ex.printStackTrace();
						}
					}
				});

				// Github label
				//
				//
				lblGithub.setText("Github: " + parser.getGithub());
				lblGithub.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				Font font5 = lblGithub.getFont();
				Map attributes5 = font.getAttributes();
				attributes5.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblGithub.setFont(font.deriveFont(attributes5));

				// Initializing mouse listener
				lblGithub.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Desktop.getDesktop().browse(
									new URI(parser.getGithub()));
							parser.setGithub("");
						} catch (URISyntaxException | IOException ex) {
							ex.printStackTrace();
						}
					}
				});

				// Mail label
				//
				//
				lblMail.setText("Mail: " + parser.getMail());
				lblMail.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				Font font6 = lblMail.getFont();
				Map attributes6 = font.getAttributes();
				attributes6.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblMail.setFont(font.deriveFont(attributes6));

				// Initializing mouse listener
				lblMail.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Desktop.getDesktop().browse(
									new URI("mailto:" + parser.getMail()));
							parser.setMail("");
						} catch (URISyntaxException | IOException ex) {
							ex.printStackTrace();
						}
					}
				});

			}
		});

		btnExtractLinks.setBounds(168, 45, 117, 29);
		contentPane.add(btnExtractLinks);

	}
}

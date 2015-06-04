package com.dvd.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dvd.domain.Booking;
import com.dvd.hibernate.doa.BookingDao;
import com.dvd.hibernate.repo.BookingRepository;
import com.dvd.prop.PropReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class UpdateBooking extends javax.swing.JFrame {

	private List<Booking> bookingList = new ArrayList<>();
	private boolean isServiceOn = false;

	/**
	 * Creates new form ShopUI
	 */
	public UpdateBooking() {
		initComponents();
		PropReader properties = new PropReader();
		isServiceOn = properties.getConnectionProp();
		System.out.println(isServiceOn);
		populateTable();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		label1 = new java.awt.Label();
		jLabel1 = new javax.swing.JLabel();
		errorLabel = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		bookingTable = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(106, 161, 172));
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(23, 193, 111));
		jPanel1.setForeground(new java.awt.Color(254, 238, 238));

		label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		label1.setFont(new java.awt.Font("Ubuntu Medium", 0, 48)); // NOI18N
		label1.setForeground(new java.awt.Color(254, 254, 254));
		label1.setText("DVD Shop");

		jLabel1.setFont(new java.awt.Font("Ubuntu Medium", 0, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(254, 254, 254));
		jLabel1.setText("View Booking");

		errorLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		errorLabel.setForeground(new java.awt.Color(226, 33, 33));

		bookingTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] {
						"Booking ID", "User ID", "DVD Copy Number", "Date" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jScrollPane1.setViewportView(bookingTable);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addComponent(
												errorLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												275,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(114, 114, 114))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(269,
																				269,
																				269)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								label1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(32,
																												32,
																												32)
																										.addComponent(
																												jLabel1))))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				770,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												label1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(0,
																				18,
																				Short.MAX_VALUE)
																		.addComponent(
																				errorLabel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				28,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												107,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(339, 339, 339)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UpdateBooking.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UpdateBooking.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UpdateBooking.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UpdateBooking.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UpdateBooking().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTable bookingTable;
	private javax.swing.JLabel errorLabel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private java.awt.Label label1;

	// End of variables declaration//GEN-END:variables

	private void populateTable() {

		getData();

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Booking ID", "User ID",
				"DVD Copy Number", "Added Date " });
		bookingTable.setModel(new DefaultTableModel());

		for (Booking booking_item : bookingList) {
			model.addRow(new String[] { String.valueOf(booking_item.getId()),
					String.valueOf(booking_item.getUserID()),
					String.valueOf(booking_item.getCopyNumber()),
					String.valueOf(booking_item.getBookingAddedDate()) });

		}
		bookingTable.setModel(model);
	}

	private void getData() {
		try {
			if (isServiceOn) {
				String result = "";
				String url1 = "http://localhost:8080/getBooking";

				// String q = URLEncoder.encode(original, "UTF-8");
				URL url = new URL(url1);

				URL obj = url;
				HttpURLConnection con = (HttpURLConnection) obj
						.openConnection();

				// optional default is GET
				con.setRequestMethod("GET");

				// add request header
				con.setRequestProperty("User-Agent", "Mozilla/5.0");

				int responseCode = con.getResponseCode();
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);

				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				result = response.toString();
				// Parse to get translated text

				JSONObject jsonObject = new JSONObject(result);
				JSONArray bookingJsonList = jsonObject.getJSONArray("body");
				List<Booking> list = new ArrayList<>();

				if (bookingJsonList != null) {

					for (int i = 0; i < bookingJsonList.length(); i++) {
						JSONObject c = bookingJsonList.getJSONObject(i);

						int id = c.getInt("id");
						int copyNum = c.getInt("copyNumber");
						int userId = c.getInt("userID");
						String da = c.getString("bookingAddedDate");

						Booking d = new Booking();
						d.setBookingAddedDate(da);
						d.setUserID(userId);
						d.setCopyNumber(copyNum);
						d.setId(id);
						System.out.println(d);
						list.add(d);
					}
					bookingList = list;
				}

			} else {

				BookingRepository repository = new BookingRepository();

				List<BookingDao> s = repository.getBookingList();
				if (s != null) {
					bookingList = new ArrayList<Booking>();
					for (BookingDao bookingDao : s) {
						DateFormat df = new SimpleDateFormat(
								"MM/dd/yyyy HH:mm:ss");
						// Using DateFormat format method we can create a string
						// representation of a date with the defined format.
						String dateAdded = df.format(bookingDao
								.getBookingAddedDate());

						bookingList.add(new Booking(bookingDao.getId(),
								bookingDao.getCopyNumber(), bookingDao
										.getUserID(), dateAdded));
					}

				}

			}

		} catch (Exception e) {

			System.out.println(e);

		}
	}
}

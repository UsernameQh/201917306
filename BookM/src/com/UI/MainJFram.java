package com.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.entity.User;

public class MainJFram extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFram frame = new MainJFram();
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
	public MainJFram() {
		setResizable(false);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u7BA1\u7406\u5458\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("开始界面", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(182)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(358, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7BA1\u7406\u5458ID", "\u5F53\u524D\u7BA1\u7406\u5458\u7528", "\u5F53\u524D\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(171);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u56FE\u4E66\u7C7B\u6DFB\u52A0", null, panel_1, null);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		Uaeradd(LoginJFram.name,LoginJFram.id);
		TuShuLeiTianJian tj=new TuShuLeiTianJian();
		//panel_1.add(tj);
		//hello h=new hello();
		panel_1.add(tj);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u56FE\u4E66\u7C7B\u7BA1\u7406", null, panel_2, null);
		TuShuLeiCaoZuo cz=new TuShuLeiCaoZuo();
		panel_2.add(cz);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("\u56FE\u4E66\u6DFB\u52A0", null, panel_3, null);
		AddBooksJF ab=new AddBooksJF();
		panel_3.add(ab);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("\u67E5\u8BE2\u56FE\u4E66", null, panel_4, null);
		ChaXunTuShuJF cx=new ChaXunTuShuJF();
		panel_4.add(cx);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("\u501F\u4E66\u7533\u8BF7\u5BA1\u6838", null, panel_5, null);
		ShenQingL sq=new ShenQingL();
		panel_5.add(sq);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("\u501F\u9605\u67E5\u8BE2", null, panel_6, null);
		AdmiApplication_BorrowingQuery aab= new AdmiApplication_BorrowingQuery();
		panel_6.add(aab);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("\u8D26\u6237\u7BA1\u7406", null, panel_7, null);
		User_Management um=new User_Management();
		panel_7.add(um);
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("\u6539\u5BC6\u7801", null, panel_8, null);
		AdmiModify Am=new AdmiModify();
		panel_8.add(Am);
	}
	
	public void Uaeradd(String user,int id) {
		DefaultTableModel dtm= (DefaultTableModel)table.getModel();//获取表的模型
		dtm.setRowCount(0);//初始化模型
		Calendar cal=Calendar.getInstance();      
		int y=cal.get(Calendar.YEAR);      
		int m=1+cal.get(Calendar.MONTH);      
		int d=cal.get(Calendar.DATE);      
		int h=cal.get(Calendar.HOUR_OF_DAY);      
		int mi=cal.get(Calendar.MINUTE);      
		int s=cal.get(Calendar.SECOND); 
		String shijian=""+y+"年"+m+"月"+d+"日"+h+":"+mi+":"+s+"";
		System.out.println(shijian);
		System.out.println(id);
		Vector v = new Vector();
		v.add(id);
		v.add(user);
		v.add(shijian);
		dtm.addRow(v);
		
	}
}

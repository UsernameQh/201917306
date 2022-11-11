package com.UI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.dao.BooksDao;
import com.dao.BorrowDao;
import com.entity.Books;
import com.jdbc.BDtil;

public class AdmiApplication_BorrowingQuery extends JPanel{
	
	private JTextField textField;
	JButton button ;
	JButton button_1 ;
	
	private JTable table;
	private Integer booktypeid;
	private Float jiage;
	private String zuozhe;
	private String Loan_formid;
	private String bookname;
	private String sex;
	private String bookdesc;
	String zt;
	private JButton button_3;
	JButton button_4;
	
	/**
	 * Create the panel.
	 */
	public AdmiApplication_BorrowingQuery() {
		
		button = new JButton("\u7533\u8BF7\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zt="申请中";
				QueryApplication_Borrowing (zt);
				TextF(zt);
				
			
			}
		});
		
		button_1 = new JButton("\u501F\u4E66\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zt="已审核";
				QueryApplication_Borrowing (zt);
				TextF(zt);
			}
		});
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		button_3 = new JButton("\u8FD8\u4E66\u67E5\u8BE2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zt="已还";
				QueryApplication_Borrowing (zt);
				TextF(zt);
			}
		});
		button_4 = new JButton("\u4E0D\u901A\u8FC7\u67E5\u8BE2");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zt="审核不通过";//查询条件
				QueryApplication_Borrowing (zt);//查询显示
				TextF(zt);//填入文本框
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_3)
							.addGap(18)
							.addComponent(button_4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 578, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(301)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(300)
							))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_3)
						.addComponent(button_4))
					.addGap(30)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					
					.addGap(17))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				MouseV();
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u501F\u4E66\u72B6\u6001ID", "\u501F\u4E66\u7528\u6237ID", "\u501F\u4E66\u7528\u6237", "\u4E66\u540D\u79F0", "\u4F5C\u8005\u540D\u5B57", "\u4F5C\u8005\u6027\u522B", "\u4E66\u4EF7\u683C", "图书类别ID", "\u4E66\u7C7B\u522B", "\u4E66\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		//QueryApplication_Borrowing ();

	}
	/*
	 * 本界面查询方法
	 */
	public void QueryApplication_Borrowing (String zt){//zt为传入的查询状态
		DefaultTableModel dt=(DefaultTableModel) table.getModel();//
		dt.setRowCount(0);//初始化第一行
		int id=LoginJFram.ids;
		Connection con=null;
		try {
			con=BDtil.LianJie();
			ResultSet a=BorrowDao.ShenQC(con, zt);
			while(a.next()) {
				Vector vt=new Vector();
				vt.add(a.getString(1));
				vt.add(a.getString(3));
				vt.add(a.getString(4));
				vt.add(a.getString(5));
				vt.add(a.getString(6));
				vt.add(a.getString(7));
				vt.add(a.getString(8));
				vt.add(a.getString(9));
				vt.add(a.getString(10));
				vt.add(a.getString(11));
				dt.addRow(vt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 向文本框添加内容
	 */
	public void TextF(String zt) {
		if(zt.equals("申请中")) {
			this.textField.setText("申请查询");
		}else if(zt.equals("已审核")) {
			this.textField.setText("借书查询");
		}else if(zt.equals("已还")) {
			this.textField.setText("还书查询");
		}else if(zt.equals("审核不通过")) {
			this.textField.setText("审核不通过");
		}
	}
	/*
	 * 鼠标事件方法
	 */
	protected void MouseV() {
		// TODO Auto-generated method stub
		if(this.textField.getText().equals("借书查询")) {
			int row=table.getSelectedRow();
			this.Loan_formid=(String) table.getValueAt(row, 0);//获取状态编号
			//System.out.println(Loan_formid);
			this.bookname=(String) table.getValueAt(row, 3);
			this.zuozhe=(String) table.getValueAt(row, 4);
			this.sex=(String) table.getValueAt(row, 5);
			this.jiage=Float.valueOf((String) table.getValueAt(row, 6));
			this.booktypeid=Integer.valueOf((String)table.getValueAt(row, 7)) ;
			this.bookdesc=(String) table.getValueAt(row, 9);
			System.out.println("01"+this.Loan_formid);
		}else {
			Initialize_Variable();
			System.out.println("00"+this.Loan_formid);
			
		}
	}
	/*
	 * 当还书时图书要相应增加
	 */
	public void Audit_But() {
		Books bk = new Books();
		bk.setBookname(bookname);
		bk.setZuozhe(zuozhe);
		bk.setZuozhexb(sex);
		bk.setJiage(jiage);
		bk.setBookID(booktypeid);
		bk.setBookdesc(bookdesc);
		try {
			Connection con=BDtil.LianJie();
			int a=BooksDao.addBooks(con, bk);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * 初始化变量
	 */

	public void Initialize_Variable() {
		this.Loan_formid=null;
		this.bookdesc=null;
		this.bookname=null;
		this.booktypeid=null;
		this.jiage=null;
		this.sex=null;
		this.zuozhe=null;
	}

}

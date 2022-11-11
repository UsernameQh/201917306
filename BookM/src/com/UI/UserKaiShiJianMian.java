package com.UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.BooksDao;
import com.dao.BorrowDao;
import com.entity.Books;
import com.entity.BorrowBooks;
import com.entity.TypeBook;
import com.jdbc.BDtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserKaiShiJianMian extends JPanel {
    JTextField nametext;
	private JTextField tushuming;
	private JTextField zuozhe;
	private JTextField bianhao;
	private JTextField mc;
	private JTextField jiage;
	private JTable table;
	JComboBox leibieBox ;
	JButton jieshu;
	String zhuangtai;
	int userid;
	String user;
	String xb;
	String zuoz;
	String miaoshu;
	String typebook;
	String book;
	String bookid;
	String typeid;
	float jieg;
	static public boolean pan;
	JRadioButton radioButton;

	/**
	 * Create the panel.
	 */
	public UserKaiShiJianMian() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		
		nametext = new JTextField();
		nametext.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		nametext.setEditable(false);
		nametext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		tushuming = new JTextField();
		tushuming.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u8005\uFF1A");
		
		zuozhe = new JTextField();
		zuozhe.setColumns(10);
		
		radioButton = new JRadioButton("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		leibieBox = new JComboBox();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Enquire();//查询方法
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7\uFF1A");
		
		bianhao = new JTextField();
		bianhao.setEditable(false);
		bianhao.setColumns(10);
		
		JLabel label_1 = new JLabel("\u540D\u79F0\uFF1A");
		
		mc = new JTextField();
		mc.setEditable(false);
		mc.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4EF7\u683C\uFF1A");
		
		jiage = new JTextField();
		jiage.setEditable(false);
		jiage.setColumns(10);
		
		jieshu = new JButton("\u501F\u9605\u7533\u8BF7");
		jieshu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//借阅按钮事件
				JieYue();//借阅方法
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(251)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(286, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tushuming, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(zuozhe, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(radioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(leibieBox, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button)
									.addGap(12)))
							.addGap(44))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bianhao, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(mc, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jiage, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addGap(108))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(299)
					.addComponent(jieshu)
					.addContainerGap(346, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButton)
						.addComponent(zuozhe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(tushuming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(leibieBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(65)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jiage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(mc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(bianhao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(jieshu)
					.addGap(23))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {//鼠标点击事件
			@Override
			public void mousePressed(MouseEvent arg0) {
				MouseX();//事件方法
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u6027\u522B", "\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u7C7B\u522BID", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		AddBooksJF csh=new AddBooksJF();
		csh.ABox(this.leibieBox);//初始化下拉框函数
		Enquire();
		LoginJFram n = new LoginJFram();
		this.nametext.setText(n.names);
	}
	/*
	 * 申请借书方法
	 */
protected void JieYue() {
		// TODO Auto-generated method stub
	if(this.bianhao.getText()!=null&&this.bianhao.getText().equals("")) {
		JOptionPane.showMessageDialog(null, "您还没选中");
	}else {
		LoginJFram jn = new LoginJFram();
		this.user=jn.names;
		this.userid=jn.ids;
		this.zhuangtai="申请中";
		BorrowBooks bbk = new BorrowBooks();
		bbk.setUserID(Integer.toString(this.userid));
		bbk.setUserName(this.user);
		bbk.setZhuangtai(this.zhuangtai);
		bbk.setBooksName(this.book);
		bbk.setTypebook(this.typebook);
		bbk.setZuozhe(this.zuoz);
		bbk.setZuozhexb(this.xb);
		bbk.setJiage(this.jieg);
		bbk.setBookDesc(this.miaoshu);
		bbk.setTypeid(this.typeid);
		//System.out.println(this.typeid);
		Connection con=null; 
		//System.out.println(jieg);
		BorrowDao bd=new BorrowDao();
		try {
			con=BDtil.LianJie();
			int a=bd.ShenQing(con, bbk);
			if(a==1) {
				JOptionPane.showMessageDialog(null, "申请成功，等待管理员审核！");
				ShanChuTuShu() ;//书被借走了，相当与删除图书
				Enquire();//调用查询，相当于更新
				Initialization();//清空文本框
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		 
	}
	/*
 * 鼠标事件
 */
	protected void MouseX() {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();//初始化
		this.bianhao.setText((String)table.getValueAt(row, 0));//获取row行0咧的值
		bookid=this.bianhao.getText();
		this.mc.setText((String)table.getValueAt(row, 1));
		this.jiage.setText((String)table.getValueAt(row, 4));
		this.book=this.mc.getText();
		this.typebook=(String) table.getValueAt(row, 7);
		this.zuoz=(String)table.getValueAt(row, 2);
		this.xb=(String) table.getValueAt(row, 3);
		this.jieg=Float.valueOf((String) table.getValueAt(row, 4));
		this.miaoshu=(String) table.getValueAt(row, 5);
		this.typeid=(String) table.getValueAt(row, 6);
	}
	/*
	 * 发出借书申请时相应的书本要减少
	 */
	public void ShanChuTuShu() {
		String booksid=this.bianhao.getText();
		System.out.println(booksid);
		try {
			Connection con=BDtil.LianJie();
			int a=BooksDao.DeleteBooks(con, booksid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
 * 查询函数
 */
	protected void Enquire() {
		// TODO Auto-generated method stub
		String bookname=this.tushuming.getText();//获取值
		String zuozhe=this.zuozhe.getText();//获取值
		TypeBook leibie =(TypeBook) this.leibieBox.getSelectedItem();
		Integer id=Integer.parseInt(leibie.getId());//获取值
		DefaultTableModel dt=(DefaultTableModel) table.getModel();
		dt.setRowCount(0);
		Connection con=null;
		Books bk = new Books();
		bk.setBookname(bookname);
		bk.setZuozhe(zuozhe);
		bk.setBookID(id);
		//System.out.println(bk.getBookname()+":"+bk.getZuozhe()+":"+bk.getBookID());
		if(radioButton.isSelected()) {
			this.pan=true;
		}else {
			this.pan=false;
		}
		System.out.println(pan);
		try {
			con=BDtil.LianJie();
			ResultSet a=BooksDao.ChaoXunBooks(con, bk);
			
			while(a.next()) {
				Vector vt=new Vector();
				vt.add(a.getString(1));
				vt.add(a.getString(2));
				vt.add(a.getString(3));
				vt.add(a.getString(4));
				vt.add(a.getString(5));
				vt.add(a.getString(7));
				vt.add(a.getString(6));
				vt.add(a.getString(9));
				dt.addRow(vt);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				BDtil.CloseCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
	/*
	 * 初始化文本框方法
	 */
	public void Initialization() {
		this.bianhao.setText("");
		this.mc.setText("");
		this.jiage.setText("");
	}
		
	}


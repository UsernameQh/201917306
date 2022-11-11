package com.UI;

import javax.swing.JPanel;
import javax.management.modelmbean.ModelMBean;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.BooksDao;
import com.dao.TypeBookDao;
import com.entity.Books;
import com.entity.TypeBook;
import com.jdbc.BDtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChaXunTuShuJF extends JPanel {
	private JTable table;
	private JTextField nametext;
	private JTextField zuozhetext;
	JComboBox leibieBox;
	JButton button ;
	private JLabel label_3;
	JTextField haotext;
	private JLabel label_4;
	private JTextField nameField_1;
	private JLabel label_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField jiagextext;
	private JTextField zuozheField_3;
	private JButton btnNewButton;
	private JButton deleteButton_1;
	JRadioButton nanButton;
	JRadioButton nvButton;
	JComboBox xialacomboBox;
	JTextArea miaotextArea ;
	private JRadioButton danxuan;
	static public boolean pan;
	String p;
	/**
	 * Create the panel.
	 */
	public ChaXunTuShuJF() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		nametext = new JTextField();
		nametext.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		zuozhetext = new JTextField();
		zuozhetext.setColumns(10);
		
		leibieBox = new JComboBox();
		
		button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JieGuo();//调用查询结果
			}
		});
		
		label_3 = new JLabel("\u4E66\u7F16\u53F7\uFF1A");
		
		haotext = new JTextField();
		haotext.setEditable(false);
		haotext.setColumns(10);
		
		label_4 = new JLabel("\u4E66\u540D\u79F0\uFF1A");
		
		nameField_1 = new JTextField();
		nameField_1.setColumns(10);
		
		label_5 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		nanButton = new JRadioButton("\u7537");
		buttonGroup.add(nanButton);
		nanButton.setSelected(true);
		
		nvButton = new JRadioButton("\u5973");
		buttonGroup.add(nvButton);
		
		JLabel label_6 = new JLabel("\u4EF7\u683C\uFF1A");
		
		jiagextext = new JTextField();
		jiagextext.setColumns(10);
		
		JLabel label_7 = new JLabel("\u4F5C\u8005\uFF1A");
		
		zuozheField_3 = new JTextField();
		zuozheField_3.setColumns(10);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		xialacomboBox = new JComboBox();
		
		JLabel label_9 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		miaotextArea = new JTextArea();
		
		btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent et) {
				
				UptadeBooks(et);
				
			}
		});
		
		deleteButton_1 = new JButton("\u5220\u9664");
		deleteButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteTuShu();
				
			}
		});
		
		danxuan = new JRadioButton("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nametext, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(zuozhetext, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(danxuan)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(leibieBox, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(haotext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6)
								.addComponent(label_9))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(jiagextext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(nameField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(12)
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(nanButton)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(nvButton))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(zuozheField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(xialacomboBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(miaotextArea, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(deleteButton_1)))))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(leibieBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(zuozhetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(danxuan)
						.addComponent(button))
					.addGap(44)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(haotext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(nameField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(nanButton)
						.addComponent(nvButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(jiagextext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7)
								.addComponent(zuozheField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8)
								.addComponent(xialacomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(label_9))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(miaotextArea, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(62, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(deleteButton_1))
							.addGap(74))))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				MouseL(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		AddBooksJF abj=new AddBooksJF();
		abj.ABox(this.leibieBox);//调用初始化下拉框
		JieGuo(); 
		miaotextArea. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));//设置textArea边框
		miaotextArea.setLineWrap(true); //设置textArea自动换行
		AddBooksJF.ABox(this.xialacomboBox);
	}
	/*
	 * 删除图书方法
	 */
	protected void DeleteTuShu() {
		// TODO Auto-generated method stub
		if(this.haotext.getText()!=null&&this.haotext.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请选择");
		}else {
			
			Connection con=null;
			try {
				con=BDtil.LianJie();
				int a = BooksDao.DeleteBooks(con, this.haotext.getText());
				if(a==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					QingKongl();
					JieGuo();
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
/*
 * 修改
 */
	protected void UptadeBooks(ActionEvent et) {
		// TODO Auto-generated method stub
		if(this.haotext.getText()!=null&&this.haotext.getText().equals("")||this.jiagextext.getText()!=null&&this.jiagextext.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请选择");
					
		}else {
			System.out.println("shabi");
			String sex=null;
			//判断单选的状态并赋值
			if(nanButton.isSelected()) {
				sex="男";
			}else if(nvButton.isSelected()) {
				sex="女";
			} 
			
			TypeBook tbook=(TypeBook) this.xialacomboBox.getSelectedItem();
			Integer booktypeid=Integer.parseInt(tbook.getId());
			Books bk=new Books(Integer.parseInt(this.haotext.getText()),this.nameField_1.getText(),this.zuozheField_3.getText(),sex,Float.parseFloat(this.jiagextext.getText()),booktypeid,this.miaotextArea.getText());
			Connection con=null;
			try {//执行调用数据库后台
				con=BDtil.LianJie();
				int na=BooksDao.UpDateBooks(con, bk);
				if(na==1) {
					JieGuo();//调用刷新结果方法
					JOptionPane.showMessageDialog(null, "修改成功！");
					QingKongl();//清除方法
				}else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				
			} finally {
				// TODO: handle finally clause
				try {
					BDtil.CloseCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	/*
	 * 获取数据鼠标事件
	 */
protected void MouseL(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		this.haotext.setText((String)table.getValueAt(row, 0));
		
		this.nameField_1.setText((String)table.getValueAt(row, 1));
		this.zuozheField_3.setText((String) table.getValueAt(row, 2));
		String sex=(String) table.getValueAt(row, 3);
		System.out.println(row);
		if("男".equals(sex)) {
			nanButton.setSelected(true);
		}else if("女".equals(sex)) {
			nvButton.setSelected(true);
		}
		this.jiagextext.setText((String) table.getValueAt(row, 4));
		this.miaotextArea.setText((String) table.getValueAt(row, 5));
		String type=(String) table.getValueAt(row, 6);
		int n=this.xialacomboBox.getItemCount();
		for(int i=0;i<n;i++) {
			TypeBook bt=(TypeBook) this.xialacomboBox.getItemAt(i);
			if(type.equals(bt.getTypebook())) {
				this.xialacomboBox.setSelectedIndex(i);
			}
		}
		
	}
	/*
	 * 清空框方法
	 */
	public void QingKongl() {
		this.haotext.setText("");
		this.nameField_1.setText("");
		this.zuozheField_3.setText("");
		this.jiagextext.setText("");
		this.miaotextArea.setText("");
		if(this.xialacomboBox.getItemCount()>0) {
			this.xialacomboBox.setSelectedIndex(0);
		}
		String sex=null;
		if(nvButton.isSelected()) {
			nanButton.setSelected(true);
		}
	}
	/*
	 * 查询方法
	 */
	protected void JieGuo() {
		// TODO Auto-generated method stub
		//获取各个组件的值
		String bookname=this.nametext.getText();
		String zuozhe=this.zuozhetext.getText();
		TypeBook leibie=(TypeBook) this.leibieBox.getSelectedItem();
		int id=Integer.parseInt(leibie.getId());
		DefaultTableModel dt=(DefaultTableModel) table.getModel();
		dt.setRowCount(0);
		Connection con=null;
		Books bk = new Books();
		bk.setBookname(bookname);
		bk.setZuozhe(zuozhe);
		bk.setBookID(id);
		if(danxuan.isSelected()) {
			this.pan=true;
		}else {
			this.pan=false;
		}
		try {//数据库执行调用
			con=BDtil.LianJie();
			ResultSet a=BooksDao.ChaoXunBooks_o(con, bk);
			
			while(a.next()) {
				//添加到动态数组
				Vector vt=new Vector();
				vt.add(a.getString(1));
				vt.add(a.getString(2));
				vt.add(a.getString(3));
				vt.add(a.getString(4));
				vt.add(a.getString(5));
				vt.add(a.getString(7));
				vt.add(a.getString(9));
				//添加到表格模型
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
}

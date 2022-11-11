package com.UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.TypeBookDao;
import com.entity.TypeBook;
import com.jdbc.BDtil;
import com.panduan.PanDuan;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TuShuLeiCaoZuo extends JPanel {
	private JTextField chaxunleibie;
	private JTable table;
	private JTextField bianhao;
	private JTextField textField;
	JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public TuShuLeiCaoZuo() {
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		chaxunleibie = new JTextField();
		chaxunleibie.setColumns(10);
		
		JButton button = new JButton("\u70B9\u51FB\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CX(e);//查询函数
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("\u5220\u9664\u6216\u4FEE\u6539\u56FE\u4E66\u7C7B\u522B");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u7F16\u53F7\uFF1A");
		
		bianhao = new JTextField();
		bianhao.setEditable(false);
		bianhao.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u76F8\u5173\u63CF\u8FF0\uFF1A");
		
		textArea = new JTextArea();
		
		JButton button_1 = new JButton("\u70B9\u51FB\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xiugai(e);
			}
		});
		
		JButton button_2 = new JButton("\u70B9\u51FB\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			delete(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(100, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addGap(33)
								.addComponent(chaxunleibie, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_4)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textArea, 0, 0, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(bianhao, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_3)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_2)
									.addGap(38)))))
					.addGap(113))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(231)
					.addComponent(label_1)
					.addContainerGap(290, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(chaxunleibie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(bianhao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4))))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouse(e);//鼠标事件
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7C7B\u522B\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u63CF\u56FE\u4E66\u7C7B\u522B\u76F8\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(2).setPreferredWidth(114);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		textArea. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));//设置textArea边框
		textArea.setLineWrap(true); //设置textArea自动换行
		xun();
	}
/*
 * 删除方法
 */
	protected void delete(ActionEvent e) {
		String id=this.bianhao.getText();
		Connection con = null;
		try {
			con=BDtil.LianJie();
			int a=TypeBookDao.delete(con, id);
			if(a==1) {
				JOptionPane.showMessageDialog(null, "删除成功");
				xun();//刷新查询方法
				QingKong();//初始化文本框
			}else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		} catch (Exception e1) {
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

	protected void xiugai(ActionEvent e) {
		// TODO Auto-generated method stub
		String i=this.bianhao.getText();
		String n=this.textField.getText();
		String m=this.textArea.getText();
		TypeBook dt=new TypeBook(i,n,m);
		Connection con = null;
		if(PanDuan.TUtil(i)) {
			JOptionPane.showMessageDialog(null, "请选择修改的图书类别");
		}
		try {
			con=BDtil.LianJie();
			int a=TypeBookDao.Updata(con, dt);
			if(a==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				QingKong();
				xun();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(i+" "+n+" "+m);
		}finally {
			try {
				BDtil.CloseCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void mouse(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		bianhao.setText((String)table.getValueAt(row, 0));
		textField.setText((String)table.getValueAt(row, 1));
		textArea.setText((String)table.getValueAt(row, 2));
	}

	protected void CX(ActionEvent e) {
		// TODO Auto-generated method stub
		xun();
		
	}
	public  void xun() {
		DefaultTableModel dtm= (DefaultTableModel)table.getModel();//获取表的模型
		dtm.setRowCount(0);//初始化模型
		String bkn=this.chaxunleibie.getText();//获取文本框的值
		Connection con = null;
		TypeBook tb=new TypeBook();
		ResultSet re=null;
		tb.setTypebook(bkn);
		try {//调用执行后台数据库查询方法
			con=BDtil.LianJie();
			re=TypeBookDao.ChaXun(con, tb);
			while(re.next()) {
				Vector vt=new Vector();//new动态数组
				vt.add(re.getString(1));//向里面添加查询到的数据
				vt.add(re.getString(2));
				vt.add(re.getString(3));
				dtm.addRow(vt);//把动态数组添加到表模型中
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				BDtil.CloseCon(con);//关闭数据库连接
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void QingKong() {
		this.bianhao.setText("");
		this.textArea.setText("");
		this.textField.setText("");
	}
}

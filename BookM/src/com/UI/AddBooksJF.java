package com.UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.dao.BooksDao;
import com.dao.TypeBookDao;
import com.entity.Books;
import com.entity.TypeBook;
import com.jdbc.BDtil;
import com.panduan.PanDuan;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AddBooksJF extends JPanel {
	private JTextField booknametext;
	private JTextField zuozhetext;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField jiagetext;
	private JTextArea textArea;
	public JComboBox typebookBox ;
	JRadioButton nanradio ;
	JRadioButton nvradio ;

	/**
	 * Create the panel.
	 */
	public AddBooksJF() {
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		booknametext = new JTextField();
		booknametext.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		zuozhetext = new JTextField();
		zuozhetext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		nanradio = new JRadioButton("\u7537");
		buttonGroup.add(nanradio);
		nanradio.setSelected(true);
		
		nvradio = new JRadioButton("\u5973");
		buttonGroup.add(nvradio);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		jiagetext = new JTextField();
		jiagetext.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		typebookBox = new JComboBox();
		
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		textArea = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addbooks(e);//调用添加图书函数
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QingKongKuang();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(typebookBox, 0, 88, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booknametext, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nanradio)
									.addGap(18)
									.addComponent(nvradio)))
							.addGap(89)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(zuozhetext))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jiagetext))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
									.addComponent(button_1))
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))))
					.addGap(184))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(booknametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(zuozhetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nanradio)
						.addComponent(nvradio)
						.addComponent(lblNewLabel_1)
						.addComponent(jiagetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(typebookBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(27))
		);
		setLayout(groupLayout);
		textArea. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));//设置textArea边框
		textArea.setLineWrap(true); //设置textArea自动换行
		ABox(this.typebookBox);
	}
	/**
	 * 添加事件，添加图书
	 * @param e
	 */
	protected void Addbooks(ActionEvent e) {
		// 获取文本框的内容
		String bookname=this.booknametext.getText();
		String zuozhe=this.zuozhetext.getText();
		String jiage=this.jiagetext.getText();
		String bookdesc=this.textArea.getText();
		TypeBook tb=(TypeBook) typebookBox.getSelectedItem();
		String bookID=tb.getId();
		String zuozhexb="";
		if(nanradio.isSelected()) {
			zuozhexb="男";
		}else if(nvradio.isSelected()) {
			zuozhexb="女";
		}
		if (PanDuan.TUtil(bookname)) {//判断文本框是否为空
			JOptionPane.showMessageDialog(null, "图书不能为空！");
		} else if (PanDuan.TUtil(zuozhe)) {//判断密码框是否为空

			JOptionPane.showMessageDialog(null, "作者不能为空！");
		} else if(PanDuan.TUtil(jiage)) {
			JOptionPane.showMessageDialog(null, "价格不能为空！");
		}else if(PanDuan.TUtil(bookdesc)) {
			JOptionPane.showMessageDialog(null, "描述不能为空！");
		}else {
			Connection con=null;
			Books bk=new Books(bookname, zuozhe, zuozhexb, Float.parseFloat(jiage), Integer.parseInt(bookID), bookdesc);
			try {
				con=BDtil.LianJie();
				int a=BooksDao.addBooks(con, bk);
				if(a==1) {
					JOptionPane.showMessageDialog(null, "添加成功");
					QingKongKuang();//调用清楚方法
				}else {
					JOptionPane.showMessageDialog(null, "添加失败");
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
	/**
	 * 初始化下拉框函数
	 */
	static public void ABox(JComboBox typebookBox) {
		// TODO Auto-generated method stub
		TypeBook tb=null;
		Connection con=null;
		try {
			con=BDtil.LianJie();
			ResultSet re=TypeBookDao.ChaXun(con, new TypeBook());
			while(re.next()) {
				tb=new TypeBook();
				tb.setId(re.getString(1));
				tb.setTypebook(re.getString(2));
				typebookBox.addItem(tb);
				System.out.println(re.getString(2)+re.getString(1));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				BDtil.CloseCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * 
	 * 清楚文本框里的文字方法
	 */
	public void QingKongKuang() {
		this.booknametext.setText("");
		this.zuozhetext.setText("");
		this.jiagetext.setText("");
		this.textArea.setText("");
		this.nanradio.setSelected(true);
		if(this.typebookBox.getItemCount()>0) {
			this.typebookBox.setSelectedIndex(0);
		}
	}
}

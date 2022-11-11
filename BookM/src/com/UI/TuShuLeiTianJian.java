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

import com.dao.TypeBookDao;
import com.entity.TypeBook;
import com.jdbc.BDtil;
import com.panduan.PanDuan;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TuShuLeiTianJian extends JPanel {
	private JTextField textField;
	static JTextArea textArea;
	static TypeBook tbuser=null;
	static int a;

	/**
	 * Create the panel.
	 */
	public TuShuLeiTianJian() {
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
	    textArea = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent et) {
				TianJian(et);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent er) {
				Chongzhi(er);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(147)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addComponent(label)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(38))
		);
		setLayout(groupLayout);
		textArea. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));//����textArea�߿�
		textArea.setLineWrap(true);  
	}

	protected void Chongzhi(ActionEvent er) {
		// TODO Auto-generated method stub
		this.textField.setText("");//��ʼ���ı���
		this.textArea.setText("");//��ʼ��textArea
	}
/*
 * ���ͼ�鷽��
 */
	protected void TianJian(ActionEvent arg0) {
		// TODO Auto-generated method stub
		a=0;
		String typebook=this.textField.getText();
		String miaoshu=this.textArea.getText();
		//�ж�����Ƿ�Ϊ�գ�������ʾ��
		if(PanDuan.TUtil(typebook)) {
			JOptionPane.showMessageDialog(null, "ͼ���������Ϊ�գ����������룡");//
		}else if(PanDuan.TUtil(miaoshu)) {
			JOptionPane.showMessageDialog(null, "ͼ��������������������룡");
		}else {
			Connection con=null;
			TypeBook tb=new TypeBook();
			tb.setTypebook(typebook);
			tb.setDesc(miaoshu);
			int a;
			try {
				con=BDtil.LianJie();
				a=TypeBookDao.BookAdd(con, tb);
				if(a==1) {
					JOptionPane.showMessageDialog(null, "��ӳɹ���");
					this.textField.setText("");//��ʼ���ı���
					this.textArea.setText("");//��ʼ��textArea
				}else {
					JOptionPane.showMessageDialog(null, "���ʧ�ܣ�ԭ�������");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {//�ر��������ݿ�
				try {
					BDtil.CloseCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}

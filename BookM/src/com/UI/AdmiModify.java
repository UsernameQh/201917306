package com.UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.dao.UserDao;
import com.jdbc.BDtil;
import com.panduan.PanDuan;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmiModify extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AdmiModify() {
		
		JLabel label = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4FEE\u6539\u4E2A\u4EBA\u5BC6\u7801");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		
		JButton button = new JButton("\u4FEE\u6539");
		//修改按钮事件
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//调用修改方法
				Modify();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(362, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(334, Short.MAX_VALUE)
					.addComponent(label_2)
					.addGap(292))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(324)
					.addComponent(button)
					.addContainerGap(347, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(label_2)
					.addGap(128)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(35))
		);
		setLayout(groupLayout);
		this.textField.setText(LoginJFram.name);
	}
	//修改事件方法
	public void Modify() {
		String id=Integer.toString(LoginJFram.id);
		String pss=this.textField_1.getText();
		if(PanDuan.TUtil(pss)) {
			JOptionPane.showMessageDialog(null, "修改为空，请重新输入！");
		}else {
			JOptionPane.showMessageDialog(null, "确认修改");
			try {
				Connection con=BDtil.LianJie();
				int a =UserDao.Update_Andmi(con, id,pss);
				if(a==1) {
					JOptionPane.showMessageDialog(null, "修改成功");
					this.textField_1.setText(null);
				}else {
					JOptionPane.showMessageDialog(null, "错误");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	
}

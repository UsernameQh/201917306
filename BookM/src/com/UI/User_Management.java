package com.UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ModifyingData.Modifying_Data;
import com.dao.OrdinaryUsersDao;
import com.jdbc.BDtil;
import com.panduan.PanDuan;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_Management extends JPanel {
	private JTable table_1;
	//��ſ�
	private JTextField textField;
	//���ֿ�
	private JTextField textField_1;
	//�����
	private JTextField textField_2;
	//�޸İ�ť
	JButton button;
	//ɾ����ť
	JButton button_1;
	//ˢ�°�ť
	JButton button_2;

	/**
	 * Create the panel.
	 */
	public User_Management() {
		
		JLabel label = new JLabel("\u666E\u901A\u7528\u6237\u5217\u8868");//����label
		label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblId = new JLabel("ID:");
		//ʵ��������
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		button = new JButton("\u4FEE\u6539");
		//�޸İ�ť�¼�
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�����޸ķ���
				ButtonListener_1();
			}
		});
		
		button_1 = new JButton("\u5220\u9664");
		//ɾ����ť�¼�
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//����ɾ������
				Delete_User();
			}
		});
		
		button_2 = new JButton("\u5237\u65B0");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(lblId)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_2)
									.addGap(32)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(250)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addComponent(label)
					.addGap(55)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button)
						.addComponent(button_2))
					.addGap(48))
		);
		
		table_1 = new JTable();
		//����ȡֵ�¼�
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//���¼��е�������ȡֵ����
				Mouse_Value();
			}
		});
		//��ģ��
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u7528\u6237\u540D", "\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_1);
		setLayout(groupLayout);
		Refresh_Display();

	}
	//xie
	//ˢ����ʾ���߲�ѯȫ������
	public void Refresh_Display() {
		DefaultTableModel dt=(DefaultTableModel) table_1.getModel();//ȡģ��
		dt.setRowCount(0);//��ʼ����һ��
		try {
			Connection con = BDtil.LianJie();
			ResultSet re=OrdinaryUsersDao.Query_allUser(con);
			while(re.next()) {
				Vector vt=new Vector();
				vt.add(re.getString(1));
				vt.add(re.getString(2));
				vt.add(re.getString(3));
				dt.addRow(vt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����ȡֵ�¼�����
	public void Mouse_Value() {
		//��ȡ������
		int row=table_1.getSelectedRow();
		//���ı�����ֵ
		this.textField.setText((String) table_1.getValueAt(row, 0));
		this.textField_1.setText((String) table_1.getValueAt(row, 1));
		this.textField_2.setText((String) table_1.getValueAt(row, 2));
		//System.out.println(textField.getText()+textField_1.getText()+textField_2.getText());
		
	}
	//����ı��򷽷�
	public void Empty_Box() {
		this.textField.setText(null);
		this.textField_1.setText(null);
		this.textField_2.setText(null);
	}
	//�޸İ�ť�¼�����
	public void ButtonListener_1(){
		Modifying_Data mf=new Modifying_Data();
		if(PanDuan.FUtil(this.textField_2.getText())) {
			mf.Modifying(this.textField.getText(),this.textField_2.getText());
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			Empty_Box();
			Refresh_Display();
		}else {
			
			JOptionPane.showMessageDialog(null, "�޸�Ϊ�գ�������ѡ�л����룡");
		}
		
	}
	//ɾ����ť�¼�����
	public void Delete_User() {
		if(PanDuan.FUtil(this.textField.getText())) {
			try {
				Connection con = BDtil.LianJie();
				int i=OrdinaryUsersDao.delete(con, this.textField.getText());
				if(i==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					Empty_Box();
					Refresh_Display();
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "û��ѡ�У�������ѡ�У�");
		}
	}
}

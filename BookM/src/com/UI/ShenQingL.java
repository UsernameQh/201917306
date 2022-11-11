package com.UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.BooksDao;
import com.dao.BorrowDao;
import com.entity.Books;
import com.jdbc.BDtil;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShenQingL extends JPanel {
	private JTable table;
	JButton ShenHeTbutton;
	JButton ShenHeFbutton;
	JButton gengxin;
	String Loan_formid;
	String bookname;
	String zuozhe;
	String sex;
	float jiage;
	Integer booktypeid;
	String bookdesc;
	/**
	 * Create the panel.
	 */
	public ShenQingL() {
		
		JLabel label = new JLabel("\u501F\u4E66\u7533\u8BF7\u5217\u8868");
		label.setFont(new Font("����", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		ShenHeTbutton = new JButton("\u5BA1\u6838\u901A\u8FC7");
		ShenHeTbutton.addActionListener(new ActionListener() {//��˰�ť�¼�
			public void actionPerformed(ActionEvent e) {
				PastTrial();//���󷽷��������ͨ������˱���������
			}
		});
		
		ShenHeFbutton = new JButton("\u5BA1\u6838\u4E0D\u901A\u8FC7");
		ShenHeFbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Loan_formid!=null) {
					Audit_But();
					Audit_Status();
				}else {
					JOptionPane.showMessageDialog(null, "��ѡ��");
				}
				
			}
		});
		
		gengxin = new JButton("\u66F4\u65B0");
		gengxin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Condition();//�����¼�
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(286)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(208)
							.addComponent(ShenHeTbutton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gengxin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ShenHeFbutton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(label)
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ShenHeTbutton)
						.addComponent(gengxin)
						.addComponent(ShenHeFbutton))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				MouseV();//�����ֵ	
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u501F\u4E66\u72B6\u6001ID", "\u501F\u4E66\u7528\u6237ID", "\u501F\u4E66\u7528\u6237", "\u4E66\u540D\u79F0", "\u4F5C\u8005\u540D\u5B57", "\u4F5C\u8005\u6027\u522B", "\u4E66\u4EF7\u683C", "ͼ�����ID", "\u4E66\u7C7B\u522B", "\u4E66\u63CF\u8FF0"
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
		Condition();
		
	}
	/*
	 * ����¼�����
	 */
	protected void MouseV() {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		this.Loan_formid=(String) table.getValueAt(row, 0);//��ȡ״̬���
		//System.out.println(Loan_formid);
		this.bookname=(String) table.getValueAt(row, 3);
		this.zuozhe=(String) table.getValueAt(row, 4);
		this.sex=(String) table.getValueAt(row, 5);
		this.jiage=Float.valueOf((String) table.getValueAt(row, 6));
		this.booktypeid=Integer.valueOf((String)table.getValueAt(row, 7)) ;
		this.bookdesc=(String) table.getValueAt(row, 9);
	}
	/*
	*����˷��� ��������ʱ��˱��л���������ͼ�飬״̬��Ϊ���ͨ��
	*/ 
	protected void PastTrial() {
		// TODO Auto-generated method stub
		if(Loan_formid!=null) {
			String zt="�����";
			try {
				Connection con=BDtil.LianJie();
				int a=BorrowDao.Changing_State(con, zt, Loan_formid);
				if(a==1) {
					JOptionPane.showMessageDialog(null, "��˳ɹ�");
					Condition();
					Loan_formid=null;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "��ѡ��");
		}
	}
	/*
	 * ��˲���ʱ��״̬,��״̬��Ϊ��˲�ͨ��
	 */
	public void Audit_Status(){
		String zt="��˲�ͨ��";
		try {
			Connection con=BDtil.LianJie();
			int a=BorrowDao.Changing_State(con, zt, Loan_formid);
			if(a==1) {
				JOptionPane.showMessageDialog(null, "��˳ɹ�");
				Condition();
				Loan_formid=null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * ����ͬ��ʱԭ�����ٵ�ͼ��Ҫ��Ӧ����,��˲���ʱ��ͼ��������ͼ��
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
	 * ״̬��ѯ����
	 */
	public void Condition() {
		DefaultTableModel dt=(DefaultTableModel) table.getModel();//
		dt.setRowCount(0);//��ʼ����һ��
		String zt="������";
		Connection con=null;
		try {
			con=BDtil.LianJie();
			ResultSet a=BorrowDao.ShenQC(con,zt);
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
}

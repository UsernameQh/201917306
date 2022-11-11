package com.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserMianJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMianJFrame frame = new UserMianJFrame();
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
	public UserMianJFrame() {
		setResizable(false);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u7528\u6237\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
		);
		this.setLocationRelativeTo(null);//显示居中
		JPanel panel = new JPanel();//在tabbedPane中创建面板panel
		panel.setToolTipText("");
		tabbedPane.addTab("\u7528\u6237\u5F00\u59CB\u754C\u9762", null, panel, null);
		contentPane.setLayout(gl_contentPane);
		UserKaiShiJianMian uk= new UserKaiShiJianMian();//实例化开始见面
		panel.add(uk);//将开始界面添加到主界面
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u67E5\u8BE2", null, panel_1, null);
		Application_BorrowingQuery abq= new Application_BorrowingQuery();//实例化查询界面
		panel_1.add(abq);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u4FEE\u6539\u8D44\u6599", null, panel_2, null);
		JFModifying_Data md=new JFModifying_Data();
		panel_2.add(md);
		
		
	}
}

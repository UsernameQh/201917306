package com.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.panduan.PanDuan;
import com.dao.OrdinaryUsersDao;
import com.dao.UserDao;
import com.entity.OrdinaryUsers;
import com.entity.User;
import com.jdbc.BDtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class LoginJFram extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JPasswordField password;
	private JButton button;
	private JButton button_1;
	
	User us = null;
	static String name=null;
	static int id;
	static String names=null;
	static int ids;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton radioButton;
	JRadioButton radioButton_1 ;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					LoginJFram frame = new LoginJFram();
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
	public LoginJFram() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u767B\u5F55");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel label_2 = new JLabel("\u5BC6   \u7801\uFF1A");
		
		nametext = new JTextField();
		nametext.setColumns(10);
		
		password = new JPasswordField();
		
		button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton.isSelected()) {
					//JOptionPane.showMessageDialog(null, "用户登录成功");
					PuTongDengLu();
				}else if(radioButton_1.isSelected()) {
					DengLu(e);
				}
				
			}
		});
		
		button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {//重置按钮事件
			public void actionPerformed(ActionEvent e) {
				ChongZhi(e);//调用重置函数
			}
		});
		
		radioButton = new JRadioButton("\u7528\u6237\u767B\u5F55");
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		
		radioButton_1 = new JRadioButton("\u7BA1\u7406\u5458\u767B\u5F55");
		buttonGroup.add(radioButton_1);
		
		JButton yonghuzhuce = new JButton("\u7528\u6237\u6CE8\u518C");
		yonghuzhuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Registration_Surface().setVisible(true); 
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(171)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(99)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(yonghuzhuce))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(radioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radioButton_1))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(nametext)
									.addComponent(password, 161, 161, Short.MAX_VALUE)))))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButton)
						.addComponent(radioButton_1))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(yonghuzhuce))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
	//管理员登陆
	protected void DengLu(ActionEvent e) {
		// TODO Auto-generated method stub
		String u = this.nametext.getText();//获取文本框
		String p = new String(this.password.getPassword());//获取密码框
		if (PanDuan.TUtil(u)) {//判断文本框是否为空
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
		} else if (PanDuan.TUtil(p)) {//判断密码框是否为空

			JOptionPane.showMessageDialog(null, "密码名不能为空！");
		} else {
			BDtil bdl = new BDtil();//new 对象
			UserDao userDao = new UserDao();
			User user = new User(u, p);
			
			Connection con = null;
			try {
				con = bdl.LianJie();//获取数据库连接
				us = UserDao.Login(con, user);//查询结果返回
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("dddddddddddddd");
			}finally {
				try {
					BDtil.CloseCon(con);//关闭数据库连接
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (us != null) {//判断如果us不为空执行
				System.out.println("登陆成功.........！");
				name=us.getUserName();
				id=us.getID();
				new MainJFram().setVisible(true);//调用显示MianJFrsm
				System.out.println(name);
				dispose();//关闭当前窗口
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误!");
			}
		}
	}
	public void PuTongDengLu() {
		//获取文本框值
		String u = this.nametext.getText();
		//获取密码框
		String p = new String(this.password.getPassword());
		OrdinaryUsers ou= new OrdinaryUsers();//创建对象
		//把获取的密码用户名存入OrdinaryUsers中
		ou.setO_user(u);
		ou.setO_user_password(p);
		//判断用户名或密码是否为空若为空则弹出窗口提示
		if(PanDuan.TUtil(u)) {
			JOptionPane.showMessageDialog(null, "请输入用户名");//弹窗
		}else if(PanDuan.TUtil(p)) {
			JOptionPane.showMessageDialog(null, "请输入密码");
		}else {
			Connection con=null;
			try {
				con=BDtil.LianJie();//连接数据库
				//查询执行
				OrdinaryUsers ud=OrdinaryUsersDao.OrdinaryUsersLogin(con, ou);
				if(ud!=null) {
					names=ud.getO_user();
					ids=ud.getO_userid();
					new UserMianJFrame().setVisible(true);
					JOptionPane.showMessageDialog(null, "用户登录成功!");
					
					
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					BDtil.CloseCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	protected void ChongZhi(ActionEvent e) {//重置函数
		// TODO Auto-generated method stub
		this.nametext.setText("");//文本框为空
		this.password.setText("");
	}
}

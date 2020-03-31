package Draw;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import unity.information;



public class myFrame extends JFrame{
	private JFileChooser fileChooser = new JFileChooser();
	String file_a,file_q,selectedFile;
	JLabel label = new JLabel("生成题目数"); 
	JLabel label2 = new JLabel("结果最大值"); 
	JLabel label3 = new JLabel("分母范围"); 
	JLabel label4 = new JLabel("题目中自然数最大值"); 
	//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
	JTextField textField = new JTextField(16);
	JTextField textField2 = new JTextField(16);
	JTextField textField3 = new JTextField(16);
	JTextField textField4 = new JTextField(16);
	JButton button = new JButton("确定");
	
	JButton button2 = new JButton("导入题目文件"); 
	JButton button3 = new JButton("导入答案文件"); 
	JButton button4 = new JButton("确定检验所选");
	JButton button5 = new JButton("确定存储");
	//构造函数
	public myFrame(String title)
	{
		//继承父类，
		super(title);
		
		//内容面板
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());//线性布局
		
		//添加控件
		contentPane.add(label);
		contentPane.add(textField);
		contentPane.add(label2);
		contentPane.add(textField2);
		contentPane.add(label3);
		contentPane.add(textField3);
		contentPane.add(label4);
		contentPane.add(textField4);
		contentPane.add(button);
	
		contentPane.add(button3);
		contentPane.add(button2);
		contentPane.add(button4);
		contentPane.add(button5);
		
		
		//导入题目文件
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
			textField.setText(selectedFile);// 显示选中文件的名称
			file_q = selectedFile;

			}

			}

			});
		
		
		
		//导入答案文件
		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
			textField.setText(selectedFile);// 显示选中文件的名称
			file_a =selectedFile;
			}

			}

			});
		
		//确认检验
		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(file_a.equals("")||file_q.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setOp(false);
				}
			
			}

			});
		
		//确认存储
		button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();//获取输入内容
				String str2 = textField2.getText();
				String str3 = textField2.getText();
				String str4 = textField2.getText();
				//判断是否输入了
				if(str.equals("")||str2.equals("")||str3.equals("")||str4.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setOp(true);
				}

			}

			});
		
		
		
		//按钮点击处理 lambda表达式
		button.addActionListener((e) -> {
			onButtonOk();
		});
	
	//按钮点击处理 lambda表达式
	button.addActionListener((e) -> {
		onButtonOk();
	});
}
	
	
	//事件处理
	private void onButtonOk()
	{
		String str = textField.getText();//获取输入内容
		String str2 = textField2.getText();
		//判断是否输入了
		if(str.equals("")&&str2.equals(""))
		{
			Object[] options = { "OK ", "CANCEL " }; 
			JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION, 
			JOptionPane.WARNING_MESSAGE,null, options, options[0]);
		}
		else
			JOptionPane.showMessageDialog(this,"您输入了：" + str+str2);
		
	}
	
}
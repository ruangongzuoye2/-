package learngui;

//myFrame基于JFrame的个人工具类


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



public class myFrame extends JFrame{
	private JFileChooser fileChooser = new JFileChooser();
	String selectedFile;
	JLabel label = new JLabel("生成题目数"); 
	JLabel label2 = new JLabel("结果最大值"); 
	
	//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
	JTextField textField = new JTextField(16);
	JTextField textField2 = new JTextField(16);
	JButton button = new JButton("确定");
	
	JButton button2 = new JButton("导入题目文件"); 
	JButton button3 = new JButton("导入答案文件"); 
	
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
		contentPane.add(button);
		
		//Container contentPane2 = getContentPane();
		//contentPane2.setLayout(new FlowLayout());
		//contentPane2.add(button2);
		contentPane.add(button3);
		contentPane.add(button2);
				//contentPane2.add(button3);
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象

			String[] filehouzhui = selectedFile.split("\\.");

			int Index = filehouzhui.length -1;

			        System.out.println(filehouzhui[Index]);

			System.out.println(filehouzhui);

			textField.setText(selectedFile);// 显示选中文件的名称

			}

			}

			});
		
		
		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象

			String[] filehouzhui = selectedFile.split("\\.");

			int Index = filehouzhui.length -1;

			        System.out.println(filehouzhui[Index]);

			System.out.println(filehouzhui);

			textField.setText(selectedFile);// 显示选中文件的名称

			}

			}

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
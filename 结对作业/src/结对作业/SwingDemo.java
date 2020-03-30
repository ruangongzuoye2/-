package learngui;

//
//java swing做一个简单的文本框
//Created by lee_1310 on 2019.03.29 23:05
//CopyRight @ https://blog.csdn.net/Lee_1310.
//


import javax.swing.JFrame;

public class SwingDemo {

public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				createGUI();
			}

	
		});
		
	}
	private static void createGUI()
	{
		//创建一个窗口，创建一个窗口
		myFrame frame = new myFrame("四则运算");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置窗口大小
		frame.setSize(600, 400);
		
		//显示窗口
		frame.setVisible(true);
	}

}
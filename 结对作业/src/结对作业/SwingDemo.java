package learngui;

//
//java swing��һ���򵥵��ı���
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
		//����һ�����ڣ�����һ������
		myFrame frame = new myFrame("��������");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô��ڴ�С
		frame.setSize(600, 400);
		
		//��ʾ����
		frame.setVisible(true);
	}

}
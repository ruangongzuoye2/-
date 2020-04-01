package Main;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import Draw.myFrame;

public class main {

	public static void main(String[] args) {
		File fex = new File(System.getProperty("user.dir")+File.separator+"Exercises.txt");
		File fan = new File(System.getProperty("user.dir")+File.separator+"Answers.txt");
		File grade = new File(System.getProperty("user.dir")+File.separator+"Grade.txt");
		try {
			if(!grade.exists())		grade.createNewFile();
			if(!fex.exists())		fex.createNewFile();
			if(!fan.exists())		fan.createNewFile();
		}catch(IOException e) {
			e.printStackTrace();
		}
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



package learngui;

//myFrame����JFrame�ĸ��˹�����


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
	JLabel label = new JLabel("������Ŀ��"); 
	JLabel label2 = new JLabel("������ֵ"); 
	
	//����JTextField��16��ʾ16�У�����JTextField�Ŀ����ʾ�����������ַ�����
	JTextField textField = new JTextField(16);
	JTextField textField2 = new JTextField(16);
	JButton button = new JButton("ȷ��");
	
	JButton button2 = new JButton("������Ŀ�ļ�"); 
	JButton button3 = new JButton("������ļ�"); 
	
	//���캯��
	public myFrame(String title)
	{
		//�̳и��࣬
		super(title);
		
		//�������
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());//���Բ���
		
		//��ӿؼ�
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

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����

			String[] filehouzhui = selectedFile.split("\\.");

			int Index = filehouzhui.length -1;

			        System.out.println(filehouzhui[Index]);

			System.out.println(filehouzhui);

			textField.setText(selectedFile);// ��ʾѡ���ļ�������

			}

			}

			});
		
		
		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����

			String[] filehouzhui = selectedFile.split("\\.");

			int Index = filehouzhui.length -1;

			        System.out.println(filehouzhui[Index]);

			System.out.println(filehouzhui);

			textField.setText(selectedFile);// ��ʾѡ���ļ�������

			}

			}

			});
		
		
		
		//��ť������� lambda���ʽ
		button.addActionListener((e) -> {
			onButtonOk();
		});
	}
	
	//�¼�����
	private void onButtonOk()
	{
		String str = textField.getText();//��ȡ��������
		String str2 = textField2.getText();
		//�ж��Ƿ�������
		if(str.equals("")&&str2.equals(""))
		{
			Object[] options = { "OK ", "CANCEL " }; 
			JOptionPane.showOptionDialog(null, "����û������ ", "��ʾ", JOptionPane.DEFAULT_OPTION, 
			JOptionPane.WARNING_MESSAGE,null, options, options[0]);
		}
		else
			JOptionPane.showMessageDialog(this,"�������ˣ�" + str+str2);
		
	}
	
}
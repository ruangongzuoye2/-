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
	JLabel label = new JLabel("������Ŀ��"); 
	JLabel label2 = new JLabel("������ֵ"); 
	JLabel label3 = new JLabel("��ĸ��Χ"); 
	JLabel label4 = new JLabel("��Ŀ����Ȼ�����ֵ"); 
	//����JTextField��16��ʾ16�У�����JTextField�Ŀ����ʾ�����������ַ�����
	JTextField textField = new JTextField(16);
	JTextField textField2 = new JTextField(16);
	JTextField textField3 = new JTextField(16);
	JTextField textField4 = new JTextField(16);
	JButton button = new JButton("ȷ��");
	
	JButton button2 = new JButton("������Ŀ�ļ�"); 
	JButton button3 = new JButton("������ļ�"); 
	JButton button4 = new JButton("ȷ��������ѡ");
	JButton button5 = new JButton("ȷ���洢");
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
		contentPane.add(label3);
		contentPane.add(textField3);
		contentPane.add(label4);
		contentPane.add(textField4);
		contentPane.add(button);
	
		contentPane.add(button3);
		contentPane.add(button2);
		contentPane.add(button4);
		contentPane.add(button5);
		
		
		//������Ŀ�ļ�
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
			textField.setText(selectedFile);// ��ʾѡ���ļ�������
			file_q = selectedFile;

			}

			}

			});
		
		
		
		//������ļ�
		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
			textField.setText(selectedFile);// ��ʾѡ���ļ�������
			file_a =selectedFile;
			}

			}

			});
		
		//ȷ�ϼ���
		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(file_a.equals("")||file_q.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "����û������ ", "��ʾ", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setOp(false);
				}
			
			}

			});
		
		//ȷ�ϴ洢
		button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();//��ȡ��������
				String str2 = textField2.getText();
				String str3 = textField2.getText();
				String str4 = textField2.getText();
				//�ж��Ƿ�������
				if(str.equals("")||str2.equals("")||str3.equals("")||str4.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "����û������ ", "��ʾ", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setOp(true);
				}

			}

			});
		
		
		
		//��ť������� lambda���ʽ
		button.addActionListener((e) -> {
			onButtonOk();
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
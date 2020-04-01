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

import Dao.getAnswer;
import Dao.getQuestion;
import unity.information;



public class myFrame extends JFrame{
	private JFileChooser fileChooser = new JFileChooser();
	String file_a,file_q,selectedFile,file_s;
	JLabel label = new JLabel("������Ŀ��"); 
	JLabel label3 = new JLabel("��ĸ��Χ"); 
	JLabel label4 = new JLabel("��Ŀ����Ȼ�����ֵ"); 
	//����JTextField��16��ʾ16�У�����JTextField�Ŀ����ʾ�����������ַ�����
	JTextField textField = new JTextField(16);
	JTextField textField2 = new JTextField(16);
	JTextField textField3 = new JTextField(16);
	JTextField textField4 = new JTextField(16);
	JTextField textField5 = new JTextField(16);
	JTextField textField6 = new JTextField(16);
	JTextField textField7 = new JTextField(16);
	
	JButton button2 = new JButton("������Ŀ�ļ�"); 
	JButton button3 = new JButton("������ļ�");
	JButton button6 = new JButton("ѡ������������ļ�");
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
		contentPane.add(textField);//��Ŀ��Ŀ
		contentPane.add(label3);
		contentPane.add(textField3);//��ĸ��Χ
		contentPane.add(label4);
		contentPane.add(textField4);//��Ȼ�����ֵ
	
		contentPane.add(button3);
		contentPane.add(textField5);//���ļ�·��
		contentPane.add(button2);
		contentPane.add(textField6);//��Ŀ�ļ�·��
		contentPane.add(button6);
		contentPane.add(textField7);//����������·��
		contentPane.add(button4);
		contentPane.add(button5);
		
		
		
		//������Ŀ�ļ�
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
			textField6.setText(selectedFile);// ��ʾѡ���ļ�������
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
			textField5.setText(selectedFile);// ��ʾѡ���ļ�������
			file_a = selectedFile;
			}

			}

			});
		
		//ȷ�ϼ���
		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				file_a = textField5.getText();
				file_q = textField6.getText();
				file_s = textField7.getText();
				if(file_a.equals("")||file_q.equals("")||file_s.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "����û������ ", "��ʾ", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setFile_s(textField7.getText());
				getAnswer gA = new getAnswer();
				if(gA.getAnswer()) {
					JOptionPane.showMessageDialog(null,"��������������"+file_s );
				}
					
				}
				}
			

			});
		
		//ȷ�ϴ洢
		button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();//��
				String str2 = textField3.getText();//��
				String str3 = textField4.getText();//��
				String str4 = textField5.getText();//��
				String str6 = textField6.getText();//��Ŀ
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
				information.setNum_timu(Integer.parseInt(textField.getText()));
				getQuestion gQ = new getQuestion();
				if(gQ.getQuestion())
				 JOptionPane.showMessageDialog(null,"��Ŀ��������"+file_q+"����������"+file_a );
				}

			}

			});
		
		button6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
			textField7.setText(selectedFile);// ��ʾѡ���ļ�������
			file_s = selectedFile;

			}

			}

			});
		
	}
}
	
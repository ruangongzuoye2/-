package 结对作业;
import java.io.*;
import java.io.FileWriter;
import java.security.SecureRandom;
public class getQuestion {
	
	public static int number(int limit,int min) {	//min < 返回的随机数  < limit
		SecureRandom r = new SecureRandom();
		int i=0;
		while(i<=min) {
			i = r.nextInt();
			i = i%limit;
			if(i<0)	i = -i;			
		}
		return i;
	}
	public static char fuhao(int n) {	//n=1时随机生成并返回 加/减/乘/除
										//n=0时函数功能是判断是否生成括号，是否增加运算项等，返回0或1
		SecureRandom r = new SecureRandom();	
		int t = r.nextInt();
		if(n==1) {
			t%=4;
			if(t==0)	return '+';
			else if(t==1)	return '-';
			else if(t==2)	return '×';
			else	return '÷';
		}else {
			if(t%2==0)	return 1;
			else	return 0;
		}
	}
	public static int gong(int m,int n) {	//返回分子和分母的公因子,m是分子,n是分母
		int gongyinshu = 1,small = m;
		for(int i=1;i<=small;i++) {if((m%i==0)&(n%i==0)) gongyinshu = i;}
		return gongyinshu;
	}

	public static void main(String[] args) {
		File fex = new File("E:\\eclipse-workspace\\结对作业\\src\\结对作业"+File.separator+"Exercises.txt");
		File fan = new File("E:\\eclipse-workspace\\结对作业\\src\\结对作业"+File.separator+"Answers.txt");
		int Qnumber=30;int i,c,d;	//Qnumber指生成题目数量,i,c,d是计数器
		int N1,N2,N3,N4;	//四个数的公因数
		int nature=100,fen=12,fenmu=13;	//自然数，真分数分子，真分数分母的限制条件
		int answerZi=0,answerMu=0,answerGong=1,temp;	//分步得到的答案的分子分母,temp是标记前后添加的,answerGong是用来化简答案的
		
		char [] Fuhao1 =new char[Qnumber]; 	//每个题目的三个运算符
		char [] Fuhao2 =new char[Qnumber]; 
		char [] Fuhao3 =new char[Qnumber]; 
		
		int [] n1 = new int[Qnumber];	//n1,n11,n111依次表示第一个数的整数,分子,分母
		int [] n11 = new int[Qnumber];
		int [] n111 = new int[Qnumber];
		int [] n2 = new int[Qnumber];
		int [] n22 = new int[Qnumber];
		int [] n222 = new int[Qnumber];
		int [] n3 = new int[Qnumber];
		int [] n33 = new int[Qnumber];
		int [] n333 = new int[Qnumber];
		int [] n4 = new int[Qnumber];
		int [] n44 = new int[Qnumber];
		int [] n444 = new int[Qnumber];
			
		int [] AnswerZi = new int[Qnumber];	//存放最终答案的分子
		int [] AnswerMu = new int[Qnumber];	//存放最终答案的分母
		
		int [] countCheng = new int[Qnumber];	//式子中乘号数量
		int [] countChu = new int[Qnumber];
		int [] countJia = new int[Qnumber];
		int [] countJian = new int[Qnumber];
		
		for(c=0;c<Qnumber;c++) {			//初始化分子分母
			n11[c]=0;n111[c]=1;		
			n22[c]=0;n222[c]=1;
			n33[c]=0;n333[c]=1;
			n44[c]=0;n444[c]=1;
			countCheng[c]=0;countChu[c]=0;countJia[c]=0;countJian[c]=0;
		}		
		
		StringBuilder s = new StringBuilder();
		String [] str = new String[Qnumber];	//存放题目，后保存到文档
		
		for(c=0;c<Qnumber;c++) {
			if(fuhao(0)==1) {									//算出随机数1
				n1[c] =number(fen,0);n111[c] = number(fenmu,2);n11[c] = number(n111[c],1);
				N1 = gong(n11[c],n111[c]);
				n11[c]/=N1;n111[c]/=N1;			
			}else	n1[c] = number(nature,0);
			if(fuhao(0)==1) {									//算出随机数2
				n2[c] =number(fen,0);n222[c] = number(fenmu,2);n22[c] = number(n222[c],1);
				N2 = gong(n22[c],n222[c]);
				n22[c]/=N2;n22[c]/=N2;
			}else	n2[c] = number(nature,0);	
			if(fuhao(0)==1) {									//算出随机数3
				n3[c] =number(fen,0);n333[c] = number(fenmu,2);n33[c] = number(n333[c],1);
				N3 = gong(n33[c],n333[c]);
				n33[c]/=N3;n333[c]/=N3;
			}else	n3[c] = number(nature,0);
			if(fuhao(0)==1) {									//算出随机数4
				n4[c] =number(fen,0);n444[c] = number(fenmu,2);n44[c] = number(n444[c],1);
				N4 = gong(n44[c],n444[c]);
				n44[c]/=N4;n444[c]/=N4;
			}else	n4[c] = number(nature,0);
		
			Fuhao1[c] = fuhao(1);Fuhao2[c] = fuhao(1);Fuhao3[c] = fuhao(1);	//三个随机运算符
		
			if(Fuhao1[c]=='-'&((n1[c]+n11[c]/n111[c])<(n2[c]+n22[c]/n222[c])))	{i=n1[c];n1[c]=n2[c];n2[c]=i;i=n11[c];n11[c]=n22[c];n22[c]=i;i=n111[c];n111[c]=n222[c];n222[c]=i;}
			switch(Fuhao1[c]) {
			case '+':countJia[c]++;answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c]+n2[c]*n111[c]*n222[c]+n111[c]*n22[c];answerMu = n111[c]*n222[c];break;
			case '-':countJian[c]++;answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c]-n2[c]*n111[c]*n222[c]-n111[c]*n22[c];answerMu = n111[c]*n222[c];break;
			case '×':countCheng[c]++;answerZi = n1[c]*n111[c]*n2[c]*n222[c]+n1[c]*n111[c]*n22[c]+n11[c]*n2[c]*n222[c]+n11[c]*n22[c];answerMu = n111[c]*n222[c];break;
			case '÷':countChu[c]++;if((n2[c]+n22[c]/n222[c])==1)	n222[c]*=number(nature,1);	answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c];answerMu = n2[c]*n111[c]*n222[c]+n22[c]*n111[c];break;
			default:answerZi = 0;
			}
			if((n11[c]==0)|(n111[c]==1))	s.append(n1[c]);
			else	s.append(n1[c]+"'"+n11[c]+"/"+n111[c]);	
			s.append(" "+Fuhao1[c]+" ");
			if((n22[c]==0)|(n222[c]==1))	s.append(n2[c]);
			else	s.append(n2[c]+"'"+n22[c]+"/"+n222[c]);
		
			if(fuhao(0)==1) {	//随机生成1时执行此操作,往题目添加第三个数
				if(fuhao(0)==1)	{	//随机生成1时添加括号
					s.insert(0,'(');
					s.append(')');			
				}
				if((Fuhao2[c]=='-')&((answerZi/answerMu-(n3[c]+n33[c]/n333[c]))>0)) {
					temp = 1;	//temp = 1时后面添加
					s.append(" "+Fuhao2[c]+" ");
					if((n33[c]==0)|(n333[c]==1))	s.append(n3[c]);
					else	s.append(n3[c]+"'"+n33[c]+"/"+n333[c]);
				}else if((Fuhao2[c]=='-')&((answerZi/answerMu-(n3[c]+n33[c]/n333[c]))<0)) {
					temp = 0;	//temp = 0时前面添加
					s.insert(0, " "+Fuhao2[c]+" ");
					if((n33[c]==0)|(n333[c]==1))	s.insert(0, n3[c]);
					else	s.insert(0,n3[c]+"'"+n33[c]+"/"+n333[c]);
				}else if(fuhao(0)==1) {	//前面添加第三个数和第二个符号 
					temp = 0;	//temp = 0时前面添加
					s.insert(0, " "+Fuhao2[c]+" ");
					if((n33[c]==0)|(n333[c]==1))	s.insert(0, n3[c]);
					else	s.insert(0,n3[c]+"'"+n33[c]+"/"+n333[c]);
				}else {				//后面添加第三个数和第二个符号
					temp = 1;	//temp = 1时后面添加
					s.append(" "+Fuhao2[c]+" ");
					if((n33[c]==0)|(n333[c]==1))	s.append(n3[c]);
					else	s.append(n3[c]+"'"+n33[c]+"/"+n333[c]);
				}
				if(temp == 1)	
					switch(Fuhao2[c]) {			//answer*下一个数
						case '+':countJia[c]++;answerZi = n333[c]*n3[c]*answerMu+n33[c]*answerMu+n333[c]*answerZi;answerMu = n333[c]*answerMu;break;
						case '-':countJian[c]++;answerZi = n333[c]*answerZi-answerMu*n3[c]*n333[c]-n33[c]*answerMu;answerMu = n333[c]*answerMu;break;
						case '×':countCheng[c]++;answerZi = n3[c]*n333[c]*answerZi+answerZi*n33[c];answerMu = n333[c]*answerMu;break;
						case '÷':countChu[c]++;if((n3[c]+n33[c]/n333[c])==1)	n333[c]*=number(nature,1);	answerZi = answerZi*n333[c];answerMu = n3[c]*n333[c]*answerMu+answerMu*n33[c];break;
				}else	
					switch(Fuhao2[c]) {			//下一个数*answer
						case '+':countJia[c]++;answerZi = n333[c]*n3[c]*answerMu+n33[c]*answerMu+n333[c]*answerZi;answerMu = n333[c]*answerMu;break;
						case '-':countJian[c]++;answerZi = n33[c]*answerMu-n333[c]*answerZi+answerMu*n3[c]*n333[c];answerMu = n333[c]*answerMu;break;
						case '×':countCheng[c]++;answerZi = n3[c]*n333[c]*answerZi+answerZi*n33[c];answerMu = n333[c]*answerMu;break;
						case '÷':countChu[c]++;answerZi = n3[c]*n333[c]*answerMu+n33[c]*answerMu;answerMu = n333[c]*answerZi;break;
					}				
			}	
			if(fuhao(0)==1) {	//随机生成1时执行此操作,往题目添加第四个数
				if(fuhao(0)==1)	{	//随机生成1时添加括号
					s.insert(0,'(');
					s.append(')');			
				}
				if((Fuhao3[c]=='-')&((answerZi/answerMu-(n4[c]+n44[c]/n444[c]))>0)) {
					temp = 1;	//temp = 1时后面添加
					s.append(" "+Fuhao3[c]+" ");
					if((n44[c]==0)|(n444[c]==1))	s.append(n4[c]);
					else	s.append(n4[c]+"'"+n44[c]+"/"+n444[c]);
				}else if((Fuhao3[c]=='-')&((answerZi/answerMu-(n4[c]+n44[c]/n444[c]))<0)) {
					temp = 0;	//temp = 0时前面添加
					s.insert(0, " "+Fuhao3[c]+" ");
					if((n44[c]==0)|(n444[c]==1))	s.insert(0, n4[c]);
					else	s.insert(0,n4[c]+"'"+n44[c]+"/"+n444[c]);
				}else if(fuhao(0)==1) {	//前面添加第4个数和第2个符号 
					temp = 0;	//temp = 0时前面添加
					s.insert(0, " "+Fuhao3[c]+" ");
					if((n44[c]==0)|(n444[c]==1))	s.insert(0, n4[c]);
					else	s.insert(0,n4[c]+"'"+n44[c]+"/"+n444[c]);
				}else {				//后面添加第4个数和第2个符号
					temp = 1;	//temp = 1时后面添加
					s.append(" "+Fuhao3[c]+" ");
					if((n44[c]==0)|(n444[c]==1))	s.append(n4[c]);
					else	s.append(n4[c]+"'"+n44[c]+"/"+n444[c]);
				}
				if(temp == 1)	
					switch(Fuhao3[c]) {				//answer*下一个数
						case '+':countJia[c]++;answerZi = n444[c]*n4[c]*answerMu+n44[c]*answerMu+n444[c]*answerZi;answerMu = n444[c]*answerMu;break;
						case '-':countJian[c]++;answerZi = n444[c]*answerZi-answerMu*n4[c]*n444[c]-n44[c]*answerMu;answerMu = n444[c]*answerMu;break;
						case '×':countCheng[c]++;answerZi = n4[c]*n444[c]*answerZi+answerZi*n44[c];answerMu = n444[c]*answerMu;break;
						case '÷':countChu[c]++;if((n4[c]+n44[c]/n444[c])==1)	n444[c]*=number(nature,1);	answerZi = answerZi*n444[c];answerMu = n4[c]*n444[c]*answerMu+answerMu*n44[c];break;
					}else	
						switch(Fuhao3[c]) {			//下一个数*answer
						case '+':countJia[c]++;answerZi = n444[c]*n4[c]*answerMu+n44[c]*answerMu+n444[c]*answerZi;answerMu = n444[c]*answerMu;break;
						case '-':countJian[c]++;answerZi = n44[c]*answerMu-n444[c]*answerZi+answerMu*n4[c]*n444[c];answerMu = n444[c]*answerMu;break;
						case '×':countCheng[c]++;answerZi = n4[c]*n444[c]*answerZi+answerZi*n44[c];answerMu = n444[c]*answerMu;break;
						case '÷':countChu[c]++;answerZi = n4[c]*n444[c]*answerMu+n44[c]*answerMu;answerMu = n444[c]*answerZi;break;
						}
			}
			answerGong = gong(answerZi,answerMu);
			answerZi/=answerGong;answerMu/=answerGong;	//化简答案
			s.append(" "+'=');
			
			for(d=0;d<c;d++) {	//判断运算是否重复,重复则重新生成题目
				if((n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d])&(countJia[c]==countJia[d])&(countJian[c]==countJian[d])&(countCheng[c]==countCheng[d])&(countChu[c]==countChu[d]))	{c--;continue;}
				else if((n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d])&(countJia[c]==countJia[d])&(countJian[c]==countJian[d])&(countCheng[c]==countCheng[d])&(countChu[c]==countChu[d]))	{c--;continue;}
			}
			str[c] = s.toString();
			AnswerZi[c] = answerZi;AnswerMu[c] = answerMu;
			s.delete(0,s.length());	//清空s			
		}
		for(c=0;c<Qnumber;c++) {
			System.out.print(str[c]+" "+AnswerZi[c]+"/"+AnswerMu[c]+"\n");
		}
		try {
			FileWriter fw = new FileWriter(fex);
			for(c=0;c<Qnumber;c++)		fw.write(c+1+"."+str[c]+"\n");	//保存题目到txt
				fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter(fan);
			for(c=0;c<Qnumber;c++)	//分母为1时不是分数，直接返回分子
				if(AnswerMu[c]==1)	fw.write(c+1+"."+AnswerZi[c]+"\n");	//保存答案到txt
				else fw.write(c+1+"."+AnswerZi[c]+"/"+AnswerMu[c]+"\n");
			fw.close();
		}catch(IOException e) {
			e.printStackTrace(); 
		}
	}	
}
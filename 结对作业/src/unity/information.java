package unity;

public class information {
	 public static boolean isOp() {
		return op;
	}
	public static void setOp(boolean op) {
		information.op = op;
	}
	static int num_timu;//������Ŀ��
	 static  int resultmax;//������ֵ
	 static  int fenmu_max;//��ĸ���ֵ
	 static  int nature;//ʽ������Ȼ�����ֵ
	 static String problem;//��Ŀ�ļ�
	 static String answer;//���ļ�
	 static boolean op;//ȷ�������ļ����ݻ��Ǵ洢���ݵ��ļ�
	
	public static int getNum_timu() {
		return num_timu;
	}
	public static String getProblem() {
		return problem;
	}
	public static void setProblem(String problem) {
		information.problem = problem;
	}
	public static String getAnswer() {
		return answer;
	}
	public static void setAnswer(String answer) {
		information.answer = answer;
	}
	public static void setNum_timu(int num_timu) {
		information.num_timu = num_timu;
	}
	public static int getResultmax() {
		return resultmax;
	}
	public static void setResultmax(int resultmax) {
		information.resultmax = resultmax;
	}
	public static int getFenmu_max() {
		return fenmu_max;
	}
	public static void setFenmu_max(int fenmu_max) {
		information.fenmu_max = fenmu_max;
	}
	public static int getNature() {
		return nature;
	}
	public static void setNature(int nature) {
		information.nature = nature;
	}
	
}

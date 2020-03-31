package Dao;

import java.security.SecureRandom;

/*
 * 生成随机数用于式子
 */
public class getopnum {
	public  int number(int limit,int min) {	//min < 返回的随机数  < limit
		SecureRandom r = new SecureRandom();
		int i=0;
		while(i<=min) {
			i = r.nextInt();
			i = i%limit;
			if(i<0)	i = -i;			
		}
		return i;
	}
}

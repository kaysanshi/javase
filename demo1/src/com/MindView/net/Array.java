package com.MindView.net;

public class Array {

	public static void main(String[] args) {
//		�˾䲻����˼��
		Other.main(new String[]{"hello","java","c++"});
	}

}
class Other{
	public static void main(String[] args) {
		for(String s:args)
			System.out.print(s+" ");
	}
}

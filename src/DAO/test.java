package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws Exception {
		String str = "29/11/2020";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
		System.out.println(str + " " + date);
	}
}
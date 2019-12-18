package com.maqian.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class ReverseDemo {

	List<Column> list = new ArrayList<Column>();
	StringBuffer strB = new StringBuffer();
	
	private String tableName;
	private String packageName;
	
	public ReverseDemo(){
		
	}
	
	public ReverseDemo(String packageName){
		this.packageName = packageName;
	}
	
	public ReverseDemo(String packageName,String tableName){
		this.packageName = packageName;
		this.tableName = tableName;
	}
	
	public void getColumnAndType(String tableName){
		this.tableName = tableName;
		try {
			Connection conn = JdbcUtils.getConn();
			Statement stat = conn.createStatement();
			String sql = "select * from "+tableName;
			ResultSet rs = stat.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				Column c = new Column();
				c.setName(rsmd.getColumnName(i));
				c.setType(rsmd.getColumnTypeName(i));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createProperty(){
		for (Column column : list) {
			strB.append("\tprivate "+tableType2JavaType(column.getType())+" "+column.getName()+";\r\n");
		}
		strB.append("\n");
	}
	
	public void createGetter(){
		for (Column column : list) {
			strB.append("\tpublic "+tableType2JavaType(column.getType())+" get"+changeFirstChar(column.getName())+"(){\r\n");
			strB.append("\t\treturn "+column.getName()+";\r\n");
			strB.append("\t}\r\n\n");
		}
	}
	
	public void createSetter(){
		for (Column column : list) {
			strB.append("\tpublic void set"+changeFirstChar(column.getName())+"("+tableType2JavaType(column.getType())+" "+column.getName()+"){\r\n");
			strB.append("\t\tthis."+column.getName()+"="+column.getName()+";\r\n");
			strB.append("\t}\r\n\n");
		}
	}
	
	
	public void createClassFront(){
		//��
		strB.append("package "+packageName+";\r\n\n");
		
		strB.append("import java.io.Serializable;\r\n\n");
		//��
		strB.append("public class "+changeFirstChar(tableName)+" implements Serializable {\r\n\n");
	}
	
	public void createClassBack(){
		strB.append("}\r\n");
	}
	
	public String changeFirstChar(String name){
		char[] cs = name.toCharArray();
		cs[0] = (char)(cs[0]-('a'-'A'));
		return new String(cs);
	}
	
	public String tableType2JavaType(String typeName){
		String temp = "";
		typeName = typeName.toLowerCase();
		switch(typeName){
			case "varchar":
			case "char":
				temp = "String";
				break;
			case "int":
				temp = "Integer";
				break;
			case "datetime":
				temp = "java.util.Date";
				break;
			case "double":
				temp = "Double";
				break;
			case "float":
				temp = "Float";
				break;
				
		}
		return temp;
	}
	
	public static void main(String[] args) {
		String tableName = "emp";
		String packageName = "com.maqian.pojo";
		ReverseDemo rd = new ReverseDemo(packageName);
		rd.getColumnAndType(tableName);
		rd.createClassFront();
		rd.createProperty();
		rd.createGetter();
		rd.createSetter();
		rd.createClassBack();
		System.out.println(rd.strB.toString());
		
		try {
			rd.createJava();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void createJava() throws IOException{
		String javaName = changeFirstChar(tableName)+".java";
		StringBuffer realPath = new StringBuffer();
		
		//�µ�˼·���ֶ����eclipse��srcĿ¼��Ȼ���ֶ���Ӱ����ͱ��������д��룬���ɷ�װ��
		String str = "C:/Users/EDZ/Documents/javawebStudy/Hibernate11/src/main/java/";
		
		//�õ���Ŀ�������·��-----------------????���⣺��ô�õ��������ϵ�src��Ŀ¼;Ŀǰֻ�ܷŽ�classes�ļ��У�������Ҫ�Ž�java�а�
//		String str = ReverseDemo.class.getClassLoader().getResource("/").getPath();
//		String str2 = ServletActionContext.getServletContext().getRealPath("/");
//		System.out.println(str2);
		
		realPath.append(str);
		//ƴ�Ӱ���
		realPath.append(packageName.replace(".", "/"));
		
//		File dir = new File(realPath.toString().substring(1));
		File dir = new File(realPath.toString());
		if(!dir.exists()){
			dir.mkdirs();
		}
		FileWriter fw = new FileWriter(new File(dir,javaName));
		BufferedWriter out = new BufferedWriter(fw);
		out.write(strB.toString(), 0, strB.length()-1);
		out.flush();
		out.close();
	}
}

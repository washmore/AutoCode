package gift.utils;

import tech.washmore.autocode.model.ColumnModel;
import tech.washmore.autocode.model.TableModel;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static tech.washmore.autocode.util.StringUtils.dataType2FieldType;
import static tech.washmore.autocode.util.StringUtils.underline2Camel;

public class CodeMaker {
	static Connection conn;

	static {
		String url = "jdbc:mysql://192.168.2.88:3306/gift?useUnicode=true&characterEncoding=utf-8";
		String account = "root";
		String password = "wangyalan";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, account, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		// System.out.println(underline2Camel("user_final_name"));
		handle();
	}

	public static void handle() throws Exception {
		List<String> tablenames = new ArrayList<String>();
		String sql = "show tables";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			tablenames.add(rs.getString(1));
			// System.out.println(rs.getString(1));
		}
		for (String tn : tablenames) {
			TableModel tm = handleTable("gift", tn);
			createModelClass(tm);
		}
	}

	public static TableModel handleTable(String dbname, String tableName) throws Exception {
		String sql = "select * from information_schema.tables  where TABLE_SCHEMA=? AND table_name=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, dbname);
		stat.setString(2, tableName);
		TableModel tm = new TableModel();

		ResultSet rs = stat.executeQuery();
		if (rs.next()) {
			tm.setTbName(rs.getString("TABLE_NAME"));
			tm.setTbComment(rs.getString("TABLE_COMMENT"));
			tm.setClsName(underline2Camel(tm.getTbName(), true));
		}
		tm.setColumns(handleColumns(dbname, tableName));

		return tm;
	}

	private static void createModelClass(TableModel tm) throws Exception {
		StringBuffer sb = new StringBuffer("");
		sb.append("package gift.model;").append(System.lineSeparator());
		sb.append("import java.io.Serializable;").append(System.lineSeparator());
		sb.append("import java.util.*;").append(System.lineSeparator());
		sb.append("import java.lang.*;").append(System.lineSeparator());
		sb.append("/**").append(System.lineSeparator());
		sb.append(" * @author Washmore").append(System.lineSeparator());
		sb.append(" * @version V1.0").append(System.lineSeparator());
		sb.append(" * @summary ").append(tm.getTbComment()).append(System.lineSeparator());
		sb.append(" * @Copyright (c) 2018, Lianjia Group All Rights Reserved.").append(System.lineSeparator());
		sb.append(" * @since 2018/6/5").append(System.lineSeparator());
		sb.append(" */").append(System.lineSeparator());
		sb.append("public class ").append(tm.getClsName()).append(" implements Serializable ").append("{")
				.append(System.lineSeparator());
		sb.append("\tprivate static final long serialVersionUID = ").append(new Random().nextLong()).append("L;")
				.append(System.lineSeparator());
		for (ColumnModel cm : tm.getColumns()) {
			sb.append("\t/**").append(System.lineSeparator());
			sb.append("\t * ").append(cm.getComment()).append(" 默认值:").append(cm.getDefaultValue())
					.append(System.lineSeparator());
			sb.append("\t */").append(System.lineSeparator());
			sb.append("\t").append("private ").append(cm.getFieldType()).append(" ").append(cm.getFieldName())
					.append(";").append(System.lineSeparator());
		}
		sb.append(System.lineSeparator());
		for (ColumnModel cm : tm.getColumns()) {
			sb.append("\t").append("public void set").append(underline2Camel(cm.getColumnName(), true)).append("(")
					.append(cm.getFieldType()).append(" ").append(cm.getFieldName()).append(") {")
					.append(System.lineSeparator());
			sb.append("\t\t").append("this.").append(cm.getFieldName()).append(" = ").append(cm.getFieldName())
					.append(";").append(System.lineSeparator());
			sb.append("\t}").append(System.lineSeparator());

			sb.append("\t").append("public ").append(cm.getFieldType()).append(" get")
					.append(underline2Camel(cm.getColumnName(), true)).append("() {").append(System.lineSeparator());
			sb.append("\t\t").append("return this.").append(cm.getFieldName()).append(";")
					.append(System.lineSeparator());
			sb.append("\t}").append(System.lineSeparator());
		}
		sb.append("}");
		System.out.println(sb.toString());
		System.out.println(System.getProperty("user.dir"));
		File dic = new File(System.getProperty("user.dir") + "/src/main/java/gift/model/");

		if (!dic.exists()) {
			dic.mkdirs();
		}
		File file = new File(dic, tm.getClsName() + ".java");
		if (!file.exists()) {
			file.createNewFile();
		} else {
			file.delete();
			file.createNewFile();
		}
		new FileOutputStream(file).write(sb.toString().getBytes());
	}

	public static List<ColumnModel> handleColumns(String dbname, String tableName) throws Exception {
		String sql = "select * from information_schema.columns  where TABLE_SCHEMA=? AND table_name=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, dbname);
		stat.setString(2, tableName);
		ResultSet rs = stat.executeQuery();
		List<ColumnModel> columnModels = new ArrayList<ColumnModel>();
		while (rs.next()) {
			ColumnModel cm = new ColumnModel();
			cm.setColumnName(rs.getString("COLUMN_NAME"));
			cm.setComment(rs.getString("COLUMN_COMMENT"));
			cm.setDataType(rs.getString("DATA_TYPE"));
			cm.setDefaultValue(rs.getString("COLUMN_DEFAULT"));
			cm.setFieldName(underline2Camel(cm.getColumnName(), false));
			cm.setFieldType(dataType2FieldType(cm.getDataType()));
			columnModels.add(cm);
		}
		return columnModels;
	}

}

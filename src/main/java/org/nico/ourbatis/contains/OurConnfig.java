package org.nico.ourbatis.contains;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nico.ourbatis.adapter.AssistAdapter;
import org.nico.ourbatis.adapter.ForeachAdapter;
import org.nico.ourbatis.adapter.RefAdapter;
import org.nico.ourbatis.wrapper.Wrapper;

public class OurConnfig {

	public static String prefix = "@{";
	
	public static String suffix = "}";
	
	public static final List<Wrapper<String>> JDBC_NAME_WRAPPERS = new ArrayList<Wrapper<String>>();
	
	public static final List<Wrapper<String>> TABLE_NAME_WRAPPERS = new ArrayList<Wrapper<String>>();
	
	public static final List<Wrapper<String>> MAPPER_NAME_WRAPPERS = new ArrayList<Wrapper<String>>();
	
	public static final Map<String, AssistAdapter> ASSIST_ADAPTERS = new HashMap<String, AssistAdapter>(){
		private static final long serialVersionUID = 1L;
		{
			put("ourbatis:foreach", new ForeachAdapter());
			put("ourbatis:ref", new RefAdapter());
		}
	};
	
	public static final Map<Class<?>, String> JAVA_TYPE_MAPPER = new HashMap<Class<?>, String>(){
		private static final long serialVersionUID = 3388503832916481034L;
		{
			put(String.class, "VARCHAR");
			put(BigDecimal.class, "DECIMAL");
			put(boolean.class, "BIT");
			put(Boolean.class, "BIT");
			put(byte.class, "TINYINT");
			put(Byte.class, "TINYINT");
			put(short.class, "SMALLINT");
			put(Short.class, "SMALLINT");
			put(int.class, "INTEGER");
			put(Integer.class, "INTEGER");
			put(long.class, "BIGINT");
			put(Long.class, "BIGINT");
			put(float.class, "REAL");
			put(Float.class, "REAL");
			put(double.class, "DOUBLE");
			put(Double.class, "DOUBLE");
			put(Date.class, "DATE");
	}};
	
	
}

package org.nico.ourbatis.mapping;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.nico.ourbatis.annotation.RenderName;
import org.nico.ourbatis.config.BaseConfig;
import org.nico.ourbatis.entity.Column;
import org.nico.ourbatis.entity.Table;
import org.nico.ourbatis.utils.ArrayUtils;
import org.nico.ourbatis.utils.ReflactUtils;
import org.nico.ourbatis.wrapper.TableNameWrapper;
import org.nico.ourbatis.wrapper.JdbcNameWrapper;
import org.nico.ourbatis.wrapper.JdbcTypeWrapper;
import org.nico.ourbatis.wrapper.MapperNameWrapper;
import org.nico.ourbatis.wrapper.Wrapper;
import org.nico.ourbatis.wrapper.WrapperConfig;

public class Mapping {

	private Wrapper<Class<?>> tableNameWrapper;
	
	private Wrapper<Class<?>> mapperNameWrapper;
	
	private Wrapper<Field> JdbcNameWrapper;
	
	private Wrapper<Class<?>> JdbcTypeWrapper;
	
	public Mapping() {
		this.tableNameWrapper = new TableNameWrapper();
		this.JdbcNameWrapper = new JdbcNameWrapper();
		this.JdbcTypeWrapper = new JdbcTypeWrapper();
		this.mapperNameWrapper = new MapperNameWrapper();
	}
	
	public Table mappingTable(Class<?> domainClass){
		Table table = new Table();
		Field[] classFields = ReflactUtils.getFields(domainClass);
		List<Column> columns = new ArrayList<Column>(classFields.length);
		List<Column> pcolumns = new ArrayList<Column>(classFields.length);
		if(ArrayUtils.isNotEmpty(classFields)) {
			for(Field field: classFields) {
				if(! ReflactUtils.isRenderIgnore(field)) {
					if(ReflactUtils.isRenderPrimary(field)){
						pcolumns.add(mappingColumnEntity(field));
					}else{
						columns.add(mappingColumnEntity(field));
					}
				}
			}
		}
		table.setTableName(tableNameWrapper.wrapping(domainClass));
		table.setPcolumns(pcolumns);
		table.setColumns(columns);
		table.setDomainClass(domainClass);
		table.setDomainClassName(domainClass.getName());
		table.setMapperClassName(BaseConfig.mapperPacketUri + "." + mapperNameWrapper.wrapping(domainClass));
		return table;
	}
	
	private Column mappingColumnEntity(Field field) {
		Column column = new Column();
		column.setJdbcName(JdbcNameWrapper.wrapping(field));
		column.setJdbcType(JdbcTypeWrapper.wrapping(field.getType()));
		column.setJavaName(field.getName());
		column.setJavaType(field.getType().getSimpleName());
		return column;
	}
	
}

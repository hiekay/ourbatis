package org.nico.ourbatis.wrapper;

import java.util.List;

import org.nico.ourbatis.contains.OurConnfig;

/** 
 * 
 * @author nico
 * @version createTime：2018年8月26日 下午5:05:32
 */

public class MapperNameWrapper extends Wrapper<Class<?>>{

	@Override
	public String wrapping(Class<?> domainClass) {
		String tableName = domainClass.getSimpleName();
		List<Wrapper<String>> wrappers = OurConnfig.MAPPER_NAME_WRAPPERS;
		if(wrappers == null) {
			throw new NullPointerException("Wrappers is null");
		}
		for(Wrapper<String> wrapper: wrappers){
			tableName = wrapper.wrapping(tableName);
		}
		return tableName;
	}

}

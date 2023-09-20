package com.test.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// xml 안 만들고 sql 여기에 때려 넣는 것도 할 수 있다심... 이방법은 비주류지만 지금 당장 간단히 보는 거부터 해보겠다심
	// 어노테이션으로 처리...
	@Select("select sysdate from dual")
	public String getTime();

	public String getTime2();
}

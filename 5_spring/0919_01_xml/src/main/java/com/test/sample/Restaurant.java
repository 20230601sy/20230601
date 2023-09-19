package com.test.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	@Setter(onMethod_ = @Autowired)
	private Chef chef; // import가 필요없다 ㄷㄷㄷ 기본적으론 null인데,, 어노테이션으로 의존성 주입 시전... → root-context.xml java bean 등록합시다
}
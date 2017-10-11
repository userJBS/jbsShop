package com.userj.domain.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageSearch {

	// 필터 기본값 name
	private String filter;
	private String param;

}

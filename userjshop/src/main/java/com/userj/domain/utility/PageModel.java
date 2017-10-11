package com.userj.domain.utility;

import com.userj.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageModel {

	private int number;
	private int totalPageNumber;
	private Category category;

}

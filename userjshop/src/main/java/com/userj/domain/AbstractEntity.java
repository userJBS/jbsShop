package com.userj.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

	@CreatedDate // 데이터가 생성된 시간
	private LocalDateTime createDate;

	@LastModifiedDate // 데이터가 수정된 시간
	private LocalDateTime modifiedDate;

	// 시간 출력 포맷
	private String getFormattedDate(LocalDateTime dateTime) {
		if (dateTime == null) {
			return "";
		}
//		return dateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss"));
		return dateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm"));
	}

	// 시간 관련 테스트 값
	public String getModifiedDate() {
		return getFormattedDate(modifiedDate);
	}

	public String getCreateDate() {
		return getFormattedDate(createDate);
	}

	public void setModifiedDate() {
	}

	public void setCreateDate() {
	}
}

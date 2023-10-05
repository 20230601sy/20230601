package com.board.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.board.domain.BoardAttachVO;
import com.board.mapper.BoardAttachMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {
	
	@Autowired
	BoardAttachMapper boardAttachMapper;
	
	private String getFolderYesterday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime());
		return str.replace("-", File.separator);
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	@Scheduled(cron = "0 * * * * *") // 6자리 초(0~59)분(0~59)시(0~23)일(1~31)월(1~12)요일(0~7) 요일의 0, 7은 모두 일요일
	// 크론 표현식 (Cron expression) 종류 다양하다심...
	// https://javawork.tistory.com/entry/Job-Scheduler-%ED%81%AC%EB%A1%A0-Cron-%EA%B3%BC-%ED%81%AC%EB%A1%A0-%ED%91%9C%ED%98%84%EC%8B%9D
	// ? : 조건없음
	// 1-5 1에서 5, */5 같은 거 쓸 수 있음. 
	// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=estern&logNo=110010101624
	// 월수금... 구분자 ,도 쓸 수 있는 거 같음, 6#3은 "#3" = 3번째 금요일(6) 6L은 월의 마지막 금요일 "15W" 는 매달 15일에 근접한 Weekday ㄷㄷㄷ 
	public void checkFiles() throws Exception {
	//	log.warn("파일 체크 메서드 실행"); // log level 때문에 info로는 출력되지 않음.
	//	log.warn("========================================");
		List<BoardAttachVO> fileList = boardAttachMapper.getList();
		List<Path> fileListPath = fileList.stream()
											.map(vo -> Paths.get("D:\\Y\\20230601ezen\\5_spring\\upload\\", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName()))
											.collect(Collectors.toList());
		fileList.stream().filter(vo -> vo.isFileType() == true)
						.map(vo -> Paths.get("D:\\Y\\20230601ezen\\5_spring\\upload\\", vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName()))
						.forEach(path -> fileListPath.add(path));
//		fileListPath.forEach(f->log.warn(f));
		File dir = Paths.get("D:\\Y\\20230601ezen\\5_spring\\upload\\", getFolderYesterday()).toFile();
		File[] removeFiles = dir.listFiles(file -> fileListPath.contains(file.toPath()) == false);
//		log.warn("삭제========================================");
		for(File f : removeFiles) {
//			log.warn(f);
			f.delete();
		}
//		log.warn("끝남========================================");
	}
}

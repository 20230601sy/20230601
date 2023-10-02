package com.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.upload.domain.FileDTO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}

	@PostMapping("/uploadAction")
	public void upload(MultipartFile[] uploadFile, Model model) {
		String uploadFolder = "D:\\Y\\20230601ezen\\5_spring\\upload";
		for (MultipartFile file : uploadFile) {
			System.out.println("========================================");
			System.out.println("원본 파일명				: " + file.getOriginalFilename());
			System.out.println("업로드 파일명			: " + file.getName());
			System.out.println("업로드 파일 콘텐츠타입		: " + file.getContentType());
			System.out.println("업로드 파일이 비었는지		: " + file.isEmpty());
			System.out.println("업로드 파일 바이트 크기	: " + file.getSize());
			System.out.println("파일을 서버에 저장		: " + "file.transferTo(파일)");

			File saveFile = new File(uploadFolder, file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
	}

	/*
	 * @PostMapping("/uploadAjax")
	 * public void upload(MultipartFile[] uploadFile) {
	 * 
	 * String uploadFolder = "D:\\Y\\20230601ezen\\5_spring\\upload";
	 * for(MultipartFile file : uploadFile) {
	 * 		System.out.println("========================================");
	 * 		System.out.println("원본 파일명				: " + file.getOriginalFilename());
	 * 		System.out.println("업로드 파일명			: " + file.getName());
	 * 
	 * 		========================================
	 * 		원본 파일명 : apple.jpg
	 * 		업로드 파일명 : uploadFile 
	 * 		브라우저가 익스프롤러일 경우에는 원본 파일명 : C:\Users\508-06\Documents\카카오톡 받은 파일\jsp쇼핑몰구축 이미지\apple.jpg 파일 경로까지 올라감... 서버에 저장할 때는 경로 안 보이게 하는 작업을 해야 함...
	 * 		이거 보안정책 위반되는 거... 귀찮게... 요즘은 익스프롤러로 열리면 엣지로 자동으로 열리게 된다심
	 * 
	 *		File saveFile = new File(uploadFolder, file.getOriginalFilename());
	 * 		try {
	 * 			file.transferTo(saveFile); 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace(); 
	 * 		}
	 * }
	 * 
	 * 
	 * String uploadFolder = "D:\\Y\\20230601ezen\\5_spring\\upload"; 
	 * File uploadPath = new File(uploadFolder, getFolder());
	 * if(uploadPath.exists() == false) { uploadPath.mkdirs(); }
	 * for (MultipartFile file : uploadFile) { 
	 * 		UUID uuid = UUID.randomUUID();
	 * 		String uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();
	 * 		File saveFile = new File(uploadPath, uploadFileName);
	 * 		try { 
	 * 			file.transferTo(saveFile);
	 * 			if(checkImageType(saveFile)) { 
	 * 				FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
	 * 				Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100); // 섬네일 가로, 세로
	 * 				thumbnail.close(); 
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * }
	 * }
	 */

	@PostMapping(value = "/uploadAjax", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<FileDTO>> upload(MultipartFile[] uploadFile) {
		List<FileDTO> list = new ArrayList<>();
		String uploadFolder = "D:\\Y\\20230601ezen\\5_spring\\upload";
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		if(!uploadPath.exists())
			uploadPath.mkdirs();
		for (MultipartFile file : uploadFile) {
			FileDTO dto = new FileDTO();
			UUID uuid = UUID.randomUUID();
		 	String uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();
		 	dto.setFileName(file.getOriginalFilename());
		 	dto.setUuid(uuid.toString());
		 	File saveFile = new File(uploadPath, uploadFileName);
		 	try { 
		 		file.transferTo(saveFile);
		 		dto.setUploadPath(uploadFolderPath);
		 		if(checkImageType(saveFile)) {
		 			dto.setImage(true);
		 			FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
		 			Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100); // 섬네일 가로, 세로
		 			thumbnail.close(); 
		 		}
		 		
		 		list.add(dto);
		 	} catch (Exception e) {
		 		e.printStackTrace();
			}
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	private String getFolder() { // 보통 여기에 작업하는 건 아니고 util 같은 곳에 생성하는...
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image"); // image/jpg, image/png, image/gif 이런식임...
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {
		File file = new File("D:\\Y\\20230601ezen\\5_spring\\upload\\" + fileName);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(String fileName){
		System.out.println("다운받는 파일명 : " + fileName);
		FileSystemResource resource = new FileSystemResource("D:\\Y\\20230601ezen\\5_spring\\upload\\" + fileName); // 서버에 저장된 파일을 읽어올 때...
		System.out.println("리소스 : " + resource);
		String resourceName = resource.getFilename();
		String oriName = resourceName.substring(resourceName.indexOf("_")+1);
		HttpHeaders header = new HttpHeaders();
		try {
//			header.add("Content-Disposition", "attachment; filename=" + new String(resourceName.getBytes("utf-8"), "iso-8859-1"));
			header.add("Content-Disposition", "attachment; filename=" + new String(oriName.getBytes("utf-8"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(resource, header, HttpStatus.OK);
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type) {
		File file = null;
		try {
			file = new File("D:\\Y\\20230601ezen\\5_spring\\upload\\" + URLDecoder.decode(fileName, "utf-8"));
			file.delete(); // 섬네일 또는 이미지가 아닌 파일 삭제
			if(type.equals("image")) {
				String oriFileName = file.getAbsolutePath().replace("s_", "");
				file = new File(oriFileName);
				file.delete(); // 원본 이미지 파일 삭제
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("삭제성공", HttpStatus.OK);
	}
}

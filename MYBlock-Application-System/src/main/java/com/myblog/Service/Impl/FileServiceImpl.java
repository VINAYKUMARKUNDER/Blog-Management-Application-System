//package com.myblog.Service.Impl;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.UUID;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.myblog.Service.FileService;
//
//@Service
//public class FileServiceImpl implements FileService {
//
//	@Override
//	public String uploadImage(MultipartFile file, String path) throws IOException {
//		String name = file.getOriginalFilename();
//		String randomName = UUID.randomUUID().toString();
//		String fileName = randomName.concat(name.substring(name.lastIndexOf(".")));
//		String fullPath = path + File.separator + fileName;
//
//		File f = new File(path);
//
//		if (!f.exists()) {
//			f.mkdir();
//		}
//
//		Files.copy(file.getInputStream(), Paths.get(fullPath));
//		return fullPath;
//	}
//
//	@Override
//	public InputStream getResourse(String path, String fileName) throws FileNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}

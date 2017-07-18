package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.FileDao;
import vo.MemberVO;
@Controller
public class FileController {
	@Autowired
	private FileDao dao;
	public void setDao(FileDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm(){
		return "upload_form";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(MemberVO member, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload_result");
		
		String path="c:/springFiles/";
		
		File dir = new File(path);
		if(dir.exists() == false){
			dir.mkdir();
		}
		
		String savedName = path+new Random().nextInt(10000000);
		File savedFile = new File(savedName);
		
		try {
			
			member.getMemberFile().transferTo(savedFile);
			mv.addObject("originalName", member.getMemberFile().getOriginalFilename());
			mv.addObject("savedName", savedName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response){
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"Koala.jpg\"");
		
		try {
			FileInputStream is = new FileInputStream("c:/springFiles/Koala.jpg");
			ServletOutputStream os = response.getOutputStream();
			
			int data = 0;
			while ((data = is.read()) != -1){
				os.write(data);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}

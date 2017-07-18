package vo;

import org.springframework.web.multipart.MultipartFile;

public class FileInfoVO {
	private int fileNum;
	private String fileName;
	private String filePath;
	private MultipartFile uploadFile;
	
	public FileInfoVO() {
		super();
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public FileInfoVO(int fileNum, String fileName, String filePath) {
		super();
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.filePath = filePath;
	}
	
}

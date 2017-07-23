package vo;

public class DepartmentVO {
	private int deptId;
	private String deptNo;
	private String deptName;
	public DepartmentVO(int deptId, String deptNo, String deptName) {
		super();
		this.deptId = deptId;
		this.deptNo = deptNo;
		this.deptName = deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "DepartmentVO [deptId=" + deptId + ", deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}
}

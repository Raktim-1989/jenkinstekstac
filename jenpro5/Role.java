import java.util.List;

public class Role {
	
	private Integer id;
	private String name;
	private List<Privilege> privilegeList;
	
	public Role(Integer id, String name , List<Privilege> privilegeList) {
		super();
		this.id = id;
		this.name = name;
		this.privilegeList = privilegeList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}
}

import java.util.List;

public class Privilege {
	
	private Integer id;
	private String name;
	private List<Role> roleList;
	
	public Privilege(Integer id, String name, List<Role> roleList) {
		super();
		this.id = id;
		this.name = name;
		this.roleList = roleList;
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

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}

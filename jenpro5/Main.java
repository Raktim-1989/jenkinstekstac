import java.io.*;
import java.util.*;
public class Main {
	
	public static void loadRolesAndprivileges(List<Role> roles , List<Privilege> privileges) {
		roles.add(new Role(1, "Manager", new ArrayList<Privilege>()));
		roles.add(new Role(2, "Shipper", new ArrayList<Privilege>()));
		roles.add(new Role(3, "Agent", new ArrayList<Privilege>()));
		roles.add(new Role(4, "Customer", new ArrayList<Privilege>()));
		privileges.add(new Privilege(1, "Process Shipment", new ArrayList<Role>()));
		privileges.add(new Privilege(2, "Create Shipment", new ArrayList<Role>()));
		privileges.add(new Privilege(3, "Schedule Shipment", new ArrayList<Role>()));
		privileges.add(new Privilege(4, "Cancel Shipment", new ArrayList<Role>()));
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		List<Role> roles = new ArrayList<Role>();
		List<Privilege> privileges = new ArrayList<Privilege>();
		Main.loadRolesAndprivileges(roles, privileges);
		String ch;
		Integer roleId;
		Integer privilegeId;
		int i,j;
		System.out.println("Available roles:");
		System.out.println(String.format("%-15s%s", "Id","Name"));
		for(Role role:roles){
			System.out.println(String.format("%-15d%s", role.getId(),role.getName()));
		}
		System.out.println("Available privileges:");
		System.out.println(String.format("%-15s%s", "Id","Name"));
		for(Privilege privilege:privileges){
			System.out.println(String.format("%-15d%s", privilege.getId(),privilege.getName()));
		}
		do{
			System.out.println("1. Assign privilege\n2. Cancel privilege\n3. Search privilege by role\n4. Search role by privilege\nEnter the choice:");
			Integer choice = Integer.parseInt(buf.readLine());
			switch(choice){
				case 1:System.out.println("Enter the id for role:");
					   roleId = Integer.parseInt(buf.readLine());
				       System.out.println("Enter the id for privilege:"); 
				       privilegeId = Integer.parseInt(buf.readLine());
				       for(i=0;i<roles.size();i++){
				    	   if(roles.get(i).getId() == roleId)
				    		   break;
				       }
				       for(j=0;j<privileges.size();j++){
				    	   if(privileges.get(j).getId() == privilegeId)
				    		   break;
				       }
				       roles.get(i).getPrivilegeList().add(privileges.get(j));
				       privileges.get(j).getRoleList().add(roles.get(i));break;
				case 2:System.out.println("Enter the id for role:");
					   roleId = Integer.parseInt(buf.readLine());
				       System.out.println("Enter the id for privilege:"); 
				       privilegeId = Integer.parseInt(buf.readLine());
				       for(i=0;i<roles.size();i++){
				    	   if(roles.get(i).getId() == roleId)
				    		   break;
				       }
				       for(j=0;j<privileges.size();j++){
				    	   if(privileges.get(j).getId() == privilegeId)
				    		   break;
				       }
				       roles.get(i).getPrivilegeList().remove(privileges.get(j));
				       privileges.get(j).getRoleList().remove(roles.get(i));break;
				case 3:System.out.println("Enter the role name:");
					   String roleName = buf.readLine();
					   for(Role role:roles){
						   if(role.getName().equals(roleName)){
							   for(Privilege privilege:role.getPrivilegeList())
								   System.out.println(""+privilege.getName());
						   }
					   }break;
				case 4:System.out.println("Enter the privilege name:");
				       String privilegeName = buf.readLine();
				       for(Privilege privilege:privileges){
				    	   if(privilege.getName().equals(privilegeName)){
				    		   for(Role role:privilege.getRoleList())
				    			   System.out.println(""+role.getName());
				    	   }
				       }break;
				default:System.out.println("Invalid Choice");
			}
			System.out.println("Do you want to process again?(yes/no)");
			ch = buf.readLine();
		}while(ch.equals("yes"));
	}
}

package nz.co.stylesoftware.SpringSecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class Users {
	
	@Id
	@Column(name="user_id")
	private Integer userId;
	
	private String first_name;
	private String last_name;
	private String password;
	private String action_flg;

}

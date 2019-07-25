package com.revature.entity;

	import javax.persistence.*;
	import org.hibernate.annotations.DynamicUpdate;
	
	@Entity 
	@Table(name="User_revature")
	
	public class User {	
		@Id 
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="fname", length=50)
		private String fname;
		
		@Column(name="lname", length=50)
		private String lname;
		
		@Column(name="email", length=50)
		private String email;
		
		@Column(name="username", length=50)
		private String username;
		
		@Column(name="password", length=50)
		private String password;
		
		@Column(name="role", length=50)
		private String role;
		
		public User() {}
		

		public User(int id, String fname, String lname, String email, String username, String password, String role) {
			super();
			this.id = id;
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.username = username;
			this.password = password;
			this.role = role;
		}
		
		
		public User(String fname, String lname, String email, String username, String password, String role) {
			super();
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.username = username;
			this.password = password;
			this.role = role;
		}

		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((fname == null) ? 0 : fname.hashCode());
			result = prime * result + id;
			result = prime * result + ((lname == null) ? 0 : lname.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((role == null) ? 0 : role.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (fname == null) {
				if (other.fname != null)
					return false;
			} else if (!fname.equals(other.fname))
				return false;
			if (id != other.id)
				return false;
			if (lname == null) {
				if (other.lname != null)
					return false;
			} else if (!lname.equals(other.lname))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (role == null) {
				if (other.role != null)
					return false;
			} else if (!role.equals(other.role))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", username="
					+ username + ", password=" + password + ", role=" + role + "]";
		}

		
		
}

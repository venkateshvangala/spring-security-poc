--
-- Schema for `users`
--

drop table if EXISTS 'sp_users';

create table sp_users(
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(100) UNIQUE NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	middle_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	mobile INT(15) UNIQUE NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	is_user_active TINYINT(1) NOT NULL DEFAULT '0',
	last_login_at DATETIME NULL DEFAULT NULL,
	created_by VARCHAR(100) DEFAULT NULL,
	created_on DATETIME NULL DEFAULT NULL,
	updated_by VARCHAR(100) DEFAULT NULL,
	updated_on DATETIME NULL DEFAULT NULL
);


--
-- Schema for `sp_organization`
--

drop table if EXISTS 'sp_organization';

create table sp_organization(
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) UNIQUE NOT NULL,
	logo VARCHAR(1000) DEFAULT NULL, 
	is_org_active TINYINT(1) NOT NULL DEFAULT '0',
	created_by VARCHAR(100) DEFAULT NULL,
	created_on DATETIME NULL DEFAULT NULL,
	updated_by VARCHAR(100) DEFAULT NULL,
	updated_on DATETIME NULL DEFAULT NULL
);

--
-- Schema for `sp_organization_users`
--

drop table if EXISTS 'sp_organization_users';

create table sp_organization_users(
	org_id INT(6) UNSIGNED NOT NULL,
	user_id INT(6) UNSIGNED NOT NULL,
	is_primary INT(15) NULL,
  	CONSTRAINT FOREIGN KEY (org_id) REFERENCES `sp_organization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  	CONSTRAINT FOREIGN KEY (user_id) REFERENCES `sp_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Schema for `sp_roles`
--

drop table if EXISTS 'sp_roles';

create table sp_roles(
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) DEFAULT NULL,
	display_name VARCHAR(100) DEFAULT NULL,
	created_by VARCHAR(100) DEFAULT NULL,
	created_on DATETIME NULL DEFAULT NULL,
	updated_by VARCHAR(100) DEFAULT NULL,
	updated_on DATETIME NULL DEFAULT NULL
);

--
-- Schema for `sp_permissions`
--

drop table if EXISTS 'sp_permissions';

create table sp_permissions(
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) DEFAULT NULL,
	display_name VARCHAR(100) DEFAULT NULL,
	created_by VARCHAR(100) DEFAULT NULL,
	created_on DATETIME NULL DEFAULT NULL,
	updated_by VARCHAR(100) DEFAULT NULL,
	updated_on DATETIME NULL DEFAULT NULL
);


--
-- Schema for `sp_role_mapping`
--

drop table if EXISTS 'sp_role_mapping';

create table sp_role_mapping(
	user_id INT(6) UNSIGNED NOT NULL,
	role_id INT(6) UNSIGNED NOT NULL,
	org_id INT(6) UNSIGNED NOT NULL,
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES `sp_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  	CONSTRAINT FOREIGN KEY (org_id) REFERENCES `sp_organization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  	CONSTRAINT FOREIGN KEY (role_id) REFERENCES `sp_roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


--
-- Schema for `sp_permission_mapping`
--

drop table if EXISTS 'sp_permission_mapping';

create table sp_permission_mapping(
	role_id INT(6) UNSIGNED NOT NULL,
	permission_id INT(6) UNSIGNED NOT NULL,
  	CONSTRAINT FOREIGN KEY (permission_id) REFERENCES `sp_permissions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  	CONSTRAINT FOREIGN KEY (role_id) REFERENCES `sp_roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);







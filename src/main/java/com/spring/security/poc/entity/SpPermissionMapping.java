package com.spring.security.poc.entity;
// Generated Dec 8, 2017 7:45:03 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SpPermissionMapping generated by hbm2java
 */
@Entity
@Table(name = "sp_permission_mapping", catalog = "spring_security_poc")
public class SpPermissionMapping implements java.io.Serializable {

	private SpPermissionMappingId id;
	private SpPermissions spPermissions;
	private SpRoles spRoles;

	public SpPermissionMapping() {
	}

	public SpPermissionMapping(SpPermissionMappingId id, SpPermissions spPermissions, SpRoles spRoles) {
		this.id = id;
		this.spPermissions = spPermissions;
		this.spRoles = spRoles;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false)),
			@AttributeOverride(name = "permissionId", column = @Column(name = "permission_id", nullable = false)) })
	public SpPermissionMappingId getId() {
		return this.id;
	}

	public void setId(SpPermissionMappingId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permission_id", nullable = false, insertable = false, updatable = false)
	public SpPermissions getSpPermissions() {
		return this.spPermissions;
	}

	public void setSpPermissions(SpPermissions spPermissions) {
		this.spPermissions = spPermissions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
	public SpRoles getSpRoles() {
		return this.spRoles;
	}

	public void setSpRoles(SpRoles spRoles) {
		this.spRoles = spRoles;
	}

}
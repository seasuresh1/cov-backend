package com.covid.model.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// Generated May 1, 2020, 8:54:03 PM by Hibernate Tools 5.2.12.Final
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PatientProviderRel generated by hbm2java
 */
@Entity
@Table(name = "patient_provider_rel", schema = "release1")
public class PatientProviderRel implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5158594858273236120L;
	private int patProRelId;
	private Integer patientId;
	private Integer healthProId;
	private String relType;
	private Date relStartDate;
	private Date relEndDate;
	private Integer relFacLocation;

	public PatientProviderRel() {
	}

	public PatientProviderRel(final int patProRelId) {
		this.patProRelId = patProRelId;
	}

	public PatientProviderRel(final int patProRelId, final Integer patientId, final Integer healthProId,
			final String relType, final Date relStartDate, final Date relEndDate, final Integer relFacLocation) {
		this.patProRelId = patProRelId;
		this.patientId = patientId;
		this.healthProId = healthProId;
		this.relType = relType;
		this.relStartDate = relStartDate;
		this.relEndDate = relEndDate;
		this.relFacLocation = relFacLocation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "pat_pro_rel_id", unique = true, nullable = false)
	public int getPatProRelId() {
		return this.patProRelId;
	}

	public void setPatProRelId(final int patProRelId) {
		this.patProRelId = patProRelId;
	}

	@Column(name = "patient_id")
	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(final Integer patientId) {
		this.patientId = patientId;
	}

	@Column(name = "health_pro_id")
	public Integer getHealthProId() {
		return this.healthProId;
	}

	public void setHealthProId(final Integer healthProId) {
		this.healthProId = healthProId;
	}

	@Column(name = "rel_type", length = 15)
	public String getRelType() {
		return this.relType;
	}

	public void setRelType(final String relType) {
		this.relType = relType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rel_start_date", length = 29)
	public Date getRelStartDate() {
		return this.relStartDate;
	}

	public void setRelStartDate(final Date relStartDate) {
		this.relStartDate = relStartDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rel_end_date", length = 29)
	public Date getRelEndDate() {
		return this.relEndDate;
	}

	public void setRelEndDate(final Date relEndDate) {
		this.relEndDate = relEndDate;
	}

	@Column(name = "rel_fac_location")
	public Integer getRelFacLocation() {
		return this.relFacLocation;
	}

	public void setRelFacLocation(final Integer relFacLocation) {
		this.relFacLocation = relFacLocation;
	}

}
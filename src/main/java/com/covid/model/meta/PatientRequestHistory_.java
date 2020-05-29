package com.covid.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.covid.model.db.Users;
import com.covid.model.db.PatientRequestHistory;
import java.sql.Timestamp;
import com.covid.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientRequestHistory.class)
public abstract class PatientRequestHistory_{

	public static volatile SingularAttribute<PatientRequestHistory, Integer> patientRequestHistoryId;
	public static volatile SingularAttribute<PatientRequestHistory, Integer> patientId;
	public static volatile SingularAttribute<PatientRequestHistory, Patient> patient;
	public static volatile SingularAttribute<PatientRequestHistory, String> requestType;
	public static volatile SingularAttribute<PatientRequestHistory, Timestamp> requestDateTime;
	public static volatile SingularAttribute<PatientRequestHistory, String> requestStatus;
	public static volatile SingularAttribute<PatientRequestHistory, String> requestComments;
	public static volatile SingularAttribute<PatientRequestHistory, String> responseType;
	public static volatile SingularAttribute<PatientRequestHistory, Integer> responseUserId;
	public static volatile SingularAttribute<PatientRequestHistory, Users> users;
	public static volatile SingularAttribute<PatientRequestHistory, Timestamp> responseDateTime;
	public static volatile SingularAttribute<PatientRequestHistory, String> responseComments;

	public static final String s_patientRequestHistoryId = "patientRequestHistoryId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_requestType = "requestType";
	public static final String s_requestDateTime = "requestDateTime";
	public static final String s_requestStatus = "requestStatus";
	public static final String s_requestComments = "requestComments";
	public static final String s_responseType = "responseType";
	public static final String s_responseUserId = "responseUserId";
	public static final String s_users = "users";
	public static final String s_responseDateTime = "responseDateTime";
	public static final String s_responseComments = "responseComments";
	
}

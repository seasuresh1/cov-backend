
--public.getlocationhierarchy
CREATE OR REPLACE FUNCTION public.getlocationhierarchy(
	locationid integer)
    RETURNS TABLE(location_id integer, locationname character varying, locationabbreviation character varying, assignpatients boolean, parentlocationid integer, countrycode character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$BEGIN
	 RETURN QUERY(SELECT * FROM public."LocationHierarchy"  WHERE "LocationId" = $1);
END; $BODY$;



--public.historylist
CREATE OR REPLACE FUNCTION public.historylist(
	id integer)
    RETURNS TABLE(healthhistoryid integer, userid integer, coughpresent boolean, feverpresent boolean, breathingdifficultypresent boolean, progressstatus character varying, temperaturecelsius double precision, heartratepermin integer, respratepermin integer, spo2percent integer) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$
begin
	RETURN Query  
	select "HealthHistoryId","UserId" ,"CoughPresent" ,
"FeverPresent" ,"BreathingDifficultyPresent" ,
"ProgressStatus" ,"TemperatureCelsius","HeartRatePerMin" ,
"RespRatePerMin" ,"SpO2Percent" from public."HealthCheckHistory"
where "UserId"=$1;

END;
$BODY$;


--public.homedetails
CREATE OR REPLACE FUNCTION public.homedetails(
	userid integer)
    RETURNS TABLE(patientid integer, firstname character varying, lastname character varying, latitude double precision, longitude double precision, emergencycontact1 character varying, requestdatetime timestamp without time zone) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$
begin
	RETURN Query  
	SELECT p."PatientId",u."FirstName", u."LastName", 
	ps."Latitude", ps."Longitude", p."EmergencyContact1", uh."RequestDateTime"
	from public."PatientProviderRelationship" pp
	JOIN public."Patient" p ON pp."PatientId" = p."PatientId"
	JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId"
	JOIN public."HealthProfessional" h ON h."HealthProfessionalId" = pp."ProviderId"
	JOIN public."User" u ON u."UserId" = h."UserId"
	LEFT JOIN public."UserRequestHistory" uh ON uh."UserId" = u."UserId"
	WHERE pp."PatientId" = $1;

END;
$BODY$;


--public.raiseyourhand
CREATE OR REPLACE FUNCTION public.raiseyourhand(
	userid integer,
	reqtype character varying,
	reqstatus character varying,
	comments character varying)
    RETURNS character varying
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$
BEGIN
    INSERT INTO public."UserRequestHistory" ("UserId" ,"RequestType" ,"RequestStatus" ,"RequestComments"  ) VALUES ($1,$2,$3,$4);
   return 'SUCCESS';
END
$BODY$;



--public.registernewhealthpro
CREATE OR REPLACE FUNCTION public.registernewhealthpro(
	title character varying,
	firstname character varying,
	lastname character varying,
	suffix character varying,
	gender character varying,
	dateofbirth date,
	emailaddress character varying,
	phonenumber character varying,
	healthprotype character varying,
	healthprojobtitle character varying,
	healthproofficeaddress character varying,
	healthprolocationid integer,
	supervisorid integer)
    RETURNS text
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$DECLARE 
 userID integer;
BEGIN
	INSERT INTO public."User"(
	 "Title", "FirstName","LastName","Suffix","Gender", "DateOfBirth" )
	VALUES ($1, $2,$3,$4,$5,$6)
	RETURNING public."User"."UserId" INTO userID;
	INSERT INTO public."EmailAddress"(
	"UserId", "EmailAddress")
	VALUES (userID, $7);	
	INSERT INTO public."PhoneNumber"(
	"UserId","PhoneNumber")
	VALUES (userID, $8);
	
	RETURN 'SUCCESS';
END; $BODY$;



--public.savepatientproviderrela
CREATE OR REPLACE FUNCTION public.savepatientproviderrela(
	patientid integer,
	providerid integer,
	relationshiptype character varying,
	locationid integer,
	relationshipstartdate date DEFAULT NULL::date,
	relationshipenddate date DEFAULT NULL::date)
    RETURNS text
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$BEGIN
	INSERT INTO public."PatientProviderRelationship"(
	 "PatientId", "ProviderId", "RelationshipType", "RelationshipStartDate", "RelationshipEndDate", "RelationshipFacilityLocation")
	VALUES ($1, $2,$3,$5,$6,$4);
	RETURN 'SUCCESS';
END; $BODY$;



--public.updatehealth
CREATE OR REPLACE FUNCTION public.updatehealth(
	userid integer,
	coughpresent boolean,
	feverpresent boolean,
	breathingdifficultypresent boolean,
	progressstatus character varying,
	temperature double precision,
	heartrate integer,
	respiratoryrate integer,
	spo2 integer)
    RETURNS character varying
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$
BEGIN
    INSERT INTO public."HealthCheckHistory" ("UserId","CoughPresent" ,"FeverPresent" ,
   "BreathingDifficultyPresent" ,"ProgressStatus" ,"TemperatureCelsius" ,
  "HeartRatePerMin" ,"RespRatePerMin" ,"SpO2Percent" ) VALUES ($1,$2,$3,$4,$5,$6,$7,$8,$9);
 return 'SUCCESS';
END
$BODY$;



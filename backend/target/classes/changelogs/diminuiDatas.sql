CREATE OR REPLACE
FUNCTION DIMINUI_DATA(
    v_datfim IN VARCHAR2,
    v_datini IN VARCHAR2
) RETURN NUMBER IS
  v_result NUMBER(12,0);
BEGIN
  select
    (to_date(v_datfim, 'dd/mm/yyyy hh24:mi') - to_date(v_datini, 'dd/mm/yyyy hh24:mi')) * 24 * 60  into v_result
  from dual;

  RETURN v_result;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
END;

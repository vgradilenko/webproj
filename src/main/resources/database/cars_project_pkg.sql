CREATE OR REPLACE PACKAGE cars_project_pkg AS
  PROCEDURE save_model(paramModelName     IN VARCHAR2, paramYear IN NUMBER, paramPrice IN NUMBER,
                       paramManufactureId IN NUMBER, outParam OUT VARCHAR2);
END cars_project_pkg;
/

CREATE OR REPLACE PACKAGE BODY cars_project_pkg AS
  PROCEDURE save_model(paramModelName     IN VARCHAR2, paramYear IN NUMBER, paramPrice IN NUMBER,
                       paramManufactureId IN NUMBER, outParam OUT VARCHAR2) AS
    BEGIN
      IF (paramYear < 2000)
      THEN
        outParam := 'Error!!!';
        RETURN;
      END IF;
      IF (paramPrice < 10000)
      THEN
        outParam := 'Error!!!';
        RETURN;
      END IF;
      INSERT INTO CAR_MODEL (ID, MODEL_NAME, MANUFACTURE_ID, MANUFACTURED_YEAR, PRICE)
      VALUES (HIBERNATE_SEQUENCE.NEXTVAL, paramModelName, paramManufactureId, paramYear, paramPrice);
      outParam := 'Success!!!';
      RETURN;
    END;
END cars_project_pkg;
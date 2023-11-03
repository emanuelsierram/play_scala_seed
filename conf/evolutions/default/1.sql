# Evolución 1
# Crea la tabla USERS
# Si la tabla ya existe, esta evolución no se aplicará
create table USERS (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  EMAIL VARCHAR(255) NOT NULL,
  FECHA TIMESTAMP,
  PRIMARY KEY (ID)
);


INSERT INTO USERS (EMAIL,FECHA) VALUES ('ejemplo@email.com','2024-10-29');
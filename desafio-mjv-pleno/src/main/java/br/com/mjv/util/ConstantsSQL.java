package br.com.mjv.util;

public class ConstantsSQL {
	
	public static final String SQL_FIND_BY_ID = "SELECT COUNT(idcolaborador) FROM colaborador WHERE idcolaborador = :id AND projeto is null AND gestor is null AND departamento is null";
	public static final String SQL_FIND_BY_NAME = "SELECT * FROM colaborador WHERE nome = :nome";
	public static final String SQL_FIND_ALL = "SELECT * FROM colaborador";
	public static final String SQL_DELETE = "DELETE FROM colaborador WHERE idcolaborador = :id";
	public static final String SQL_UPDATE = "UPDATE colaborador SET idcolaborador = :idcolaborador, nome = :nome, sobrenome = :sobrenome, email = :email, "
												+ "projeto = :projeto, gestor = :gestor, departamento = :departamento WHERE idcolaborador = :idcolaborador";
	public static final String SQL_INSERT = "INSERT INTO colaborador (idcolaborador, nome, sobrenome, email, projeto, gestor, departamento) "
												+ "VALUES ((SELECT MAX(idcolaborador) +1 FROM colaborador), :nome, :sobrenome, :email, :projeto, :gestor, :departamento)";

}
